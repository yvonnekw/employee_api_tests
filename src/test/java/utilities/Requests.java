package utilities;

import base.TestBase;
import io.restassured.path.json.JsonPath;


import static io.restassured.RestAssured.given;
import static utilities.Test_data_employee.employee_test_data;

public class Requests extends TestBase {

    public static String createEmployeeReturnId(){
        String  employee = (given()
                .spec(CommonSpec.basicCommonHeader())
                .body(employee_test_data())
                .when()
                .post(Properties.baseUrl + Properties.basePath)
                .thenReturn().asString());

        JsonPath jsonPath= new JsonPath(employee);
        return jsonPath.getString("id");
    }

    public static String createEmployeeReturnName(){
        String  employee = (given()
                .spec(CommonSpec.basicCommonHeader())
                .body(employee_test_data())
                .when()
                .post(Properties.baseUrl + Properties.basePath)
                .thenReturn().asString());

        JsonPath jsonPath= new JsonPath(employee);
        return jsonPath.getString("employee_name");
    }
}
