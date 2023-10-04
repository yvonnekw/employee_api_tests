package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class CommonSpec {

    public static RequestSpecification basicCommonHeader() {
        RequestSpecBuilder builder = basicHeaderBuilder();
        RequestSpecification headerSpec;
        headerSpec = builder.build();
        return headerSpec;
    }
    private static RequestSpecBuilder basicHeaderBuilder() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader("Accept", "application/json");
        builder.setContentType(ContentType.JSON);
        return builder;
    }
}
