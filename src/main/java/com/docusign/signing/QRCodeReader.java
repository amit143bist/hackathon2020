package com.docusign.signing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QRCodeReader {

	public static String decodeQRCode(File qrCodeimage) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		try {
			Result result = new MultiFormatReader().decode(bitmap);
			return result.getText();
		} catch (NotFoundException e) {
			log.info("There is no QR code in the image");
			return null;
		}
	}
	
	public static String decodeQRCodeFromStream(InputStream qrCodeimage) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		try {
			Result result = new MultiFormatReader().decode(bitmap);
			
			log.info("QRCodeReader.decodeQRCodeFromStream() " + result.getText());
			return result.getText();
		} catch (NotFoundException e) {
			log.info("There is no QR code in the image");
			return null;
		}
	}

	public static void main(String[] args) { 
		try {
			File file = new File("C:\\hackathon2020\\qrcode/MyQRCode.png");
			String decodedText = decodeQRCode(file);
			if (decodedText == null) {
				log.info("No QR Code found in the image");
			} else {
				log.info("Decoded text = " + decodedText);
			}
		} catch (IOException e) {
			log.info("Could not decode QR Code, IOException :: " + e.getMessage());
		}
	}
}