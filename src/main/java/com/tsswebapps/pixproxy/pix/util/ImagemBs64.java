package com.tsswebapps.pixproxy.pix.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class ImagemBs64 {
    public BufferedImage gerarImageQrCode(String textoDoQrCode, int largura, int altura) throws Exception {
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(textoDoQrCode, BarcodeFormat.QR_CODE, largura, altura);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    public String bufferedImageParaBase64(BufferedImage image) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(image, "png", outputStream);
        byte[] bs = outputStream.toByteArray();
        String imagemEmTexto = Base64.getEncoder().encodeToString(bs);
        imagemEmTexto = imagemEmTexto.replaceAll("\n", "").replaceAll("\r", "");
        return imagemEmTexto;
    }

    public BufferedImage base64ParaImageBuffered(String imagemEmTexto) throws IOException {
        byte[] bs = Base64.getDecoder().decode(imagemEmTexto);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bs);
        return ImageIO.read(inputStream);
    }

}
