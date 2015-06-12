package test.resource;

import java.util.List;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.resource.ServerResource;

import test.AdminApplication;

public class AbstractApplicationServerResource extends ServerResource {

    protected Application getApplicationByName(String name) {
        if (getApplication() instanceof AdminApplication) {
            List<Application> applications = ((AdminApplication) getApplication()).getApplications();
            for (Application application : applications) {
                if (application.getName() != null && application.getName().equals(name)) {
                    return application;
                }
            }
        }

        return null;
    }

    protected Component getComponent() {
        if (getApplication() instanceof AdminApplication) {
            return ((AdminApplication) getApplication()).getComponent();
        }
        return null;
    }
}
