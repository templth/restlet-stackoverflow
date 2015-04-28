package org.restlet.test.routing;

import org.restlet.Application;
import org.restlet.Component;
import org.restlet.Restlet;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class RestletApplication extends Application {

    @Override
    public Restlet createInboundRoot() {
        Router router = new CustomRouter(getContext());

        router.attach("/ping", MyServerResourceDefault.class);
        router.attach("/ping", MyServerResourceTokened.class);

        return router;
    }

    public static void main(String[] args) {
        Component component = new Component();
        component.setName("My component");
        component.setDescription("My component description");
        component.setOwner("Restlet");
        component.setAuthor("The Restlet Team");

        component.getServers().add(Protocol.HTTP, 8182);
        
        component.getDefaultHost().attachDefault(new RestletApplication());
        
        
        try {
            component.start();
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
