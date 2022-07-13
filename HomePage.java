package pages;

import java.util.concurrent.CountDownLatch;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    
    public HomePage (WebDriver driver){
        super(driver);
    }

    By homePageTitleBy = By.xpath("//*[@id='header_container']/div[2]/span");
    By shoppingCartBadgeBy = By.className("shopping_cart_badge");
    By addToCartButton1By = By.id("add-to-cart-sauce-labs-backpack");
    By numberOfItems = By.className("inventory_item");
    By menuButton = By.id("react-burger-menu-btn");
    By aboutButton = By.id("about_sidebar_link");
    String expectedLink = "https://saucelabs.com/";

    public HomePage verifySuccesfulLogin(String expectedText){
        String actualText = readText(homePageTitleBy);
        assertTextEquals(expectedText, actualText);
        return this;
    }

    public HomePage verifyProductAddedToCart (){
        click(addToCartButton1By);
        waitVisability(shoppingCartBadgeBy);
        return this;
    }

    public HomePage clickOnHamburgerMenu(){ 
        click(menuButton);
        return this;
    }

    public HomePage numberOfProducts (int expectedNumberOfProducts){
        int actualNumberOfProducts = countItems(numberOfItems);
        assertIntegerEquals(expectedNumberOfProducts, actualNumberOfProducts);
        return this;
    }

    public HomePage verifyAboutLink(){
        String actualLink = readHref(aboutButton);
        assertTextEquals(expectedLink, actualLink);
        return this;
    }

}
