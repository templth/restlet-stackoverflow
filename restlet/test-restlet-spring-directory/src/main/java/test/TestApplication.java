package test;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class TestApplication extends Application {
    private Router root;

    // @Override
    // public Restlet createInboundRoot() {
    // Router router = new Router(getContext());
    //
    // router.attach("/ping", TestServerResource.class);
    //
    // Directory directory = new Directory(getContext(), "war:///");
    // directory.setListingAllowed(true);
    // router.attach("/dir", directory);
    //
    // return router;
    // }
    //
    
    public TestApplication() {
    }

    @Override
    public Restlet createInboundRoot() {
        return root;
    }

    public Router getRoot() {
        return root;
    }

    public void setRoot(Router root) {
        this.root = root;
    }
}
