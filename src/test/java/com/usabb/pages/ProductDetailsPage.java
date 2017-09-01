package com.usabb.pages;

import com.usabb.locators.*;
import com.usabb.models.BaseProduct;
import com.usabb.models.VariantProduct;
import com.usabb.utils.JsonUtils;
import com.usabb.utils.PageObject;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class ProductDetailsPage extends PageObject {

    public void clickOnProductMainImage() {
        Serenity.getCurrentSession().put("pdpImagePath", $(ProductDetailsPageLocators.PRODUCT_MAIN_IMAGE).getAttribute("src"));
        $(ProductDetailsPageLocators.PRODUCT_MAIN_IMAGE).click();
    }

    public boolean compareProductImages() {
        String productPath = Serenity.getCurrentSession().get("pdpImagePath").toString() != null ?
                Serenity.getCurrentSession().get("pdpImagePath").toString() : "null";
        return productPath.equals($(ProductDetailsPageLocators.PRODUCT_IMAGE_ZOOMED).getAttribute("src"));
    }

    public boolean getZoomedModalVisibleStatus() {
        return $(ProductDetailsPageLocators.ZOOMED_IMAGE_MODAL_WINDOW).isVisible();
    }

    public boolean getZoomedModalInvisibleStatus() {
        withTimeoutOf(60000, TimeUnit.MILLISECONDS)
                .waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath(ProductDetailsPageLocators.ZOOMED_IMAGE_MODAL_WINDOW)));
        return $(ProductDetailsPageLocators.ZOOMED_IMAGE_MODAL_WINDOW).isCurrentlyVisible();
    }

    public boolean getCloseButtonOnZoomedModalWindowStatus() {
        return $(ProductDetailsPageLocators.ZOOMED_MODAL_CLOSE_BUTTON).isDisplayed();
    }

    public void clickOnCloseButtonOnZoomModal() {
        $(ProductDetailsPageLocators.ZOOMED_MODAL_CLOSE_BUTTON).click();
    }

    public void clickOnZoomedImage() {
        $(ProductDetailsPageLocators.PRODUCT_IMAGE_ZOOMED).click();
    }

    public boolean verifyThatImageIsMovingAccordingToTheCursorPosition(int xOffset, int yOffset) {
        String xInitial, yInitial;
        xInitial = $(ProductDetailsPageLocators.PRODUCT_IMAGE_ZOOMED).getCssValue("left");
        yInitial = $(ProductDetailsPageLocators.PRODUCT_IMAGE_ZOOMED).getCssValue("top");
        Actions action = new Actions(getDriver());
        action.moveByOffset(xOffset, yOffset).build().perform();
        return !xInitial.equals($(ProductDetailsPageLocators.PRODUCT_IMAGE_ZOOMED).getCssValue("left"))
                && !yInitial.equals($(ProductDetailsPageLocators.PRODUCT_IMAGE_ZOOMED).getCssValue("top"));
    }

    public String getModalHeaderSign() {
        return $(ProductDetailsPageLocators.CART_HEADER_SIGN).getText();
    }

    public boolean getDisplayStatusOfButton(String s) {
        return $(ProductDetailsPageLocators.CART_BUTTONS.replace("$1", s)).isDisplayed();
    }

    public boolean getDisplayStatusOfCloseButton() {
        return $(ProductDetailsPageLocators.CART_CLOSE_BUTTON).isDisplayed();
    }

    public String returnProductTextByClassName(String arg0) {
        return $("//*[@class='" + arg0 + "']").getText();
    }

    public void rememberProductDataOnPdp() {
        HashMap<String, String> productInformation = new HashMap<>();
        String name = $(ProductDetailsPageLocators.PRODUCT_NAME).getText();
        name = name.split("ID")[0];
        productInformation.put("Name", name);
        String price = $(ProductDetailsPageLocators.PRODUCT_PRICE).getText();
        productInformation.put("Price", price);
        String quantity = $(ProductDetailsPageLocators.PRODUCT_QUANTITY).getValue();
        productInformation.put("Quantity", quantity);
        String code = $(ProductDetailsPageLocators.PRODUCT_CODE).getText();
        productInformation.put("Code", code);
//        String sku = $(ProductDetailsPageLocators.PRODUCT_SKU).getText();
//        productInformation.put("SKU", sku);
//        String materialDescription = $(ProductDetailsPageLocators.MATERIAL_DESCRIPTION).getText();
//        productInformation.put("MaterialDescription", materialDescription);
//        String toolsAssembly = $(ProductDetailsPageLocators.TOOLS_ASSEMBLY).getText();
//        productInformation.put("ToolsAssembly", toolsAssembly);
//        String longDescription = $(ProductDetailsPageLocators.LONG_DESCRIPTION).getText();
//        productInformation.put("LongDescription", longDescription);
        Serenity.getCurrentSession().put("PDP", productInformation);
    }

    public String getProductNameInModal() {
        return $(ProductDetailsPageLocators.PRODUCT_NAME_IN_MODAL).getText();
    }

    public String returnPriceInModal() {
        return $(ProductDetailsPageLocators.PRODUCT_PRICE_ON_MODAL).getText();
    }

    public void enterValueInQuantityField(String arg0) {
        WebElement quantityField = $(ProductDetailsPageLocators.QUANTITY_FIELD);
        quantityField.clear();
        quantityField.sendKeys(arg0);
    }

    public boolean getQtyFieldPresenceStatus() {
        return $(ProductDetailsPageLocators.QUANTITY_FIELD).isPresent();
    }

    public String getQuantityOfProduct() {
        return $(ProductDetailsPageLocators.QUANTITY_FIELD).getValue();
    }

    public boolean getQtyButtonEnabledStatus(String arg0) {
        return $(ProductDetailsPageLocators.QUANTITY_BUTTON.replace("$1", arg0)).isEnabled();
    }

    public List<String> verifyThatRecommendedProductsAreShown(String type) {
        List<String> results = new ArrayList<>();
        String productName = $(ProductDetailsPageLocators.MATERIAL_DESCRIPTION).getText();
        VariantProduct variantProduct = JsonUtils.getVariantProduct(productName);
        String baseModel = variantProduct.getBaseModel();
        BaseProduct baseProduct = JsonUtils.getBaseProduct(baseModel);
        List<String> similarProducts;
        String typeOfProducts;
        if (type.equalsIgnoreCase("Cross-Sell")) {
            similarProducts = baseProduct.getCrossSellArray();
            typeOfProducts = "This product goes well with...";
        } else {
            similarProducts = baseProduct.getUpSellArray();
            typeOfProducts = "Recommended products";
        }
        List<String> recommendedProducts = getRecommendedProductsSkus(typeOfProducts);
        similarProducts = similarProducts.stream().sorted().collect(Collectors.toList());
        recommendedProducts = recommendedProducts.stream().sorted().collect(Collectors.toList());
        for (int i = 0; i < Math.min(similarProducts.size(), recommendedProducts.size()); ++i) {
            if (!rmSpaces(similarProducts.get(i)).equals(rmSpaces(recommendedProducts.get(i)))) {
                results.add("\nExpected: " + similarProducts.get(i) + " Found: " + recommendedProducts.get(i));
            }
        }
        return results;
    }

    private String rmSpaces(String s) {
        return s.replaceAll(" ", "");
    }

    public List<String> getRecommendedProductsSkus(String productCategory) {
        List<String> recommendedProducts = new ArrayList<>();
        for (WebElement element : findAll(ProductDetailsPageLocators.SIMILAR_PRODUCTS_LINKS.replace("$1", productCategory))) {
            String elementLink = element.getAttribute("href");
            String bmt = elementLink.substring(elementLink.indexOf("/p/") + 3, elementLink.lastIndexOf('/'));
            String baseModel = JsonUtils.getVariantProductsWithAttribute("SAP Material Number", bmt).get(0).getBaseModel();
            recommendedProducts.add(baseModel);
        }
        return recommendedProducts;
    }

    public void clickOnRecommendedProductInSection(String arg0, String arg1) {
        String prodName = findAll(ProductDetailsPageLocators.SIMILAR_PRODUCTS_NAMES.replace("$1", arg1)).get(Integer.valueOf(arg0) - 1).getText();
        String prodPrice = findAll(ProductDetailsPageLocators.SIMILAR_PRODUCTS_PRICES.replace("$1", arg1)).get(Integer.valueOf(arg0) - 1).getText();
        Serenity.getCurrentSession().put("SimilarProdName", prodName);
        Serenity.getCurrentSession().put("SimilarProdPrice", prodPrice);
        findAll(ProductDetailsPageLocators.SIMILAR_PRODUCTS_LINKS.replace("$1", arg1)).get(Integer.valueOf(arg0) - 1).click();
    }

    public void clickOnProductLinkInPopUp() {
        WebElement link = $(ProductDetailsPageLocators.SIMILAR_PRODUCT_LINK_IN_POP_UP);
        Serenity.getCurrentSession().put("SimilarProductLinkName", link.getText());
        link.click();
    }

    public boolean compareClickedPageWithExpected() {
        return $(ProductDetailsPageLocators.PRODUCT_NAME).getAttribute("innerHTML").equals(Serenity.getCurrentSession().get("SimilarProductLinkName").toString());
    }

    public void openPdpOfProductWithAttribute(String arg0, String arg1, String arg2) {
        boolean hasAttr = arg1.equalsIgnoreCase("has");
        String productName = arg0.equalsIgnoreCase("BMT") ? JsonUtils.getRandomBaseProductWithAttributeOrWithOut(arg2, hasAttr).getBaseModel() :
                JsonUtils.getRandomVariantProductWithAttributeOrWithOut(arg2, hasAttr).getMaterialDescription();
        searchForProductByName(productName);
    }

    private void searchForProductByName(String name) {
        $(SearchLocators.SEARCH_INPUT_FIELD).clear();
        $(SearchLocators.SEARCH_INPUT_FIELD).sendKeys(name);
        try {
            withTimeoutOf(10, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(SearchLocators.SEARCH_DROP_DOWN_ALL)));
            findAll(SearchLocators.SEARCH_DROP_DOWN_ALL).get(0).click();
        } catch (Exception e) {
            $(SearchLocators.SEARCH_INPUT_FIELD).sendKeys(Keys.ENTER);
            $(CategoryPageLocators.LIST_OF_PRODUCTS_IMAGES.replace("$1", "0")).click();
        }

    }

    public String getToolsAssemblyText() {
        String text = $(ProductDetailsPageLocators.TOOLS_ASSEMBLY_SIGN).getText();
        return text.substring(text.lastIndexOf(':') + 2);
    }

    public String getSimilarProductNameInModal() {
        return $(ProductDetailsPageLocators.SIMILAR_PRODUCT_LINK_IN_POP_UP).getText();
    }

    public String getSimilarProductPrice() {
        return $(ProductDetailsPageLocators.SIMILAR_PRODUCT_PRICE_IN_MODAL).getText();
    }

    public boolean checkProductName(String arg0) {
        return $(ProductDetailsPageLocators.PRODUCT_NAME).getText().startsWith(arg0);
    }

    public boolean checkDropDownOnPdp(String arg0) {
        for (WebElementFacade element : findAll(ProductDetailsPageLocators.VARIANT_PRODUCT_SELECTORS)) {
            if (element.isCurrentlyVisible()) {
                if (element.getText().equalsIgnoreCase(arg0)) return true;
            }
        }
        return false;
    }

    public void openPdpOfProductWithConfiguration(String arg0, String arg1) {
        String attribute = JsonUtils.getAttributeForConfiguration(arg0, arg1);
        Serenity.getCurrentSession().put("AttributeConfig", attribute);
        String name = JsonUtils.getProductForConfiguration(arg0, arg1);
        if (name == null) Assert.assertTrue("The chosen product doesn't contain information to show", false);
        searchForProductByName(name);
    }

    public void openPdpWithProductThatHasUpCrossSellProducts(String arg0) {
        VariantProduct product = JsonUtils.getProductWithUpCrossSell(arg0);
        String sku = String.valueOf(product.getMaterialNumber());
        getDriver().get(SiteData.DEV_STOREFRONT_URL + "/p/" + sku);
    }

    public void openPdpWithProductThatHasAssemblyRequiredAttribute(String attribute) {
        VariantProduct product = JsonUtils.getProductAssemblyRequiredAttribute(attribute);
        String sku = String.valueOf(product.getMaterialNumber());
        getDriver().get(SiteData.DEV_STOREFRONT_URL + "/p/" + sku);
    }

    public boolean verifyPresenceOfToolsAssembly() {
        String text = $(ProductDetailsPageLocators.TOOLS_ASSEMBLY_SIGN).getText();
        return text.length() == 0;
    }

    public void selectValueInQtyDropDown(String arg0) {
        $(ProductDetailsPageLocators.QTY_DROP_DOWN).click();
        WebElement dropDownValue = $(ProductDetailsPageLocators.QTY_DROP_DOWN_VALUES.replace("$1", arg0));
        waitFor(ExpectedConditions.visibilityOf(dropDownValue)).$(dropDownValue).click();
    }
}
