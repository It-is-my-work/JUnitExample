package pages.filters;

public enum BlogCategories {
    TUTORIAL("Tutorial"),
    MAKING("Making Of"),
    WORKFLOW("Work In Progress"),
    ARTICLE("Article"),
    NEWS("News"),
    GENERAL("General");

    public final String name;

    BlogCategories(String name){
        this.name = name;
    }
}
