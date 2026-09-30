package karate;

import com.intuit.karate.junit5.Karate;

public class Users {
    @Karate.Test
    Karate testReq() {
        return Karate.run("users").relativeTo(getClass());
    }
}
