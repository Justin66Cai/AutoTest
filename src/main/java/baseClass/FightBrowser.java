package baseClass;

import function.FightLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import useBrowser.UseDrivers;

public class FightBrowser {
    public static WebDriver driver;
    private static String URL = "http://127.0.0.1:1080/WebTours/";
    UseDrivers browser = new UseDrivers();
    @BeforeSuite
    public void start() throws Exception{
        try{
            driver =  browser.startChrome(URL);
            System.out.println("ÄÃµ½chrome");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    @AfterSuite
    public void end() throws Exception{
        browser.tearDownBrowser();
    }
}
