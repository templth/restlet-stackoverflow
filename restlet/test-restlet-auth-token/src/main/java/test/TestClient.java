package test;

import java.io.IOException;

import org.restlet.data.ChallengeResponse;
import org.restlet.data.ChallengeScheme;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class TestClient {

    public static void main(String[] args) throws IOException {
        testWithCustomHeader();
        // testWithBearer();
    }

    private static void testWithCustomHeader() {
        String resourceURL = "http://localhost:8183/test";
        ProtectedClientResource resource = new ProtectedClientResource(resourceURL);
        String token = "myToken";
        resource.setToken(token);
        //
        resource.get();
    }

    private void testWithBearer() {
        String resouceURL = "http://localhost:8183/test";
        ClientResource resource = new ClientResource(resouceURL);

        resource.setChallengeResponse(ChallengeScheme.HTTP_OAUTH_BEARER, "mytoken", "tst");
        String token = "myToken";
        ChallengeResponse cr = new ChallengeResponse(
                ChallengeScheme.HTTP_OAUTH_BEARER);
        cr.setRawValue(token);
        resource.setChallengeResponse(cr);
        Representation rep = resource.get();
    }

}
