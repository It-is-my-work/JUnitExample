package pages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudioPage {

    public StudioPage openStudioPage(){
        open("/jobs");
        return this;
    }

    public StudioPage chooseStudio(String studioName){
        $(byText(studioName)).click();
        return this;
    }

    public StudioPage checkStudioName(String studioName){
        $(".page-header").shouldHave(text(studioName));
        return this;
    }

    public StudioPage checkStudioLocation(String location){
        $("p.text-center").shouldHave(text(location));
        return this;
    }

    public StudioPage checkStudioWebsite(String url){
        $("p.text-center a").shouldHave(attribute("href", url));
        return this;
    }
}
