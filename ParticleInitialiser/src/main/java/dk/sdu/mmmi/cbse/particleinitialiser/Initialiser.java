package dk.sdu.mmmi.cbse.particleinitialiser;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.ComponentContext;

public class Initialiser {

    private ServiceReference reference;
    private IEntityProcessingService service;

    protected void activate(ComponentContext context) {

        if (reference != null) {
            service = (IEntityProcessingService) context.locateService("IEntityServiceReference", reference);
        }
    }

    public void gotService(ServiceReference reference) {
        this.reference = reference;
        System.out.println("Got reference: " + reference);
    }
    
    public void lostService(ServiceReference reference){
    this.reference = null;
        System.out.println("Lost reference: " + reference);
    }

}
