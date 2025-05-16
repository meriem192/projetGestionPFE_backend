package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.CahierDesCharges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CahierDesChargesRepository extends JpaRepository<CahierDesCharges, Integer> {
}
