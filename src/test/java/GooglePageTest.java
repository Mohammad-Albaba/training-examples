import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class GooglePageTest {
    private ChromeDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        wait = new WebDriverWait(driver, 10);
    }


    @Test()
    public void testProvider() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Hello World");
        searchBox.sendKeys(Keys.ENTER);
        searchBox = driver.findElement(By.name("q"));
        assertTrue(searchBox.isDisplayed());

    }

    @AfterClass
    void tearDown() {
        driver.quit();

    }
}
