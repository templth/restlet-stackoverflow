package test;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class TestApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        System.out.println(">> createInboundRoot");
        Router router = new Router(getContext());

        router.attach("/ping", TestServerResource.class);

        return router;
    }

}
