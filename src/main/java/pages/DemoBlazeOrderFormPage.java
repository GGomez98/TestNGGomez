package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoBlazeOrderFormPage {

    By nameInput = By.xpath("//input[@id='name']");
    By countryInput = By.xpath("//input[@id='country']");
    By cityInput = By.xpath("//input[@id='city']");
    By cardInput = By.xpath("//input[@id='card']");
    By monthInput = By.xpath("//input[@id='month']");
    By yearInput = By.xpath("//input[@id='year']");
    By purchaseButton = By.xpath("//div[@id='orderModal']/div/div/div[@class='modal-footer']/button[2]");
    WebDriver driver;

    public DemoBlazeOrderFormPage(WebDriver driver){
        this.driver = driver;
    }
    public String fillName(String clientName){
        driver.findElement(nameInput).sendKeys(clientName);
        return clientName;
    }
    public String fillCountry(String country){
        driver.findElement(countryInput).sendKeys(country);
        return country;
    }
    public String fillCity(String city){
        driver.findElement(cityInput).sendKeys(city);
        return city;
    }
    public String fillCard(String card){
        driver.findElement(cardInput).sendKeys(card);
        return card;
    }
    public String fillMonth(String month){
        driver.findElement(monthInput).sendKeys(month);
        return month;
    }
    public String fillYear(String year){
        driver.findElement(yearInput).sendKeys(year);
        return year;
    }
    public void clickOnPurchaseButton(){
        driver.findElement(purchaseButton).click();
    }
}
