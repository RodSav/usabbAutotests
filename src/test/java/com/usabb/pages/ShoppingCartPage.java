package com.usabb.pages;

import com.usabb.locators.ProductDetailsPageLocators;
import com.usabb.locators.ShoppingCartLocators;
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

public class ShoppingCartPage extends PageObject {

    public void rememberInformationOffAllProductsOnCartPage() {
        Serenity.getCurrentSession().put("ProductsOnCartPage", getProductsOnPage());
    }

    public List<Product> getProductsOnPage() {
        int productCount = findAll(ShoppingCartLocators.ALL_PRODUCTS_FOR_COUNT).size();
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productCount; ++i) {
            Product product = new Product();
            product.setName(findAll(ShoppingCartLocators.ALL_PRODUCTS_NAME).get(i).getText());
            product.setCode(findAll(ShoppingCartLocators.ALL_PRODUCTS_CODE).get(i).getText());
            // product.setStock(findAll(ShoppingCartLocators.ALL_PRODUCTS_STOCK).get(i).getText());
            product.setPrice(findAll(ShoppingCartLocators.ALL_PRODUCTS_PRICE).get(i).getText());
            product.setQuantity($(ShoppingCartLocators.ALL_QUANTITY_INPUT.replace("$1", String.valueOf(i))).getValue());
//            product.setDelivery(findAll(ShoppingCartLocators.ALL_DELIVERY).get(i).getText());
            product.setTotalPrice(findAll(ShoppingCartLocators.ALL_TOTAL_PRICE).get(i).getText());
            products.add(product);
        }
        return products;
    }

    public ArrayList<String> verifyProductsOnCartPage() {
        ArrayList<String> results = new ArrayList<>();
        List<Product> productsListOld = (List<Product>) Serenity.getCurrentSession().get("ProductsOnCartPage");
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

    public boolean checkThatAddedProductIsPresentedInTheCart() {
        HashMap<String, String> productInformation = (HashMap<String, String>) Serenity.getCurrentSession().get("PDP");
        for (WebElement name : findAll(ShoppingCartLocators.ALL_PRODUCTS_NAME)) {
            if (name.getText().equals(productInformation.get("Name"))) return true;
        }
        return false;
    }

    public void clickOnAddedProductOnCartPage() {
        HashMap<String, String> productInformation = (HashMap<String, String>) Serenity.getCurrentSession().get("PDP");
        for (WebElement name : findAll(ShoppingCartLocators.ALL_PRODUCTS_NAME)) {
            if (name.getText().equals(productInformation.get("Name"))) {
                name.click();
                return;
            }
        }
    }

    public boolean verifyThatAppropriatePageIsOpenedWithAddedProduct() {
        HashMap<String, String> productInformation = (HashMap<String, String>) Serenity.getCurrentSession().get("PDP");
        String productName = productInformation.get("Name");
        String name = $(ProductDetailsPageLocators.PRODUCT_NAME).getText();
        if (productName.equals(name.substring(0, name.indexOf("ID")))) return true;
        else return false;
    }

    public boolean verifyThatRemoveButtonIsShownPerEachRecord() {
        int productCount = findAll(ShoppingCartLocators.ALL_PRODUCTS_FOR_COUNT).size();
        int removeButtonCount = findAll(ShoppingCartLocators.ALL_REMOVE_BUTTON_POINT).size();
        return productCount == removeButtonCount;
    }

    public void removeRecordFromTheCart(int arg0) {
        int position = arg0 - 1;
        String productNameForDeletion = findAll(ShoppingCartLocators.ALL_PRODUCTS_NAME).get(position).getText();
        Serenity.getCurrentSession().put("DeletedProduct", productNameForDeletion);
        findAll(ShoppingCartLocators.ALL_REMOVE_BUTTON_POINT).get(position).click();
        WebElement removeButton = findAll(ShoppingCartLocators.ALL_REMOVE_BUTTON).get(position);
        waitFor(ExpectedConditions.elementToBeClickable(removeButton));
        removeButton.click();
        $(ShoppingCartLocators.POP_UP_BUTTON.replace("$1", "Yes")).click();
    }

    public boolean verifyThatProductIsDeletedFromTheCart() {
        String productName = Serenity.getCurrentSession().get("DeletedProduct").toString();
        for (WebElement product : findAll(ShoppingCartLocators.ALL_PRODUCTS_NAME)) {
            if (product.getText().equals(productName)) return false;
        }
        return true;
    }

    public boolean verifyThatTotalIsRecalculated(double total) {
        List<Product> products = (List<Product>) Serenity.getCurrentSession().get("ProductsOnCartPage");
        String productName = Serenity.getCurrentSession().get("DeletedProduct").toString();
        double expectedTotal = 0.0;
        for (Product product : products) {
            if (!product.getName().equals(productName)) expectedTotal += product.getTotalPrice();
        }
        return expectedTotal == total;
    }

    public String getTotalPrice() {
        return $(ShoppingCartLocators.GRAND_TOTAL_PRICE).getText().replaceAll("[^.0-9]", "");
    }

    public String getTotalPriceInMiniCart() {
        return $(ShoppingCartLocators.MINI_CART_TOTAL_PRICE).getText().replaceAll("[^.0-9]", "");
    }

    public void hoverMouseOnMiniCart() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement($(ShoppingCartLocators.MINI_CART_ICON)).build().perform();
    }

    public List<String> verifyTheItemsInTheMiniCart(int itemsToCheck) {
        List<String> results = new ArrayList<>();
        int itemsCount = findAll(ShoppingCartLocators.MINI_CART_ITEMS).size();
        List<Product> products = (List<Product>) Serenity.getCurrentSession().get("ProductsOnCartPage");
        if (itemsCount != products.size() && products.size() < 5)
            results.add("The count of items is wrong. Expected: " + products.size() + " Found: " + itemsCount);
        for (int i = 0; i < itemsCount; ++i) {
            Product product = products.get(products.size() - i - 1);
            String prodName = findAll(ShoppingCartLocators.MINI_CART_PRODUCT_LINK).get(i).getText();
            double prodPrice = Double.valueOf(findAll(ShoppingCartLocators.MINI_CART_PRODUCTS_PRICE).get(i).getText().replaceAll("[^.0-9]", ""));
            if (!product.getName().equalsIgnoreCase(prodName))
                results.add("Wrong name of product. Expected: " + product.getName() + " Found: " + prodName);
            if (product.getPrice() != prodPrice)
                results.add("Wrong price of product. Expected: " + product.getPrice() + " Found: " + prodPrice);
        }
        return results;
    }

    public String getPageBodyHeader() {
        return $(ShoppingCartLocators.PAGE_BODY_HEADER).getText();
    }

    public boolean getVisibilityOfMiniCart() {
        return $(ShoppingCartLocators.MINI_CART_MODAL).isCurrentlyVisible();
    }

    public boolean getDeleteButtonPresenceStatus() {
        WebElementFacade deleteButton = findAll(ShoppingCartLocators.ALL_REMOVE_BUTTON_POINT).get(0);
        return deleteButton.isPresent() && deleteButton.isCurrentlyVisible();
    }

    public boolean getMaterialDescriptionPresenceStatus() {
        WebElementFacade productName = findAll(ShoppingCartLocators.ALL_PRODUCTS_NAME).get(0);
        return productName.isPresent() && productName.isCurrentlyVisible();
    }

    public boolean getSkuPresenceStatus() {
        WebElementFacade productSKU = findAll(ShoppingCartLocators.ALL_PRODUCTS_CODE).get(0);
        return productSKU.isPresent() && productSKU.isCurrentlyVisible();
    }

    public boolean getDescriptionPresenceStatus() {
        WebElementFacade productDescription = findAll(ShoppingCartLocators.ALL_PRODUCTS_DESCRIPTION).get(0);
        return productDescription.isPresent() && productDescription.isCurrentlyVisible();
    }

    public boolean getAssemblyRequiredPresenceStatus() {
        WebElementFacade assemblyRequired = findAll(ShoppingCartLocators.ALL_ASSEMBLY_REQUIRED).get(0);
        return assemblyRequired.isPresent() && assemblyRequired.isCurrentlyVisible();
    }

    public boolean getColorPresenceStatus() {
        WebElementFacade productColor = findAll(ShoppingCartLocators.ALL_COLOR).get(0);
        return productColor.isPresent() && productColor.isCurrentlyVisible();
    }

    public boolean getDeliveryPresenceStatus() {
        WebElementFacade productDelivery = findAll(ShoppingCartLocators.ALL_DELIVERY).get(0);
        return productDelivery.isPresent() && productDelivery.isCurrentlyVisible();
    }

    public boolean getPricePresenceStatus() {
        WebElementFacade productPrice = findAll(ShoppingCartLocators.ALL_PRODUCTS_PRICE).get(0);
        return productPrice.isPresent() && productPrice.isCurrentlyVisible();
    }

    public boolean getTotalPricePresenceStatus() {
        WebElementFacade productTotalPrice = findAll(ShoppingCartLocators.ALL_TOTAL_PRICE).get(0);
        return productTotalPrice.isPresent() && productTotalPrice.isCurrentlyVisible();
    }

    public List<String> verifyProductData() {
        List<String> results = new ArrayList<>();
        HashMap<String, String> productInformation = (HashMap<String, String>) Serenity.getCurrentSession().get("PDP");
        if (!findAll(ShoppingCartLocators.ALL_PRODUCTS_NAME).get(0).getText().equalsIgnoreCase(productInformation.get("Name"))) {
            results.add("Wrong Name of product, Expected: " + productInformation.get("Name") +
                    " Found: " + findAll(ShoppingCartLocators.ALL_PRODUCTS_NAME).get(0).getText());
        }
        if (!findAll(ShoppingCartLocators.ALL_PRODUCTS_CODE).get(0).getText().equalsIgnoreCase(productInformation.get("SKU"))) {
            results.add("Wrong SKU of product, Expected: " + productInformation.get("SKU") +
                    " Found: " + findAll(ShoppingCartLocators.ALL_PRODUCTS_CODE).get(0).getText());
        }
        if (!findAll(ShoppingCartLocators.ALL_PRODUCTS_DESCRIPTION).get(0).getText().equalsIgnoreCase(productInformation.get("LongDescription"))) {
            results.add("Wrong LongDescription of product, Expected: " + productInformation.get("LongDescription") +
                    " Found: " + findAll(ShoppingCartLocators.ALL_PRODUCTS_DESCRIPTION).get(0).getText());
        }
        if (!productInformation.get("ToolsAssembly").toLowerCase()
                .contains(findAll(ShoppingCartLocators.ALL_ASSEMBLY_REQUIRED).get(0).getText().toLowerCase())) {
            results.add("Wrong ToolsAssembly of product, Expected: " + productInformation.get("ToolsAssembly") +
                    " Found: " + findAll(ShoppingCartLocators.ALL_ASSEMBLY_REQUIRED).get(0).getText());
        }
        if (!$(ShoppingCartLocators.ALL_QUANTITY_INPUT.replace("$1", "0"))
                .getValue().equalsIgnoreCase(productInformation.get("Quantity"))) {
            results.add("Wrong Quantity of product, Expected: " + productInformation.get("Quantity") +
                    " Found: " + $(ShoppingCartLocators.ALL_QUANTITY_INPUT.replace("$1", "0")).getValue());
        }
        if (!findAll(ShoppingCartLocators.ALL_PRODUCTS_PRICE).get(0).getText().equalsIgnoreCase(productInformation.get("Price"))) {
            results.add("Wrong Quantity of product, Expected: " + productInformation.get("Price") +
                    " Found: " + findAll(ShoppingCartLocators.ALL_PRODUCTS_PRICE).get(0).getText());
        }
        //TODO update
        return results;

    }

    public String getQuantityInTheMiniCart() {
        String qtyText = $(ShoppingCartLocators.QTY_IN_MINI_CART).getText();
        return qtyText.substring(0, qtyText.lastIndexOf(' '));
    }

    public void clickOnLinkInCartHeader(String arg0) {
        $(ShoppingCartLocators.CART_HEADER_LINK.replace("$1", arg0)).click();
    }
}
