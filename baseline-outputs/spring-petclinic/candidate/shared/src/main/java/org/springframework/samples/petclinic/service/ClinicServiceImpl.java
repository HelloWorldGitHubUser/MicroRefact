package org.springframework.samples.petclinic.service;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.petclinic.model;
import org.springframework.samples.petclinic.repository.OwnerRepository;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.samples.petclinic.repository.VetRepository;
import org.springframework.samples.petclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.cache.annotation.CacheResult;
import java.util.Collection;
import java.util.List;
import org.springframework.samples.petclinic.Interface.PetRepository;
import org.springframework.samples.petclinic.Interface.VetRepository;
import org.springframework.samples.petclinic.Interface.OwnerRepository;
import org.springframework.samples.petclinic.Interface.VisitRepository;
@Service
public class ClinicServiceImpl implements ClinicService{

 private  PetRepository petRepository;

 private  VetRepository vetRepository;

 private  OwnerRepository ownerRepository;

 private  VisitRepository visitRepository;

@Autowired
public ClinicServiceImpl(PetRepository petRepository, VetRepository vetRepository, OwnerRepository ownerRepository, VisitRepository visitRepository) {
    this.petRepository = petRepository;
    this.vetRepository = vetRepository;
    this.ownerRepository = ownerRepository;
    this.visitRepository = visitRepository;
}
@Override
@Transactional(readOnly = true)
public Owner findOwnerById(int id) throws DataAccessException{
    return ownerRepository.findById(id).get();
}


@Override
@Transactional(readOnly = true)
public Pet findPetById(int id) throws DataAccessException{
    return petRepository.findById(id);
}


@Override
@Transactional
public void savePet(Pet pet) throws DataAccessException{
    petRepository.save(pet);
}


@Override
@Transactional(readOnly = true)
@CacheResult(cacheName = "vets")
public Collection<Vet> findVets() throws DataAccessException{
    return vetRepository.findAll();
}


@Override
@Transactional(readOnly = true)
public List<Visit> findVisitsByPetIds(Collection<Integer> petIds) throws DataAccessException{
    return visitRepository.findByPetIdIn(petIds);
}


@Override
@Transactional
public void saveVisit(Visit visit) throws DataAccessException{
    visitRepository.save(visit);
}


@Transactional(readOnly = true)
public Collection<Owner> findAll() throws DataAccessException{
    return ownerRepository.findAll();
}


@Override
@Transactional(readOnly = true)
public Collection<PetType> findPetTypes() throws DataAccessException{
    return petRepository.findPetTypes();
}


@Override
@Transactional
public void saveOwner(Owner owner) throws DataAccessException{
    ownerRepository.save(owner);
}


}