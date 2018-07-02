package useBrowser;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseDrivers {
    //启动谷歌浏览器

    public static WebDriver driver;
    public WebDriver startChrome(String url) throws Exception {
        try {
            //意健险地址
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            //机票地址
            System.setProperty("webdriver.chrome.driver","C:\\Users\\Justin\\AppData\\Local\\Google\\Chrome\\Application\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.get(url);
            System.out.println("成功打开谷歌浏览器！");
//	driver.manage().window().maximize();
//            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("打开谷歌浏览器时出错了"+e);
        }
        return driver;

    }
    //关闭浏览器

    public void tearDownBrowser() throws Exception {
        try {
            Thread.sleep(2000);
            driver.close();
            System.out.println("成功关闭浏览器！");
        } catch (Exception e) {
            System.out.println("关闭浏览器时出错了" + e);
        }

    }
}
