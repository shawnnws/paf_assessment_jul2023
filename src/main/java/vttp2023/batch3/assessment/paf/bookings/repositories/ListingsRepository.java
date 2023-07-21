package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.View;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp2023.batch3.assessment.paf.bookings.models.AccomDetails;
import vttp2023.batch3.assessment.paf.bookings.models.Listing;
import vttp2023.batch3.assessment.paf.bookings.models.SearchInput;
import vttp2023.batch3.assessment.paf.bookings.models.ViewTwoListing;

@Repository
public class ListingsRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//TODO: Task 2

	/*
	 	db.getCollection("accomodation_info").distinct("address.country")
	 */
	public List<String> getAllCountries() {
		String fieldName = "address.country";
        List<String> distinctCountries = mongoTemplate.query(Listing.class)
				.inCollection("listings")
                .distinct(fieldName)
                .as(String.class)
                .all();
        return distinctCountries;
	}
	
	//TODO: Task 3

	/* 
		db.listings.aggregate([
			{
				$match: {
				"address.country": { $regex: ".*Australia.*", $options: "i" },
				"accommodates": { $gte: 2 },
				"price": { $gte: 100, $lte: 200 }
				}
			},
			{
				$project: {
				"accommodationId": "$_id",
				"name": "1",
				"price": 1,
				"image": "$images.picture_url"
				}
			},
			{
				$sort: { "price": -1 }
			}
			])
	*/

	public List<ViewTwoListing> getViewTwoListing(SearchInput search) {
		MatchOperation matchOps = Aggregation.match(
			Criteria.where("address.country").is(search.getCountry())
				.and("accommodates").gte(search.getNumberOfPerson())
				.and("price").gte(search.getMinPriceRange()).lte(search.getMaxPriceRange())
		);
		ProjectionOperation projectionOps = Aggregation.project("_id", "address.country", "accommodates", "price")
			.andExpression("_id").as("accommodationId")
        	.andExpression("name").as("name")
            .andExpression("address.street").as("address")
            .andExpression("images.picture_url").as("image");

		SortOperation sortOps = Aggregation.sort(Sort.by(Direction.DESC, "price"));

		Aggregation pipeline = Aggregation.newAggregation(matchOps, projectionOps, sortOps);
		AggregationResults<ViewTwoListing> results = mongoTemplate.aggregate(pipeline, "listings", ViewTwoListing.class);
		return results.getMappedResults();
	}


	//TODO: Task 4
	
	/*
		 db.listings.aggregate([
		{
			$match: {
				"_id" : "27498126"
			}
		},
		{
			$project: {
				"accommodationId" : "$_id",
				"description" : 1,
				"image" : "images.picture_url",
				"address.street" : 1,
				"address.suburb" : 1,
				"address.country" : 1,
				"price" : 1,
				"amenities" : 1
			}
		}
	])
	*/

	public AccomDetails getAccomDetails(String accommodationId) {
		MatchOperation matchOps = Aggregation.match(Criteria.where("_id").is(accommodationId));

		ProjectionOperation projectionOps = Aggregation.project()
			.andExpression("_id").as("accommodationId")
			.and("description").as("description")
			.and("address.street").as("street")
			.and("address.suburb").as("suburb")
			.and("address.country").as("country")
			.and("images.picture_url").as("image")
			.and("price").as("price")
			.and("amenities").as("amenities");

		Aggregation pipeline = Aggregation.newAggregation(matchOps, projectionOps);
		AggregationResults<AccomDetails> result = mongoTemplate.aggregate(pipeline, "listings", AccomDetails.class);
		return result.getUniqueMappedResult();
	}

	//TODO: Task 5
	

}
