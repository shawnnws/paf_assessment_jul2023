package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.models.AccomDetails;
import vttp2023.batch3.assessment.paf.bookings.models.BookingForm;
import vttp2023.batch3.assessment.paf.bookings.models.Listing;
import vttp2023.batch3.assessment.paf.bookings.models.SearchInput;
import vttp2023.batch3.assessment.paf.bookings.models.ViewTwoListing;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class ListingsService {

	@Autowired
	ListingsRepository listingsRepository;
	
	//TODO: Task 2
	public List<String> getAllCountries() {
		return listingsRepository.getAllCountries();
	}
	
	//TODO: Task 3
	public List<ViewTwoListing> getViewTwoListing(SearchInput searchInput) {
		return listingsRepository.getViewTwoListing(searchInput);
	}

	//TODO: Task 4
	public AccomDetails getAccomDetails(String accommodationId) {
		return listingsRepository.getAccomDetails(accommodationId);
	}

	//TODO: Task 5
	

}
