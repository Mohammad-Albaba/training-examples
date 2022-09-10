
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AndroidTest {
    protected AppiumDriver driver = null;
    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities= new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("appium:app_activity",".ui.actionitem.MainActivity");
        capabilities.setCapability("appium:app_package","jinyoung.dev.todolist");
        String apkpath = "//Users//ibrahimalsharif//IdeaProjects//TodoList//app//build//outputs//apk//debug//app-debug.apk";
        capabilities.setCapability(MobileCapabilityType.APP, apkpath);
        File app = new File(apkpath);
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void tt(){
        System.out.println("Empty test");
    }
}
