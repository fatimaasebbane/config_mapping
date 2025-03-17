package org.example.configmapping.mapping.transformers;

import org.example.configmapping.mapping.api.MappingContext;
import org.example.configmapping.mapping.core.transform.ValueTransformer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTransformer implements ValueTransformer {
    private String sourceFormat;
    private String targetFormat;

    public DateFormatTransformer() {}

    public DateFormatTransformer(String sourceFormat, String targetFormat) {
        this.sourceFormat = sourceFormat;
        this.targetFormat = targetFormat;
    }


    @Override
    public Object transform(Object value, MappingContext context) {
        if (value == null) return null;
        try{
            SimpleDateFormat srcFormat = new SimpleDateFormat(sourceFormat);
            SimpleDateFormat tgtFormat = new SimpleDateFormat(targetFormat);

            Date date = srcFormat.parse(value.toString());
            return tgtFormat.format(date);

        }catch (Exception e){

        }
    }


    public String getSourceFormat() { return sourceFormat; }
    public void setSourceFormat(String sourceFormat) { this.sourceFormat = sourceFormat; }
    public String getTargetFormat() { return targetFormat; }
    public void setTargetFormat(String targetFormat) { this.targetFormat = targetFormat; }
}
