package org.example.configmapping.mapping.core.definition;

import org.example.configmapping.mapping.api.MappingContext;

public interface MappingCondition {
    boolean evaluate(Object source, Object target, MappingContext context);
    MappingCondition copy();
}