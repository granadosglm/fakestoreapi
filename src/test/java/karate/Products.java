package karate;

import com.intuit.karate.junit5.Karate;

public class Products {
    @Karate.Test
    Karate testGenerar() {
        return Karate.run("products.feature").relativeTo(getClass());
    }
}
