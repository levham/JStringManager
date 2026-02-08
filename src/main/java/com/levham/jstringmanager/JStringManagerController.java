package com.levham.jstringmanager;

import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Argumanları denetler İlgili fonksiyona gönderir.
 *
 * @author Mu
 */
public class JStringManagerController {
    private static final Logger logger = LoggerFactory.getLogger(JStringManagerController.class);

    public void handleArgument(String[] args) {
        logger.debug("\n//////Program Side ////////");

        // argumanlarda * ve / varmı 
        // * kopyalabilirme yetkisi verir 
        // / türkçe karahter olmadan çalışma yetkisi verir.
        boolean clipboardRule = false;
        boolean localeRootRule = false;
        String textResult = null;

        //arguman var mı?
        if (args == null || args.length == 0) {
            JStringManagerView.showNullParameter();
            return;
        }

        //ilk arguman 
        String firstArg = args[0];

        //kopyalama desteği veya ing karahter desteği
        if (firstArg.startsWith("/*") || firstArg.startsWith("*/")) {
            localeRootRule = true;
            clipboardRule = true;
        }

        //kopyalama desteği
        if (firstArg.startsWith("*")) {
            clipboardRule = true;
        }

        //ing karahter desteği
        if (firstArg.startsWith("/")) {
            localeRootRule = true;
        }

        //ilk parametre dışındakileri otherArg içine ekle
        String[] otherArg = new String[args.length - 1];
        for (int i = 1; i < args.length; i++) {
            otherArg[i - 1] = args[i];
        }

        //text i normalize et
        String textNormalized = firstArg.toLowerCase(Locale.ROOT);
        textNormalized = textNormalized.replace("*", "").replace("/", "");

        if (args.length == 1) {
            switch (textNormalized) {
                case "help", "-help", "h", "-h", "/?" -> {
                    JStringManagerView.showHelp();
                    return;
                }
                default -> {
                    JStringManagerView.showError();
                    return;
                }
            }
        }

        logger.debug("  main arguman length: " + args.length);

        if (args.length >= 2) {
            switch (textNormalized) {

                // küçük harflere çevir
                case "tolowercase", "lowercase", "lower", "low" -> {
                    textResult = JStringManagerService.functionLowercase(localeRootRule, otherArg);
                }
                // büyük harflere çevir
                case "touppercase", "uppercase", "upper", "up" ->
                    textResult = JStringManagerService.functionUppercase(localeRootRule, otherArg);

                // uzunluk hesaplar
                case "length", "size" ->
                    textResult = JStringManagerService.functionLength(otherArg);

                // baştaki ve sonraki boşluğu siler 
                case "trim" ->
                    textResult = JStringManagerService.functionTrim(otherArg);

                // her argumanın başındaki ve sonundaki boşluğu siler
                case "trim2" ->
                    textResult = JStringManagerService.functionTrim2(otherArg);

                // tüm boşlukları sil
                case "trimall" ->
                    textResult = JStringManagerService.functionTrimAll(otherArg);

                // girilen parametreleri birleştir
                case "concat" ->
                    textResult = JStringManagerService.functionConcat(otherArg);

                // Metnin içinde aranan bölümün bulunup bulunmadığı 
                case "contain", "contains" -> {
                    if (args.length >= 3) {
                        textResult = JStringManagerService.functionContains(args[1], otherArg);
                    } else {
                        JStringManagerView.showMissingParameter();
                    }
                }

                // Metni tersine çevir
                case "reverse" ->
                    textResult = JStringManagerService.functionReverse(otherArg);

                // Metni belli bir karahtere göre parçalar.  
                case "split" -> {
                    if (args.length >= 3) {
                        textResult = JStringManagerService.functionSplit(args[1], otherArg);
                    } else {
                        JStringManagerView.showMissingParameter();
                    }
                }

                // Metnin belli bir değere göre kırpılması
                case "substring" -> {
                    if (args.length >= 3) {
                        textResult = JStringManagerService.functionSubstring(args[1], otherArg);
                    } else {
                        JStringManagerView.showMissingParameter();
                    }
                }

                // Metnin içindeki bir bölümün küçük bir metin ile değiştirilmesi
                case "replace" -> {
                    if (args.length >= 4) {
                        textResult = JStringManagerService.functionReplace(args[1], args[2], otherArg);
                    } else {
                        JStringManagerView.showMissingParameter();
                    }
                }

                // Metnin içinde istenilen indis değerindeki karahteri bulunması.
                case "charat" -> {
                    textResult = JStringManagerService.functionCharAt(args[1], otherArg);
                }

                // Metnin içindeki bir bölümün ilk geçtiği yerin indis olarak verilmesi.
                case "indexof" -> {
                    textResult = JStringManagerService.functionIndexOf(args[1], otherArg);

                }

                // Metnin içindeki bir bölümün son geçtiği yerin indis olarak verilmesi.
                case "lastindexof", "lastındexof" -> {
                    textResult = JStringManagerService.functionLastIndexOf(args[1], otherArg);

                }

                default -> {
                    JStringManagerView.showError();
                    return;
                }
            }
        }

        logger.debug("\n//////User Side ////////");

        if (clipboardRule) {
            JStringManagerService.toclipboard(textResult);
        } else {
            JStringManagerView.showResult(textResult);
        }

    }
}
