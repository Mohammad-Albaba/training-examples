import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ChromeTest {
    static ChromeDriver driver;

   @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.calculator.net/");
    }


    @DataProvider (name = "Fatima")
    public Object[][] dpMethod(){
       return new Object[][] {{7,"+", 2, 9},{8,"-", 3, 5},{8,"+", 2, 10},{5,"-", 3, 2}};
    }



    @Test (dataProvider = "Fatima")
    public void testProvider(int number1,String operation, int number2, int expectedResult){

       //Click the first number
       String number1Xpath = "//span[@onclick='r("+number1+")']";
        WebElement firstNumberButton= driver.findElement(By.xpath(number1Xpath));
        assertTrue(firstNumberButton.isDisplayed());
        firstNumberButton.click();

        // Click the operation
        String operationXpath="//span[@onclick=\"r('".concat(operation).concat("')\"]");
        WebElement operationButton= driver.findElement(By.xpath(operationXpath));
        assertTrue(operationButton.isDisplayed());
        operationButton.click();

        //Click the second number
        String number2Xpath = "//span[@onclick='r("+number2+")']";
        WebElement secondNumberButton= driver.findElement(By.xpath(number2Xpath));
        assertTrue(secondNumberButton.isDisplayed());
        secondNumberButton.click();

        //Click =
        String equalsXpath="//span[@onclick=\"r('".concat("=").concat("')\"]");
        WebElement equalsButton= driver.findElement(By.xpath(equalsXpath));
        assertTrue(equalsButton.isDisplayed());
        equalsButton.click();

        //Verify the output
        WebElement answerFiled= driver.findElement(By.id("sciOutPut"));
        assertTrue(answerFiled.isDisplayed());
        System.out.println("getText: "+answerFiled.getText().trim());
        System.out.println("innerText: "+answerFiled.getAttribute("innerText").trim());
        System.out.println("textContent: "+answerFiled.getAttribute("textContent").trim());
        assertEquals(answerFiled.getText().trim(), ""+expectedResult);


    }

   @AfterClass
    void tearDown(){
        driver.quit();

    }
}
