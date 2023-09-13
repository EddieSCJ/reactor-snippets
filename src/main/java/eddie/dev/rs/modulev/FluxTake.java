package eddie.dev.rs.modulev;

import eddie.dev.rs.utils.Util;
import reactor.core.publisher.Flux;

public class FluxTake {
    public static void main(String[] args) {
        Flux.range(1, 1000)
                .take(3)
                .subscribe(Util.subscriber(FluxTake.class, "element: "));
    }
}
