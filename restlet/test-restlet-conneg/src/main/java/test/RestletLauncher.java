package test;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;

public class RestletLauncher {

    public static void main(String[] args) {
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

            Application application = new MyApplication();

            component.getDefaultHost().attachDefault(application);

            component.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
