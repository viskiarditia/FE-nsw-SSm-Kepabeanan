package step_definitions;

import com.fasterxml.jackson.core.json.JsonGeneratorImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
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
        Thread.sleep(30000);
    }


    @And("Pengguna mengisi semua formulir tahapan Data Perusahaan yang dibutuhkan")
    public void penggunamengisisemuaformulirtahapanDataPerusahaanyangdibutuhkan() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        WebElement freeClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal")));
        freeClick.sendKeys(Keys.ESCAPE);

        WebElement createPermohonan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("createPPKEK")));
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
        Thread.sleep(3000);

    }


    @Then("Pengguna mengisi lanjutan formulir tahapan Data Transportasi yang diperlukan")
    public void penggunaMengisiLanjutanFormulirTahapanDataTransportasiYangDiperlukan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
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

        WebElement OKSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='swal-overlay swal-overlay--show-modal']")));
        OKSuccess.sendKeys(Keys.ESCAPE);

    }

    @And("Penguna mengisi lanjutan formulir tahapan Data Komoditi yang di butuhkan")
    public void     pengunaMengisiLanjutanFormulirTahapanDataKomoditiYangDiButuhkan() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement DATAKOMODITI = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Data Komoditi']")));
        DATAKOMODITI.click();

        //Barang
        WebElement tambahdata = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flex-grow-0 > #Tooltip > svg")));
        tambahdata.click();

        //kodeHS
        WebElement kodeHS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='kode_hs']/div[@class=' css-1s2u09g-control']//input[1]")));
        kodeHS.click();
        kodeHS.sendKeys("123");
        WebElement selectKodeHS = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-14-option-0']")));
        selectKodeHS.click();
        Thread.sleep(5000);

        //uraian
        WebElement inputUraian = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ur_barang']")));
        inputUraian.sendKeys("testing");

        //merk
        WebElement inputMerk = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='merk']")));
        inputMerk.sendKeys("Honda");

        //tipe
        WebElement inputTipe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='tipe']")));
        inputTipe.sendKeys("SUV");

        //ukuran
        WebElement inputUkuran = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ukuran']")));
        inputUkuran.sendKeys("Besar");

        //spesifikasi_lain
        WebElement inputSpesifikasiLain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='spesifikasi_lain']")));
        inputSpesifikasiLain.sendKeys("pinjol");

        //kd_barang
        WebElement inputKdBarang = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kd_barang']")));
        inputKdBarang.sendKeys("12345");

//        Kondisi Barang*
        //barang_baru
        WebElement selectBarangBaru = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='barang_baru']")));
        selectBarangBaru.click();
        // Misalnya, jika ingin memilih opsi pertama pada dropdown:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[.='Baik']"))).click();


//        Negara asal*
        WebElement negaraAsal= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='negara_asal']/div[@class=' css-1s2u09g-control']//input[1]")));
        negaraAsal.click();
        negaraAsal.sendKeys("Indonesia");
        WebElement negaraAsal1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-15-option-0']")));
        negaraAsal1.click();

//        Daerah Asal Barang*
        WebElement DaerahAsalBarang= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='daerah_asal_barang']/div[@class=' css-1s2u09g-control']//input[1]")));
        DaerahAsalBarang.click();
        DaerahAsalBarang.sendKeys("Bandung");
        WebElement DaerahAsalBarang1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-16-option-0']")));
        DaerahAsalBarang1.click();

//                Netto*
        WebElement Netto= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@class='mb-3 row form-group']/div[1]/input[@class='form-control']")));
        Netto.click();
        Netto.sendKeys("12345");

//                Bruto*
        WebElement Bruto= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@class='mb-3 row form-group']/div[3]/input[@class='form-control']")));
        Bruto.click();
        Bruto.sendKeys("12345");

//                Jumlah Satuan*
        WebElement JumlahSatuan= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[8]/div[1]/input[@class='form-control']")));
        JumlahSatuan.click();
        JumlahSatuan.sendKeys("12345");

//                Kode Satuan*
        WebElement KodeSatuan= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']/div[@class='modal-body']//div[2]//div[@class=' css-1s2u09g-control']//input[1]")));
        KodeSatuan.click();
        KodeSatuan.sendKeys("12");
        WebElement KodeSatuan1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-17-option-0']")));
        KodeSatuan1.click();

//                Jumlah Kemasan*
        WebElement JumlahKemasan= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[8]/div[3]/input[@class='form-control']")));
        JumlahKemasan.click();
        JumlahKemasan.sendKeys("123");

//                Kode Kemasan*
        WebElement KodeKemasan= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@class='mt-3 row form-group']/div[4]//div[@class=' css-1s2u09g-control']//input[1]")));
        KodeKemasan.click();
        KodeKemasan.sendKeys("12");
        WebElement KodeKemasan1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='react-select-18-option-0']")));
        KodeKemasan1.click();

//                Simpan*
        WebElement Simpan= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-content']//div[@class='tab-pane active']//button[@class='btn-pill pull-right btn btn-success']")));
        Simpan.click();

        //confirm save
        WebElement confirmSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swal2-confirm")));
        confirmSave.click();
        Thread.sleep(2000);

        WebElement OKSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swal2-confirm")));
        OKSuccess.click();
//        .swal2-container
         Thread.sleep(3000);

//        Kontainer
        WebElement kontainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[.='Kontainer']")));
        kontainer.click();

        WebElement tambahDataKontainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-12.mb-4 .mb-2 > #Tooltip")));
        tambahDataKontainer.click();
//         nomorKontainer
        WebElement nomorKontainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nomor_kontainer']")));
        nomorKontainer.sendKeys("MSCU5285725");
//          Stuffing
        WebElement Stuffing = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='stuffing']")));
        Stuffing.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[.='EMPTY']"))).click();
//        Stuffing.sendKeys("//option[.='EMPTY']");

//          jenisSeal
        WebElement seal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='jenis_seal']")));
        seal.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[.='Carrier']"))).click();
//        seal.sendKeys("//option[.='Carrier']");

//          nomorSeal
        WebElement nomorSeal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='nomor_seal']")));
        nomorSeal.sendKeys("12345");

//            tipeKontainer
        WebElement tipeKontainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='tipe_kontainer']")));
        tipeKontainer.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[.='TUNNE TYPE']"))).click();
//        tipeKontainer.sendKeys("//option[.='TUNNE TYPE']");

//            ukuranKontainer
        WebElement ukuranKontainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='ukuran_container']")));
        ukuranKontainer.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[.='20 Feet']"))).click();
//        ukuranKontainer.sendKeys("//option[.='20 Feet']");

        WebElement simpanKontainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']//button[@class='btn-pill pull-right btn btn-success']")));
        simpanKontainer.click();

        //confirm save
        WebElement confirmSave2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swal2-confirm")));
        confirmSave2.click();
        Thread.sleep(2000);

        WebElement OKSuccess2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swal2-confirm")));
        OKSuccess2.click();

    }

    @Then("Pengguna mengisi lanjutan formulir tahapan Data Layanan")
    public void penggunaMengisiLanjutanFormulirTahapanDataLayanan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement DATALAYANAN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Layanan']")));
        DATALAYANAN.click();

        WebElement aksi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#tooltip-pengajuan")));
        aksi.click();

        WebElement OKSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".swal2-confirm")));
        OKSuccess.click();


    }

    @And("Pengguna Lanjut ke formulir Data Pengajuan")
    public void penggunaLanjutKeFormulirDataPengajuan() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(35));
//        WebElement DATAPENGAJUAN = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='Data Pengajuan']")));
//        DATAPENGAJUAN.click();


    }
}

