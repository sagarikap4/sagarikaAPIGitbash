package BaseClassUtility;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import GenericUtility.DataBaseUtility;
import GenericUtility.FileUtility;
import GenericUtility.JavaUtility;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseclassUtility {
	public JavaUtility jLib = new JavaUtility();
	public FileUtility fLib = new FileUtility();
	public DataBaseUtility dbLib = new DataBaseUtility();
	public  static RequestSpecification specReqObj;
	public  static ResponseSpecification specRespObj;
	@BeforeSuite
	public void beforeSuitExecution() throws IOException
	{
		RequestSpecBuilder req=new RequestSpecBuilder();
		req.setContentType(ContentType.JSON);
		req.setBaseUri(fLib.getDataFromPropertiesFile("BASEUri"));
		specReqObj=req.build();
		
		ResponseSpecBuilder res=new ResponseSpecBuilder();
		res.expectContentType(ContentType.JSON);
		specRespObj=res.build();
		
	}
	@AfterSuite
	public void afterSuitExecution()
	{
		
	}
	

}
