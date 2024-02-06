package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import net.bytebuddy.asm.Advice;
import org.checkerframework.checker.units.qual.K;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
        Thread.sleep(25000);
    }


    @And("Pengguna mengisi semua formulir tahapan Data Perusahaan yang dibutuhkan")
    public void penggunamengisisemuaformulirtahapanDataPerusahaanyangdibutuhkan() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement createPermohonan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='createPPKEK']")));
        createPermohonan.click();
        Thread.sleep(1000);

        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }

        WebElement jenisPengajuan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=' css-ackcql']/input[1]")));
        jenisPengajuan.click();
        jenisPengajuan.sendKeys("Pengeluaran TLDDP");
        jenisPengajuan.sendKeys(Keys.ENTER);
        WebElement OK = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".w-100")));
        OK.click();

        //Data Perusahaan

        //Jenis Pembantu
        WebElement jenisPemberitahu1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='pemberitahu']//div[@class=' css-tlfecz-indicatorContainer']")));
        Thread.sleep(3000);
        jenisPemberitahu1.click();
        WebElement optionDropdown1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-3-option-0']")));
        optionDropdown1.click();

        //Jenis Identitas
        WebElement jenisIdentitas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='jenis_identitas_pk']")));
        Select selectJenisIdentitas = new Select(jenisIdentitas);
        selectJenisIdentitas.selectByVisibleText("KTP");

        WebElement namaPerusahaan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nama_perusahaan_pk']")));
        namaPerusahaan.click();
        namaPerusahaan.sendKeys("Nashta Global Utama");

        // Kota
        WebElement kota = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kota_pk']")));
        kota.click();
        kota.sendKeys("Bogor");

        // RT/RW
        WebElement rtRw = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='rt_rw_pk']")));
        rtRw.click();
        rtRw.sendKeys("006/003");

        // Kode Pos
        WebElement kodePos = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kode_pos_pk']")));
        kodePos.click();
        kodePos.sendKeys("16620");

        // Telepon
        WebElement telepon = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tlp_pk']")));
        telepon.click();
        telepon.sendKeys("0812345678");

        // Kecamatan
        WebElement kecamatan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kecamatan_pk']")));
        kecamatan.click();
        kecamatan.sendKeys("juanda");

        // Nomor Identitas
        WebElement nomorIdentitas = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nomor_identitas_pk']")));
        nomorIdentitas.click();
        nomorIdentitas.sendKeys("123454321");

        // Alamat
        WebElement alamat = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='alamat_pk']")));
        alamat.click();
        alamat.sendKeys("Bogor Kota");

        // Email
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email_pk']")));
        email.click();
        email.sendKeys("anjay@gmail.com");

        //Negara
        WebElement negaraDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='react-select-6-input']")));
        negaraDropdown.click();
        negaraDropdown.sendKeys("Indonesia");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-6-option-0']"))).click();

        //Simpan
        WebElement simpan1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='buttonSave']/button")));
        simpan1.click();

        //confirm save
        WebElement confirmSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swal-button--confirm")));
        confirmSave.click();
        Thread.sleep(2000);

    }


    @Then("Pengguna mengisi lanjutan formulir tahapan Data Transportasi yang diperlukan")
    public void penggunaMengisiLanjutanFormulirTahapanDataTransportasiYangDiperlukan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement DATATRANSPORTASI = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[.='Data Transportasi']")));
        DATATRANSPORTASI.click();

//        Cara Pengangkutan
        WebElement caraPengangkutan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cara-pengangkutan")));
        caraPengangkutan.click();
        Select selectLAUT = new Select(caraPengangkutan);
        selectLAUT.selectByVisibleText("LAUT");
//        Nama Sarana Pengangkut
        WebElement namaSaranaPengangkut = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='sarana_pengangkutan']")));
        namaSaranaPengangkut.click();
        namaSaranaPengangkut.sendKeys("Kapal Bea Cukai Ngurah Rai");

//        No Polisi
        WebElement noPolisi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='no_voyage']")));
        noPolisi.click();
        noPolisi.sendKeys("123454321");

        // Simpan
        WebElement simpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-pill")));
        simpan.click();

        //confirm save
        WebElement confirmSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swal-button--confirm")));
        confirmSave.click();

    }

    @And("Penguna mengisi lanjutan formulir tahapan Data Komoditi yang di butuhkan")
    public void pengunaMengisiLanjutanFormulirTahapanDataKomoditiYangDiButuhkan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement DATAKOMODITI = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Data Komoditi']")));
        DATAKOMODITI.click();

    }

    @Then("Pengguna mengisi lanjutan formulir tahapan Data Layanan")
    public void penggunaMengisiLanjutanFormulirTahapanDataLayanan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement DATALAYANAN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Layanan']")));
        DATALAYANAN.click();

    }

    @And("Pengguna Lanjut ke formulir Data Pengajuan")
    public void penggunaLanjutKeFormulirDataPengajuan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement DATAPENGAJUAN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Data Pengajuan']")));
        DATAPENGAJUAN.click();
    }
}

