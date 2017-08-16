package com.usabb.steps;

import com.usabb.steps.serenity.ProductManagementUserSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
public class ProductManagementDefinitionSteps {

    @Steps
    ProductManagementUserSteps steps;

    @Then("^productmanager has logged in$")
    public void productmanagerHasLoggedIn() throws Throwable {
        steps.verifyThatCmsManagerHasLoggedIn();
    }

    @When("^select \"([^\"]*)\" product catalog$")
    public void selectProductCatalog(String arg0) throws Throwable {
        steps.clickOnVircoProductCatalog(arg0);
    }

    @When("^click on advanced search button$")
    public void clickOnAdvancedSearchButton() throws Throwable {
        steps.clickOnAdvancedSearchButton();
    }

    @When("^select \"([^\"]*)\" in type combobox$")
    public void selectInTypeCombobox(String arg0) throws Throwable {
        steps.clickOnTypeComboBox();
        steps.selectVariantInTypeComboBox(arg0);
    }

    @When("^perform products search$")
    public void performProductsSearch() throws Throwable {
        steps.clickOnGlobalSearchButton();
    }

    @When("^select \"([^\"]*)\" product from products list$")
    public void selectProductFromProductsList(String arg0) throws Throwable {
        steps.selectProductByNumberFromTheList(arg0);
    }

    @When("^remember value in \"([^\"]*)\" field$")
    public void rememberValueInField(String arg0) throws Throwable {
        steps.rememberValueInField(arg0);
    }

    @When("^enter \"([^\"]*)\" in \"([^\"]*)\" editor field$")
    public void enterInEditorField(String arg0, String arg1) throws Throwable {
        steps.enterTheValueInFieldByLabelName(arg0, arg1);
    }

    @When("^start product catalog synchronization$")
    public void startProductCatalogSynchronization() throws Throwable {
        steps.synchronizeProductCatalog();
    }

    @Then("^product is synchronized$")
    public void productIsSynchronized() throws Throwable {
        steps.verifyThatProductIsSynchronized();
    }

    @Then("^the data in \"([^\"]*)\" field is \"([^\"]*)\"$")
    public void theDataInFieldIs(String arg0, String arg1) throws Throwable {
        steps.verifyThatDataInFieldIsSaved(arg0, arg1);
    }

    @Then("^the field \"([^\"]*)\" is not editable$")
    public void theFieldIsNotEditable(String arg0) throws Throwable {
        steps.verifyThatFieldWithLabelIsNotEditable(arg0);
    }

    @When("^search for saved sku in cockpit$")
    public void searchForSavedSkuInCockpit() throws Throwable {
        steps.searchForProductSavedSku();
    }
}
