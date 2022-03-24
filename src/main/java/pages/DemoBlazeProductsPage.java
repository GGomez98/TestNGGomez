package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoBlazeProductsPage {
    By firstElementModel = By.linkText("Sony vaio i5");
    WebDriver driver;

    public DemoBlazeProductsPage(WebDriver driver){

        this.driver = driver;
    }
    public void clickOnSonyVaioI5(){
        driver.findElement(firstElementModel).click();
    }
}
