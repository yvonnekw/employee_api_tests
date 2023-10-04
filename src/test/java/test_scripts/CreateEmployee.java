package test_scripts;

import org.testng.annotations.Test;
import utilities.CommonSpec;
import utilities.Properties;
import static io.restassured.RestAssured.given;
import static utilities.Test_data_employee.test_data;

public class CreateEmployee {

    @Test
    void create_employee(){
        given()
                .spec(CommonSpec.basicCommonHeader())
                .body(test_data())
                .when()
                .post(Properties.baseUrl + Properties.basePath)
                .then().statusCode(201).log().all();
    }

}
