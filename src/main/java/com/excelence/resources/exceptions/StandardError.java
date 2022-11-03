package com.excelence.resources.exceptions;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant timestamp;
	private Integer statua;
	private String error;
	private String message;
	private String path;
	

	public StandardError() {
	}

	public StandardError(Instant timestamp, Integer statua, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.statua = statua;
		this.error = error;
		this.message = message;
		this.path = path;
	}


	public Instant getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}


	public Integer getStatua() {
		return statua;
	}


	public void setStatua(Integer statua) {
		this.statua = statua;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}

}