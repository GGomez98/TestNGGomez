package pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoBlazeDetailItemPage {
    @FindBy(xpath = "//div[@id='tbodyid']/h2")
    WebElement modelDetail;
    @FindBy(xpath="//div[@id='tbodyid']/h3")
    WebElement priceDetail;
    @FindBy(xpath="//div[@id='tbodyid']/div[@class='row']/div/a")
    WebElement addToCart;
    WebDriver driver;

    public DemoBlazeDetailItemPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getModel(){
        System.out.println(modelDetail.getText());
        return modelDetail.getText();
    }

    public String getPrice(){
        String price = priceDetail.getText();
        String str = price.substring(1,4);
        System.out.println(str);
        return str;
    }

    public void clickOnAddToCartButton() {
        addToCart.click();
    }
}
