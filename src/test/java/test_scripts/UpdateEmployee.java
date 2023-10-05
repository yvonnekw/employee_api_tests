package test_scripts;


import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CommonSpec;
import utilities.Properties;
import static io.restassured.RestAssured.given;
import static utilities.Requests.createEmployeeReturnId;
import static utilities.Test_data_employee.employee_test_data;


public class UpdateEmployee extends TestBase {

    @Test //TODO provide better assertions for any data being updated
    void update_full_employee_details()  {
        logger.info("********* staring testing to update_full_employee_details  ********** ");

        String employeeId = createEmployeeReturnId();

        Response response =  given()
                .spec(CommonSpec.basicCommonHeader())
                .body(employee_test_data())
                .when()
                .put(Properties.baseUrl + "/employees/"  + employeeId);

        String responseBody = response.getBody().asString();

        logger.info("********* results for update_full_employee_details test ********** " + responseBody);

        Assert.assertTrue(responseBody.contains(employeeId), "Response body contains " + employeeId);
    }

    @Test //TODO provide better assertions for any data being updated
    void update_employeeDetails()  {
        logger.info("********* staring testing to update a new employee  ********** ");

        String employeeId = createEmployeeReturnId();

        Response response = given()
                .spec(CommonSpec.basicCommonHeader())
                .body(employee_test_data())
                .when()
                .put(Properties.baseUrl + Properties.basePath  + employeeId);

        String responseBody = response.getBody().asString();

        logger.info("********* results for get_employee_id test ********** " + responseBody);

        Assert.assertTrue(responseBody.contains(employeeId), "Response body contains " + employeeId);
    }



}
