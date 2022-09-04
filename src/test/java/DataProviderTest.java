import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DataProviderTest {
    static ChromeDriver driver;

   @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//        driver.get("https://www.calculator.net/");
    }


    @DataProvider (name = "Fatima")
    public Object[][] dpMethod(){
       return new Object[][] {{7,8},{8,9},{2,3},{5,6}};
    }

int counter=0;

    @Test (dataProvider = "Fatima")
    public void testProvider(int number1, int number2){
       counter++;
        System.out.println("Counter: "+counter + " Number: "+number1);
    }

   @AfterClass
    void tearDown(){
        driver.quit();

    }
}
