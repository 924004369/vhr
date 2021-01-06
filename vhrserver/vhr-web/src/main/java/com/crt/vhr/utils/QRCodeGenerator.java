package com.crt.vhr.utils;

import java.util.ArrayList;
import java.util.List;

public class QRCodeGenerator {
    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

    public static void main(String[] args) {
//        QrCodeUtil.generateQrCodeAndSave("This is my first QR Code", "png", 350, 350, QR_CODE_IMAGE_PATH);
//        byte[] pngs = QrCodeUtil.generateQrCode("This is my first QR Code", "png", 350, 350);
        List<Object> list = new ArrayList<>();
        String str = "我是谁";
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
