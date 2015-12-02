package test.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.resource.Directory;
import org.restlet.routing.Router;

public class RestletApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        router.attach("/test/{id}", MyServerResource.class);
        
        return router;
    }

}
