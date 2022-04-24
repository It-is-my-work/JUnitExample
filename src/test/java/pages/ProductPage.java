package pages;

import pages.components.HeaderComponent;
import pages.components.ToastComponent;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {

    HeaderComponent headerComponent = new HeaderComponent();
    ToastComponent toastComponent = new ToastComponent();

    String price;

    public ProductPage setPrice(){
        this.price = $(".productPage-price").getText();
        return this;
    }

    public String getPrice(){
        return this.price;
    }

    public ProductPage addProductToCart(){
        $(".btn-success ").click();
        return this;
    }

    public ProductPage checkToastContainer(String toastText){
        toastComponent.checkToastContainer(toastText);
        return this;
    }

    public ProductPage checkBadgeCart(String numberOfProducts){
        headerComponent.checkBadgeCart(numberOfProducts);
        return this;
    }

    public void openCart(){
        headerComponent.goToCart();
    }

}
