package test_scripts;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.CommonSpec;
import utilities.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetEmployee {

    @Test
    void get_all_employees(){
        given()
                .spec(CommonSpec.basicCommonHeader())
                .when()
                .get(Properties.baseUrl + Properties.basePath)
                .then()
                .assertThat()
                        .statusCode(200).log().all()
                .body("[0].id", equalTo(1));

    }
    @Test
    void get_employee_id_2(){
        given()
                .spec(CommonSpec.basicCommonHeader())
                .when()
                .get(Properties.baseUrl + Properties.basePath + "/2")
                .then()
                .assertThat()
                .statusCode(200).log().all()
                .body("id", equalTo(2));
    }

    @Test
    void get_employee_details_with_param_id_3(){
        String employee_id = "3";
        Response response = given()
                .spec(CommonSpec.basicCommonHeader())
                .param("id",employee_id)
                .when()
                .get(Properties.baseUrl + Properties.basePath);

        String responseBody = response.getBody().asString();

        Assert.assertTrue(responseBody.contains(employee_id), "Response body contains " + employee_id);
    }

    @Test
    void get_employee_name(){
        String employee_name = "Roger Metz MD";
       Response response = given()
                .spec(CommonSpec.basicCommonHeader())
                .param("employee_name",employee_name)
                .when()
                .get(Properties.baseUrl + Properties.basePath);

        String responseBody = response.getBody().asString();

        Assert.assertTrue(responseBody.contains(employee_name), "Response body contains " + employee_name);
    }



}
