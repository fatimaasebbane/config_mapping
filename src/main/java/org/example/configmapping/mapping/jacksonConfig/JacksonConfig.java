package org.example.configmapping.mapping.jacksonConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.configmapping.mapping.transformers.DateFormatTransformer;
import org.example.configmapping.mapping.transformers.EnumMappingTransformer;
import org.example.configmapping.mapping.transformers.PrefixTransformer;
import org.example.configmapping.mapping.transformers.StringTruncateTransformer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
    @Bean
    public ObjectMapper yamlMapper() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        // Activer la sérialisation/désérialisation polymorphe
        mapper.registerModule(new SimpleModule() {
            @Override
            public void setupModule(SetupContext context) {
                super.setupModule(context);

                // Enregistrer tous vos transformateurs
                context.registerSubtypes(
                        DateFormatTransformer.class,
                        EnumMappingTransformer.class,
                        PrefixTransformer.class,
                        StringTruncateTransformer.class
                );
            }
        });

        return mapper;
    }
}
