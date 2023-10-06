package test_scripts;

import base.TestBase;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CommonSpec;
import utilities.Properties;
import static io.restassured.RestAssured.given;
import static utilities.Requests.createEmployeeReturnId;

public class DeleteEmployee extends TestBase {

    @Test
    void create_employee_delete(){
        logger.info("********* staring test to create a new employee  ********** ");
        String employeeId =  createEmployeeReturnId();

        Response response =  given()
                .spec(CommonSpec.basicCommonHeader())
                .when()
                .delete(Properties.baseUrl + Properties.basePath  + employeeId);

        String responseBody = response.getBody().asString();

        logger.info("********* results for get_employee_id test ********** " + responseBody);

        Assert.assertFalse(responseBody.contains(employeeId), "Response body contains " + employeeId);
    }
}
