package com.example.model;

public class Task {
    private int id;
    private int printRequestId;
    private int agentId;
    private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrintRequestId() {
		return printRequestId;
	}
	public void setPrintRequestId(int printRequestId) {
		this.printRequestId = printRequestId;
	}
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

    // Getters et Setters
}
