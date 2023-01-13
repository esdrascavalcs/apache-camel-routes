package org.apache.camel.routes;

import org.apache.camel.builder.RouteBuilder;

public class CityRoute extends RouteBuilder {

    public void configure() {
        from("file:src/data/cities?noop=true")
            .choice()
                .when(xpath("/person/city = 'London'"))
                    .log("UK message")
                    .to("file:target/messages/uk")
                .otherwise()
                    .log("Other message")
                    .to("file:target/messages/others");
    }

}
