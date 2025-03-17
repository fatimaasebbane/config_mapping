package org.example.configmapping.mapping.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.configmapping.mapping.core.definition.MappingDefinition;
import org.example.configmapping.mapping.override.MappingOverride;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileBasedConfigLoader implements MappingConfigLoader{
    private final ResourcePatternResolver resourceResolver;

    private final ObjectMapper yamlMapper;
    private final ObjectMapper jsonMapper;

    private final String baseDefinitionsPath;
    private final String bankOverridesPathTemplate;

    public FileBasedConfigLoader(ResourcePatternResolver resourceResolver ,@Value("${adria.mapping.definitions-path:classpath:/mappings/definitions/}") String baseDefinitionsPath,
                                 @Value("${adria.mapping.overrides-path-template:classpath:/mappings/overrides/{bankId}/}") String bankOverridesPathTemplate) {
        this.resourceResolver = resourceResolver;
        this.baseDefinitionsPath = baseDefinitionsPath;
        this.bankOverridesPathTemplate = bankOverridesPathTemplate;

        this.yamlMapper = new ObjectMapper(new YAMLFactory());
        this.jsonMapper = new ObjectMapper();
        configureMappers();
    }

    @Override
    public List<MappingDefinition> loadMappingDefinitions() {
        List<MappingDefinition> definitions = new ArrayList<>();
        return List.of();
    }

    @Override
    public List<MappingOverride> loadMappingOverrides(String bankId) {
        return List.of();
    }
}
