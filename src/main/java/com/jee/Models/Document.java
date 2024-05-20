package com.jee.Models;

import java.sql.Timestamp;

public class Document {
	
	private int id;
	private int patientId;
	private String docType;
	private String path;
	private Timestamp toc;
	private String description;

	
	public Document() {
	}


	public Document(int id, int patientId, String docType, String path, Timestamp toc, String description) {
		this.id = id;
		this.patientId = patientId;
		this.docType = docType;
		this.path = path;
		this.toc = toc;
		this.description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPatientId() {
		return patientId;
	}


	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}


	public String getDocType() {
		return docType;
	}


	public void setDocType(String docType) {
		this.docType = docType;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public Timestamp getToc() {
		return toc;
	}


	public void setToc(Timestamp toc) {
		this.toc = toc;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Document [id=" + id + ", patientId=" + patientId + ", docType=" + docType + ", path=" + path + ", toc="
				+ toc + ", description=" + description + "]";
	}


	
	   
	
	

	
	   


}
