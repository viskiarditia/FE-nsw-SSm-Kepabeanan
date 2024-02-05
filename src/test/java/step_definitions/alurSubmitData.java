package step_definitions;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class alurSubmitData {
    private final WebDriver driver;
    public alurSubmitData(){
        super();
        this.driver = Hooks.driver;
    }
    private boolean isElementVisible(WebDriver driver, By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    @Then("Pengguna Memilih masuk ke menu pemberitahuan pengabean KEK")
    public void penggunaMemilihMasukKeMenuPemberitahuanPengabeanKEK() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 400);");
        Thread.sleep(1000);

        try {
            WebElement crouserRight = driver.findElement(By.cssSelector(".react-multiple-carousel__arrow--right"));

            // Loop to click the right arrow until the desired element is visible
            while (!isElementVisible(driver, By.cssSelector("[data-index='9'] .cardBody-dashboard"))) {
                crouserRight.click();
            }

            // Now, the desired element is visible, so locate and click it
            WebElement aplikasiKEK = driver.findElement(By.cssSelector("[data-index='9'] .cardBody-dashboard"));
            aplikasiKEK.click();
        }finally {
            Thread.sleep(5000);
        }
//        WebElement crouserRight = driver.findElement(By.cssSelector(".react-multiple-carousel__arrow--right"));
//        crouserRight.click();
//        crouserRight.click();
        //        js.executeScript("arguments[0].scrollIntoView(true);", crouser3);
//        WebElement aplikasiKEK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-index='9'] .cardBody-dashboard")));
//        aplikasiKEK.click();
//        Assert.assertTrue(true);
//        Thread.sleep(5000);

    }


}
