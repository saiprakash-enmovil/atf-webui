package org.enmovil.atf.util;

import org.apache.commons.lang3.RandomStringUtils;

import io.netty.util.internal.ThreadLocalRandom;

public class CommonUtils {
	
	public static int generateRandomNumber() {
		int rand_number = ThreadLocalRandom.current().nextInt();
		return rand_number;
	}
	
	public static String generateRandomName() {
		String genRandName = RandomStringUtils.randomAlphabetic(8);
		return genRandName;
	}
	
	public static int generateIMEI() {
		int imei = ThreadLocalRandom.current().nextInt(15);
		return imei;
	}
	
	public static String generateLicenseNumber() {
		String randomStr = RandomStringUtils.random(14, false, true);
    	String fistr = RandomStringUtils.random(2, true, false).toUpperCase();
    	String result = fistr + randomStr;
    	return result;
	}
	
	public static String generatePhoneNumber() {
		String randomPhoneNumber = RandomStringUtils.random(9, false, true);
		return 9+randomPhoneNumber;
	}
}
 