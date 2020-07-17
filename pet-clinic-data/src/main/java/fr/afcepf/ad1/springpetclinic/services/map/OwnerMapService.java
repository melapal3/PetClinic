package fr.afcepf.ad1.springpetclinic.services.map;

import fr.afcepf.ad1.springpetclinic.model.Owner;
import fr.afcepf.ad1.springpetclinic.model.Pet;
import fr.afcepf.ad1.springpetclinic.services.OwnerService;
import fr.afcepf.ad1.springpetclinic.services.PetService;
import fr.afcepf.ad1.springpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerMapService(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){ //si user a des pets on veut itérer dessus
            if(!object.getPets().isEmpty()){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("PetType is required");
                    }
                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }

    }

    @Override
    public void deleteById(Long id) {
    super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
    super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

}
