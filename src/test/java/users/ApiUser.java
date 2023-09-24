package users;


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ApiUser {
    public static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    public static final String API_V_1 = "/api/auth";

    public ValidatableResponse createUser(FullUser fullUser){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(fullUser)
                .when()
                .post(API_V_1 + "/register")
                .then().log().all();
    }
    public String getToken(ValidatableResponse response){
        String token =
                response.extract().path("accessToken");
        return token;
    }
    public ValidatableResponse deleteUser(String token){
        return  given().log().all()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .header("Authorization",token)
                .when()
                .delete(API_V_1 + "/user")
                .then().log().all();
    }

}
