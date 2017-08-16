package com.usabb.steps.serenity;

import com.usabb.pages.SearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

/**
 * Created by ${Timonov_Viacheslav} on 4/21/17.
 */
public class SearchUserSteps extends ScenarioSteps {
    SearchPage searchPage;

    @Step
    public void searchForProductUsingSearchBar(String arg0) {
        searchPage.searchForProductUsingSearchBar(arg0);
    }

    @Step
    public void checkTheNameOfTheProductByPosition(String arg0, String arg1) {
        Assert.assertTrue("The name of product is not correct", arg1.equals(searchPage.getProductNameByPosition(arg0)));
    }

    @Step
    public void verifyThatTheSearchResultIsNotEmpty() {
        Assert.assertFalse("The search result is empty", searchPage.getResultEmptyStatus());
    }
}
