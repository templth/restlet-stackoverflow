package test;

import org.restlet.Application;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;
import org.restlet.routing.Filter;
import org.restlet.routing.Router;

public class MyApplication extends Application {

    public MyApplication() {
        getTunnelService().setExtensionsTunnel(true);
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router();

        router.attach("/test", MyServerResource.class);

        Filter preferencesFilter = new Filter(getContext()) {
            protected int beforeHandle(Request request, Response response) {
                if (request.getClientInfo().getAcceptedMediaTypes().isEmpty()) {
                    request.getClientInfo().accept(MediaType.APPLICATION_JSON);
                } else if ((request.getClientInfo().getAcceptedMediaTypes().size() == 1)
                    && (request.getClientInfo().getAcceptedMediaTypes().get(0).getMetadata().equals(MediaType.ALL))) {
                    request.getClientInfo().accept(MediaType.APPLICATION_JSON);
                }
                return super.beforeHandle(request, response);
            }            
        };
        preferencesFilter.setNext(router);
        
        return preferencesFilter;
    }

}