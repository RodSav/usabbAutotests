package com.usabb.steps;

import com.usabb.steps.serenity.ProductDetailsPageUserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProductDetailsPageDefinitionSteps {
    @Steps
    ProductDetailsPageUserSteps steps;

    @When("^click on product image$")
    public void clickOnProductImage() throws Throwable {
        steps.clickOnProductMainImage();
    }

    @Then("^zoomed image is shown$")
    public void zoomedImageIsShown() throws Throwable {
        steps.verifyThatZoomedImageIsShown();
    }

    @When("^click on close zoom button$")
    public void clickOnCloseZoomButton() throws Throwable {
        steps.clickOnCloseButtonOfZoomModal();
    }

    @Then("^zoomed image is not shown$")
    public void zoomedImageIsNotShown() throws Throwable {
        steps.verifyThatZoomedImageIsNotShown();
    }

    @When("^click on zoomed image$")
    public void clickOnZoomedImage() throws Throwable {
        steps.clickOnZoomedImage();
    }

    @Then("^image is moving according to the cursor position$")
    public void imageIsMovingAccordingToTheCursorPosition() throws Throwable {
        steps.verifyThatImageIsMovingAccordingToTheCursorPosition();
    }

    @Then("^\"([^\"]*)\" modal window is opened$")
    public void modalWindowIsOpened(String arg0) throws Throwable {
        steps.verifyModalWindow(arg0);
    }

    @When("^remember product data on pdp$")
    public void rememberProductDataOnPdp() throws Throwable {
        steps.rememberProductData();
    }

    @When("^change product quantity to \"([^\"]*)\"$")
    public void changeProductQuantityTo(String arg0) throws Throwable {
        steps.changeProductQuantity(arg0);
    }

    @Then("^quantity field is presented on pdp$")
    public void quantityFieldIsPresentedOnPdp() throws Throwable {
        steps.verifyThatQtyFieldIsPresentedOnPdp();
    }

    @Then("^quantity on pdp is \"([^\"]*)\"$")
    public void quantityOnPdpIs(String arg0) throws Throwable {
        steps.checkQuantityOnPDP(arg0);
    }

    @Then("^qty button \"([^\"]*)\" is disabled$")
    public void qtyButtonIsDisabled(String arg0) throws Throwable {
        steps.verifyStatusOfQtyButton(arg0);
    }

    @Then("^\"([^\"]*)\" products are shown$")
    public void productsAreShown(String arg0) throws Throwable {
        steps.verifyThatRecommendedProductsAreShown(arg0);
    }

    @When("^click on \"([^\"]*)\" product in \"([^\"]*)\" section$")
    public void clickOnProductInSection(String arg0, String arg1) throws Throwable {
        steps.clickOnRecommendedProductInSection(arg0, arg1);
    }

    @When("^click on product link in pop-up$")
    public void clickOnProductLinkInPopUp() throws Throwable {
        steps.clickOnProductLinkInPopUp();
    }

    @Then("^pdp of clicked in pop-up product is opened$")
    public void pdpOfClickedInPopUpProductIsOpened() throws Throwable {
        steps.verifyThatAppropriateProductPageIsOpened();
    }

    @Then("^similar product information is shown in modal$")
    public void similarProductInformationIsShownInModal() throws Throwable {
        steps.verifySimilarProductInformation();
    }

    @Then("^product name is \"([^\"]*)\"$")
    public void productNameIs(String arg0) throws Throwable {
        steps.verifyProductName(arg0);
    }

    @When("^open pdp with \"([^\"]*)\" product that \"([^\"]*)\" \"([^\"]*)\" attribute$")
    public void openPdpWithProductThatAttribute(String arg0, String arg1, String arg2) throws Throwable {
        steps.searchForProductWithAttribute(arg0, arg1, arg2);
    }

    @Then("^the \"([^\"]*)\" drop-down is shown on pdp$")
    public void theDropDownIsShownOnPdp(String arg0) throws Throwable {
        steps.verifyDropDownOnPdp(arg0);
    }

    @When("^open pdp with product in the category \"([^\"]*)\" that has \"([^\"]*)\"$")
    public void openPdpWithProductInTheCategoryThatHas(String arg0, String arg1) throws Throwable {
        steps.openPdpForProductConfiguration(arg0, arg1);
    }

    @Then("^the configuration is shown on PDP$")
    public void theConfigurationIsShownOnPDP() throws Throwable {
        steps.verifyThatConfigurationIsShownOnPdp();
    }

    @When("^open pdp with product that has \"([^\"]*)\"$")
    public void openPdpWithProductThatHas(String arg0) throws Throwable {
        steps.openPdpWithProductThatHasUpCrossSellProducts(arg0);
    }

    @When("^open pdp with product that has Assembly Required attribute \"([^\"]*)\"$")
    public void openPdpWithProductThatHasAssemblyRequiredAttribute(String arg0) throws Throwable {
        steps.openPdpWithProductThatHasAssemblyRequiredAttribute(arg0);
    }

    @Then("^Tools assembly required text is \"([^\"]*)\"$")
    public void toolsAssemblyRequiredTextIs(String arg0) throws Throwable {
        steps.verifyPresenceOfToolsAssemblyText(arg0);
    }

    @Then("^Tools assembly required text is not presented$")
    public void toolsAssemblyRequiredTextIsNotPresented() throws Throwable {
        steps.verifyPresenceOfToolsAssembly();
    }

    @When("^select \"([^\"]*)\" in qty dropdown$")
    public void selectInQtyDropdown(String arg0) throws Throwable {
        steps.selectValueInQtyDropDown(arg0);
    }
}
