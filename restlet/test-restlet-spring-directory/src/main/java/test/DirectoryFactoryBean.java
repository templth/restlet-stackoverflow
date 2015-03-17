package test;

import org.restlet.Component;
import org.restlet.Context;
import org.restlet.resource.Directory;
import org.springframework.beans.factory.FactoryBean;

public class DirectoryFactoryBean implements FactoryBean<Directory> {
    private Component component;

    @Override
    public Directory getObject() throws Exception {
        Directory directory = new Directory(component.getContext(), "war:///") {
            @Override
            public Context getContext() {
                // TODO Auto-generated method stub
                System.out.println(">> getContext() = "+super.getContext());
                System.out.println(">> getContext().getClientDispatcher() = "+super.getContext().getClientDispatcher());
                
                return super.getContext();
            }
            
        };
        directory.setListingAllowed(true);
        return directory;
    }

    @Override
    public Class<?> getObjectType() {
        // TODO Auto-generated method stub
        return Directory.class;
    }

    @Override
    public boolean isSingleton() {
        // TODO Auto-generated method stub
        return true;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

}
