package gipsy.springframework.petclinic.repositories;

import gipsy.springframework.petclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
