package com.groupe4.projet_avis.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * On passe un message au controlleur du RuntimeException qui prend en
 * paramettre un argument de type string L'annotation veut dire: return 404
 * resource introuvable
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AvisNotFoundException extends Exception {

	/**
	 * Appel du constructeur
	 * 
	 * @param message
	 */
	public AvisNotFoundException(String message) {
		super(message);
	}

}
