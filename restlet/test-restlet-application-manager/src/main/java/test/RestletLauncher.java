package test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;

public class RestletLauncher {

    public static void main(String[] args) {
        Engine.getInstance().setLogLevel(Level.FINEST);
        launchApplication();
        // launchStaticApplication();
    }

    private static void launchApplication() {
        try {
            Component component = new Component();
            component.setName("My component");
            component.setDescription("My component description");
            component.setOwner("Restlet");
            component.setAuthor("The Restlet Team");

            component.getServers().add(Protocol.HTTP, 8182);

            // Application 1
            Application application1 = new MyApplication1();
            application1.setName("app1");
            component.getDefaultHost().attach("/app1", application1);

            // Application 1
            Application application2 = new MyApplication2();
            application2.setName("app2");
            component.getDefaultHost().attach("/app2", application2);

            // Admin application
            List<Application> applications = new ArrayList<>();
            applications.add(application1);
            applications.add(application2);
            Application adminApplication = new AdminApplication(component, applications);
            component.getDefaultHost().attach("/admin", adminApplication);

            component.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
