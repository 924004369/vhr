package com.crt.vhr;

import com.crt.vhr.utils.QrCodeUtil;

import java.util.Base64;

public class QRCodeGenerator {
    private static final String QR_CODE_IMAGE_PATH = "./MyQRCode.png";

    public static void main(String[] args) {
        QrCodeUtil.generateQrCodeAndSave("This is my first QR Code", "png", 350, 350, QR_CODE_IMAGE_PATH);
//        byte[] pngs = QrCodeUtil.generateQrCode("This is my first QR Code", "png", 350, 350);
    }
}
