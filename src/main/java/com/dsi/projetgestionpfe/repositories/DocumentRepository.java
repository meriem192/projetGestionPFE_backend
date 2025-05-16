package com.dsi.projetgestionpfe.repositories;

import com.dsi.projetgestionpfe.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
