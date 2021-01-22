package gipsy.springframework.petclinic.bootstrap;

import gipsy.springframework.petclinic.model.Owner;
import gipsy.springframework.petclinic.model.PetType;
import gipsy.springframework.petclinic.model.Vet;
import gipsy.springframework.petclinic.services.OwnerService;
import gipsy.springframework.petclinic.services.PetTypeService;
import gipsy.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Doggo");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cathy");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();

        owner1.setFirstName("Chris");
        owner1.setLastName("Slav");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Flupke");
        owner2.setLastName("Janetteke");

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("monki");
        vet1.setLastName("typon");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Yoehoe:)");
        vet2.setLastName("Boehoe:(");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
