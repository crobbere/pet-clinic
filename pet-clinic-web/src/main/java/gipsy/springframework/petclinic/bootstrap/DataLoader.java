package gipsy.springframework.petclinic.bootstrap;

import gipsy.springframework.petclinic.model.Owner;
import gipsy.springframework.petclinic.model.Pet;
import gipsy.springframework.petclinic.model.PetType;
import gipsy.springframework.petclinic.model.Vet;
import gipsy.springframework.petclinic.services.OwnerService;
import gipsy.springframework.petclinic.services.PetTypeService;
import gipsy.springframework.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
        owner1.setAddress("123 Baasstraat");
        owner1.setCity("Baaseinië");
        owner1.setTelephone("123456789");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rupert");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Flupke");
        owner2.setLastName("Janetteke");
        owner2.setAddress("122 Baasstraat");
        owner2.setCity("Baaseinïe");
        owner2.setTelephone("987654321");

        Pet flupkesPet = new Pet();
        flupkesPet.setPetType(savedCatPetType);
        flupkesPet.setOwner(owner2);
        flupkesPet.setBirthDate(LocalDate.now());
        flupkesPet.setName("Josiane");
        owner2.getPets().add(flupkesPet);

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
