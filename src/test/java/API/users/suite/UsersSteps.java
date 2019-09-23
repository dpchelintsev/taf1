package API.users.suite;

import com.jayway.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;

import static com.jayway.restassured.RestAssured.given;

public class UsersSteps {

    private String baseUrl = "https://reqres.in";
    private String usersApi = "/api/users/";
    private String registrationApi = "/api/register/";
    private String loginApi = "/api/login/";

    public Response createUser(HashMap user) {
       return given()
                .contentType("application/json")
                .body(user)
                .when()
                .post(baseUrl + usersApi);
    }

    public String getUserId(){
        JSONObject requestParams = new JSONObject();
        requestParams.put("name", "NPHu2");
        requestParams.put("job", "Ywxyz");

        return given()
                .contentType("application/json")
                .body(requestParams.toString())
                .when()
                .post(baseUrl + usersApi)
                .then()
                .extract()
                .path("id");
    }

    public Response updateUser(HashMap user, String userId) {
        return given()
                .contentType("application/json")
                .body(user)
                .when()
                .put(baseUrl + usersApi + userId);
    }

    public Response deleteUser(String userId) {
        return given()
                .contentType("application/json")
                .when()
                .delete(baseUrl + usersApi + userId);
    }

    public Response getUser(String userId) {
        return given()
                .contentType("application/json")
                .when()
                .get(baseUrl + usersApi + userId);
    }

    public Response registerUser(HashMap userCredentials) {
        return given()
                .contentType("application/json")
                .body(userCredentials)
                .when()
                .post(baseUrl + registrationApi);
    }

    public Response loginUser(HashMap userCredentials) {
        return given()
                .contentType("application/json")
                .body(userCredentials)
                .when()
                .post(baseUrl + loginApi);
    }
}

