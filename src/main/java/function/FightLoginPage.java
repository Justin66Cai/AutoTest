package function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FightLoginPage {
    private String name = "andy";
    private String pwd = "123456";
    private String forLogin = "login";
    public void login(WebDriver driver, String username, String password) throws Exception{
        driver.switchTo().frame("body");   //定位第一个frame
        driver.switchTo().frame("navbar");//定位第二个frame
        driver.findElement(By.name("username")).sendKeys(name);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.name(forLogin)).click();
        System.out.println("登录页面网址=" + driver.getCurrentUrl());
        Thread.sleep(1);
        System.out.println("登录页面网址=" + driver.getCurrentUrl());
    }
    //检查点,验证登录后显示用户名
    public boolean isLoginSuccess(WebDriver driver) throws Exception{
        boolean isA = false;

        try{
            driver.switchTo().frame("body");   //定位第一个frame
            driver.switchTo().frame("info");//定位第二个frame
            if(driver.findElement(By.tagName("name")).isDisplayed()){
                isA = true;
            }
        }catch (Exception e){
            System.out.println("验证失败"+e);
        }
        return isA;
    }
    //登录失败时,登录状态
//    public boolean loginStatus(WebDriver driver) throws Exception{
//        System.out.println("验证失败");
//    }

    public  boolean isLoginPage(WebDriver driver) throws Exception {
        boolean flag = false;
        try {
            if (driver.findElement(By.name("login")).getAttribute("value").equals("login")) {
                flag = true;
                return flag;
            }
        } catch (Exception e) {
//	    System.out.println(e);
            return flag;
        }
        return flag;

    }
}
