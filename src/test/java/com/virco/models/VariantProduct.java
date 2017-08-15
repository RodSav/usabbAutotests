package com.virco.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Field;

/**
 * Created by ${Timonov_Viacheslav} on 6/1/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class VariantProduct {
    @JsonProperty("SAP Material Number")
    private String materialNumber;
    @JsonProperty("SAP Material Description")
    private String materialDescription;
    @JsonProperty("Delivery Type")
    private String delivery;
    @JsonProperty("Base Model")
    private String baseModel;
    @JsonProperty("Seat Color")
    private String seatColor;
    @JsonProperty("Upholstery Color")
    private String upholsteryColor;
    @JsonProperty("Desk/Table top color")
    private String topColor;
    @JsonProperty("Desk/Table edge Color")
    private String topEdgeColor;
    @JsonProperty("Frame Color")
    private String frameColor;
    @JsonProperty("Arm Color")
    private String armColor;
    @JsonProperty("Panel Color")
    private String panelColor;
    @JsonProperty("Bench Edge Color")
    private String benchEdgeColor;
    @JsonProperty("Box/Tray Color")
    private String trayColor;
    @JsonProperty("Box Color")
    private String boxColor;
    @JsonProperty("Pad Color")
    private String padColor;
    @JsonProperty("Panel/Screen Color")
    private String screenColor;

    public String getMaterialNumber() {
        return materialNumber;
    }

    public void setMaterialNumber(String materialNumber) {
        this.materialNumber = materialNumber;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public String getBaseModel() {
        return baseModel;
    }

    public void setBaseModel(String baseModel) {
        this.baseModel = baseModel;
    }

    public Object getAttribute(String jsonProperty) {
        Field[] fields = VariantProduct.class.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonProperty.class)) {
                String annotationValue = field.getAnnotation(JsonProperty.class).value();
                if (annotationValue.equalsIgnoreCase(jsonProperty)) try {
                    return field.get(this);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return "";
    }
}
