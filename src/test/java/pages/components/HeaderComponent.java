package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class HeaderComponent {

    public void goToCart(){
        $(".fa-shopping-cart").click();
    }

    public void checkBadgeCart(String numberOfProducts){
        $(".badge-cart-items").shouldHave(text(numberOfProducts));
    }
}
