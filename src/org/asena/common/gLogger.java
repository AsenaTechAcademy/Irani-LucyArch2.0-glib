
package org.asena.common;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.sql.*;


public class gLogger
{
	public static void Log(String exceptionclassname, String message)
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/glib", "glibadmin", "123");
			stmt = conn.createStatement();
			String sql = "INSERT INTO aaexceptionlogs (exceptionclassname,message,cdate) " + "VALUES ('" + exceptionclassname
						+ "',' " + message + "','" + gCal.getCurrentDateTime() + "');";
			stmt.executeUpdate(sql);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (!(null == conn))
					conn.close();
			}
			catch (Exception e)
			{}
		}
	}



	public static String getStackTrace(Throwable aThrowable)
	{
		Writer result = new StringWriter();
		PrintWriter printWriter = new PrintWriter(result);
		aThrowable.printStackTrace(printWriter);
		return result.toString();
	}


}
