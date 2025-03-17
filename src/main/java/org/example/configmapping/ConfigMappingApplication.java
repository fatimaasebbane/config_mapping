package org.example.configmapping;

import org.example.configmapping.mapping.core.MappingRegistry;
import org.example.configmapping.mapping.domain.TransferMappingService;
import org.example.configmapping.test.SopraTransferRequest;
import org.example.configmapping.test.TransferRequestDto;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConfigMappingApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ConfigMappingApplication.class, args);

        TransferMappingService bean = run.getBean(TransferMappingService.class);

        TransferRequestDto requestDto = new TransferRequestDto();
        requestDto.setSourceAccountId("ACC123");
        requestDto.setDestinationAccountId("ACC456");
        requestDto.setAmount(1000.50);
        requestDto.setCurrency("EUR");
        requestDto.setReference("REF789");
        requestDto.setExecutionDate("2025-03-18");  // Format source (yyyy-MM-dd)
        requestDto.setTransferType("DOMESTIC");

        String bankId = "BANK123";

        SopraTransferRequest clientRequest = bean.map(requestDto,SopraTransferRequest.class, bankId);

        System.out.println("Objet client mappé :");
        System.out.println(clientRequest);

    }


}
