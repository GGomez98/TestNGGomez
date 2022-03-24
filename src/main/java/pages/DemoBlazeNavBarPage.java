package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoBlazeNavBarPage {
    By cartSection = By.xpath("//a[@id='cartur']");
    WebDriver driver;

    public DemoBlazeNavBarPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnCartSection(){
        driver.findElement(cartSection).click();
    }
}
