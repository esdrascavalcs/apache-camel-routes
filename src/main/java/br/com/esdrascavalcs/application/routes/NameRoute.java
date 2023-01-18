package br.com.esdrascavalcs.application.routes;

import org.apache.camel.builder.RouteBuilder;

public class NameRoute extends RouteBuilder {

    private static final String NAME_MESSAGE_ROUTE = "file:src/data/names?noop=true";
    private static final String PB_MESSAGE_ROUTE = "file:target/messages/pb";
    private static final String OTHER_MESSAGE_ROUTE = "file:target/messages/others";

    public void configure() {
        this.moveNameMessage();
    }

    private void moveNameMessage(){
        from(NAME_MESSAGE_ROUTE)
                .choice()
                .when(xpath("/person/firstName = 'Maria'"))
                .log("PB message")
                .to(PB_MESSAGE_ROUTE)
                .otherwise()
                .log("Other message")
                .to(OTHER_MESSAGE_ROUTE);
    }
}
