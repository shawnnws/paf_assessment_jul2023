package vttp2023.batch3.assessment.paf.bookings.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations.Search;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vttp2023.batch3.assessment.paf.bookings.models.AccomDetails;
import vttp2023.batch3.assessment.paf.bookings.models.BookingForm;
import vttp2023.batch3.assessment.paf.bookings.models.Listing;
import vttp2023.batch3.assessment.paf.bookings.models.SearchInput;
import vttp2023.batch3.assessment.paf.bookings.models.ViewTwoListing;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@Controller
@RequestMapping
public class ListingsController {

	@Autowired
	ListingsService listingsService;

	//TODO: Task 2
	@GetMapping("/")
	public ModelAndView homePage() {		
		List<String> countriesList = listingsService.getAllCountries();

		ModelAndView mav = new ModelAndView();
		mav.setViewName("view0");
		mav.addObject("countriesList", countriesList);
		mav.addObject("search", new SearchInput());
		mav.setStatus(HttpStatusCode.valueOf(200));
		return mav;
	}
	
	//TODO: Task 3
	@GetMapping("/search")
	public ModelAndView searchByCountry(@RequestParam String country,
										@RequestParam Integer numberOfPerson,
										@RequestParam Float minPriceRange,
										@RequestParam Float maxPriceRange) {

		SearchInput searchInput = new SearchInput();
		searchInput.setCountry(country);
		searchInput.setNumberOfPerson(numberOfPerson);
		searchInput.setMinPriceRange(minPriceRange);
		searchInput.setMaxPriceRange(maxPriceRange);

		List<ViewTwoListing> accomsList = listingsService.getViewTwoListing(searchInput);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("view1");
		mav.addObject("accomsList", accomsList);

		mav.addObject("country", country);
		mav.addObject("numberOfPerson", numberOfPerson);
		mav.addObject("minPriceRange", minPriceRange);
		mav.addObject("maxPriceRange", maxPriceRange);
		mav.setStatus(HttpStatusCode.valueOf(200));
		return mav;
	}

	//TODO: Task 4
	@GetMapping("/details/{accommodationId}")
	public ModelAndView showAccomDetails(@PathVariable String accommodationId,
											@RequestParam(name = "country") String country,
											@RequestParam(name = "numberOfPerson") Integer numberOfPerson,
											@RequestParam(name = "minPriceRange") Float minPriceRange,
											@RequestParam(name = "maxPriceRange") Float maxPriceRange) {
		
		AccomDetails accomDetail = listingsService.getAccomDetails(accommodationId);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("view2");
		mav.addObject("country", country);
		mav.addObject("numberOfPerson", numberOfPerson);
		mav.addObject("minPriceRange", minPriceRange);
		mav.addObject("maxPriceRange", maxPriceRange);
		mav.addObject("accomDetail", accomDetail);
		mav.addObject("bookingForm", new BookingForm());
		mav.setStatus(HttpStatusCode.valueOf(200));
		return mav;
	}

	//TODO: Task 5


}
