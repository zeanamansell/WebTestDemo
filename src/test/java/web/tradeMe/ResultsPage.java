package web.tradeMe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ResultsPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 10);
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("headerColumnGalleryViewText")));

    }

    public String getNumSearchResults() {
        return driver.findElement(By.id("totalCount")).getText();
    }

    public void viewAsList() {
        WebElement listView = driver.findElement(By.id("ListingViewBar_listViewTab_icon_a"));
        listView.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("PagingFooter")));
    }

    public String getTopOfListLocation() {
        return driver.findElement(By.cssSelector("#mainContent > div.supergrid-overlord > div > a > div > div.location-wrapper > div.location-info > div.location")).getText();
    }

    public AuctionPage goToAuctionPage() {
        WebElement topResult = driver.findElement(By.cssSelector("#mainContent > div.supergrid-overlord > div > a > div > div.image"));
        topResult.click();
        return PageFactory.initElements(this.driver, AuctionPage.class);
    }

}
