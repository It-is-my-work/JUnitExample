package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PrintPage {

    String printTitle;

    SelenideElement firstPrint = $("div.masonry-grid-item:first-child");

    public PrintPage selectTypeOfArt(String nameOfArtType){
        $("prints-index-carousel div.slick-list").$(byText(nameOfArtType)).click();
        return this;
    }

    public String getPrintTitle(){
        return this.printTitle;
    }

    public PrintPage setPrintTitle(){
        this.printTitle = firstPrint.$(".print-masonry-preview-title").getText();
        return this;
    }

    public PrintPage selectFirstPrint(){
        firstPrint.click();
        return this;
    }

    public PrintPage openPrintPage(){
        open("/prints");
        return this;
    }

    public void checkPageTitle(String artType){
        $(".printsPage-home-grid-title").shouldHave(text(artType));
    }
}
