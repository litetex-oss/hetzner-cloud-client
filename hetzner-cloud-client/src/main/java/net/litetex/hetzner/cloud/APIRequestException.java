package net.litetex.hetzner.cloud;

import net.litetex.hetzner.cloud.error.response.APIErrorResponse;


public class APIRequestException extends RuntimeException
{
	private static final String DEFAULT_EXCEPTION_MSG = "Encountered error while calling the Hetzner-API: [%s] %s";
	
	private final APIErrorResponse apiErrorResponse;
	
	public APIRequestException(final APIErrorResponse r)
	{
		this(String.format(DEFAULT_EXCEPTION_MSG, r.error().code(), r.error().message()), null, r);
	}
	
	public APIRequestException(final String message, final APIErrorResponse apiErrorResponse)
	{
		this(message, null, apiErrorResponse);
	}
	
	public APIRequestException(final Throwable cause, final APIErrorResponse apiErrorResponse)
	{
		this(cause != null ? cause.getMessage() : null, cause, apiErrorResponse);
	}
	
	public APIRequestException(final String message, final Throwable cause, final APIErrorResponse apiErrorResponse)
	{
		super(message);
		if(cause != null)
		{
			super.initCause(cause);
		}
		
		this.apiErrorResponse = apiErrorResponse;
	}
	
	public APIErrorResponse getApiErrorResponse()
	{
		return this.apiErrorResponse;
	}
}
