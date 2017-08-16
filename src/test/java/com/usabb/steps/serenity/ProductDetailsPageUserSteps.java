package com.usabb.steps.serenity;

import com.usabb.pages.ProductDetailsPage;
import com.usabb.utils.SoftAssert;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

import java.util.List;

public class ProductDetailsPageUserSteps extends ScenarioSteps {
    ProductDetailsPage productDetailsPage;

    @Step
    public void clickOnProductMainImage() {
        productDetailsPage.clickOnProductMainImage();
    }

    @Step
    public void verifyThatZoomedImageIsShown() {
        Assert.assertTrue("The zoomed modal is not shown", productDetailsPage.getZoomedModalVisibleStatus());
        Assert.assertTrue("Wrong image is opened. The image is not the same with the image on gallery view",
                productDetailsPage.compareProductImages());
        Assert.assertTrue("The close button is not shown", productDetailsPage.getCloseButtonOnZoomedModalWindowStatus());
    }

    @Step
    public void clickOnCloseButtonOfZoomModal() {
        productDetailsPage.clickOnCloseButtonOnZoomModal();
    }

    @Step
    public void verifyThatZoomedImageIsNotShown() {
        Assert.assertFalse("The zoomed modal is shown", productDetailsPage.getZoomedModalInvisibleStatus());
    }

    @Step
    public void clickOnZoomedImage() {
        productDetailsPage.clickOnZoomedImage();
    }

    @Step
    public void verifyThatImageIsMovingAccordingToTheCursorPosition() {
        Assert.assertTrue("Image is not moving by XY offset",
                productDetailsPage.verifyThatImageIsMovingAccordingToTheCursorPosition(150, 150));
    }

    @Step
    public void verifyModalWindow(String arg0) {
        switch (arg0) {
            case "Cart PDP":
              /*  HashMap<String, String> productDataFromSession = (HashMap<String, String>) Serenity.getCurrentSession().get("PDP");
                String prodName = productDataFromSession.get("Name");
                String prodPrice = productDataFromSession.get("Price");
                String prodQuantity = productDataFromSession.get("Quantity");

                String quantity = productDetailsPage.returnProductTextByClassName("qty");
                String price = productDetailsPage.returnPriceInModal();
                */

                SoftAssert.assertTrue("The Cart header sign is missed",
                        "Added to Your Shopping Cart".equals(productDetailsPage.getModalHeaderSign()));
                SoftAssert.assertTrue("The CheckOut button is missed", productDetailsPage.getDisplayStatusOfButton("Check Out"));
                SoftAssert.assertTrue("The Close button is missed", productDetailsPage.getDisplayStatusOfCloseButton());
                /*TODO return changes after prices will be done
                SoftAssert.assertTrue("Wrong Name of product", prodName.equalsIgnoreCase(productDetailsPage.getProductNameInModal()));
                SoftAssert.assertTrue("Wrong quantity", prodQuantity.equalsIgnoreCase(quantity.replaceAll("[^0-9]", "")));
                SoftAssert.assertTrue("Wrong price", convertToDouble(prodPrice.substring(prodPrice.indexOf("$") + 1))
                        == (convertToDouble(quantity.substring(quantity.lastIndexOf(" ") + 1))
                        * convertToDouble(price.substring(price.indexOf("$") + 1))));
                */
                break;
        }
        SoftAssert.assertAll();
    }

