package eu.winwinit.bcc.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.model.OrdineInsertRequest;

public interface OrdineService {
	
	public List<Ordine> findOrdineAll();
	
	public Optional<Ordine> findOrdineById(Integer id);
	
	public List<Ordine> findOrdineByDate(Date startDate, Date endDate);
	
	public List<Ordine> findOrdineByPrezzo(Double prezzo);
	
	public int deleteOrdine(Integer id);
	
	public int updateOrdine(Integer idOrdine, Date data);
	
	public String insertOrder(OrdineInsertRequest ordInsReq);
	

}
