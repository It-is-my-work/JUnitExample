package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ToastComponent {

    SelenideElement toastContainer = $("#toast-container");

    public void checkToastContainer(String containerText){
        toastContainer.shouldHave(text(containerText));
    }
}
