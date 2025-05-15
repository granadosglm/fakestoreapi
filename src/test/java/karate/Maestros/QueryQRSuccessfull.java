package karate.Maestros;

import com.intuit.karate.junit5.Karate;

public class QueryQRSuccessfull {
    @Karate.Test
    Karate testGenerar() {
        return Karate.run("queryQR.feature").relativeTo(getClass());
    }
}
