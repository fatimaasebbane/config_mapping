package org.example.configmapping.mapping.transformers;

import org.example.configmapping.mapping.api.MappingContext;
import org.example.configmapping.mapping.core.transform.ValueTransformer;

public class StringTruncateTransformer implements ValueTransformer {
    private int maxLength;

    public StringTruncateTransformer() {}

    public StringTruncateTransformer(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public Object transform(Object value, MappingContext context) {
        if (value == null) return null;
        String str = value.toString();
        return (str.length() <= maxLength) ? str : str.substring(0, maxLength);
    }

    public int getMaxLength() { return maxLength; }
    public void setMaxLength(int maxLength) { this.maxLength = maxLength; }
}