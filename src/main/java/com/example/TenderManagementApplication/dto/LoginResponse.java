package com.example.TenderManagementApplication.dto;


public class LoginResponse {
    private String jwt;
    private int status;

    public LoginResponse(String jwt, int status) {
        this.jwt = jwt;
        this.status = status;
    }
    

    public LoginResponse() {
		super();
	}


	public void setJwt(String jwt) {
		this.jwt = jwt;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getJwt() {
        return jwt;
    }

    public int getStatus() {
        return status;
    }
}
