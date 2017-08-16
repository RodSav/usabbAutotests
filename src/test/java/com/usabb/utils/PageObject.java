package com.usabb.utils;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static net.serenitybdd.core.selectors.Selectors.xpathOrCssSelector;

/**
 * Created by ${Timonov_Viacheslav} on 6/14/17.
 */
public abstract class PageObject extends net.serenitybdd.core.pages.PageObject {

    @Override
    public <T extends net.serenitybdd.core.pages.WebElementFacade> T $(String xpathOrCssSelector) {
        waitForLoader();
        return element(xpathOrCssSelector);
    }

    @Override
    public List<WebElementFacade> findAll(String xpathOrCssSelector) {
        waitForLoader();
        return findAll(xpathOrCssSelector(xpathOrCssSelector));
    }

    @Step
    private void waitForLoader() {
        withTimeoutOf(30, TimeUnit.SECONDS).waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='page-overlay']")));
    }
}
