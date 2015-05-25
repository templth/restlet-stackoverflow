package test;

import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class MyServerResource extends ServerResource {

    @Get("json")
    public Representation testGetJson() {
        return new StringRepresentation("test json : - ok");

    }

    @Get("xml")
    public Representation testGetXml() {
        return new StringRepresentation("test xml : - ok");

    }

    @Get
    public Representation testGetDefault() {
        return new StringRepresentation("test default : - ok");

    }
}
