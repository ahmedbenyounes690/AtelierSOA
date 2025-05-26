package restAPI;

import io.swagger.jaxrs.config.BeanConfig;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class SwaggerConfig extends Application {
    public SwaggerConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/LogementRendezVous-Etudiant/api");
        beanConfig.setResourcePackage("restAPI");
        beanConfig.setScan(true);
        beanConfig.setTitle("Logement et RendezVous API");
        beanConfig.setDescription("API pour la gestion des logements et rendez-vous");
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(LogementResource.class);
        resources.add(RendezVousResource.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }
}