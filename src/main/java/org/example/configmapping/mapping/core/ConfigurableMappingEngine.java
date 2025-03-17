package org.example.configmapping.mapping.core;

import org.example.configmapping.mapping.api.MappingContext;
import org.example.configmapping.mapping.api.MappingService;
import org.example.configmapping.mapping.config.MappingConfigLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigurableMappingEngine implements MappingService {
    @Autowired
    private final MappingRegistry mappingRegistry;
    @Autowired
    private final MappingConfigLoader configLoader;
    @Autowired
    private final BankConfigurationService bankConfigService;

    public ConfigurableMappingEngine(MappingRegistry mappingRegistry, MappingConfigLoader configLoader, BankConfigurationService bankConfigService) {
        this.mappingRegistry = mappingRegistry;
        this.configLoader = configLoader;
        this.bankConfigService = bankConfigService;
    }


    @Override
    public <S, T> T transform(S source, Class<T> targetType) {
        return null;
    }

    @Override
    public <S, T> List<T> transformList(List<S> sources, Class<T> targetType) {
        return List.of();
    }

    @Override
    public <S, T> T transformWithContext(S source, Class<T> targetType, MappingContext context) {
        return null;
    }
}
