package org.restlet.test.routing;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.engine.component.InternalRouter;
import org.restlet.routing.TemplateRoute;

public class CustomRouter extends InternalRouter {

    public CustomRouter(Context context) {
        super(context);
        setFinderClass(CustomFinder.class);
    }

    protected TemplateRoute createRoute(String uriPattern, Restlet target,
            int matchingMode) {
        CustomTemplateRoute result = new CustomTemplateRoute(this,
                uriPattern, target) {
            @Override
            protected int beforeHandle(Request request, Response response) {
                final int result = super.beforeHandle(request, response);

                // Set the request's root reference in order to help the
                // retrieval of the relative reference.
                request.setRootRef(request.getResourceRef().getBaseRef());

                return result;
            }
        };

        result.getTemplate().setMatchingMode(matchingMode);
        result.setMatchingQuery(getDefaultMatchingQuery());
        return result;
    }
}
