package testFunction;

import baseClass.OpenBrowser;
import function.LoginPage;
import org.testng.annotations.Test;
import useBrowser.UseDrivers;

public class LoginTest extends OpenBrowser {
//    String loginUrl = "http://18827-health-artemis-za-artemis-bops-ui.test.za.net/";
    LoginPage loginPage=new LoginPage();
    @Test(priority=1)
    public void loginTest1() throws  Exception{
//        driver.get(loginURL);
        loginPage.login(driver,"wb_caifudi1","Ne8AM5u9Q6");

        System.out.println("登录结果"+loginPage.isLoginSuccess(driver));
    }

}
