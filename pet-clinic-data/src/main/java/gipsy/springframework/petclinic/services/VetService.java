package gipsy.springframework.petclinic.services;

import gipsy.springframework.petclinic.model.Owner;
import gipsy.springframework.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
