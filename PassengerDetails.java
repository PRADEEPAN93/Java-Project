package com.ticket.booking;

public class PassengerDetails {
String passengerName;
	
	int passengerAge;

	public String getPassengerName() {
	
		return passengerName;
	
	}

	public void setPassengerName(String passengerName) {
	
		this.passengerName = passengerName;
	
	}

	public int getPassengerAge() {
	
		return passengerAge;
	
	}

	public void setPassengerAge(int passengerAge) {
	
		this.passengerAge = passengerAge;
	
	}

	@Override
	public String toString() {
	
		return "PassengerDetails [passengerName=" + passengerName + ", passengerAge=" + passengerAge + "]";
	
	}
}
