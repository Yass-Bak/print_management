package com.example.model;

import java.time.LocalDateTime;

public class PrintRequest {
    private int id;
    private int teacherId;
    private int subjectId;
    private String pdfDocument;
    private LocalDateTime printDate; // Change to LocalDateTime
    private int numCopies;


    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getPdfDocument() {
		return pdfDocument;
	}

	public void setPdfDocument(String pdfDocument) {
		this.pdfDocument = pdfDocument;
	}

	public int getNumCopies() {
		return numCopies;
	}

	public void setNumCopies(int numCopies) {
		this.numCopies = numCopies;
	}

	public LocalDateTime getPrintDate() {
        return printDate;
    }

    public void setPrintDate(LocalDateTime printDate) { // Change to LocalDateTime
        this.printDate = printDate;
    }


}
