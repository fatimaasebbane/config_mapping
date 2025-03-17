package org.example.configmapping.mapping.core.override;

import org.example.configmapping.mapping.core.definition.FieldMapping;
import org.example.configmapping.mapping.core.definition.MappingCondition;
import org.example.configmapping.mapping.core.transform.ValueTransformer;

public class FieldOverride {
    private String sourcePath;
    private String targetPath; // facultatif : si null, on conserve celui d'origine
    private ValueTransformer transformer;
    private MappingCondition condition;

    /**
     * Crée un nouveau FieldMapping basé sur cette surcharge.
     */
    public FieldMapping createFieldMapping() {
        FieldMapping mapping = new FieldMapping();
        mapping.setSourcePath(this.sourcePath);
        mapping.setTargetPath(this.targetPath != null ? this.targetPath : this.sourcePath);
        mapping.setTransformer(this.transformer);
        mapping.setCondition(this.condition != null ? this.condition.copy() : null);
        return mapping;
    }

    public String getSourcePath() {
        return sourcePath;
    }
    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }
    public String getTargetPath() {
        return targetPath;
    }
    public void setTargetPath(String targetPath) {
        this.targetPath = targetPath;
    }
    public ValueTransformer getTransformer() {
        return transformer;
    }
    public void setTransformer(ValueTransformer transformer) {
        this.transformer = transformer;
    }
    public MappingCondition getCondition() {
        return condition;
    }
    public void setCondition(MappingCondition condition) {
        this.condition = condition;
    }

}
