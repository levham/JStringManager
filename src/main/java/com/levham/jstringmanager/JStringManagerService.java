package com.levham.jstringmanager;

import java.util.regex.Pattern;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JStringManagerService {
    private static final Logger logger = LoggerFactory.getLogger(JStringManagerService.class);

    /**
     * Argumanları birleştirir.
     *
     * @param otherArg veri.
     * @param subLimit hangi elemandan itibaren başlanıcağı.
     * @return argumanları birleştirerek gönderir.
     */
    public static String concatArgs(String[] otherArg, int subLimit) {
        logger.debug("  status otherArg length: " + otherArg.length);
        if (otherArg.length == 1) {
            return otherArg[0];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = subLimit; i < otherArg.length; i++) {
            if (i > subLimit) {
                sb.append(" ");
            }
            sb.append(otherArg[i]);
        }

        String mainString = sb.toString();
        logger.debug("  birlestirilmis arguman: " + mainString);
        return mainString;
    }

    /**
     * Metni küçük harfe dönüştürür.
     *
     * @param locateRootRule ingilizce karahter kontrol değişkeni.
     * @param otherArg veri.
     * @return küçük harfe dönüşmüş metni gönderir.
     */
    public static String functionLowercase(boolean locateRootRule, String[] otherArg) {
        logger.debug("\n  process: functionLowercase");
        logger.debug("  status LocateRootRule: " + locateRootRule);

        String combinedData = concatArgs(otherArg, 0);
        String output;
        if (locateRootRule) {
            combinedData = convertTrLetter(combinedData);
            output = combinedData.toLowerCase(Locale.ENGLISH);
        } else {
            output = combinedData.toLowerCase();
        }
        logger.debug("\n  result process: " + output);
        return output;

    }

    /**
     * Metni büyük harfe dönüştürür.
     *
     * @param locateRootRule ingilizce karahter kontrol değişkeni
     * @param otherArg veri.
     * @return büyük harfe dönüşmüş metni gönderir.
     */
    public static String functionUppercase(boolean locateRootRule, String[] otherArg) {
        logger.debug("\n  process: functionUppercase");
        logger.debug("  status LocateRootRule: " + locateRootRule);

        String combinedData = concatArgs(otherArg, 0);
        String output;
        if (locateRootRule) {
            combinedData = convertTrLetter(combinedData);
            output = combinedData.toUpperCase(Locale.ENGLISH);
        } else {
            output = combinedData.toUpperCase();
        }
        logger.debug("\n  result process: " + output);
        return output;
    }

    /**
     * Türkçe karahterleri igilizce karahtere dönüştürür.
     *
     * @param stringItem tr karahterli metin.
     * @return sadece ing karanterli metin.
     */
    private static String convertTrLetter(String content) {
        content = content.replace("Ö", "o")
                .replace("ö", "o")
                .replace("Ü", "u")
                .replace("Ü", "u")
                .replace("Ğ", "g")
                .replace("ğ", "g")
                .replace("Ş", "s")
                .replace("ş", "s")
                .replace("Ç", "c")
                .replace("ç", "c")
                .replace("I", "i")
                .replace("ı", "i")
                .replace("İ", "i");

        return content;
    }

    /**
     * Metnin uzunluğunu hesaplar.
     *
     * @param otherArg veri.
     * @return metnin uzunluğunu gönderir.
     */
    public static String functionLength(String[] otherArg) {
        logger.debug("\n  process: functionLength");

        String combinedData = concatArgs(otherArg, 0);
        int output = combinedData.length();

        logger.debug("\n  result process: " + output);
        return String.valueOf(output);
    }

    /**
     * Metnin başındaki ve sondaki boşluklarını siler.
     *
     * @param otherArg veri.
     * @return metnin başındaki ve sondaki boşlukların silinmiş hali.
     */
    public static String functionTrim(String[] otherArg) {
        logger.debug("\n  process: functionTrim");
        String combinedData = concatArgs(otherArg, 0);

        String output = combinedData.trim();
        logger.debug("\n  result process: " + output);

        return output;
    }

    /**
     * Matnin başındaki, sonundaki ve parametreler arası boşlukları siler.
     *
     * @param otherArg veri.
     * @return boşlukları silinmiş veri.
     */
    public static String functionTrim2(String[] otherArg) {
        logger.debug("\n  process: functionTrim2");

        String output = "";
        for (String st : otherArg) {
            output += st.trim();
        }
        logger.debug("\n  result process: " + output);
        return output;
    }

    /**
     * Metnin tüm boşluklarını siler.
     *
     * @param otherArg veri.
     * @return boşluksuz metin gönderir.
     */
    public static String functionTrimAll(String[] otherArg) {
        logger.debug("\n  process: functionTrimAll");

        String output = "";
        for (String st : otherArg) {
            output += st.trim();
        }
        output = output.replace(" ", "");
        logger.debug("\n  result process: " + output);
        return output;
    }

    /**
     * Parametreli veriyi birleştirir.
     *
     * @param otherArg veri.
     * @return birleştirilmiş veriyi gönderir.
     */
    public static String functionConcat(String[] otherArg) {
        logger.debug("\n  process: functionConcat");
        return concatArgs(otherArg, 0);
    }

    /**
     * Metnin içinde aranan bölümün bulunup bulunmadığı belirtir.
     *
     * @param item aranan bölüm.
     * @param otherArg veri.
     * @return aranan bölümün bulunup bulunmadığını gönderir.
     */
    public static String functionContains(String item, String[] otherArg) {
        boolean statusItem = false;
        logger.debug("\n  process: functionContains");

        for (int i = 1; i < otherArg.length; i++) {
            System.out.println("---------->" + otherArg[i]);
            statusItem = otherArg[i].contains(item);
            if (statusItem) {
                break;
            }
        }
        String output = (statusItem) ? "Aranan metin bulundu" : "Aranan metin bulunamadı ";
        logger.debug("\n  result process: " + output);

        return output;
    }

    /**
     * Metnin tersten yazılışını verir.
     *
     * @param otherArg veri.
     * @return metni tersten yazılışını gönderir.
     */
    public static String functionReverse(String[] otherArg) {
        logger.debug("\n  process: functionReverse");
        String result = concatArgs(otherArg, 0);

        String output = "";
        for (int i = result.length() - 1; i >= 0; i--) {
            output += result.charAt(i);
        }
        logger.debug("\n  result process: " + output);

        return output;
    }

    /**
     * Metni belli bir karahtere göre parçalar.
     *
     * @param config parçalanacak karahterler.
     * @param otherArg veri.
     * @return parçalanmış veriyi alt alta gönderir.
     */
    public static String functionSplit(String config, String[] otherArg) {

        logger.debug("\n  process: functionSplit");
        String newString = concatArgs(otherArg, 1);

        try {
            // Eğer config bir özel karakter içeriyorsa, doğru şekilde kaçırmak için Pattern.quote() kullan.
            String regexConfig = Pattern.quote(config);

            // Verilen config'e göre parçala
            String[] parts = newString.split(regexConfig);

            // parçaları alt alta yaz
            StringBuilder newArray = new StringBuilder();
            newArray.append("\n");
            for (String part : parts) {
                newArray.append(part).append("\n");
            }
            String output = newArray.toString();

            if (output.equals("\n" + newString + "\n")) {
                throw new Exception("Hata mesajı");
            }

            logger.debug("\n  result process: " + output);
            return output;

        } catch (Exception e) {
            logger.error("\n  hatali split parametresi ");
            return "";

        }
    }

    /**
     * Metnin belli bir değere göre kırpılması.
     *
     * @param config kırpılacak değer.
     * @param otherArg veri.
     * @return kırpılmış veriyi gönderir.
     */
    public static String functionSubstring(String config, String[] otherArg) {

        logger.debug("\n  process: functionSubstring");
        String mainString = concatArgs(otherArg, 1);

        String output;
        try {
            if (config.contains(".")) {
                String[] parts = config.split("\\.");
                if (parts.length < 2) {
                    return "Eksik substring formatı: " + config;
                }
                int start = Integer.parseInt(parts[0].trim());
                int end = Integer.parseInt(parts[1].trim());
                output = mainString.substring(start, end);
            } else {
                int start = Integer.parseInt(config.trim());
                output = mainString.substring(start);
            }
            if (config.contains(",")) {
                output = "substring parametresinde . kullanılmalı";
            }
        } catch (NumberFormatException e) {
            output = "Hatalı substring formatı: " + config;
        } catch (StringIndexOutOfBoundsException e) {
            output = "Hatalı substring değerleri: " + config;
        }
        logger.debug("\n  result process: " + output);

        return output;
    }

    /**
     * Metnin içindeki bir bölümün küçük bir metin ile değiştirilmesi.
     *
     * @param targetString1 değiştirilecek bölüm.
     * @param targetString2 değiştirecek bölüm.
     * @param otherArg veri.
     * @return değiştirilmiş metni gönderir.
     */
    public static String functionReplace(String targetString1, String targetString2, String[] otherArg) {
        logger.debug("\n  process: functionReplace");
        String mainString = concatArgs(otherArg, 2);
        String output = mainString.replace(targetString1, targetString2);
        logger.debug("\n  result process: " + output);
        return output;

    }

    /**
     * Metnin içinde istenilen indis değerindeki karahteri bulunması.
     *
     * @param config aranan indis.
     * @param otherArg veri.
     * @return aranan karahterin indisini gönderir.
     */
    public static String functionCharAt(String config, String[] otherArg) {

        try {
            int index = Integer.parseInt(config);

            logger.debug("\n  process: functionCharAt");
            String mainString = concatArgs(otherArg, 1);

            if (index < 0 || mainString.length() < index) {
                throw new IllegalArgumentException();
            }
            char result = mainString.charAt(index);
            String output = "Arana metin:" + String.valueOf(result);
            logger.debug("\n  result process: " + output);

            return output;
        } catch (NumberFormatException e) {
            return "charat'ın ilk parametresi int olmalı ";
        } catch (IllegalArgumentException e) {
            return "Hata oluştu: charat'ın ilk parametresi negatif veya aranıcak ifade uzunluğundan büyük";
        }

    }

    /**
     * Metnin içindeki bir bölümün ilk geçtiği yerin indis olarak verilmesi.
     *
     * @param search aranan bölüm.
     * @param otherArg veri.
     * @return aranan yerin indisini gönderir.
     */
    public static String functionIndexOf(String search, String[] otherArg) {
        logger.debug("\n  process: functionIndexOf");
        String mainString = concatArgs(otherArg, 1);

        int status = mainString.indexOf(search);

        if (status == -1) {
            return "Aranan metin bulunmadı";
        }

        String output = "Aranan metin " + String.valueOf(status) + ".indiste";
        logger.debug("\n  result process: " + output);

        return output;
    }

    /**
     * Metnin içindeki bir bölümün son geçtiği yerin indis olarak verilmesi.
     *
     * @param search aranan bölüm.
     * @param otherArg veri.
     * @return aranan yerin indisini gönderir.
     */
    public static String functionLastIndexOf(String search, String[] otherArg) {
        logger.debug("\n  process: functionLastIndexOf");
        String mainString = concatArgs(otherArg, 1);

        int status = mainString.lastIndexOf(search);

        if (status == -1) {
            return "Aranan metin bulunmadı";
        }
        // Direkt String.valueOf kullan  
        String output = "Aranan metin " + String.valueOf(status) + ".indiste";
        logger.debug("\n  result process: " + output);

        return output;
    }

    /**
     * Kopyalama yapan metod.
     *
     * @param content kopyalanan içerik.
     */
    public static void toclipboard(String content) {
        try {
            // StringSelection ile kopyalanacak metni hazırla
            StringSelection selection = new StringSelection(content);
            // Sistem clipboard'unu al
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            // İçeriği clipboard'a set et 
            clipboard.setContents(selection, null);
            System.out.println(content + " metni kopyalandı!");
        } catch (HeadlessException e) {
            System.out.println("Kopyalama hatası:" + e);
        }
    }
}
