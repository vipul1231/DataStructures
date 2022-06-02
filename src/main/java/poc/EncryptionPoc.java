package poc;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Duration;
import java.time.Instant;

public class EncryptionPoc {

	private static IvParameterSpec getIv() {
		SecureRandom srandom = new SecureRandom();
		byte[] iv = new byte[128 / 8];
		srandom.nextBytes(iv);
		IvParameterSpec ivspec = new IvParameterSpec(iv);
		//Save it.
		try (FileOutputStream fos = new FileOutputStream("iv.file")) {
			fos.write(iv);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return ivspec;
	}

	private static SecretKey getSecretKey(String algorithm) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance(algorithm);
			kgen.init(128);
			return kgen.generateKey();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	private static PrivateKey loadPrivateKey() {
		try {
			byte[] bytes = Files.readAllBytes(Paths.get("private.key"));
			PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PrivateKey pvt = kf.generatePrivate(ks);
			return pvt;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static KeyPair getKeyPair(String algorithm) {
		try {
			KeyPairGenerator kpg = KeyPairGenerator.getInstance(algorithm);
			kpg.initialize(2048);
			KeyPair keyPair = kpg.generateKeyPair();
			return keyPair;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	private static void writeContent(IvParameterSpec ivspec, PrivateKey privateKey, SecretKey secretKey) {

		try {
			FileOutputStream out = new FileOutputStream("output-6.enc");
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);
			byte[] b = cipher.doFinal(secretKey.getEncoded());
			out.write(b);

			Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
			ci.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
			try (FileInputStream in = new FileInputStream("ideaIC-2021.1.3.tar.gz")) {
				processFileForAes(ci, in, out);
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private static void readContent() {

		try {
			byte[] bytes = Files.readAllBytes(Paths.get("public.pub"));
			X509EncodedKeySpec ks = new X509EncodedKeySpec(bytes);
			KeyFactory kf = KeyFactory.getInstance("RSA");
			PublicKey pub = kf.generatePublic(ks);

			FileInputStream in = new FileInputStream("output-6.enc");
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.DECRYPT_MODE, pub);
			byte[] b = new byte[256];
			in.read(b);
			byte[] keyb = cipher.doFinal(b);
			SecretKeySpec skey = new SecretKeySpec(keyb, "AES");

			byte[] iv = new byte[128 / 8];
			FileInputStream fis = new FileInputStream("iv.file");
			fis.read(iv);
			IvParameterSpec ivspec = new IvParameterSpec(iv);

			Cipher ci = Cipher.getInstance("AES/CBC/PKCS5Padding");
			ci.init(Cipher.DECRYPT_MODE, skey, ivspec);
			try (FileOutputStream out = new FileOutputStream("ideaIC-2021.1.3-1.tar.gz")) {
				processFile(ci, in, out);
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	//	////////////////////////////////////////////////////////////////////////////////////////
	private static void saveKeypair(KeyPair keyPair) {
		try (FileOutputStream out = new FileOutputStream("private.key")) {
			out.write(keyPair.getPrivate().getEncoded());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		try (FileOutputStream out = new FileOutputStream("public.pub")) {
			out.write(keyPair.getPublic().getEncoded());
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	public static void RSAEncryption(PrivateKey privateKey) {

		try {
			Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			cipher.init(Cipher.ENCRYPT_MODE, privateKey);

			try (FileOutputStream out = new FileOutputStream("Doc-enc.des");
			     FileInputStream in = new FileInputStream("File1.deb")) {
				processFile(cipher, in, out);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private static void processFile(Cipher ci, InputStream in, OutputStream out)
			throws javax.crypto.IllegalBlockSizeException,
			javax.crypto.BadPaddingException,
			java.io.IOException {
		byte[] ibuf = new byte[1024];
		int len;
		while ((len = in.read(ibuf)) != -1) {
			byte[] obuf = ci.update(ibuf, 0, len);
			if (obuf != null) out.write(obuf);
		}
		byte[] obuf = ci.doFinal();
		if (obuf != null) out.write(obuf);
	}


	static private void processFileForAes(Cipher ci, InputStream in, OutputStream out)
			throws javax.crypto.IllegalBlockSizeException,
			javax.crypto.BadPaddingException,
			java.io.IOException {
		byte[] ibuf = new byte[1024];
		int len;
		while ((len = in.read(ibuf)) != -1) {
			byte[] obuf = ci.update(ibuf, 0, len);
			if (obuf != null) out.write(obuf);
		}
		byte[] obuf = ci.doFinal();
		if (obuf != null) out.write(obuf);
	}

	public static void main(String[] args) {
//		Instant in1 = Instant.now();
//		KeyPair keyPair = getKeyPair("RSA");
//		saveKeypair(keyPair);
//		RSAEncryption(keyPair.getPrivate());
//		Instant in2 = Instant.now();
//
//		Duration duration = Duration.between(in1, in2);
//		System.out.println(duration.toMillis());

		Instant in1 = Instant.now();
		SecretKey secretKey = getSecretKey("AES");
		IvParameterSpec ivs = getIv();
		PrivateKey privateKey = loadPrivateKey();
		writeContent(ivs, privateKey, secretKey);
		Instant in2 = Instant.now();
		readContent();
		Duration duration = Duration.between(in1, in2);
		System.out.println(duration.toMillis());

	}

}
