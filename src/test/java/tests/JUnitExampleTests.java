package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.*;
import pages.filters.BlogCategories;

import java.util.List;
import java.util.stream.Stream;

@DisplayName("Class with parameterized test examples.")
public class JUnitExampleTests {

    ProductPage productPage = new ProductPage();
    CartPage cartPage = new CartPage();
    PrintPage printPage = new PrintPage();
    LearningPage learningPage = new LearningPage();
    StudioPage studioPage = new StudioPage();
    BlogPage blogPage = new BlogPage();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://www.artstation.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("Add art to cart")
    void addArtToCart() {
        printPage.openPrintPage()
                .setPrintTitle()
                .selectFirstPrint();
        productPage.setPrice()
                .addProductToCart()
                .checkToastContainer("Added to Cart")
                .checkBadgeCart("1")
                .openCart();
        cartPage.checkProductsInCart(printPage.getPrintTitle(),
                productPage.getPrice());
    }

    @ValueSource(strings = {
            "Nature and Landscapes",
            "People"
    })
    @ParameterizedTest(name = "Filter art by type {0}")
    void selectArtType(String artType) {
        printPage.openPrintPage()
                .selectTypeOfArt(artType)
                .checkPageTitle(artType);
    }

    @CsvSource(value = {
            "2D | Level up your digital and traditional 2D artwork-making abilities.",
            "3D | Master digital 3D art skills for animation, games, VFX, film, and much more.",
            "Career | Take charge of your creative career planning and development with these courses."
    },
            delimiter = '|'
    )
    @ParameterizedTest(name = "Choose {0} as the subject of study.")
    void choosingSubject(String subject, String description) {
        learningPage.openLearningPage()
                .chooseSubject(subject)
                .checkLearningPageTitle(subject)
                .checkLearningPageDescription(description);
    }

    static Stream<Arguments> choosingArtStudio() {
        return Stream.of(
                Arguments.of("Ubisoft German Studios",
                        List.of("https://bluebyte.ubisoft.com/en/jobs/", "Germany, Germany")),
                Arguments.of("Cloud Chamber",
                        List.of("http://www.cloudchamberstudios.com/", "Novato, CA (US) & Montreal, Quebec, Canada"))
        );
    }

    @MethodSource("choosingArtStudio")
    @ParameterizedTest(name = "Checking information about Studio {0}")
    void choosingArtStudio(String studioName, List<String> studioInformation){
        studioPage.openStudioPage()
                .chooseStudio(studioName)
                .checkStudioName(studioName)
                .checkStudioWebsite(studioInformation.get(0))
                .checkStudioLocation(studioInformation.get(1));
    }

    @EnumSource(BlogCategories.class)
    @ParameterizedTest(name = "Checking the result of filtering articles by category {0}")
    void blogFilterByCategoriesTest(BlogCategories categories){
        blogPage.openBlogPage()
                .filterArticlesByCategory(categories.name)
                .checkFilteringResult(categories.name);
    }
}
