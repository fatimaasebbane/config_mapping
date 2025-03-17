package org.example.configmapping.mapping.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.example.configmapping.mapping.core.definition.MappingDefinition;
import org.example.configmapping.mapping.override.MappingOverride;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FileBasedConfigLoader implements MappingConfigLoader {
    private final ResourcePatternResolver resourceResolver;
    private final ObjectMapper yamlMapper;
    private final ObjectMapper jsonMapper;

    private final String baseDefinitionsPath;
    private final String bankOverridesPathTemplate;

    public FileBasedConfigLoader(
            ResourcePatternResolver resourceResolver,
            @Value("${adria.mapping.definitions-path:classpath:/mappings/definitions/}") String baseDefinitionsPath,
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
        try {
            Resource[] yamlResources = resourceResolver.getResources(baseDefinitionsPath + "**/*.yml");
            for (Resource resource : yamlResources) {
                MappingDefinition definition = yamlMapper.readValue(resource.getInputStream(), MappingDefinition.class);
                definitions.add(definition);
            }
            Resource[] jsonResources = resourceResolver.getResources(baseDefinitionsPath + "**/*.json");
            for (Resource resource : jsonResources) {
                MappingDefinition definition = jsonMapper.readValue(resource.getInputStream(), MappingDefinition.class);
                definitions.add(definition);
            }
        } catch (Exception e) {
            throw new RuntimeException("Échec du chargement des définitions de mapping", e);
        }
        return definitions;
    }

    @Override
    public List<MappingOverride> loadMappingOverrides(String bankId) {
        List<MappingOverride> overrides = new ArrayList<>();
        try {
            String overridesPath = bankOverridesPathTemplate.replace("{bankId}", bankId == null ? "global" : bankId);
            Resource[] yamlResources = resourceResolver.getResources(overridesPath + "**/*.yml");
            for (Resource resource : yamlResources) {
                MappingOverride override = yamlMapper.readValue(resource.getInputStream(), MappingOverride.class);
                override.setBankId(bankId);
                overrides.add(override);
            }
            Resource[] jsonResources = resourceResolver.getResources(overridesPath + "**/*.json");
            for (Resource resource : jsonResources) {
                MappingOverride override = jsonMapper.readValue(resource.getInputStream(), MappingOverride.class);
                override.setBankId(bankId);
                overrides.add(override);
            }
        } catch (Exception e) {
            if (!e.getMessage().contains("No resources found")) {
                throw new RuntimeException("Échec du chargement des overrides pour la banque: " + bankId, e);
            }
        }
        return overrides;
    }

    private void configureMappers() {
        // Configuration éventuelle pour la gestion des classes personnalisées.
    }

}
