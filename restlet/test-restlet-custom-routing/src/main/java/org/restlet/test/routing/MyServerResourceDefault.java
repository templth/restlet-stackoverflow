package org.restlet.test.routing;

import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class MyServerResourceDefault extends ServerResource {

    @Post
    public void test(Representation repr) {
        System.out.println(">>  MyServerResourceDefault");
    }
}
