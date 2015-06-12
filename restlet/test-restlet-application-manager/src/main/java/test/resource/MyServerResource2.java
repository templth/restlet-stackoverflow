package test.resource;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class MyServerResource2 extends ServerResource {
    @Get
    public Representation testGetJson() {
        return new StringRepresentation("test2");
    }
}
