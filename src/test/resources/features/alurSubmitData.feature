@alurSubmitData
Feature: alur sumbit data
  Sebagai pengguna saya ingin menambahkan pengajuan baru

  Background: Sudah ada halaman website di Kepabeanan
    Given Pengguna telah membuka situs Kepabeanan
    When Pengguna memasukkan Nama Pengguna dan Kata Sandi dengan Data Valid di halaman
    Then Pengguna sudah berada di halaman arahan
    And Pengguna Konfirmasi kembali untuk verifikasi login

  Scenario: Menambahkan Data untuk bisa di submit
    Then Pengguna Memilih masuk ke menu pemberitahuan pengabean KEK
    And Pengguna mengisi semua formulir tahapan Data Perusahaan yang dibutuhkan
    Then Pengguna mengisi lanjutan formulir tahapan Data Transportasi yang diperlukan
    And Penguna mengisi lanjutan formulir tahapan Data Komoditi yang di butuhkan
    Then Pengguna mengisi lanjutan formulir tahapan Data Layanan
    And Pengguna Lanjut ke formulir Data Pengajuan
