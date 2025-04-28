package karate;

import com.intuit.karate.Logger;
import com.intuit.karate.junit5.Karate;
import com.intuit.karate.core.ScenarioEngine;
import org.junit.jupiter.api.BeforeAll;

public class GenerateQRsuccessfull {

    @Karate.Test
    Karate testGenerar() {
        return Karate.run("P2P/generateQR.feature").relativeTo(getClass());
    }

}
