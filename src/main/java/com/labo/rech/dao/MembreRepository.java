package com.labo.rech.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.labo.rech.entity.Membre;
import com.labo.rech.entity.Publication;

@Repository
@Transactional
public interface MembreRepository extends JpaRepository<Membre,Integer> {
	@Query("SELECT m.publications FROM Membre m WHERE m.id = :id")
	public List<Publication> getPublicationsByMembreId(@Param("id") Integer id);
}