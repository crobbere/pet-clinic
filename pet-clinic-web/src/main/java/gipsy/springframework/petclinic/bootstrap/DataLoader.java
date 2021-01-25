package gipsy.springframework.petclinic.bootstrap;

import gipsy.springframework.petclinic.model.*;
import gipsy.springframework.petclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Doggo");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cathy");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(flupkesPet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Holy moly dude, it's dying");

        visitService.save(catVisit);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("monki");
        vet1.setLastName("typon");
        vet1.getSpecialties().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Yoehoe:)");
        vet2.setLastName("Boehoe:(");
        vet2.getSpecialties().add(savedDentistry);

        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
