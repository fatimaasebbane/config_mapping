package org.example.configmapping.mapping.core.definition;

import org.example.configmapping.mapping.api.MappingContext;

import java.util.ArrayList;
import java.util.List;

public class MappingDefinition {
    private String id;
    private String sourceType;
    private String targetType;
    private List<FieldMapping> fieldMappings = new ArrayList<>();
    private int priority;

    /**
     * Applique ce mapping à l'objet source pour produire l'objet cible.
     */
    public Object apply(Object source, MappingContext context) {
        try {
            // Créer une instance de l'objet cible à partir de son nom de classe
            Class<?> targetClass = Class.forName(targetType);
            Object target = targetClass.getDeclaredConstructor().newInstance();

            // Appliquer chaque mapping de champ
            for (FieldMapping fieldMapping : fieldMappings) {
                fieldMapping.apply(source, target, context);
            }

            return target;
        } catch (Exception e) {
            throw new MappingException("Échec de l'application du mapping : " + id, e);
        }
    }
}
