package com.groupe4.projet_avis.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class JeuNotFoundException extends Exception {
	
	/**
	 * 
	 * @param message
	 */
	public JeuNotFoundException(String message) {
		super(message);
	}
}
