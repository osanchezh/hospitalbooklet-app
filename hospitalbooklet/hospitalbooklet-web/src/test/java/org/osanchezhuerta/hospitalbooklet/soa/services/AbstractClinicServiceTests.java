package org.osanchezhuerta.hospitalbooklet.soa.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;

import org.joda.time.DateTime;
import org.junit.Test;
import org.osanchezhuerta.hospitalbooklet.soa.model.Owner;
import org.osanchezhuerta.hospitalbooklet.soa.model.Pet;
import org.osanchezhuerta.hospitalbooklet.soa.model.PetType;
import org.osanchezhuerta.hospitalbooklet.soa.model.Vet;
import org.osanchezhuerta.hospitalbooklet.soa.model.Visit;
import org.osanchezhuerta.hospitalbooklet.soa.services.ClinicService;
import org.osanchezhuerta.hospitalbooklet.soa.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractClinicServiceTests {

    @Autowired
    protected ClinicService clinicService;

    @Test
    @Transactional
    public void findOwners() {
        Collection<Owner> owners = this.clinicService.findOwnerByLastName("Davis");
        assertEquals(2, owners.size());
        owners = this.clinicService.findOwnerByLastName("Daviss");
        assertEquals(0, owners.size());
    }

    @Test
    public void findSingleOwner() {
        Owner owner1 = this.clinicService.findOwnerById(1);
        assertTrue(owner1.getLastName().startsWith("Franklin"));
        Owner owner10 = this.clinicService.findOwnerById(10);
        assertEquals("Carlos", owner10.getFirstName());

        assertEquals(owner1.getPets().size(), 1);
    }

    @Test
    @Transactional
    public void insertOwner() {
        Collection<Owner> owners = this.clinicService.findOwnerByLastName("Schultz");
        int found = owners.size();
        Owner owner = new Owner();
        owner.setFirstName("Sam");
        owner.setLastName("Schultz");
        owner.setAddress("4, Evans Street");
        owner.setCity("Wollongong");
        owner.setTelephone("4444444444");
        this.clinicService.saveOwner(owner);
        owners = this.clinicService.findOwnerByLastName("Schultz");
        assertEquals("Verifying number of owners after inserting a new one.", found + 1, owners.size());
    }

    @Test
    @Transactional
    public void updateOwner() throws Exception {
        Owner o1 = this.clinicService.findOwnerById(1);
        String old = o1.getLastName();
        o1.setLastName(old + "X");
        this.clinicService.saveOwner(o1);
        o1 = this.clinicService.findOwnerById(1);
        assertEquals(old + "X", o1.getLastName());
    }

	@Test
	public void findPet() {
	    Collection<PetType> types = this.clinicService.findPetTypes();
	    Pet pet7 = this.clinicService.findPetById(7);
	    assertTrue(pet7.getName().startsWith("Samantha"));
	    assertEquals(EntityUtils.getById(types, PetType.class, 1).getId(), pet7.getType().getId());
	    assertEquals("Jean", pet7.getOwner().getFirstName());
	    Pet pet6 = this.clinicService.findPetById(6);
	    assertEquals("George", pet6.getName());
	    assertEquals(EntityUtils.getById(types, PetType.class, 4).getId(), pet6.getType().getId());
	    assertEquals("Peter", pet6.getOwner().getFirstName());
	}

	@Test
	public void getPetTypes() {
	    Collection<PetType> petTypes = this.clinicService.findPetTypes();
	
	    PetType petType1 = EntityUtils.getById(petTypes, PetType.class, 1);
	    assertEquals("emergency room", petType1.getName());
	    PetType petType4 = EntityUtils.getById(petTypes, PetType.class, 4);
	    assertEquals("recovery room", petType4.getName());
	}

	@Test
	@Transactional
	public void insertPet() {
	    Owner owner6 = this.clinicService.findOwnerById(6);
	    int found = owner6.getPets().size();
	    Pet pet = new Pet();
	    pet.setName("bowser");
	    Collection<PetType> types = this.clinicService.findPetTypes();
	    pet.setType(EntityUtils.getById(types, PetType.class, 2));
	    pet.setBirthDate(new DateTime());
	    owner6.addPet(pet);
	    assertEquals(found + 1, owner6.getPets().size());
	    // both storePet and storeOwner are necessary to cover all ORM tools
	    this.clinicService.savePet(pet);
	    this.clinicService.saveOwner(owner6);
	    owner6 = this.clinicService.findOwnerById(6);
	    assertEquals(found + 1, owner6.getPets().size());
	}

	@Test
	@Transactional
	public void updatePet() throws Exception {
	    Pet pet7 = this.clinicService.findPetById(7);
	    String old = pet7.getName();
	    pet7.setName(old + "X");
	    this.clinicService.savePet(pet7);
	    pet7 = this.clinicService.findPetById(7);
	    assertEquals(old + "X", pet7.getName());
	}

	@Test
	public void findVets() {
	    Collection<Vet> vets = this.clinicService.findVets();
	
	    Vet v1 = EntityUtils.getById(vets, Vet.class, 2);
	    assertEquals("Leary", v1.getLastName());
	    assertEquals(1, v1.getNrOfSpecialties());
	    assertEquals("General physician/ family practitioner", (v1.getSpecialties().get(0)).getName());
	    Vet v2 = EntityUtils.getById(vets, Vet.class, 3);
	    assertEquals("Douglas", v2.getLastName());
	    assertEquals(2, v2.getNrOfSpecialties());
	    assertEquals("An emergency doctor", (v2.getSpecialties().get(0)).getName());
	    assertEquals("Internal medical doctor", (v2.getSpecialties().get(1)).getName());
	}

	@Test
	@Transactional
	public void insertVisit() {
	    Pet pet7 = this.clinicService.findPetById(7);
	    int found = pet7.getVisits().size();
	    Visit visit = new Visit();
	    pet7.addVisit(visit);
	    visit.setDescription("test");
	    // both storeVisit and storePet are necessary to cover all ORM tools
	    this.clinicService.saveVisit(visit);
	    this.clinicService.savePet(pet7);
	    pet7 = this.clinicService.findPetById(7);
	    assertEquals(found + 1, pet7.getVisits().size());
	}


}
