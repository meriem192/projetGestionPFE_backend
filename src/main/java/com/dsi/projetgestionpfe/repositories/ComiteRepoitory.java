package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.Comite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComiteRepoitory extends JpaRepository<Comite,Long> {
}
