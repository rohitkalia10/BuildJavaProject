package controller;

import model.InventoryDao;
import model.Inventory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import util.Utils;

import java.util.List;
import java.util.Map;

@RestController

public class ApplicationController {

	private static final Logger logger = LogManager.getLogger(ApplicationController.class);
/*	@Autowired
	SpringMongoConfig config;*/

	@Autowired
    private InventoryDao inventoryDao;

//	@Autowired
//	ObjectMapper mapper;

/*	@RequestMapping(value = "/shop", method = RequestMethod.POST)
	public String onlineShopping() {

		return "Name and Price for an item";
	}*/

/*	@RequestMapping(value = "/shopping", method = RequestMethod.POST)
	public JSONObject getGeneric(@RequestBody String stringToParse) {

		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		try {
			json = (JSONObject) parser.parse(stringToParse);



			System.out.println("Size is" + inventoryList.size());

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return json;
	}*/

/*	@RequestMapping(value = "/insertInventory", method = RequestMethod.POST)
	public ResponseEntity insertInventory(@RequestBody Map<String, String> myParam) {
		Inventory invEntity = new Inventory();

		String name = myParam.get("name");
		Double price = Double.parseDouble(myParam.get("price"));

//		invEntity.setName(name);
//		invEntity.setPrice(price);
//
//		inventoryDao.saveInventory(invEntity);

		return new ResponseEntity("{ \"status\" : \"SUCCESS\" }",HttpStatus.OK) ;
	}*/


/*	@RequestMapping(value = "/searchByPrice/{price}", method = RequestMethod.GET)
	public String searchByPrice(@PathVariable("price") double price) {
		List<Inventory> inventoryList = new ArrayList<>();
//		config.mongoTemplate().find()

		return  Utils.prettyJson(inventoryList);
	}*/


/*	@RequestMapping(value = "/searchByName/{name}", method = RequestMethod.GET)
	public String searchByName(@PathVariable("name") String name) {
		RestTemplate restTemplate = new RestTemplate();
		List<Inventory> inventoryList = new ArrayList<Inventory>();
		inventoryList = inventoryDao.findInventoryByName(name);

		String returnValue = "Something Broke";
		if(inventoryList.size()<1) {
			 final String uri = "http://localhost:8090/queryByName?name=Pencil";

	//		 restTemplate.getForEntity(uri, List<Inventory> l, uriVariables)

			 String result = restTemplate.getForObject(uri, String.class);
			 try {
				returnValue = mapper.writer().withDefaultPrettyPrinter().writeValueAsString(result);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		}else {
			returnValue = Utils.prettyJson(inventoryList);
		}
		return  returnValue;
	}*/

	@RequestMapping(value = "/query", method = RequestMethod.GET)
	public String getQuery(@RequestParam Map<String, String> myParam) {

		List<Inventory> inventoryList = inventoryDao.find(myParam);
		return Utils.prettyJson(inventoryList);

	}
	
	
/*	@RequestMapping("/")
	public String index() {
		return "Greetings from our developers!";
	}*/
}
