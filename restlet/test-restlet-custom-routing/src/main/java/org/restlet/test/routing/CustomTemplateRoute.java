package org.restlet.test.routing;

import java.util.Map;

import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.routing.Router;
import org.restlet.routing.Template;
import org.restlet.routing.TemplateRoute;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomTemplateRoute extends TemplateRoute {

    public CustomTemplateRoute(Restlet next) {
        super(next);
    }

    public CustomTemplateRoute(Router router, String uriTemplate,
            Restlet next) {
        super(router, uriTemplate, next);
    }

    public CustomTemplateRoute(Router router, Template template,
            Restlet next) {
        super(router, template, next);
    }

    @Override
    public float score(Request request, Response response) {
        float result = super.score(request, response);

        if (isTokenedServerResource()) {
            boolean containsToken = containsToken(request);
            if (containsToken) {
                return result + 0.1f;
            } else {
                return result - 0.1f;
            }
        }

        return result;
    }

    private boolean isTokenedServerResource() {
        if (getNext() instanceof CustomFinder) {
            CustomFinder finder = (CustomFinder) getNext();
            if (MyServerResourceTokened.class.isAssignableFrom(finder.getTargetClass())) {
                return true;
            }
        }
        return false;
    }

    private boolean containsToken(Request request) {
        try {
            Representation repr = request.getEntity();
            String content = repr.getText();

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> jsonContent = objectMapper.readValue(content, Map.class);

            StringRepresentation sRepr = new StringRepresentation(content, repr.getMediaType());
            request.setEntity(sRepr);

            if (jsonContent.get("token") != null) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
