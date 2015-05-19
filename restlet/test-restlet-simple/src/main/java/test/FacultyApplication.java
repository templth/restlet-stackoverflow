package test;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class FacultyApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router();

        router.attach("/attendance/faculty/{facultyName}", FacultyServerResource.class);

        return router;
    }

}