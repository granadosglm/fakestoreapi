package karate.Maestros;

import com.intuit.karate.junit5.Karate;

public class QueryAlernativeScenariosQR {
    @Karate.Test
    Karate testConsultarAlternativos() {
        return Karate.run("queryAlternativeScenariosQR.feature").relativeTo(getClass());
    }
}
