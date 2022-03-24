package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoBlazeConfirmModal {
    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']/h2")
    WebElement thanks;
    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']/p")
    WebElement info;
    WebDriver driver;

    public  DemoBlazeConfirmModal(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getThanks(){
        return thanks.getText();
    }

    public String getAmout(){
        String p = info.getText();
        String amount = p.substring(20,23);
        System.out.println(amount);
        return amount;
    }

    public String getCard(){
        String p = info.getText();
        String card = p.substring(41,60);
        System.out.println(card);
        return card;
    }

    public String getName(){
        String p = info.getText();
        String name = p.substring(67,73);
        System.out.println(name);
        return name;
    }
}
