package API.users.suite;

import API.users.data_provider.UsersDataProvider;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class UsersSuite {

    private String userId;
    private UsersSteps usersSteps = new UsersSteps();

    /**
     2 a) Cover CRUD operations for one REST endpoint defined in reqres.in;
     **/

    @Test(dataProvider = "usersDataProvider", dataProviderClass = UsersDataProvider.class)
    public void createUserTest(HashMap user) {

        String name = (String) user.get("name");
        String job = (String) user.get("job");

        usersSteps.createUser(user)
                  .then()
                  .statusCode(201)
                  .body("name", equalTo(name))
                  .body("job", equalTo(job));
    }

    @Test(dataProvider = "usersDataProvider", dataProviderClass = UsersDataProvider.class)
    public void updateUserTest(HashMap user) {

       String newName = (String) user.get("name");
       String newJob = (String) user.get("job");

       userId = usersSteps.getUserId();

       usersSteps.updateUser(user, userId)
                 .then()
                 .statusCode(200)
                 .body("name", equalTo(newName))
                 .body("job", equalTo(newJob));
    }

    @Test
    public void deleteUser() {

        userId = usersSteps.getUserId();

        usersSteps.deleteUser(userId)
                  .then()
                  .statusCode(204);
    }

    /**
     * //Test fails due to bug in GetUsers API
     */
    @Test
    public void getUser() {

        userId = usersSteps.getUserId();

        usersSteps.getUser(userId)
                .then()
                .statusCode(200);
    }

/**
 2 b) Cover scenarios which contains usage of several endpoints;


    /**Test fails due to bug with user registration.
     *
     * @param user
     */
    @Test(dataProvider = "usersDataProvider", dataProviderClass = UsersDataProvider.class)
    public void registerUserFlow(HashMap user) {

        HashMap<String,Object> userCredentials = new HashMap<>();
        userCredentials.put("email", RandomStringUtils.randomAlphanumeric(5) + "@gmail.com");
        userCredentials.put("password",  RandomStringUtils.randomAlphanumeric(10));

        userId = usersSteps.createUser(user)
                .then()
                .statusCode(201)
                .extract()
                .path("id");

        usersSteps.registerUser(userCredentials)
                  .then()
                  .statusCode(200);

        usersSteps.loginUser(userCredentials)
                .then()
                .statusCode(200);

        usersSteps.deleteUser(userId)
                .then()
                .statusCode(204);

        usersSteps.loginUser(userCredentials)
                .then()
                .statusCode(404);
    }
}
