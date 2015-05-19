package test;

import java.io.IOException;

import org.restlet.data.MediaType;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class TestClient {

    public static void main(String[] args) throws IOException {
        ClientResource resource = new ClientResource(
                "http://localhost:8182/attendance/faculty/myFaculty");
        Representation rep = resource.get(MediaType.APPLICATION_JSON);
        System.out.println(rep.getText());
    }
}
