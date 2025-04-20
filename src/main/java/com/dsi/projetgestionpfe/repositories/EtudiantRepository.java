package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    List<Etudiant> findByEnseignantId(Long enseignantId);
}
