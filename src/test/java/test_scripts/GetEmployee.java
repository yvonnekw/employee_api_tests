package test_scripts;


import base.TestBase;

import com.google.gson.Gson;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import objects.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CommonSpec;
import utilities.Properties;

import static io.restassured.RestAssured.given;
import static utilities.Requests.*;

public class GetEmployee extends TestBase {

    @Test
    void get_all_employees(){
        logger.info("********* staring test for the get_all_employee  ********** ");
        String employeeId =  createEmployeeReturnId();
        Response response = given()
                .spec(CommonSpec.basicCommonHeader())
                .when()
                .get(Properties.baseUrl + Properties.basePath);

        String responseBody = response.getBody().asString();

        logger.info("********* results for get_all_employee test ********** " + responseBody);

        Assert.assertTrue(responseBody.contains(employeeId), "Response body contains " + employeeId);
    }
    @Test
    void get_employee_id(){
        logger.info("********* staring test for the get employee by id  ********** ");
        String employeeId =  createEmployeeReturnId();
        Response response = given()
                .spec(CommonSpec.basicCommonHeader())
                .when()
                .get(Properties.baseUrl + Properties.basePath + employeeId);

        String responseBody = response.getBody().asString();

        logger.info("********* results for get_employee_id test ********** " + responseBody);

        Assert.assertTrue(responseBody.contains(employeeId), "Response body contains " + employeeId);
    }

    @Test
    void get_employee_details_with_param_id(){
        logger.info("********* staring test for the get employee details with param id ********** ");
        String employeeId =  createEmployeeReturnId();
        Response response = given()
                .spec(CommonSpec.basicCommonHeader())
                .param("id",employeeId)
                .when()
                .get(Properties.baseUrl + Properties.basePath);

        String responseBody = response.getBody().asString();

        logger.info("********* results for get_employee_id test ********** " + responseBody);

        Assert.assertTrue(responseBody.contains(employeeId), "Response body contains " + employeeId);
    }

    @Test
    void get_employee_param_name(){
        String employee_name = createEmployeeReturnName();
       Response response = given()
                .spec(CommonSpec.basicCommonHeader())
                .param("employee_name",employee_name)
                .when()
                .get(Properties.baseUrl + Properties.basePath);

        String responseBody = response.getBody().asString();

        logger.info("********* results for get_employee_id test ********** " + responseBody);

        Assert.assertTrue(responseBody.contains(employee_name), "Response body contains " + employee_name);
    }

    @Test
    void validate_employees_data(){
        logger.info("********* staring test for the validate_employees_data  ********** ");
        createEmployeeReturnId();
                given()
                .spec(CommonSpec.basicCommonHeader())
                .when()
                .get(Properties.baseUrl + Properties.basePath)
                        .then()
                        .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("json_schema.json"));
    }

    @Test
    void validate_employee_salary(){
        logger.info("********* staring test for the validate_employees_data  ********** ");
        String employeeId = createEmployeeReturnId();
        Response response = given()
                .spec(CommonSpec.basicCommonHeader())
                .when()
                .get(Properties.baseUrl + Properties.basePath + employeeId);
        response.then().statusCode(200);
        Employee employee = response.as(Employee.class);
        Assert.assertTrue(employee.getEmployee_salary() > 0);
        Assert.assertTrue(employee.getEmployee_salary() < 100000);

    }
}
