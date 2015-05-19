package test;

import java.util.List;

import org.restlet.data.Cookie;
import org.restlet.data.CookieSetting;
import org.restlet.representation.EmptyRepresentation;
import org.restlet.representation.Representation;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

public class MyServerResource extends ServerResource {

    @Post
    public Representation test(Representation repr) {
        List<Cookie> cookies = getRequest().getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(">> cookie = " + cookie);
            getResponse().getCookieSettings().add(new CookieSetting(cookie.getName(), cookie.getValue()));
        }

        return new EmptyRepresentation();
    }
}
