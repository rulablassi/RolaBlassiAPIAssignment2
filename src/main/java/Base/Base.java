import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Base {



    public String baseURL(String url){


        return RestAssured.baseURI=url;
    }

    public RequestSpecification httpRequest() {
        RequestSpecification httpRequest = RestAssured.given();
        return httpRequest;
    }
}


