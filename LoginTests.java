package tests;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest{
public HomePage homePage;   
public LoginPage loginPage;
String standardUsername = "standard_user";
String password = "secret_sauce";
String expectedText = "PRODUCTS";

String errorUsername = "locked_out_user";
String errorText = "Epic sadface: Sorry, this user has been locked out.";
String emptyUsername = "";
String emptyPassword = "";
String emptyUsernameError = "Epic sadface: Username is required";
String emptyPasswordError = "Epic sadface: Password is required";
String invalidPassword = "test1";
String invalidPasswordError = "Epic sadface: Username and password do not match any user in this service";

@Test
public void verifySuccesfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, password);
    homePage.verifySuccesfulLogin(expectedText);

    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
}
@Test
public void verifyUnsuccesfulLogin(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(errorUsername, password);
    loginPage.verifyUnsuccesfulLogin(errorText);

    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }

}
@Test
public void verifyEmptyUsernameError(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(emptyUsername, password);
    loginPage.verifyUnsuccesfulLogin(emptyUsernameError);
    
    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyEmptyPasswordError(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, emptyPassword);
    loginPage.verifyUnsuccesfulLogin(emptyPasswordError);
    
    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
}

@Test
public void verifyInvalidPasswordError(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.basePage();
    loginPage.login(standardUsername, invalidPassword);
    loginPage.verifyUnsuccesfulLogin(invalidPasswordError);
    
    try{
        Thread.sleep(5000);
    }
    catch(InterruptedException e){
        e.printStackTrace();
    }
}



}
