package org.restlet.test.routing;

import org.restlet.Component;
import org.restlet.data.Protocol;

public class RestletLauncher {

    public static void main(String[] args) {
        try {
            Component component = new Component();

            component.getServers().add(Protocol.HTTP, 8182);

            component.getDefaultHost().attach("/app", new RestletApplication());

            component.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
