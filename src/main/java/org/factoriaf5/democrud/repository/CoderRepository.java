package org.factoriaf5.democrud.repository;

import org.factoriaf5.democrud.model.Coder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoderRepository extends JpaRepository<Coder, Long> {

}
