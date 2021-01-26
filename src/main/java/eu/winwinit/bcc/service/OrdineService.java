package eu.winwinit.bcc.service;

import java.sql.Date;
import java.util.List;

import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.model.OrdineInsertRequest;
import eu.winwinit.bcc.model.OrdineWithArticoliGet;

public interface OrdineService {
	
	public List<Ordine> findOrdineAll();
	
	public OrdineWithArticoliGet findOrdineById(Integer id);
	
	public List<Ordine> findOrdineByDate(Date startDate, Date endDate);
	
	public List<Ordine> findOrdineByPrezzo(Double prezzo);
	
	public String deleteOrdine(Integer id);
	
	public String updateOrdine(Integer idOrdine, Date data);
	
	public String insertOrder(OrdineInsertRequest ordInsReq);
	

}
