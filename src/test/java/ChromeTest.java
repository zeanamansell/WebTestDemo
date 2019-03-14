import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import web.tradeMe.AuctionPage;
import web.tradeMe.HomePage;
import web.tradeMe.ResultsPage;

import static org.junit.Assert.assertEquals;

public class ChromeTest {

    private WebDriver driver;
    private HomePage homePage;
    private static ChromeOptions chromeOptions;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

    }

    @Before
    public void setUpBrowser() {
        driver = new ChromeDriver(chromeOptions);
//        driver = new ChromeDriver();
        this.homePage = PageFactory.initElements(this.driver, HomePage.class);
    }

    @After
    public void tearDownBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testNumSearchResults() {

        ResultsPage resultsPage = this.homePage.searchFor("Carbon credits");

        String totalNumResults = resultsPage.getNumSearchResults();
        assertEquals("1", totalNumResults);

    }

    @Test
    public void testListingLocation() {

        ResultsPage resultsPage = this.homePage.searchFor("Carbon credits");

        resultsPage.viewAsList();

        String topListingLocation = resultsPage.getTopOfListLocation();
        assertEquals("Auckland", topListingLocation);
    }


    @Test
    public void testTopResultAuctionPageTitle() {

        ResultsPage resultsPage = this.homePage.searchFor("Carbon credits");

        AuctionPage auctionPage = resultsPage.goToAuctionPage();

        String pageTitle = auctionPage.getListingTitle();
        assertEquals("Carbon Credit - zero flatulence", pageTitle);

    }
}
