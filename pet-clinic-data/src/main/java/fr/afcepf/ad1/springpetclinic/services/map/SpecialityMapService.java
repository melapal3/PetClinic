package fr.afcepf.ad1.springpetclinic.services.map;

import fr.afcepf.ad1.springpetclinic.model.Speciality;
import fr.afcepf.ad1.springpetclinic.services.SpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class SpecialityMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public void deleteById(Long id) {
    super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
    super.delete(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }
}
