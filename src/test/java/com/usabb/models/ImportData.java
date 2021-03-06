package com.usabb.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImportData {
    private BaseProduct baseProduct;
    private VariantProduct variantProduct;

    public VariantProduct getVariantProduct() {
        return variantProduct;
    }

    public void setVariantProduct(VariantProduct variantProduct) {
        this.variantProduct = variantProduct;
    }

    public BaseProduct getBaseProduct() {
        return baseProduct;
    }

    public void setBaseProduct(BaseProduct baseProduct) {
        this.baseProduct = baseProduct;
    }
}
