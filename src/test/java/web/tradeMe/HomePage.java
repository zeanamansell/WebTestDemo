package web.tradeMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.tmsandbox.co.nz");

    }

    public ResultsPage searchFor (String searchText) {
        WebElement searchBox = driver.findElement(By.id("searchString"));
        searchBox.sendKeys(searchText);
        searchBox.submit();
        return PageFactory.initElements(this.driver, ResultsPage.class);
    }

}
