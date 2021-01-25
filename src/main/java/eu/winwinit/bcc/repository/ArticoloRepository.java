package eu.winwinit.bcc.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import eu.winwinit.bcc.entities.Articolo;

@Repository("articoloRepository")
public interface ArticoloRepository extends JpaRepository<Articolo, Integer>{

	public List<Articolo> findArticoloByNome(@Param("nome") String nome);

	public List<Articolo> findArticoloByCodiceFornitore(@Param("codiceFornitore") Integer codiceFornitore);
		
}
