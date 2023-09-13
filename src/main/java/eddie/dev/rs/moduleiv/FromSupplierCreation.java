package eddie.dev.rs.moduleiv;

import com.github.javafaker.Faker;
import reactor.core.publisher.Mono;

public class FromSupplierCreation {
    public static void main(String[] args) {

        // it will invoke the method generateName() only when the subscription happens
        Mono<String> mono = Mono.fromSupplier(() -> generateName());

        // first type of subscription (simpler one)
        mono.subscribe(); // shall sysout the 'Generating name...' message
    }
    public static String generateName() {
        System.out.println("Generating name...");
        return Faker.instance().name().fullName();
    }
}
