package function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;


public class LoginPage {
    String name = "username";
    String pwd = "password";
    String loginButton = "za-id-label";

    public void login(WebDriver driver,String userName,String password) throws InterruptedException {
//        System.out.println("userName;"+userName+";password;"+password);
        driver.findElement(By.name(name)).sendKeys(userName);
        driver.findElement(By.name(pwd)).sendKeys(password);
        driver.findElement(By.id(loginButton)).click();
        Thread.sleep(2000);
    }
    public boolean isLoginSuccess(WebDriver driver) throws Exception{
        boolean flag =false;
        try{
            if(driver.findElement(By.linkText("意健险")).isDisplayed()){
                System.out.println("登录成功");
                return true;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return flag;
    }
}
