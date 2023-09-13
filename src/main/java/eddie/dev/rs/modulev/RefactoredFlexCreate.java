package eddie.dev.rs.modulev;

import com.github.javafaker.Faker;
import eddie.dev.rs.utils.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Optional;
import java.util.function.Function;

public class RefactoredFlexCreate {
    public static void main(String[] args) throws Exception {
        SinkProducer<FluxSink<String>> sinkProducer = new SinkProducer(RefactoredFlexCreate::sinkGenerator);

        Flux.create(sinkProducer)
                .take(5)
                .subscribe(Util.subscriber(RefactoredFlexCreate.class, "Processing country: "));

    }

    public static Void sinkGenerator(Object fluxSink) {
        String countryName;
        do {
            countryName = Faker.instance().country().name();
            ((FluxSink) fluxSink).next(countryName);
        } while (!countryName.equalsIgnoreCase("Brazil") && !((FluxSink) fluxSink).isCancelled());

        return null;
    }

}
