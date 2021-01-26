package eu.winwinit.bcc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import eu.winwinit.bcc.entities.OrdiniArticoli;
import eu.winwinit.bcc.entities.OrdiniArticoliPK;
import eu.winwinit.bcc.model.ArticoloWithQuantita;

@Repository("ordiniArticoliRepository")
public interface OrdiniArticoliRepository extends JpaRepository<OrdiniArticoli, OrdiniArticoliPK>{
	
	//public List<OrdiniArticoliToInsert> findByIdOrdine(@Param("idOrdine") Integer idOrdine);
	
//	@Query(value = "SELECT idArticolo FROM OrdiniArticoli o WHERE idOrdine = :idOrdine ")
//	public List<Integer> findByIdOrdine(@Param("idOrdine") Integer idOrdine);
	//"SELECT a.idArticolo, a.nome, a.codiceFornitore, a.prezzo, o.quantita "
	
	@Query(value = "SELECT new eu.winwinit.bcc.model.ArticoloWithQuantita(a.idArticolo, a.nome, a.codiceFornitore, a.prezzo, o.quantita) "  
				 + "FROM Articolo a JOIN OrdiniArticoli o ON (a.idArticolo = o.primaryKey.idArticoli) " 
				 + "WHERE o.primaryKey.idOrdini = :idOrdine ")
	public List<ArticoloWithQuantita> findByIdOrdine(@Param("idOrdine") Integer idOrdine);
	
}
