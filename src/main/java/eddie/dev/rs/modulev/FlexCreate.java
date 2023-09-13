package eddie.dev.rs.modulev;

import com.github.javafaker.Faker;
import eddie.dev.rs.utils.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FlexCreate {

    public static void main(String[] args) {
        Flux flux = Flux.create(fluxSink -> {
                    String countryName;
                    do {
                        countryName = Faker.instance().country().name();
                        if(countryName.equalsIgnoreCase("Canada"))
                            fluxSink.error(new RuntimeException("Error, it can't be Canada"));

                        fluxSink.next(countryName);

                    } while (!countryName.equalsIgnoreCase("Brazil"));
                    fluxSink.complete();
                });

        flux.subscribe(Util.subscriber(FlexCreate.class, "Processing country: "));

    }
}
