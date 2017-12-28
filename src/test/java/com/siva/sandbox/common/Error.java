package com.siva.sandbox.common;

public enum Error {

	// @formatter:off
	E10000("Incorrect path or file missing"), 
	E10001("Incorrect json file"), 
	E20000("Sample error");
	// @formatter:on

	public String description;

	private Error(String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}