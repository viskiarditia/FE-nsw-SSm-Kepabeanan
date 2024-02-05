package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.bytebuddy.asm.Advice;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);

        WebElement element = driver.findElement(By.cssSelector(".container-fluid > div > div > div > div:nth-of-type(2) .title-menu"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(1000);
        WebElement crouserRight = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".react-multiple-carousel__arrow")));
        crouserRight.click();
        actions.release().perform();
        Thread.sleep(2000);
        crouserRight.click();
        WebElement aplikasiKEK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(.,'Kawasan Ekonomi Khusus (KEK) Aplikasi KEK')]")));
        aplikasiKEK.click();
        WebElement pemberitahuanPabeanKEK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-index='0'] .cardBody-dashboard")));
        pemberitahuanPabeanKEK.click();

        long endTime = System.currentTimeMillis() + 10000; // 10 seconds timeout
        while (System.currentTimeMillis() < endTime) {
            // Check if the loading element is present
            WebElement loadingElement = null;
            try {
                loadingElement = driver.findElement(By.cssSelector(".custom-loading-icon"));
            } catch (org.openqa.selenium.NoSuchElementException ignored) {
                // Element not found, loading might be complete
                break;
            }

            // If the loading element is not displayed, loading is complete
            if (!loadingElement.isDisplayed()) {
                break;
            }

            // Sleep for a short interval before checking again
            try {
                Thread.sleep(500); // Adjust the sleep time based on your needs
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        WebElement validasiNextPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='text-center']")));
        validasiNextPage.isDisplayed();
    }


    @And("Pengguna mengisi semua tahapan dan formulir pengisian data yang dibutuhkan")
    public void penggunaMengisiSemuaTahapanDanFormulirPengisianDataYangDibutuhkan() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement createPermohonan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class='fa fa-plus']")));
        createPermohonan.click();
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        WebElement jenisPengajuan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-ackcql']")));
        jenisPengajuan.click();
        jenisPengajuan.sendKeys("Pengeluaran TLDDP");
        jenisPengajuan.sendKeys(Keys.ENTER);
        WebElement OK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".w-100")));
        OK.click();

        Thread.sleep(10000);
    }
}

