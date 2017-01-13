
package org.asena.AAA.common;

import java.math.BigInteger;
import java.security.SecureRandom;

public class AAATools
{
	public static String getHashed(String input)
	{
		return org.apache.commons.codec.digest.DigestUtils.sha384Hex(input);
	}

	public static String getRandomPassword()
	{
		SecureRandom random = new SecureRandom();
		return new BigInteger(50, random).toString(32);
	}
}
