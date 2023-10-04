package test_scripts;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static utilities.Test_data_employee.test_data;

public class Employee_post {


  @BeforeClass
  void setup(){
      RestAssured.baseURI = "http://localhost:3004/";
      RestAssured.basePath ="/employees";
  }


    @Test
    void post_employee_data(){
        given()
                .contentType("application/json")
                .body(test_data())
                .when()
                .post()
                .then().statusCode(201);
    }



}
