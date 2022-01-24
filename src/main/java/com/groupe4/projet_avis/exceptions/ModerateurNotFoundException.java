package com.groupe4.projet_avis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ModerateurNotFoundException extends Exception {

	/**
	 * 
	 * @param message
	 */
		public ModerateurNotFoundException(String message) {
			super(message);
		}
}
