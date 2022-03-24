import Utility.DriverFactory;
import Utility.PropertiesFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;


public class TestNGGomez {
    private String url = PropertiesFile.getProperty("url");
    public WebDriver driver = DriverFactory.getDriver();
    DemoBlazeCategories demoBlazeCategories;
    DemoBlazeProductsPage demoBlazeProductsPage;
    DemoBlazeDetailItemPage demoBlazeDetailItemPage;
    DemoBlazeNavBarPage demoBlazeNavBarPage;
    DemoBlazeCartPage demoBlazeCartPage;
    DemoBlazeOrderFormPage demoBlazeOrderFormPage;
    DemoBlazeConfirmModal demoBlazeConfirmModal;

    @BeforeTest
    public void BeforeTest(){
        driver.get(url);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void NavigateInDemoBlaze(){
        demoBlazeCategories = new DemoBlazeCategories(driver);
        demoBlazeProductsPage = new DemoBlazeProductsPage(driver);
        demoBlazeDetailItemPage = new DemoBlazeDetailItemPage(driver);
        demoBlazeNavBarPage = new DemoBlazeNavBarPage(driver);
        demoBlazeCartPage = new DemoBlazeCartPage(driver);
        demoBlazeOrderFormPage = new DemoBlazeOrderFormPage(driver);
        demoBlazeConfirmModal = new DemoBlazeConfirmModal(driver);

        demoBlazeCategories.clickOnLaptopsButton();
        demoBlazeProductsPage.clickOnSonyVaioI5();
        String modelInDetail = demoBlazeDetailItemPage.getModel();
        String priceInDetail = demoBlazeDetailItemPage.getPrice();
        demoBlazeDetailItemPage.clickOnAddToCartButton();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        demoBlazeNavBarPage.clickOnCartSection();
        String modelInCart = demoBlazeCartPage.getModel();
        String priceInCart = demoBlazeCartPage.getPrice();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(modelInDetail, modelInCart);
        softAssert.assertEquals(priceInDetail, priceInCart);
        softAssert.assertAll();
        demoBlazeCartPage.clickOnPlaceOrderButton();
        String orderName = demoBlazeOrderFormPage.fillName("Gastón");
        String orderCountry = demoBlazeOrderFormPage.fillCountry("Argentina");
        String orderCity = demoBlazeOrderFormPage.fillCity("Banfield");
        String orderCard = demoBlazeOrderFormPage.fillCard("0000 1111 2222 3333");
        String orderMonth = demoBlazeOrderFormPage.fillMonth("March");
        String orderYear = demoBlazeOrderFormPage.fillYear("2022");
        demoBlazeOrderFormPage.clickOnPurchaseButton();
        String thanksMessage = demoBlazeConfirmModal.getThanks();
        String expectedMessage = "Thank you for your purchase!";
        Assert.assertEquals(thanksMessage,expectedMessage);
        Assert.assertEquals(demoBlazeConfirmModal.getAmout(),priceInCart);
        Assert.assertEquals(demoBlazeConfirmModal.getCard(),orderCard);
        Assert.assertEquals(demoBlazeConfirmModal.getName(),orderName);
    }

    @AfterTest
    public void EndTest(){
        driver.quit();
    }
}
