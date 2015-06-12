package test;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import test.resource.MyServerResource1;

public class MyApplication1 extends Application {
    @Override
    public Restlet createInboundRoot() {
        Router router = new Router();

        router.attach("/test1", MyServerResource1.class);

        return router;
    }
}