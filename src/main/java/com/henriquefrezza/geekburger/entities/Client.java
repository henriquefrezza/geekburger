package com.henriquefrezza.geekburger.entities;


public class Client {
	private String clientId;
	private Restriction restrictions;
	
	public Client(String clientId, Restriction restrictions) {
		super();
		this.clientId = clientId;
		this.restrictions = restrictions;
	}
        
        public Client(){}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public Restriction getRestrictions() {
		return restrictions;
	}

	public void setRestrictions(Restriction restrictions) {
		this.restrictions = restrictions;
	}

    @Override
    public String toString() {
        return "Client{" + "clientId=" + clientId + ", restrictions=" + restrictions + '}';
    }
        
        
}
