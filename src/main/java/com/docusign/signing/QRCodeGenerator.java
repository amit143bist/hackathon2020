package com.docusign.signing;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QRCodeGenerator {

	private static final String QR_CODE_IMAGE_PATH = "C:\\hackathon2020\\qrcode/MyQRCode";

	public static void generateQRCodeImage(String text, int width, int height, String filePath)
			throws WriterException, IOException {
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

		Path path = FileSystems.getDefault().getPath(filePath);
		MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
	}

	public static void main(String[] args) {
		
		try {
			generateQRCodeImage("http://localhost:53134?applicationId=12346", 350, 350, QR_CODE_IMAGE_PATH + "_12346.png");
		} catch (WriterException e) {
			log.info("Could not generate QR Code, WriterException :: " + e.getMessage());
		} catch (IOException e) {
			log.info("Could not generate QR Code, IOException :: " + e.getMessage());
		}
	}
}