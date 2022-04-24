package pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CartPage {

    public void checkProductsInCart(String title, String price){
        $(".table-cart").shouldHave(text(title), text(price));
    }
}
