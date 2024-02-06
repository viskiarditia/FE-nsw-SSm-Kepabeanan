package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class login {
    private final WebDriver driver;
    public login(){
        super();
        this.driver = Hooks.driver;
        new Actions(driver);
        new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @Given("Pengguna telah membuka situs Kepabeanan")
    public void penggunaTelahMembukaSitusKepabeanan() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement OpenWebsite = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[alt='logoInsw']")));
        OpenWebsite.isDisplayed();
        Assert.assertTrue(true);
        Thread.sleep(1000);
    }

    @When("Pengguna memasukkan Nama Pengguna dan Kata Sandi dengan Data Valid di halaman")
    public void penggunaMemasukkanNamaPenggunaDanKataSandiDenganDataValidDiHalaman() {
        Properties properties;
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String email = properties.getProperty("email");
        String password = properties.getProperty("password");


        WebElement ClickFieldUsername = driver.findElement(By.xpath("//input[@name='username']"));
        ClickFieldUsername.click();
        ClickFieldUsername.sendKeys(email);

        WebElement ClickFieldPassword = driver.findElement(By.xpath("//input[@name='password']"));
        ClickFieldPassword.click();
        ClickFieldPassword.sendKeys(password);

        WebElement ClickMasuk = driver.findElement(By.cssSelector(".btn-primary-dark"));
        ClickMasuk.click();
    }

    @Then("Pengguna sudah berada di halaman arahan")
    public void penggunaSudahBeradaDiHalamanArahan() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement landingPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".rounded-2xl")));
        landingPage.isDisplayed();
        Assert.assertTrue(true);
        Thread.sleep(1000);
    }


    @And("Pengguna Konfirmasi kembali untuk verifikasi login")
    public void penggunaKonfirmasiKembaliUntukVerifikasiLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Properties properties;
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String email = properties.getProperty("email");
        String password = properties.getProperty("password");
        WebElement autoUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[autocomplete='username webauthn']")));
        autoUsername.click();
        autoUsername.sendKeys(email);
        WebElement clickNext = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[.='Next']")));
        clickNext.click();

        WebElement signInWithPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mt-2.group")));
        signInWithPassword.click();
        WebElement autoPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        autoPassword.click();
        autoPassword.sendKeys(password);

        WebElement signInVerify = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".w-100 div > .text-white")));
        signInVerify.click();
        Thread.sleep(2000);

        WebElement allow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='group relative w-full flex justify-center py-2 px-4 border border-transparent text-sm font-medium rounded-md text-white bg-bluePrimary1 hover:bg-bluePrimary1/80 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500']")));
        allow.click();

        WebElement landingPage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".jumbotron-container")));
        landingPage.isDisplayed();
        Thread.sleep(2000);
    }

    @When("Pengguna memasukkan Nama Pengguna yang salah dan Kata Sandi yang salah di halaman")
    public void penggunaMemasukkanNamaPenggunaYangSalahDanKataSandiYangSalahDiHalaman() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Properties properties;
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String emailSalah = properties.getProperty("emailSalah");
        String passwordSalah = properties.getProperty("passwordSalah");
        WebElement Username2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='username']")));
        Username2.click();
        Username2.sendKeys(emailSalah);
        WebElement Password2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='password']")));
        Password2.click();
        Password2.sendKeys(passwordSalah);

        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-primary-dark")));
        signIn.click();
    }

    @Then("Pengguna melihat pesan kesalahan {string}")
    public void penggunaMelihatPesanKesalahan(String data) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement terjadiKesalahan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"swal2-content\"]")));
        terjadiKesalahan.getText();

    }

    @When("Pengguna memasukkan Nama Pengguna yang benar dan Kata Sandi yang salah di halaman")
    public void penggunaMemasukkanNamaPenggunaYangBenarDanKataSandiYangSalahDiHalaman() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        Properties properties;
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String emailSalah = properties.getProperty("email");
        String passwordSalah = properties.getProperty("passwordSalah");
        WebElement Username2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='username']")));
        Username2.click();
        Username2.sendKeys(emailSalah);
        WebElement Password2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='password']")));
        Password2.click();
        Password2.sendKeys(passwordSalah);

        WebElement signIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-primary-dark")));
        signIn.click();
    }

    @Then("Pengguna Klik Field Username")
    public void penggunaKlikFieldUsername() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ClickFieldUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        ClickFieldUsername.click();
    }

    @And("Pengguna memasukan berbagai macam Test dalam field Username {string}")
    public void penggunaMemasukanBerbagaiMacamTestDalamFieldUsername(String dataTestUsername) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ClickFieldUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        ClickFieldUsername.sendKeys(dataTestUsername);
    }

    @Then("Pengguna Klik Field Kata Sandi")
    public void penggunaKlikFieldKataSandi() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ClickFieldPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        ClickFieldPassword.click();
    }


    @And("Pengguna memasukan berbagai macam Test dalam field Password{string}")
    public void penggunaMemasukanBerbagaiMacamTestDalamFieldPassword(String dataTestPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ClickFieldPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
        ClickFieldPassword.sendKeys(dataTestPassword);
    }

    @Then("Pengguna Klik Field Lupa Password")
    public void penggunaKlikFieldLupaPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ClickFieldPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Lupa Password']")));
        ClickFieldPassword.click();

    }

    @And("Pengguna memasukan berbagai macam Test dalam field Lupa Password{string}")
    public void penggunaMemasukanBerbagaiMacamTestDalamFieldLupaPassword(String dataTestLupaPassword) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement ClickFieldUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        ClickFieldUsername.sendKeys(dataTestLupaPassword);
        WebElement ClickFieldEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
        ClickFieldEmail.sendKeys(dataTestLupaPassword);
    }
}
