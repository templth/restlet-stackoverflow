package org.restlet.test.routing;

import org.restlet.Context;
import org.restlet.resource.Finder;
import org.restlet.resource.ServerResource;

public class CustomFinder extends Finder {

    private Class<? extends ServerResource> targetClass;

    public CustomFinder() {
        super();
    }

    public CustomFinder(Context context) {
        super(context);
    }

    public CustomFinder(Context context, Class<? extends ServerResource> targetClass) {
        super(context, targetClass);
        this.targetClass = targetClass;
    }

}
