package com.qfedu.house.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public final class CommonUtil {
	private static final String CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int LEN = CHARS.length();
	
	private CommonUtil() {
		throw new AssertionError();
	}
	
	public static double randomDouble(double min, double max) {
		return Math.random() * (max - min) + min;
	}
	
	public static String generateVC(int len) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; ++i) {
			int index = (int) (Math.random() * LEN);
			sb.append(CHARS.charAt(index));
		}
		return sb.toString();
	}
	
	public static BufferedImage getImageFromString(String code, int width, int height) {
		int size = (width - 10) / code.length();
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = (Graphics2D) image.getGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		g.setFont(new Font("ËÎÌו", Font.BOLD, height * 4 / 5));
		for (int i = 0; i < code.length(); ++i) {
			g.setColor(Color.BLUE);
			String str = code.substring(i, i + 1);
			g.drawString(str, 10 + size * i, height / 2 + 5);
		}
		return image;
	}
	
}
