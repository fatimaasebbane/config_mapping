package org.example.configmapping.mapping.config;

import org.example.configmapping.mapping.core.definition.MappingDefinition;
import org.example.configmapping.mapping.override.MappingOverride;

import java.util.List;

public interface MappingConfigLoader {
    List<MappingDefinition> loadMappingDefinitions();
    List<MappingOverride> loadMappingOverrides(String bankId);
}
