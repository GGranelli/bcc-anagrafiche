package eu.winwinit.bcc.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eu.winwinit.bcc.entities.Articolo;
import eu.winwinit.bcc.entities.Ordine;

@Repository("ordineRepository")
public interface OrdineRepository extends JpaRepository<Ordine, Integer>{
	
	@Query(value = "SELECT o " 
				 + "FROM Ordine o " 
				 + "WHERE data BETWEEN :startDate AND :endDate ")
	public List<Ordine> findByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	public List<Ordine> findByPrezzoTotale(@Param("prezzoTotale") Double prezzoTotale);
	
}
