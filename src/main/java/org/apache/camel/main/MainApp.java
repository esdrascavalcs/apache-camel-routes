package org.apache.camel.main;

import org.apache.camel.routes.CityRoute;
import org.apache.camel.routes.NameRoute;

public class MainApp {

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new CityRoute());
        main.configure().addRoutesBuilder(new NameRoute());
        main.run(args);
    }

}

