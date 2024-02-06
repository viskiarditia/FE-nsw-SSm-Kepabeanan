@login
Feature: login
    Sebagai pengguna saya ingin login website insw Kepabeanan

  Background: Sudah ada halaman website di Kepabeanan
    Given Pengguna telah membuka situs Kepabeanan

    #Functional Test
  Scenario: LG 001 - login Normal
    When Pengguna memasukkan Nama Pengguna dan Kata Sandi dengan Data Valid di halaman
    Then Pengguna sudah berada di halaman arahan
    And Pengguna Konfirmasi kembali untuk verifikasi login

  Scenario: LG 002 - Login dengan Username dan Password yang Salah
    When Pengguna memasukkan Nama Pengguna yang salah dan Kata Sandi yang salah di halaman
    Then Pengguna melihat pesan kesalahan "Username tidak ditemukan atau tidak sesuai."

  Scenario: LG 003 - Login dengan Username Benar tetapi Password Salah
    When Pengguna memasukkan Nama Pengguna yang benar dan Kata Sandi yang salah di halaman
    Then Pengguna melihat pesan kesalahan "Username tidak ditemukan atau tidak sesuai."

        #Validation Test
  Scenario Outline: LG 004 - Verifikasi Field Username
    Then Pengguna Klik Field Username
    And Pengguna memasukan berbagai macam Test dalam field Username "<Data Test>"
    Examples:
      | Data Test  |
      | ABCDEFGHIJ |
      | 1234567890 |
      | !@#$%^&*() |
      | qwertyuQWE |

  Scenario Outline: LG 005 - Verifikasi Field Kata Sandi
    Then Pengguna Klik Field Kata Sandi
    And Pengguna memasukan berbagai macam Test dalam field Password"<Data Test>"
    Examples:
      | Data Test  |
      | ABCDEFGHIJ |
      | 1234567890 |
      | !@#$%^&*() |
      | qwertyuQWE |

  Scenario Outline: LG 006 - Lupa Password
    Then Pengguna Klik Field Lupa Password
    And Pengguna memasukan berbagai macam Test dalam field Lupa Password"<Data Test>"
    Examples:
      | Data Test  |
      | ABCDEFGHIJ |
      | 1234567890 |
      | !@#$%^&*() |
      | qwertyuQWE |






