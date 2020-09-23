package com.lenovo.smarttraffic.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateQRBitpam {

    public static Bitmap CreateQRBitMap(String content, int width, int height) throws WriterException {

        HashMap<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = new QRCodeWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        QRCodeWriter qrCodeWriter = new QRCodeWriter();

        new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);

        final int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixels[y * width + x] = bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);

        return bitmap;
    }


    public static Bitmap createQRBitmap1(String content, int width, int height) throws WriterException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        HashMap<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);

        int[] pixs = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixs[y * width + x] = bitMatrix.get(x, y) ?  0xFFFFFFFF :0xFF000000 ;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixs, 0, width, 0, 0, width, height);
        return bitmap;
    }

    public static Bitmap creatQRBitmap2(String str, int width, int height) throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        HashMap<EncodeHintType, String> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = qrCodeWriter.encode(str, BarcodeFormat.QR_CODE, width, height, hints);


        int[] pixs = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                pixs[y * width + x] = bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixs, 0, width, 0, 0, width, height);
        return bitmap;
    }

    public Bitmap createQRBitmap3(int width, int height, String content) throws WriterException {
        QRCodeWriter codeWriter = new QRCodeWriter();
        HashMap<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        BitMatrix bitMatrix = codeWriter.encode(content, BarcodeFormat.QR_CODE, width, height, hints);

        int[] pixs = new int[width*height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < height; x++) {
                pixs[y*width+x] = bitMatrix.get(width,height) ? 0xFF000000 : 0xFFFFFFFF;
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixs,0,width,0,0,width,height);

        return bitmap;
    }

    public static void hashs() {
        List<String> keys = new ArrayList<>();


        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String key : keys) {
            if (hashMap.containsKey(key)) {
                int x = hashMap.get(key) + 1;
                hashMap.put(key, x);

            } else {
                hashMap.put(key, 0);
            }

        }
        hashMap.put("111", 0);
        hashMap.put("222", 0);
        hashMap.put("111", 1);

        System.out.println(hashMap);

    }

    public static void main(String[] args) {
        hashs();
    }


}
