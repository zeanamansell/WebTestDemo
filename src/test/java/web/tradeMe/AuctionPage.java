package web.tradeMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuctionPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AuctionPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("DetailsFooter_PageCounterContainer")));
    }

    public String getListingTitle() {
        return driver.findElement(By.id("ListingTitle_title")).getText();
    }
}
