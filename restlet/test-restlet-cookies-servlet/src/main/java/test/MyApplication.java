package test;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class MyApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router();

        router.attach("/test", MyServerResource.class);

        return router;
    }

}