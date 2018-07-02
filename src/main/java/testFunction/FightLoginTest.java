package testFunction;

import baseClass.OpenBrowser;
import function.FightLoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FightLoginTest extends OpenBrowser {

        String URL = "http://127.0.0.1:1080/WebTours/";
    FightLoginPage loginPage = new FightLoginPage();

    @Test(priority=1)
        public void loginTest2() throws Exception{
            if(!loginPage.isLoginPage(driver)){
                driver.get(URL);
            }
            try {
                loginPage.login(driver,"andy","123456");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

//        @Test(priority=2)
//        public void loginTest1() throws Exception{
//            if(!loginPage.isLoginPage(driver)){
//                driver.get(URL);
//            }
//            try {
//                loginPage.login(driver,"andy","123");
//            } catch (Exception e) {
//                System.out.println(e);
//            }
//        }
}
