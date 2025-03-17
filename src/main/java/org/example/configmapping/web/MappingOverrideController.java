package org.example.configmapping.web;

import org.example.configmapping.mapping.core.ConfigurableMappingEngine;
import org.example.configmapping.mapping.override.MappingOverride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mapping-overrides")
public class MappingOverrideController {

    private final ConfigurableMappingEngine mappingEngine;

    @Autowired
    public MappingOverrideController(ConfigurableMappingEngine mappingEngine) {
        this.mappingEngine = mappingEngine;
    }

    /**
     * Ajoute ou met à jour une surcharge de mapping pour une banque spécifique.
     */
    @PostMapping("/{bankId}")
    public String addMappingOverride(@PathVariable String bankId, @RequestBody MappingOverride override) {
        override.setBankId(bankId);
        mappingEngine.registerMappingOverride(override);
        return "Mapping override ajouté pour la banque : " + bankId;
    }
}