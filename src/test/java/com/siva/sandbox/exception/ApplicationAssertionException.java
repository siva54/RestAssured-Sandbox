package com.siva.sandbox.exception;

import com.siva.sandbox.common.Error;

public class ApplicationAssertionException extends Exception {
	private static final long serialVersionUID = 4129239466937422138L;
	private Error error;
	private Exception exception;

	public ApplicationAssertionException(Error error, Exception exception) {
		this.error = error;
		this.exception = exception;
	}

	@Override
	public String getMessage() {
		String message = error != null ? error.getDescription() : super.getMessage();

		if (error != null) {
			message = "Error Reason : " + error.getDescription();
			if (exception != null) {
				message = message + ", And the cause is : " + exception.getMessage();
			}
		} else {
			message = super.getMessage();
		}

		return message;
	}
}