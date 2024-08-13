package ProjectModule;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import BaseClassUtility.BaseclassUtility;
import PojoClassUtility.ProjectPojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import javax.swing.text.AbstractDocument.Content;

/**
 * Create Project
 */
public class AddSingleProjectWithCreated extends BaseclassUtility {
 
	@Test
	public void createSingleProject()
	{
		int randomnumber = jLib.getRandomNumber();
		String projectname="BonitoHomes"+randomnumber;
		String createdbyuser="Mani"+randomnumber;
		ProjectPojo pp=new ProjectPojo(createdbyuser,"Created",0,projectname);
		Response res=given().spec(specReqObj).body(pp).when().post(EndPointInterface.IEndPoint.ADDProj);
		res.then().assertThat().statusCode(201).and().time(Matchers.lessThan(500L)).and().contentType(ContentType.JSON).log().all();
		
		String projectName=res.jsonPath().get("projectName");
		System.out.println(projectName);
		String msg=res.jsonPath().get("msg");
		System.out.println(msg);
		String status=res.jsonPath().get("status");
		System.out.println(status);
	}
}
