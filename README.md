# JStringManager  ![badge](https://img.shields.io/badge/Java%20Language-brown) 
 _Metin işlemleri için yardımcı konsol uygulaması_

 _java jdk21 gerektirir_ 

> [🢆 JStringManager.exe](https://github.com/levham/JStringManager/raw/refs/heads/main/JStringManager.exe)  
> [🢆 JStringManager-1.0.jar](https://github.com/levham/JStringManager/raw/refs/heads/main/JStringManager-1.0.jar)  



### Çalıştırma
```
Java.exe -jar JStringManager-1.0.jar help
```
```
JStringManager.exe help
```



### Komutlar

- **help , -help , h  , -h, /?** Yardım metnini görüntüler

  ```JStringManager -help```

- **lowercase, tolowercase, lower, low** Metni küçük harfe dönüştürür.

  ```JStringManager lowercase DENEME```
  > ->_deneme_

- **uppercase, touppercase, upper, up** Metni büyük harfe dönüştürür. 

  ```JStringManager uppercase deneme```
  > ->_DENEME_

- **length,size** Metnin uzunluğunu hesaplar.

  >```JStringManager length deneme```
  > ->_6_

- **trim** Metnin başındaki ve sondaki boşluklarını siler.
  - JStringManager trim " deneme "
  > ->_deneme_

- **trim2** Matnin başındaki, sonundaki ve parametreler arası boşlukları siler.
  - JStringManager trim2 "   a "  " b "
  > ->_ab_

- **trimall** Metnin tüm boşluklarını siler.
  - JStringManager trimall "   a  b"
  > ->_ab_

- **concat** Parametreli veriyi birleştirir.
  - JStringManager concat a b c  d e
  > ->_a b c d e_

- **contain,contains** Metnin içinde aranan bölümün bulunup bulunmadığı belirtir.
  - JStringManager contain a abccdd
  > ->_Aranan metin bulunamadı_
  - JStringManager contain a bbccdd
  > ->_Aranan metin bulundu_

- **reverse** Metnin tersten yazılışını verir.
  - JStringManager reverse deneme
  > ->emened

- **split** Metni belli bir karahtere göre parçalar.
  - JStringManager split . aa.bb
  > ->
  > aa
  > bb

  - JStringManager split d abcdae
  ->
  abc
  ae

- **substring** Metnin belli bir değere göre kırpılması.
  - JStringManager substring  9 1234567890123
  ->0123
  - JStringManager program substring 4.7 1234567890123
  ->567

- **replace** Metnin içindeki bir bölümün küçük bir metin ile değiştirilmesi.
  - JStringManager replace aa bb ccddaaa
  ->ccddbba

- **charat** Metnin içinde istenilen indis değerindeki karahteri bulunması.
  - JStringManager charat 3 abcdefg
  ->Arana metin:d

- **indexof** Metnin içindeki bir bölümün ilk geçtiği yerin indis olarak verilmesi.
  - JStringManager indexof f abfdefgh
  ->Aranan metin 2.indiste

- **lastindexof** Metnin içindeki bir bölümün son geçtiği yerin indis olarak verilmesi.
  - JStringManager lastindexof f abfdefgh
  ->Aranan metin 5.indiste
 

### Özel sembolleri kullanımı
- \* komutun çıktısını kopyalar. Örneğin,
  - JStringManager *lowercase DENEME

- / komutun çıktısındaki türkçe harfleri ingilizce harfe dönüştürür. Örneğin,
  - JStringManager /uppercase DENEME

- \*/ veya /\*  komutun hem çıktısını kopyalar hem de tr harfleri ingye dönüştürür. Örneğin,
  - JStringManager */lowercase DENEME
