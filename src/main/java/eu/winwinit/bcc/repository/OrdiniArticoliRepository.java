package eu.winwinit.bcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.winwinit.bcc.entities.OrdiniArticoli;
import eu.winwinit.bcc.entities.OrdiniArticoliPK;

@Repository("ordiniArticoliRepository")
public interface OrdiniArticoliRepository extends JpaRepository<OrdiniArticoli, OrdiniArticoliPK>{
	
	//public List<OrdiniArticoli> findByIdOrdine(@Param("idOrdine") Integer idOrdine);
	
}
