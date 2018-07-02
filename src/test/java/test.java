import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import  org.openqa.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class test {
    public static WebDriver driver;
    private static String name = "username";
    private static String pwd = "password";
    private static String loginButton = "za-id-label";
    public  static void main(String args[]) throws Exception{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://18827-health-artemis-za-artemis-bops-ui.test.za.net/");
        driver.findElement(By.name(name)).sendKeys("userName");
        driver.findElement(By.name(pwd)).sendKeys("password");
        driver.findElement(By.id(loginButton)).click();
        Thread.sleep(2000);

    }
}
