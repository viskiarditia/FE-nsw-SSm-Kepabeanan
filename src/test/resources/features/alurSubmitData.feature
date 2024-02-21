@alurSubmitData
Feature: alur sumbit data
  Sebagai pengguna saya ingin menambahkan pengajuan baru

  Background: Sudah ada halaman website di Kepabeanan
    Given Pengguna telah membuka situs Kepabeanan
    When Pengguna memasukkan Nama Pengguna dan Kata Sandi dengan Data Valid di halaman
    Then Pengguna sudah berada di halaman arahan
    And Pengguna Konfirmasi kembali untuk verifikasi login

  Scenario: ASD 001 - Menambahkan Data untuk bisa di submit
    Then Pengguna Memilih masuk ke menu pemberitahuan pengabean KEK
    And Pengguna mengisi semua formulir tahapan Data Perusahaan yang dibutuhkan
    Then Pengguna mengisi lanjutan formulir tahapan Data Transportasi yang diperlukan
    And Penguna mengisi lanjutan formulir tahapan Data Komoditi yang di butuhkan
    Then Pengguna mengisi lanjutan formulir tahapan Data Layanan
#    And Pengguna Lanjut ke formulir Data Pengajuan

  Scenario Outline: ASD 002 - Validasi di Halaman Beranda Permohonan
    Then Pengguna Memilih masuk ke menu pemberitahuan pengabean KEK
    And Pengguna melakukan validasi di field nomor_permohonan dengan beberapa "<Data Test>"
    Then Pengguna melakukan validasi di field nomor_pendaftaran dengan beberapa "<Data Test>"
    And Pengguna melakukan validasi di field npwp dengan beberapa "<Data Test>"
    Then Pengguna melakukan validasi di field nama_perusahaan dengan beberapa "<Data Test>"
    Examples:
      | Data Test  |
      | ABCDEFGHIJ |
      | 1234567890 |
      | !@#$%^&*() |
      | qwertyuQWE |

#  Scenario: ASD 003 - Validasi di Halaman akun profil
#  Scenario: ASD 004 - Validasi di Halaman Tahapan Data transportasi
#  Scenario: ASD 005 - Validasi di Halaman Tahapan Data komoditi
#  Scenario: ASD 006 - Validasi di Halaman Tahapan Data data layanan
#  Scenario: ASD 007 - Validasi di Halaman Tahapan Data Data Pengajuan
