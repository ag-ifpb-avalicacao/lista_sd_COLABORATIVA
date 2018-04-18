package br.com.ifpb.sd.user.rs;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author rodrigobento
 */
@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }
    
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(br.com.ifpb.sd.user.rs.UserResource.class);
    }
    
}
