package elaundry.search.bean;

public interface SearchBeanI {
	
	int countTickets(String confirmationLink, String search);
	String servicesGivenInJson(String confirmationLink, String search);
	int countOpenTickets();
	int countAllTickets();
}
