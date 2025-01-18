# LC Waikiki Selenium Test Otomasyon Projesi

## Proje Özeti

Bu proje, Selenium WebDriver ve Java kullanarak LC Waikiki web sitesinde bir alışveriş senaryosunu otomatikleştirir.
Proje siteye giriş yapmaktan başlayarak kategori seçimi, filtre seçimi, ürün seçimi, sepete ekleme, sepet doğrulaması ve ürünü favorilere eklemeye kadar olan adımları kapsar.

## Özellikler

* Kullanıcı e-post ve şifre girerek giriş yapar.
* Anasayfadan kategori ve ürün filtreleri seçilir.
* Ürün bedeni seçildikten sonra sepete eklenir.
* Sepetteki ürün adı, rengi, adet bilgisi ve fiyat bilgisinin doğruluğunu kontrol edilir.
* Ürün favorilere eklenir.

## Kullanılan Teknolojiler

* Java

* Testing Framework: JUnit / TestNG

* Automation Tool: Selenium WebDriver

* Build Tool: Maven

* Design Pattern: POM (Page Object Model)

* Allure Report

* Git

## Gereksinimler

Projeyi çalıştırmak için bu yazılımların yüklü olduğundan emin olun: Java, Maven, ChromeDriver, Allure


## Kurulum ve Yükleme

*1.* Repository:

```
git clone https://github.com/busrahadimlioglu/lcw-test-automation-project.git
cd selenium-lcw-automation
```

*2.* ChromeDriver Ayarlayın:

ChromeDriver uygun sürümünü indirin: https://chromedriver.chromium.org/downloads


*3.* Allure Kurun

## Testleri Çalıştırma

Projeyi tercih ettiğiniz IDE'de (ör. IntelliJ IDEA ) açın.

JUnit veya TestNG kullanarak senaryoyu çalıştırın.

Alternatif olarak, Maven kullanarak çalıştırabilirsiniz:
```
mvn test
```
Allure Raporu Oluşturma:
```
allure serve allure-results
```

## Test Senaryosu
 * https://www.lcw.com/ adresine giderek “GirişYapˮ butonu tıklanır.
 * E-mail girilir devam butonuna tıklanır.
 * Şifre girilir “Giriş Yapˮ butonuna tıklanır.
 * Çocuk&Bebek kategorisi seçilir, "Kız çocuk(6-14 YAŞ)" seçilir, "Mont ve Kaban" alt menüsü seçilir.
 * Beden filtresinde "5-6", "6" ve "6-7" yaş seçenekleri seçilir.
   Renk filtresinde "Bej" seçilir.
 * Sırala comboboxına tıklanır, "En çok satanlar" seçilir. Ürünler yeniden listelenir.
 * İlk sıradaki 4.ürüne tıklanır. Ürün detayına gidilir. Bir yaş grubu seçilir ve sepete ekle butonuna tıklanır.
 * Sepetim ekranına gidilir. Sepetim ekranında, ürünün "adı","rengi" ve "adet" alanlarının doğruluğu kontrol edilir.
   Ürünün tutarı ile "Ödeme adımına geç" alanında yazan tutarın doğtuluğu kontrol edilir.
 * Ürün kartı üzerinde yer alan kalp simgesi ile ürün favorilere eklenir.
 * "Ödeme adımına geç" butonuna tıklanır.
 * "Favorilerim" ikonuna tiklanir. Favoriler ekrani açilir. Seçilen ürün görülür.
