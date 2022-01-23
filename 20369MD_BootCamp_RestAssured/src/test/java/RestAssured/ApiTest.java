package RestAssured;

import static io.restassured.RestAssured.*;  //most important that we have to manually call this library

import java.io.File;

import org.junit.Assert;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ApiTest {

	public static void main(String[] args) {
	
		Response responsive = get("https://reqres.in/api/users?page=2");
		responsive.prettyPrint();
		 int statusc=responsive.statusCode();
		 System.out.println(statusc);
		 Assert.assertEquals(statusc, 200);
		 
		 ResponseBody<?> verifying=responsive.getBody();
		String converts= verifying.asString();
		Assert.assertEquals(converts.contains("Funke"), true);
		File it=new File("C:\\Users\\jerry\\eclipse-workspace\\20369MD_BootCamp_RestAssured\\src\\test\\java\\RestAssured\\Automation.jason");
		Response gt= given().contentType(ContentType.JSON).body(it).post("https://reqres.in/api/users?page=2");
		gt.prettyPrint();
		
	}

}
