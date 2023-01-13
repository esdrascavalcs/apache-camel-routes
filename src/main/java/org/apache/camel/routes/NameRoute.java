package org.apache.camel.routes;

import org.apache.camel.builder.RouteBuilder;

public class NameRoute extends RouteBuilder {

    public void configure() {
        from("file:src/data/names?noop=true")
            .choice()
                .when(xpath("/person/firstName = 'Maria'"))
                    .log("PB message")
                    .to("file:target/messages/pb")
                .otherwise()
                    .log("Others messages")
                    .to("file:target/messages/others");
    }
}
