package gipsy.springframework.petclinic.bootstrap;

import gipsy.springframework.petclinic.model.Owner;
import gipsy.springframework.petclinic.model.Vet;
import gipsy.springframework.petclinic.services.OwnerService;
import gipsy.springframework.petclinic.services.VetService;
import gipsy.springframework.petclinic.services.map.OwnerServiceMap;
import gipsy.springframework.petclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();

    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Chris");
        owner1.setLastName("Slav");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Flupke");
        owner2.setLastName("Janetteke");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("monki");
        vet1.setLastName("typon");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Yoehoe:)");
        vet2.setLastName("Boehoe:(");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}