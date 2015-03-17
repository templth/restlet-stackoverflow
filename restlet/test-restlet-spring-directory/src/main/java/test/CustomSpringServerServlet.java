package test;

import org.restlet.Application;
import org.restlet.Client;
import org.restlet.Component;
import org.restlet.ext.spring.SpringServerServlet;
import org.restlet.util.ClientList;

public class CustomSpringServerServlet extends SpringServerServlet {

    @Override
    protected void init(Application application) {
        // TODO Auto-generated method stub
        super.init(application);
    }

    @Override
    protected void init(Component component) {
        // TODO Auto-generated method stub
        super.init(component);
        
        ClientList list = component.getClients();
        for (Client client : list) {
            System.out.println(">> client = "+client);
        }
    }

}
