package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class LearningPage {

    public LearningPage openLearningPage(){
        open("/learning");
        return this;
    }

    public LearningPage chooseSubject(String subject){
        $(".learning-header-branches").$(byText(subject)).click();
        return this;
    }

    public LearningPage checkLearningPageTitle(String subject){
        $(".learning-header-title").shouldHave(Condition.text(subject));
        return this;
    }

    public LearningPage checkLearningPageDescription(String description){
        $(".learning-header .lead").shouldHave(Condition.text(description));
        return this;
    }
}