    private double convertToDouble(String value) {
        try {
            return Double.valueOf(value.replace(",", ""));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Step
    public void rememberProductData() {
        productDetailsPage.rememberProductDataOnPdp();
    }

    @Step
    public void changeProductQuantity(String arg0) {
        productDetailsPage.enterValueInQuantityField(arg0);
    }

    @Step
    public void verifyThatQtyFieldIsPresentedOnPdp() {
        Assert.assertTrue("The qty input field is not shown", productDetailsPage.getQtyFieldPresenceStatus());
    }

    @Step
    public void checkQuantityOnPDP(String arg0) {
        Assert.assertTrue("Wrong quantity on pdp:", arg0.equals(productDetailsPage.getQuantityOfProduct()));
    }

    @Step
    public void verifyStatusOfQtyButton(String arg0) {
        Assert.assertFalse("The " + arg0 + " qty button is not disabled", productDetailsPage.getQtyButtonEnabledStatus(arg0));
    }

    @Step
    public void verifyThatRecommendedProductsAreShown(String type) {
        List<String> results = productDetailsPage.verifyThatRecommendedProductsAreShown(type);
        Assert.assertTrue("" + results, results.size() == 0);
    }

    @Step
    public void clickOnRecommendedProductInSection(String arg0, String arg1) {
        productDetailsPage.clickOnRecommendedProductInSection(arg0, arg1);
    }

    @Step
    public void clickOnProductLinkInPopUp() {
        productDetailsPage.clickOnProductLinkInPopUp();
    }

    @Step
    public void verifyThatAppropriateProductPageIsOpened() {
        Assert.assertTrue("Its not a clicked product page", productDetailsPage.compareClickedPageWithExpected());
    }

    @Step
    public void searchForProductWithAttribute(String arg0, String arg1, String arg2) {
        productDetailsPage.openPdpOfProductWithAttribute(arg0, arg1, arg2);
    }

    @Step
    public void verifyPresenceOfToolsAssemblyText(String arg0) {
        Assert.assertTrue("The tools assembly presence is not " + arg0, arg0.equalsIgnoreCase(productDetailsPage.getToolsAssemblyText()));
    }

    @Step
    public void verifySimilarProductInformation() {
        String prodNameSaved = Serenity.getCurrentSession().get("SimilarProdName").toString();
        String prodPriceSaved = Serenity.getCurrentSession().get("SimilarProdPrice").toString();
        SoftAssert.assertTrue("Wrong product name in modal.", prodNameSaved.equalsIgnoreCase(productDetailsPage.getSimilarProductNameInModal()));
        SoftAssert.assertTrue("Wrong product price in modal.", prodPriceSaved.equalsIgnoreCase(productDetailsPage.getSimilarProductPrice()));
        SoftAssert.assertAll();
    }

    @Step
    public void verifyProductName(String arg0) {
        Assert.assertTrue("The product name is not " + arg0, productDetailsPage.checkProductName(arg0));
    }

    @Step
    public void verifyDropDownOnPdp(String arg0) {
        Assert.assertTrue("Missed " + arg0 + " dropdown on PDP", productDetailsPage.checkDropDownOnPdp(arg0));
    }

    @Step
    public void openPdpForProductConfiguration(String arg0, String arg1) {
        productDetailsPage.openPdpOfProductWithConfiguration(arg0, arg1);
    }

    @Step
    public void verifyThatConfigurationIsShownOnPdp() {
        String arg0 = (String) Serenity.getCurrentSession().get("AttributeConfig");
        Assert.assertTrue("Missed " + arg0 + " dropdown on PDP for " + getDriver().getCurrentUrl(), productDetailsPage.checkDropDownOnPdp(arg0));
    }

    @Step
    public void openPdpWithProductThatHasUpCrossSellProducts(String arg0) {
        productDetailsPage.openPdpWithProductThatHasUpCrossSellProducts(arg0);
    }

    @Step
    public void openPdpWithProductThatHasAssemblyRequiredAttribute(String arg0) {
        productDetailsPage.openPdpWithProductThatHasAssemblyRequiredAttribute(arg0);
    }

    @Step
    public void verifyPresenceOfToolsAssembly() {
        Assert.assertTrue("The tools assembly is presented", productDetailsPage.verifyPresenceOfToolsAssembly());
    }

    @Step
    public void selectValueInQtyDropDown(String arg0) {
        productDetailsPage.selectValueInQtyDropDown(arg0);
    }
}
