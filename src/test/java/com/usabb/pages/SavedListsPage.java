package com.usabb.pages;

import com.usabb.locators.CommonElementsLocators;
import com.usabb.locators.ProductDetailsPageLocators;
import com.usabb.locators.SavedListsLocators;
import com.usabb.models.Product;
import com.usabb.utils.PageObject;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SavedListsPage extends PageObject {

    public void rememberInformationOffAllProductsOnListPage() {
        Serenity.getCurrentSession().put("ProductsOnListPage", getProductsOnPage());
    }

    public List<Product> getProductsOnPage() {
        int productCount = findAll(SavedListsLocators.ALL_PRODUCTS_FOR_COUNT).size();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productCount; ++i) {
            Product product = new Product();
            product.setName(findAll(SavedListsLocators.ALL_PRODUCTS_NAME).get(i).getText());
            product.setCode(findAll(SavedListsLocators.ALL_PRODUCTS_CODE).get(i).getText());
            product.setPrice(findAll(SavedListsLocators.ALL_PRODUCTS_PRICE).get(i).getText());
            product.setQuantity($(SavedListsLocators.ALL_QUANTITY_INPUT.replace("$1", String.valueOf(i))).getValue());
            product.setTotalPrice(findAll(SavedListsLocators.ALL_TOTAL_PRICE).get(i).getText());
            products.add(product);
        }
        return products;
    }

    public void clickOnButtonInModalAction(String arg0) {
        WebElementFacade button = $(SavedListsLocators.BUTTON_IN_MODAL_WITH_NAME.replace("$1", arg0));
        withTimeoutOf(5, TimeUnit.SECONDS).waitFor(ExpectedConditions.visibilityOf(button));
        button.click();
    }

    public ArrayList<String> verifyProductsOnRestoredListToCart() {
        ArrayList<String> results = new ArrayList<>();
        List<Product> productsListOld = (List<Product>) Serenity.getCurrentSession().get("ProductsOnListPage");
        List<Product> productsListNew = getProductsOnPage();
        if (productsListNew.size() != productsListOld.size())
            results.add("The amount of products on page is not equal to expected amount\n");
        for (int i = 0; i < Math.min(productsListNew.size(), productsListOld.size()); ++i) {
            if (!productsListOld.get(i).getCode().equalsIgnoreCase(productsListNew.get(i).getCode()))
                results.add("\nWrong SKU of product. Expected: "
                        + productsListOld.get(i).getCode()
                        + " Found: " + productsListNew.get(i).getCode());
        }
        return results;
    }
}
