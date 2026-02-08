package com.levham.jstringmanager;

public class JStringManagerView {
    public static void showNullParameter() {
        System.out.println("\nParametre bulunamadı.");
        System.out.println("Detaylar için -help");
    }

    public static void showMissingParameter() {
        System.out.println("\nEksik parametre.");
        System.out.println("Detaylar için -help");
    }

    public static void showError() {
        System.out.println("\nHata oluştu. ");
        System.out.println("Detaylar için -help");
    }

    public static void showResult(String content) {
        System.out.println("->" + content);
    }

    public static void showHelp() {
        System.out.println("StringManager 1.0 @levham");
        System.out.println("  Metin işlemleri için yardımcı konsol uygulaması");
        System.out.println("  java jdk21 gerektirir.\n");

        System.out.println("-----------------------------------");
        System.out.println("Özel sembolleri kullanımı");
        System.out.println("  * komutun çıktısını kopyalar. Örneğin,");
        System.out.println("    ->JStringManager *lowercase DENEME\n");

        System.out.println("  / komutun çıktısındaki türkçe harfleri ingilizce harfe dönüştürür. Örneğin,");
        System.out.println("    ->JStringManager /uppercase DENEME\n");

        System.out.println("  */ veya /*  komutun hem çıktısını kopyalar hem de tr harfleri ingye dönüştürür. Örneğin,");
        System.out.println("    ->JStringManager */lowercase DENEME");
        System.out.println("-----------------------------------\n");

        System.out.println("Komutlar ve açıklamaları ");
        System.out.println("  help, -help, h, -h, /?");
        System.out.println("    ->yardım metni\n");

        System.out.println("  lowercase, tolowercase, lower, low: Metni küçük harfe dönüştürür.");
        System.out.println("    ->JStringManager lowercase DENEME\n");

        System.out.println("  uppercase, touppercase, upper, up: Metni büyük harfe dönüştürür.");
        System.out.println("    ->JStringManager uppercase deneme \n");

        System.out.println("  length, size: Metnin uzunluğunu hesaplar.");
        System.out.println("    ->JStringManager length deneme\n");

        System.out.println("  trim: Metnin başındaki ve sondaki boşluklarını siler. ");
        System.out.println("    ->JStringManager trim \" deneme \"\n");

        System.out.println("  trim2: Matnin başındaki, sonundaki ve parametreler arası boşlukları siler. ");
        System.out.println("    ->JStringManager trim2 \"   a \"  \" b \"\n");

        System.out.println("  trimall: Metnin tüm boşluklarını siler.");
        System.out.println("    ->JStringManager trimall \"   a  b\"\n");

        System.out.println("  concat: Parametreli veriyi birleştirir. ");
        System.out.println("    ->JStringManager concat a b c  d e\n");

        System.out.println("  contain, contains: Metnin içinde aranan bölümün bulunup bulunmadığı belirtir. ");
        System.out.println("    ->JStringManager contain a abccdd\n");

        System.out.println("  reverse: Metnin tersten yazılışını verir. ");
        System.out.println("    ->JStringManager reverse deneme\n");

        System.out.println("  split: Metni belli bir karahtere göre parçalar. ");
        System.out.println("    ->JStringManager split . aa.bb\n");

        System.out.println("  substring: Metnin belli bir değere göre kırpılması. ");
        System.out.println("    ->JStringManager substring  3 12345678\n");

        System.out.println("  replace: Metnin içindeki bir bölümün küçük bir metin ile değiştirilmesi. ");
        System.out.println("    ->JStringManager replace aa bb ccddaaa\n");

        System.out.println("  charat: Metnin içinde istenilen indis değerindeki karahteri bulunması. ");
        System.out.println("    ->JStringManager charat 3 abcdefg\n");

        System.out.println("  indexof: Metnin içindeki bir bölümün ilk geçtiği yerin indis olarak verilmesi.");
        System.out.println("    ->JStringManager indexof f abfdefgh\n");

        System.out.println("  lastindexof: Metnin içindeki bir bölümün son geçtiği yerin indis olarak verilmesi.");
        System.out.println("    ->JStringManager lastindexof f abfdefgh\n");

    }

}
