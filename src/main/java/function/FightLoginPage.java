package function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FightLoginPage {
    private String name = "andy";
    private String pwd = "123456";
    private String forLogin = "login";
    public void login(WebDriver driver, String username, String password) throws Exception{
        driver.switchTo().frame("body");   //��λ��һ��frame
        driver.switchTo().frame("navbar");//��λ�ڶ���frame
        driver.findElement(By.name("username")).sendKeys(name);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.name(forLogin)).click();
        System.out.println("��¼ҳ����ַ=" + driver.getCurrentUrl());
        Thread.sleep(1);
        System.out.println("��¼ҳ����ַ=" + driver.getCurrentUrl());
    }
    //����,��֤��¼����ʾ�û���
    public boolean isLoginSuccess(WebDriver driver) throws Exception{
        boolean isA = false;

        try{
            driver.switchTo().frame("body");   //��λ��һ��frame
            driver.switchTo().frame("info");//��λ�ڶ���frame
            if(driver.findElement(By.tagName("name")).isDisplayed()){
                isA = true;
            }
        }catch (Exception e){
            System.out.println("��֤ʧ��"+e);
        }
        return isA;
    }
    //��¼ʧ��ʱ,��¼״̬
//    public boolean loginStatus(WebDriver driver) throws Exception{
//        System.out.println("��֤ʧ��");
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
