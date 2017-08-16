package com.usabb.utils;

import com.usabb.models.Product;

/**
 * Created by ${Timonov_Viacheslav} on 5/26/17.
 */
public class ProductsComparisonUtils {

    public static String compareProducts(Product expectedProduct, Product actualProduct) {
        String result = "";
        if (!expectedProduct.getName().equals(actualProduct.getName()))
            result += "Name: Expected: " + expectedProduct.getName() + " Found: " + actualProduct.getName() + "\n";
        if (!expectedProduct.getCode().equals(actualProduct.getCode()))
            result += "Code: Expected: " + expectedProduct.getCode() + " Found: " + actualProduct.getCode() + "\n";
        if (!expectedProduct.getPrice().equals(actualProduct.getPrice()))
            result += "Price: Expected: " + expectedProduct.getPrice() + " Found: " + actualProduct.getPrice() + "\n";
        int expQty = expectedProduct.getQuantity();
        int actQty = actualProduct.getQuantity();
        if (expQty != actQty)
            result += "Qty: Expected: " + expectedProduct.getQuantity() + " Found: " + actualProduct.getQuantity() + "\n";
        if (!expectedProduct.getTotalPrice().equals(actualProduct.getTotalPrice()))
            result += "Total price: Expected: " + expectedProduct.getTotalPrice() + " Found: " + actualProduct.getTotalPrice() + "\n";
        return result;
    }
}
