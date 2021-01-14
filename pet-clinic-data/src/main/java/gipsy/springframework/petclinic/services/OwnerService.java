package gipsy.springframework.petclinic.services;

import gipsy.springframework.petclinic.model.Owner;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
