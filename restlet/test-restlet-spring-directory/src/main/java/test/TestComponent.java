package test;

import org.restlet.Application;
import org.restlet.Component;
import org.springframework.beans.factory.InitializingBean;

public class TestComponent extends Component implements InitializingBean {
    private Application application;

    public TestComponent() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        getDefaultHost().attach("/", new TestApplication());
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
