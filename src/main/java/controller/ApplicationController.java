package controller;

import model.Inventory;
import mongodb.SpringMongoConfig;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ApplicationController {

	@Autowired
	SpringMongoConfig config;

	@RequestMapping(value = "/shop", method = RequestMethod.POST)
	public String onlineShopping() {

		return "Name and Price for an item";
	}

	@RequestMapping(value = "/shopping", method = RequestMethod.POST)
	public JSONObject getGeneric(@RequestBody String stringToParse) {

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		try {
			json = (JSONObject) parser.parse(stringToParse);

			String name = json.get("name").toString();
			String price = json.get("price").toString();

			MongoTemplate mongoTemplate = config.mongoTemplate();
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is("Front Door"));
			List<Inventory> inventoryList = mongoTemplate.find(query, Inventory.class);

			System.out.println("Size is" + inventoryList.size());

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value = "/searchByPrice/{price}", method = RequestMethod.GET)
	public String searchByPrice(@PathVariable("price") double price) {
//		JSONObject json = new JSONObject();
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {

			MongoTemplate mongoTemplate = config.mongoTemplate();
			Query query = new Query();
			query.addCriteria(Criteria.where("price").is(price));
			inventoryList = mongoTemplate.find(query, Inventory.class);

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			jsonString =  mapper.writeValueAsString(inventoryList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		  
		  System.out.println("***********Value :::"+jsonString);
		
		return jsonString;
		
		
	}
	
	@RequestMapping(value = "/searchByName/{name}", method = RequestMethod.GET)
	public String searchByName(@PathVariable("name") String name) {
//		JSONObject json = new JSONObject();
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = null;
		try {

			MongoTemplate mongoTemplate = config.mongoTemplate();
			Query query = new Query();
			query.addCriteria(Criteria.where("name").is(name));
			inventoryList = mongoTemplate.find(query, Inventory.class);

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			jsonString =  mapper.writeValueAsString(inventoryList);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		  
		  System.out.println("***********Value :::"+jsonString);
		
		return jsonString;
	}
	
	
	@RequestMapping("/")
	public String index() {
		return "Greetings from our developers!";
	}
}
