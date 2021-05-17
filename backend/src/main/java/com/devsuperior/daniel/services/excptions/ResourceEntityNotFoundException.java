package com.devsuperior.daniel.services.excptions;

public class ResourceEntityNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ResourceEntityNotFoundException(String msg) {
		super(msg);
	}

}
