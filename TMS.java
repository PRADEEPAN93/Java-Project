package com.ticket.booking;

import java.util.Random;

import java.util.*;

public class TMS {
private static ArrayList<Ticket> ticketList = new ArrayList<>();
	
	private static Random random = new Random();

	private static int generateTicketNumber() {
	
		Random random = new Random();
		
		return random.nextInt(10000) + 1;
	
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
	
		int choice;
		
		System.out.println("Welcome to TMS!");
		
		do {
		
			System.out.println("1. Book Ticket");
			
			System.out.println("2. List Tickets");
			
			System.out.println("3. Cancel Ticket");
			
			System.out.println("4. View Ticket");
			
			System.out.println("5. Exit");
			
			System.out.print("Enter your choice: ");
			
			choice = scanner.nextInt();
			
			switch (choice) {
			
			case 1:
			
				bookTicket(scanner);
				
				break;
			
			case 2:
			
				listTickets();
				
				break;
		
			case 3:
			
				cancelTicket(scanner);
				
				break;
			
			case 4:
			
				viewTicket(scanner);
				
				break;
			
			case 5:
			
				System.out.println("Exiting... Thank you!");
				
				break;
			
			default:
			
				System.out.println("Invalid choice. Please try again.");
			
			}
		} 
		
		while (choice != 0);
		
		scanner.close();

	}

	private static void bookTicket(Scanner scanner) {

		System.out.print("Enter the number of passengers: ");
		
		int numPassengers = scanner.nextInt();// 2
		
		scanner.nextLine();
		
		System.out.print("Boarding Point: ");
		
		String boardingPoint = scanner.nextLine();
		
		System.out.print("Destination Point: ");
		
		String destinationPoint = scanner.nextLine();
		
		int ticketNumber = random.nextInt(10000) + 1;
		
		List<PassengerDetails> passengers = new ArrayList<>();
		
		for (int i = 1; i <= numPassengers; i++) {
		
			PassengerDetails passenger = new PassengerDetails();
			
			System.out.println("Enter details for passenger " + (i) + ":");
			
			System.out.print("Name: ");
			
			String name = scanner.nextLine();
			
			passenger.setPassengerName(name);
			
			System.out.print("Age: ");
			
			int age = scanner.nextInt();
			
			passenger.setPassengerAge(age);
			
			scanner.nextLine();
			
			passengers.add(passenger);
		}
		
		Ticket ticket = new Ticket(ticketNumber, boardingPoint, destinationPoint);
	
		ticket.setPassengers(passengers);
		
		ticketList.add(ticket);
		
		System.out.println("Thanks for booking! Your PNR is: " + ticketNumber);
	}
	

	public static void listTickets() {
	
		if (ticketList.isEmpty()) {
		
			System.out.println("No tickets booked yet.");
		} 
		else {
		
			System.out.println("List of booked tickets:");
			
			for (Ticket ticket : ticketList) {
			
				System.out.println(ticket);
			
			}
		}

	}

	public static void cancelTicket(Scanner scanner) {
		
		if (ticketList.isEmpty()) {
		
			System.out.println("No tickets booked yet.");
		}
		
		System.out.print("Enter PNR to cancel ticket: ");
		
		int pnrToCancel = scanner.nextInt();
		
		boolean found = false;
		
		for (Ticket ticket : ticketList) {
		
			if (ticket.ticketNumber == pnrToCancel) {
			
				ticketList.remove(ticket);
				
				System.out.println("Ticket with PNR " + pnrToCancel + " canceled successfully.");
				
				found = true;
				
				break;
			}
		}
		
		if (!found) {
		
			System.out.println("Ticket with PNR " + pnrToCancel + " not found.");
		}
		
	}

	private static void viewTicket(Scanner scanner) {

		System.out.print("Enter the ticket number to view: ");
		
		int ticketNumber = scanner.nextInt();

		
		for (Ticket ticket : ticketList) {// arraylist objects
		
			if (ticket.ticketNumber == ticketNumber) {
			
				System.out.println("Ticket Details:");
				
				System.out.println("Ticket Number: " + ticket.ticketNumber);
				
				System.out.println("Boarding Point: " + ticket.boardingPoint);
				
				System.out.println("Destination Point: " + ticket.destinationPoint);
				
				int count = 1;
				
				for (PassengerDetails passenger : ticket.getPassengers()) {
				
					System.out.println("Passenger " + (count) + " Name: " + passenger.passengerName);
					
					System.out.println("Passenger " + (count) + " Age: " + passenger.passengerAge);
					
					count++;
				
				}
				
				return;
			
			}
		}

		System.out.println("Ticket number not found...");

	}
}
