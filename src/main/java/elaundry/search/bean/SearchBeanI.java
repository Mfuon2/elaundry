package elaundry.search.bean;

public interface SearchBeanI {
	
	int countCustomerSearch(String confirmationLink, String search);
	String servicesGivenInJson(String confirmationLink, String search);
}
