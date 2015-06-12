package test.resource;

import org.restlet.Application;
import org.restlet.resource.Put;

import test.representation.ApplicationStateRepresentation;

public class ApplicationServerResource extends AbstractApplicationServerResource {
    @Put
    public void updateState(ApplicationStateRepresentation repr) {
        String appName = getAttribute("appname");
        Application application = getApplicationByName(appName);
        if (application != null) {
            boolean updateHosts = false;
            if (mustAttach(repr)) {
                getComponent().getDefaultHost().attach("/" + application.getName(), application);
                updateHosts = true;
            } else if (mustDetach(repr)) {
                getComponent().getDefaultHost().detach(application);
                updateHosts = true;
            }

            if (updateHosts) {
                doUpdateHosts();
            }
        }
    }

    private boolean mustAttach(ApplicationStateRepresentation repr) {
        return "added".equals(repr.getState());
    }

    private boolean mustDetach(ApplicationStateRepresentation repr) {
        return "removed".equals(repr.getState());
    }

    private void doUpdateHosts() {
        try {
            getComponent().updateHosts();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
