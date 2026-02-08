package com.levham.jstringmanager;

/**
 * Proje: JStringManager
 * Açıklama: Metin işlemleri için yardımcı konsol uygulaması
 *
 * @author Levham
 * @version 1.0
 * @since 05.02.2026
 */
public class JStringManager {

    public static void main(String[] args) {
        JStringManagerController stringManagerController = new JStringManagerController();

        //argumanlı normal çalışma şartlarında
        stringManagerController.handleArgument(args);

        //test ortamı
        //String[] test={"uppercase","deneme","acasc"};
        //stringManagerController.handleArgument(test);
    }
}
