package com.mse.forum.services.impl;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * A class that can be used to encrypt and handle encryption of passwords.
 * 
 * @author ivo.rusev
 *
 */
public class PasswordEncryptionUtil {

	private static final String SALT = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static final int ITERATIONS = 10000;
	private static final int KEY_LENGTH = 256;

	/**
	 * Encrypts a password.
	 * 
	 * @param password the plain text password.
	 * @return encrypted password, see implementation for details.
	 */
	private static String encrypt(String password) {
		byte[] securePassword = hash(password.toCharArray());
		return Base64.getEncoder().encodeToString(securePassword);
	}

	/**
	 * Verifies if a password passed as a String equals a certain encrypted
	 * password.
	 * 
	 * @param password          the plain text password
	 * @param encryptedPassword the already encrypted password.
	 * @return true if both match false otherwise.С
	 */
	public static boolean verifyUserPassword(String password, String encryptedPassword) {
		// Generate New secure password with the same salt
		String newSecurePassword = encrypt(password);
		// Check if two passwords are equal
		return newSecurePassword.equalsIgnoreCase(encryptedPassword);
	}

	private static byte[] hash(char[] password) {
		PBEKeySpec spec = new PBEKeySpec(password, SALT.getBytes(), ITERATIONS, KEY_LENGTH);
		Arrays.fill(password, Character.MIN_VALUE);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return skf.generateSecret(spec)
					.getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}

	/*
	public static void main(String[] args) {
		System.out.println(encrypt("asd"));
		System.out.println(verifyUserPassword("asd", encrypt("asd")));
	}
	*/
}