package org.example.configmapping.mapping.core.transform;

import org.example.configmapping.mapping.api.MappingContext;

public interface ValueTransformer {
    Object transform(Object value, MappingContext context);
}