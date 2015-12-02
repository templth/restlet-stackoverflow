package test.server;

import org.restlet.data.Reference;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class MyServerResource extends ServerResource {

	@Get
	public Representation get() {
		String id = getAttribute("id");
		System.out.println("id = "+id);
		System.out.println("id = "+Reference.decode(id));
		return new EmptyRepresentation();
	}

}