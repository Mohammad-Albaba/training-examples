import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomePOM {
    public static MobileElement getAddButton(){
       return (MobileElement) AndroidTest.driver.findElementById("jinyoung.dev.todolist:id/fab");
    }

    public static MobileElement getNewTaskPopup(){
       return (MobileElement) AndroidTest.driver.findElementById("jinyoung.dev.todolist:id/etName");
    }


}
