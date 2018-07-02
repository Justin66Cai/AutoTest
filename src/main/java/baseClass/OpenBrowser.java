package baseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import useBrowser.UseDrivers;

import java.sql.Driver;

public class OpenBrowser {
    public String loginURL = "http://127.0.0.1:1080/WebTours/";
    UseDrivers useDrivers = new UseDrivers();
    public  static WebDriver driver;
    @BeforeSuite
    public void startBrowser() throws Exception{
        try {
            driver = useDrivers.startChrome(loginURL);
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @AfterSuite
    public void end() throws Exception{
        useDrivers.tearDownBrowser();
    }


}
