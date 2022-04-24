package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BlogPage {

    public BlogPage openBlogPage(){
        open("/blogs");
        return this;
    }

    public BlogPage filterArticlesByCategory(String categoryName){
        $(".slick-track").$(byText(categoryName)).click();
        return this;
    }

    public BlogPage checkFilteringResult(String categoryName){
        $$(".blog-card-category").first().shouldHave(Condition.text(categoryName));
        return this;
    }
}
