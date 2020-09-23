package com.lenovo.smarttraffic.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRTest1 {

    public static void qrCreate(String content, int width, int height) throws WriterException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height);

        int pixil[] = new int[width * height];
        for(int i = 0;i < height; i++){
            for(int j = 0; j < width; j++){
                pixil[i*width+j] = bitMatrix.get(j,i) ? 0xff000000 : 0xffffffff;
            }
        }


        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixil,0,width,0,0,width,height);
    }
}
