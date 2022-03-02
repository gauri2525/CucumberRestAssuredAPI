package StepDefinations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.*;

public class PlaceAPISteps extends Utils {

	   
	  
	 RequestSpecification res;
	   ResponseSpecification respSpec;
	   Response response;
	   TestDataBuild data=new TestDataBuild();
	
		@Given("Add Place Payload")
		public void add_place_payload() {
			

		    res=given().spec(requestSpecification())
		    .body(data.addPlacePayload());
		    
		    respSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();

		    
		}
	
		@When("user calls {string} with POST http request.")
		public void user_calls_add_place_api_with_post_http_request(String addPlaceAPI) {
		     response=res.when().post("maps/api/place/add/json").
		    		 then().spec(respSpec).extract().response();
		}
		
		@Then("the API call is success with status code {int}")
		public void the_api_call_is_success_with_status_code(Integer ExpStatusCode) {
			assertEquals(response.getStatusCode(),200);
		}
		@Then("{string} in response body is {string}.")
		public void in_response_body_is(String key, String Value) {
		    //converting response into String 
			String resp=response.asString();
			JsonPath js=new JsonPath(resp);
			
			//compare actual jsonkey value with expected jsonkey value
			assertEquals(js.get(key),Value);
			
		   
			
		}




	}


