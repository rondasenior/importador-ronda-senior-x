package br.com.senior.importadorrondaseniorx.core;

public class MandatoryFieldEmptyException extends GenericException {

	private static final long serialVersionUID = 1L;

	public MandatoryFieldEmptyException(String message) {
		super(message);
	}
}
