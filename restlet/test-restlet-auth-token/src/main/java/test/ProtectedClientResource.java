package test;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.resource.ClientResource;

public class ProtectedClientResource extends ClientResource {
    private String token;

    public ProtectedClientResource(String uri) {
        super(uri);
    }

    @Override
    public Response handleOutbound(Request request) {
        if (token != null) {
            request.getHeaders().add("Authorization", token);
        }
        return super.handleOutbound(request);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}