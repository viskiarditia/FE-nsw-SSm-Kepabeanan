@login
Feature: login
    Sebagai pengguna saya ingin login website insw Kepabeanan

  Background: Sudah ada halaman website di Kepabeanan
    Given Pengguna telah membuka situs Kepabeanan

    #Functional Test

  Scenario: login Normal
    When Pengguna memasukkan Nama Pengguna dan Kata Sandi dengan Data Valid di halaman
    Then Pengguna sudah berada di halaman arahan
    And Pengguna Konfirmasi kembali untuk verifikasi login

  Scenario: Login dengan Username dan Password yang Salah
    When Pengguna memasukkan Nama Pengguna yang salah dan Kata Sandi yang salah di halaman
    Then Pengguna melihat pesan kesalahan "Username tidak ditemukan atau tidak sesuai."

  Scenario: Login dengan Username Benar tetapi Password Salah
    When Pengguna memasukkan Nama Pengguna yang benar dan Kata Sandi yang salah di halaman
    Then Pengguna melihat pesan kesalahan "Username tidak ditemukan atau tidak sesuai."






