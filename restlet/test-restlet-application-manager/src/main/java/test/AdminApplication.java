package test;

import java.util.List;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.routing.Router;

import test.resource.ApplicationServerResource;

public class AdminApplication extends Application {
    private Component component;
    private List<Application> applications;

    public AdminApplication(Component component, List<Application> applications) {
        this.component = component;
        this.applications = applications;
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router();

        router.attach("/applications/{appname}", ApplicationServerResource.class);

        return router;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public Component getComponent() {
        return component;
    }

}