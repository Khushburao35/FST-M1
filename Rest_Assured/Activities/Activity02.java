package Activity;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Activity02 {

	final static String ROOT_URI = "https://petstore.swagger.io/v2/user";




	@Test (priority=1)
	public void PostPet() throws FileNotFoundException {
		System.out.println("Post run");

		File myObj = new File("C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\RestAssured\\UserRequest.json");
		@SuppressWarnings("resource")
		Scanner myReader = new Scanner(myObj);
		String reqBody = "";
		while (myReader.hasNextLine()) {
			reqBody += myReader.nextLine();
		}
		System.out.println(reqBody);

		Response response = 
				given().contentType(ContentType.JSON) // Set headers
				.body(reqBody) // Add request body
				.when().post(ROOT_URI); // Send POST request
		System.out.println(response.asPrettyString());
		// Assertion
		response.then().body("message", equalTo("9901"));
		
	}


	@Test (priority=2)
	public void getPet() {
		System.out.println("Get run");
		File outputJSON = new File("C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\RestAssured\\UserResponse.json");

		String a = ROOT_URI + "/{username}";
		Response response = 
				given().contentType(ContentType.JSON) // Set headers
				.pathParam("username", "Abhi") // Pass request body from file
				.when().get(a); // Send POST request
		
		//System.out.println(a);

		// Get response body
		String resBody = response.getBody().asPrettyString();

		try {
			// Create JSON file
			outputJSON.createNewFile();
			// Write response body to external file
			FileWriter writer = new FileWriter(outputJSON.getPath());
			writer.write(resBody);
			writer.close();
		} catch (IOException excp) {
			excp.printStackTrace();
		}

		// Assertion
		response.then().body("id", equalTo(9901));
		response.then().body("username", equalTo("Abhi"));
		response.then().body("firstName", equalTo("Justin"));
		response.then().body("lastName", equalTo("Case"));
		response.then().body("email", equalTo("justincase@mail.com"));
		response.then().body("password", equalTo("password123"));
		response.then().body("phone", equalTo("9812763450"));
	}

	@Test (priority=3) 
	public void deletePet() {
		System.out.println("Delete run");
		Response response = 
	            given().contentType(ContentType.JSON) // Set headers
	            .pathParam("username", "Abhi") // Add path parameter
	            .when().delete(ROOT_URI + "/{username}"); // Send POST request
	 
	        // Assertion
	        response.then().body("code", equalTo(200));
	        response.then().body("message", equalTo("Abhi"));
	}
}