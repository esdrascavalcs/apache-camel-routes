package br.com.esdrascavalcs.application.routes;

import org.apache.camel.builder.RouteBuilder;

public class CityRoute extends RouteBuilder {

    private static final String CITY_MESSAGE_ROUTE = "file:src/main/resources/data/cities?noop=true";
    private static final String UK_MESSAGE_ROUTE = "file:target/messages/uk";
    private static final String OTHER_MESSAGE_ROUTE = "file:target/messages/others";
    public void configure() {
        this.moveCityMessage();
    }

    private void moveCityMessage(){
        from(CITY_MESSAGE_ROUTE)
                .choice()
                .when(xpath("/person/city = 'London'"))
                .log("UK message")
                .to(UK_MESSAGE_ROUTE)
                .otherwise()
                .log("Other message")
                .to(OTHER_MESSAGE_ROUTE);
    }
}
