package step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
;


public class Hooks {
    public static WebDriver driver;

    @Before
    public void openBrowser(){
        ChromeOptions a = new ChromeOptions();
        a.addArguments("--remote-allow-origins=*");
        a.addArguments("--no-sandbox");
        a.addArguments("--disable-dev-shm-usage");
//        a.addArguments("--headless");
        a.addArguments("--window-size=1920,1080");
        WebDriverManager.chromedriver().driverVersion("121.0.6167.160").setup();


        driver= new ChromeDriver(a);
        String appUrl = "https://account.insw.go.id/";
        driver.get(appUrl);
        driver.manage().window().maximize();
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }

}