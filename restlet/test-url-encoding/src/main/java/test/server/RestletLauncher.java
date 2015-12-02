package test.server;

import java.util.Arrays;
import java.util.HashSet;
import java.util.logging.Level;

import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.service.CorsService;


public class RestletLauncher {

    public static void main(String[] args) {
        launchApplication();
    }

    private static void launchApplication() {
        try {
        	Engine.setLogLevel(Level.FINEST);
        	
            Component component = new Component();
            component.setName("My component");
            component.setDescription("My component description");
            component.setOwner("Restlet");
            component.setAuthor("The Restlet Team");

            component.getServers().add(Protocol.HTTP, 8182);
            component.getClients().add(Protocol.FILE);

            CorsService corsService = new CorsService();         
            corsService.setAllowedOrigins(new HashSet(Arrays.asList("*")));
            corsService.setAllowedCredentials(true);
            
            RestletApplication application = new RestletApplication();
            application.getServices().add(corsService);
            component.getDefaultHost().attachDefault(application);

            component.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
