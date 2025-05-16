package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.Jury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JuryRepository extends JpaRepository<Jury, Integer> {
}
