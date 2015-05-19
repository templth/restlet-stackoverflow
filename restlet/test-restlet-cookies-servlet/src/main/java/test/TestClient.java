package test;

import java.io.IOException;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.List;

import org.restlet.data.CookieSetting;
import org.restlet.representation.Representation;
import org.restlet.resource.ClientResource;

public class TestClient {

    public static void main(String[] args) throws IOException {
        CookieHandler.setDefault(new CookieManager(null, CookiePolicy.ACCEPT_ALL));
        ClientResource resource = getClientResource();
        Representation rep = resource.post(null);
        System.out.println(rep.getText());

        List<CookieSetting> settings = resource.getResponse().getCookieSettings();
        for (CookieSetting cookieSetting : settings) {
            System.out.println(">> cookieSetting = " + cookieSetting);
        }
    }

    private static ClientResource getClientResource() {
        String resouceURL = "http://localhost:8080/test-restlet-cookies-servlet/test";
        CookieSetting cookie1 = new CookieSetting("USER",
                "qdny6HjWY0HONvWoyufBWemrDE+5IcdsssssK0E8UGmu5RKPF7h0BWKvBPSn+Kucb82Aq");
        cookie1.setDomain(".abc.com");
        cookie1.setPath("/");
        cookie1.setMaxAge(-1);
        ClientResource resource = new ClientResource(resouceURL);
        resource.getRequest().getCookies().add(cookie1);
        return resource;
    }
}
