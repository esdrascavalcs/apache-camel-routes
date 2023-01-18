package br.com.esdrascavalcs.application;

import br.com.esdrascavalcs.application.routes.CityRoute;
import br.com.esdrascavalcs.application.routes.NameRoute;
import org.apache.camel.main.Main;

public class MainApp {

    public static void main(String... args) throws Exception {
        Main main = new Main();
        main.configure().addRoutesBuilder(new CityRoute());
        main.configure().addRoutesBuilder(new NameRoute());
        main.run(args);
    }

}

