package com.usabb.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.usabb.locators.Path;
import com.usabb.models.BaseProduct;
import com.usabb.models.ImportData;
import com.usabb.models.VariantProduct;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class JsonUtils {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private static final String CONFIGURATION = "ConfigurationPath";
    private static final String BASE_MODEL = "BMT";
    private static final String VARIANT_PRODUCT = "SKU";
    private static final String CATEGORIES = "ProductCategories";
    private static final String FUNCTIONAL_CATEGORY = "FUNCTIONAL CATEGORY";
    private static final String BASE_MODEL_COLUMN_NAME = "Base Model";
    private static final String JSON_SOURCE = ContentUtils.readContentFile(Path.jsonPath).toString();
    private static final String JSON_BMT = getJSONArray(JSON_SOURCE, BASE_MODEL);
    private static final String JSON_SKU = getJSONArray(JSON_SOURCE, VARIANT_PRODUCT);

    public static BaseProduct getBaseProduct(String bmt) {
        JSONArray jsonArray = new JSONArray(JSON_BMT);
        BaseProduct product = new BaseProduct();
        for (Object object : jsonArray) {
            JSONObject objectJson = new JSONObject(object.toString());
            if (objectJson.has(bmt)) {
                product = deserializeBaseProduct(objectJson.get(bmt).toString());
                break;
            }
        }
        return product;
    }

    private static BaseProduct deserializeBaseProduct(String json) {
        BaseProduct product = new BaseProduct();
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readTree(json);
            ImportData importData = new ImportData();
            importData.setBaseProduct(objectMapper.treeToValue(node, BaseProduct.class));
            product = importData.getBaseProduct();
        } catch (IOException ioEx) {
            logger.error("Error parse json {}", ioEx);
        }
        return product;
    }

    public static VariantProduct getVariantProduct(String sku) {
        JSONArray jsonArray = new JSONArray(JSON_SKU);
        VariantProduct product = new VariantProduct();
        for (Object object : jsonArray) {
            JSONObject objectJson = new JSONObject(object.toString());
            if (objectJson.has(sku)) {
                product = deserializeVariantProduct(objectJson.get(sku).toString());
                break;
            }
        }
        return product;
    }

    private static VariantProduct deserializeVariantProduct(String json) {
        VariantProduct product = new VariantProduct();
        final ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readTree(json);
            ImportData importData = new ImportData();
            importData.setVariantProduct(objectMapper.treeToValue(node, VariantProduct.class));
            product = importData.getVariantProduct();
        } catch (IOException ioEx) {
            logger.error("Error parse json {}", ioEx);
        }
        return product;
    }

    private static String getJSONArray(String json, String identifier) {
        JSONObject object = new JSONObject(json);
        JSONArray jsonArray = object.getJSONArray(identifier);
        return jsonArray.toString();
    }

    public static BaseProduct getRandomBaseProductWithAttributeOrWithOut(String attribute, boolean hasAttribute) {
        BaseProduct product = new BaseProduct();
        JSONArray jsonArray = new JSONArray(JSON_BMT);
        for (Object object : jsonArray) {
            JSONObject objectJson = new JSONObject(object.toString());
            Iterator<String> keys = objectJson.keys();
            String key = keys.next();
            if (!Objects.equals(new JSONObject(objectJson.get(key).toString()).get(attribute).toString(), "") && !Objects.equals(new JSONObject(objectJson.get(key).toString()).get(attribute).toString(), "None") && hasAttribute) {
                product = getBaseProduct(key);
                break;
            } else if (Objects.equals(new JSONObject(objectJson.get(key).toString()).get(attribute).toString(), "") && !hasAttribute) {
                product = getBaseProduct(key);
                break;
            }
        }
        return product;
    }

    public static VariantProduct getRandomVariantProductWithAttributeOrWithOut(String attribute, boolean hasAttribute) {
        VariantProduct product = new VariantProduct();
        JSONArray jsonArray = new JSONArray(JSON_SKU);
        for (Object object : jsonArray) {
            JSONObject objectJson = new JSONObject(object.toString());
            Iterator<String> keys = objectJson.keys();
            String key = keys.next();
            if (!Objects.equals(new JSONObject(objectJson.get(key).toString()).get(attribute).toString(), "null") && hasAttribute) {
                product = getVariantProduct(key);
                break;
            } else if (Objects.equals(new JSONObject(objectJson.get(key).toString()).get(attribute).toString(), "null") && !hasAttribute) {
                product = getVariantProduct(key);
                break;
            }
        }
        return product;
    }

    public static String getProductForConfiguration(String functionalCategory, String configName) {
        return getProductThatHasMoreThanOneAttributeForConfiguration(getAttributeForConfiguration(functionalCategory, configName), functionalCategory);
    }

    public static String getAttributeForConfiguration(String functionalCategory, String configName) {
        JSONArray jsonArray = new JSONArray(getJSONArray(JSON_SOURCE, CONFIGURATION));
        String attribute = new String();
        for (Object object : jsonArray) {
            JSONObject objectJson = new JSONObject(object.toString());
            Iterator<String> keys = objectJson.keys();
            String key = keys.next();
            if (key.equalsIgnoreCase(functionalCategory)) {
                JSONObject configs = new JSONObject(objectJson.get(key).toString());
                attribute = configs.getString(configName);
            }
        }
        return attribute;
    }

    private static String getProductThatHasMoreThanOneAttributeForConfiguration(String attribute, String category) {
        boolean isBaseAttribute = getAttributePresenceStatusInSheet(BASE_MODEL, attribute);
        List<BaseProduct> baseProductsInCategory = getBaseProductsWithAttribute(FUNCTIONAL_CATEGORY, category);
        if (isBaseAttribute) {
            if (isAttributeMultipleInBaseProducts(attribute, baseProductsInCategory)) {
                return baseProductsInCategory.get(0).getProductGroupPDP();
            }
        } else {
            List<VariantProduct> variantProductsInCategory = new ArrayList<>();
            for (int i = 0; i < baseProductsInCategory.size(); ++i) {
                List<VariantProduct> variantProducts = getVariantProductsWithAttribute(BASE_MODEL_COLUMN_NAME,
                        baseProductsInCategory.get(i).getBaseModel());
                if (variantProducts.size() > 1) variantProductsInCategory.addAll(variantProducts);
            }
            if (isAttributeMultipleInVariantProducts(attribute, variantProductsInCategory)) {
                return variantProductsInCategory.get(0).getMaterialDescription();
            }
        }
        return null;
    }

    private static boolean isAttributeMultipleInBaseProducts(String name, List<BaseProduct> products) {
        for (int i = 1; i < products.size(); ++i) {
            if (!products.get(i).getAttribute(name).equals(products.get(i - 1).getAttribute(name))) return true;
        }
        return false;
    }

    private static boolean isAttributeMultipleInVariantProducts(String name, List<VariantProduct> products) {
        for (int i = 1; i < products.size(); ++i) {
            if (!products.get(i).getAttribute(name).equals(products.get(i - 1).getAttribute(name))) return true;
        }
        return false;
    }

    private static boolean getAttributePresenceStatusInSheet(String sheetName, String attribute) {
        JSONArray jsonArray = new JSONArray(getJSONArray(JSON_SOURCE, sheetName));
        for (Object object : jsonArray) {
            JSONObject objectJson = new JSONObject(object.toString());
            Iterator<String> keys = objectJson.keys();
            String key = keys.next();
            return new JSONObject(objectJson.get(key).toString()).has(attribute);
        }
        return false;
    }

    private static ArrayList<String> getKeysInSheet(String sheetName) {
        ArrayList<String> keysList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(getJSONArray(JSON_SOURCE, sheetName));
        for (Object object : jsonArray) {
            JSONObject objectJson = new JSONObject(object.toString());
            Iterator<String> keys = objectJson.keys();
            keysList.add(String.valueOf(keys.next()));
        }
        return keysList;
    }

    private static List<BaseProduct> getBaseProductsWithAttribute(String attributeName, String value) {
        List<BaseProduct> products = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(getJSONArray(JSON_SOURCE, BASE_MODEL));
        int i = 0;
        for (Object object : jsonArray) {
            JSONObject objectJson = new JSONObject(object.toString());
            Iterator<String> keys = objectJson.keys();
            String key = keys.next();
            if (objectJson.getJSONObject(key).get(attributeName).toString().equalsIgnoreCase(value)) {
                products.add(getBaseProduct(key));
            }
        }
        return products;
    }

    public static List<VariantProduct> getVariantProductsWithAttribute(String attributeName, String value) {
        List<VariantProduct> products = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(JSON_SKU);
        for (Object object : jsonArray) {
            JSONObject objectJson = new JSONObject(object.toString());
            Iterator<String> keys = objectJson.keys();
            String key = keys.next();
            if ((new JSONObject(objectJson.get(key).toString()).get(attributeName).toString().equalsIgnoreCase(value))) {
                products.add(getVariantProduct(key));
            }
        }
        return products;
    }

    public static VariantProduct getProductWithUpCrossSell(String arg0) {
        VariantProduct mainProduct = new VariantProduct();
        ArrayList<String> categoriesConf = getKeysInSheet("ConfigurationPath");
        JSONArray jsonArray = new JSONArray(JSON_BMT);
        BaseProduct product = new BaseProduct();
        for (Object object : jsonArray) {
            JSONObject objectJson = new JSONObject(object.toString());
            Iterator<String> keys = objectJson.keys();
            String key = keys.next();
            if (!Objects.equals(new JSONObject(objectJson.get(key).toString()).get(arg0).toString(), "")) {
                product = getBaseProduct(key);
                ArrayList<String> sellProducts = (ArrayList<String>)
                        (arg0.equalsIgnoreCase("Similar products") ? product.getUpSellArray() : product.getCrossSellArray());
                for (String s : sellProducts) {
                    if (categoriesConf.contains(getBaseProduct(s).getFunctionalCategory())) {
                        if (getVariantProductsWithAttribute("Base Model", s).size() != 0) {
                            return getVariantProductsWithAttribute("Base Model", key).get(0);
                        }
                    }
                }
            }
        }
        return mainProduct;
    }

    public static VariantProduct getProductAssemblyRequiredAttribute(String attribute) {
        VariantProduct mainProduct = new VariantProduct();
        ArrayList<String> categoriesConf = getKeysInSheet("ConfigurationPath");
        String attributeName = "Assembly Required";
        for (BaseProduct baseProduct : getBaseProductsWithAttribute(attributeName, attribute)) {
            String key = baseProduct.getBaseModel();
            if (categoriesConf.contains(baseProduct.getFunctionalCategory())) {
                if (getVariantProductsWithAttribute("Base Model", key).size() != 0) {
                    return getVariantProductsWithAttribute("Base Model", key).get(0);
                }
            }
        }
        return mainProduct;
    }
}
