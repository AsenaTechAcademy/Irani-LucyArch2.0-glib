package org.asena.common.exception;

public class gException extends Exception 
{
    private static final long serialVersionUID = 1997753363232807009L;

	public gException()
	{
	}
	
	public gException(String message)
	{
		super(message);
	}
	
	public gException(Throwable cause)
	{
		super(cause);
	}
	
	public gException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public gException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
