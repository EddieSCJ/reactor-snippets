package eddie.dev.rs.modulev;

import com.github.javafaker.Faker;
import eddie.dev.rs.utils.Util;
import reactor.core.publisher.Flux;

public class FluxGenerateWithState {
    public static void main(String[] args) {
        Flux.generate(() -> 1, (state, sink) -> {
            String country = Faker.instance().country().name();
            sink.next(country);
            if(country.equalsIgnoreCase("canada"))
                sink.complete();
            return state + 1;
        })
                .take(3)
                .subscribe(Util.subscriber(FluxGenerateWithState.class, "element: "));
    }
}
