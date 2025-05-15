package karate.Maestros;

import com.intuit.karate.junit5.Karate;

public class generateAndQueryQR {
    @Karate.Test
    Karate testConsultarAlternativos() {
        return Karate.run("generateAndQueryQR.feature").relativeTo(getClass());
    }
}
