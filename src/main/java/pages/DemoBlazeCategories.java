package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoBlazeCategories {
    By laptopsSection = By.linkText("Laptops");
    WebDriver driver;

    public DemoBlazeCategories(WebDriver driver){

        this.driver = driver;
    }

    public void clickOnLaptopsButton() {
        driver.findElement(laptopsSection).click();
    }
}
