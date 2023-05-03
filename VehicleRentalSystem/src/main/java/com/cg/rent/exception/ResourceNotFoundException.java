package com.cg.rent.exception;

/**
 * ResourceNotFoundException class
 * will handle the exception if resource is not found
 * @author 15BW089AX
 *
 */
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String msg)
	{
		super(msg);
	}
}
