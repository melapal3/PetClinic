package fr.afcepf.ad1.springpetclinic.bootstrap;

import fr.afcepf.ad1.springpetclinic.model.*;
import fr.afcepf.ad1.springpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final PetService petService;
    private final PetTypeService petTypeService;
    private final VetService vetService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, PetService petService, PetTypeService petTypeService, VetService vetService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.petService = petService;
        this.petTypeService = petTypeService;
        this.vetService = vetService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        //Insert speciality
        Speciality radiology = new Speciality();
        radiology.setDescription("Radiologie");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentiste");
        Speciality savedDentistry = specialityService.save(dentistry);

        Speciality surgery = new Speciality();
        surgery.setDescription("Urgence");
        Speciality savedSurgery = specialityService.save(surgery);

        System.out.println("SPECIAL kzepofjzepofjzpefjepf");

        //Add PetType
        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);
        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("PET TYPE jpfezjfpoejzfpofjzepof");

        //Add Owner
        Owner owner1 = new Owner();
        owner1.setFirstName("Felix");
        owner1.setFirstName("Feu");
        owner1.setAddress("123 loin");
        owner1.setCity("paris");
        owner1.setTelephone("123456789");
        Pet lixPet = new Pet();
        lixPet.setPetType(savedDogPetType);
        lixPet.setName("lilix");
        lixPet.setOwner(owner1);
        lixPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(lixPet);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setFirstName("Hae");
        owner1.setFirstName("DY");
        owner1.setAddress("123 très loin");
        owner1.setCity("paris");
        owner1.setTelephone("30303030");
        Pet haePet = new Pet();
        haePet.setOwner(owner2);
        haePet.setBirthDate(LocalDate.now());
        haePet.setName("yock");
        haePet.setPetType(savedCatPetType);
        owner2.getPets().add(haePet);
        ownerService.save(owner2);

        System.out.println("jpoaefj owner");

        //load visit
        Visit catVisit = new Visit();
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Cat headache");
        catVisit.setPet(haePet);
        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("veto1");
        vet1.setLastName("lloll");
        vet1.getSpecialities().add(savedSurgery);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("veto2");
        vet2.setLastName("olo");
        vet2.getSpecialities().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("VETTTTT upjfzefjhzipfçzoj");

    }

}
