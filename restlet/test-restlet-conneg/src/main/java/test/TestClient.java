package test;

import java.io.IOException;

import org.restlet.data.Form;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class TestClient {

    public static void main(String[] args) throws IOException {
        String resouceURL = "http://localhost:8182/test";
        ClientResource resource = new ClientResource(resouceURL);

        // Representation rep = resource.post(null, new MediaType("application/user+yml"));
        Form form = new Form();
        form.add("user", "user value");
        form.add("password", "password value");

        Representation rep = resource.post(form);
        // System.out.println(rep.getText());

    }

}
