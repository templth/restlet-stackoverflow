package test;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import test.resource.MyServerResource2;

public class MyApplication2 extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router();

        router.attach("/test2", MyServerResource2.class);

        return router;
    }

}