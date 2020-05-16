package com.bayamp.cucumber.selenium.step.definitions;

import com.bayamp.selenium.webmail.base.BaseWebUI;
import com.bayamp.selenium.webmail.pageobjects.LandingPage;
import com.bayamp.selenium.webmail.pageobjects.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTestsStepDefinition extends BaseWebUI {
    private WebDriver driver;
    private LoginPage loginPage;
    private LandingPage landingPage;
    private String userName,password;

    // login positive test
    @Given("I login to BayAmp WebMail")
    public void loginPositiveTest() throws Exception {

        driver = getDriver();
        loginPage =  new LoginPage(driver);
        userName = getUserName();
        password = getPassword();
        landingPage = loginPage.loginSuccessful(userName,password);
    }
    @When("verify login is successful")
    public void verify(){
        Assert.assertTrue(landingPage.isLogOutElementPresent());
    }
    @Then("logout and close")
    public void logout() {
        driver.quit();
    }

    //login negative test
    @Given("I open BayAmp WebMail")
    public void openBayAmpWebMail() throws Exception {
        driver = getDriver();
        loginPage =  new LoginPage(driver);
    }
    @When("I click login")
    public void clickLogin() throws Exception {
         loginPage.login("","");
    }
    @Then("I see the error message")
    public void validate() throws InterruptedException {
        loginPage.isErrorMessagePresent();
    }

}
