package org.asena.common;

import java.sql.Timestamp;

import com.b4a.manamsoftware.PersianDate.ManamPersianDate;

public class gCal 
{
	
	public static Timestamp getCurrentDateTime()
	{
		return new java.sql.Timestamp(new java.util.Date().getTime());
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  PersianToGregorian
	
	public static String PersianToGregorian (String S) throws InstantiationException, IllegalAccessException
	{
		String A[]=new String[3];
	    int B[]=new int[3];
	    A=S.split("/");
	    for(int i=0;i<A.length;i++)
 			 B[i]=Integer.parseInt(A[i]);
 		String w=ManamPersianDate.class.newInstance().PersianToGregorian(B[0], B[1], B[2]);
		return w;
	}

	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  GregorianToPersian
	public static String GregorianToPersian (String S) throws InstantiationException, IllegalAccessException
	{
		String A[]=new String[3];
	    int B[]=new int[3];
	    A=S.split("/");
	    for(int i=0;i<A.length;i++)
 			 B[i]=Integer.parseInt(A[i]);
 		String w=ManamPersianDate.class.newInstance().GregorianToPersian(B[0], B[1], B[2]);
		return w;
	}

}
