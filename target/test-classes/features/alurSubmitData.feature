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
    And Pengguna mengisi semua tahapan dan formulir pengisian data yang dibutuhkan

