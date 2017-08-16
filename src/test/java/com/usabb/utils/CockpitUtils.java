package com.usabb.utils;

import com.usabb.locators.ContentManagementPageLocators;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CockpitUtils extends PageObject {

    private static final Logger logger = LoggerFactory.getLogger(CockpitUtils.class);

    public void clickOnElement(String xPath) {
        delaySpinner();
        WebElement element = $(xPath);
        int repeatCount = 10;
        do {
            try {
                withTimeoutOf(2, TimeUnit.SECONDS)
                        .waitFor(ExpectedConditions.elementToBeClickable(element));
                element.click();
                repeatCount = 0;
            } catch (Exception e) {
                logger.info("The element is not clickable, try count = " + repeatCount);
            }
            waitABit(1000);
            repeatCount--;
        } while (repeatCount > 0);
        if (repeatCount==0) throw new NoSuchElementException(xPath);
    }

    public void doubleClickOnElement(String xPath) {
        delaySpinner();
        WebElement element = $(xPath);
        int repeatCount = 10;
        do {
            try {
                withTimeoutOf(2, TimeUnit.SECONDS)
                        .waitFor(ExpectedConditions.visibilityOf(element));
            } catch (Exception e) {
                logger.info("The element is not visible, try count = " + repeatCount);
            }
            try {
                withTimeoutOf(2, TimeUnit.SECONDS)
                        .waitFor(ExpectedConditions.elementToBeClickable(element));
                Actions actions = new Actions(getDriver());
                actions.moveToElement(element).doubleClick().build().perform();
                repeatCount = 0;
            } catch (Exception e) {
                logger.info("The element is not clickable, try count = " + repeatCount);
            }
            waitABit(1000);
            repeatCount--;
        } while (repeatCount > 0);
        if (repeatCount==0) throw new NoSuchElementException(xPath);
    }

    public void waitForVisibilityWithCount(String xPath) {
        WebElement element = $(xPath);
        int repeatCount = 3;
        while (repeatCount > 0) {
            try {
                withTimeoutOf(60, TimeUnit.SECONDS)
                        .waitFor(ExpectedConditions.visibilityOf(element));
                break;
            } catch (Exception e) {
                logger.info("The element is not visible, try count = " + repeatCount);
            }
            repeatCount--;
        }
    }

    private void delaySpinner() {
        long timeout = 1500;
        boolean condition = false;
        int waitForSpinnerCount = 3;
        synchronized (this) {
            while (waitForSpinnerCount > 0 && condition) {
                try {
                    wait(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                condition = waitForSpinner();
                waitForSpinnerCount--;
            }
        }
    }


    private boolean waitForSpinner() {
        try {
            withTimeoutOf(60, TimeUnit.SECONDS).waitFor(ExpectedConditions
                    .invisibilityOfElementLocated(By.xpath(ContentManagementPageLocators.SPINNER)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
