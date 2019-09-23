package API.users.data_provider;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

import java.util.HashMap;

public class UsersDataProvider {
    @DataProvider(name = "usersDataProvider")
    public static Object[][] usersDataProvider() {

        HashMap<String,Object> user = new HashMap<>();
        user.put("name", RandomStringUtils.randomAlphanumeric(5));
        user.put("job",  RandomStringUtils.randomAlphanumeric(5));
        return new Object[][]{{user}};
    }
}
