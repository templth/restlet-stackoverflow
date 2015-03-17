package test;

import org.restlet.Application;
import org.restlet.Context;
import org.springframework.beans.factory.FactoryBean;

public class ApplicationContextFactoryBean implements FactoryBean<Context> {
    private Application application;

    @Override
    public Context getObject() throws Exception {
        // TODO Auto-generated method stub
        return application.getContext();
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return Context.class;
    }

    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return false;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
    
}
