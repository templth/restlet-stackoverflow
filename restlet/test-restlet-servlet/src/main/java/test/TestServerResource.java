package test;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class TestServerResource extends ServerResource {

    @Get
    public String ping() {
        return "pong";
    }
    
}
