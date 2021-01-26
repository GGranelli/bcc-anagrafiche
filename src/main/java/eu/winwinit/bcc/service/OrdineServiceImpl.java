package eu.winwinit.bcc.service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.winwinit.bcc.entities.Articolo;
import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.entities.OrdiniArticoli;
import eu.winwinit.bcc.entities.OrdiniArticoliPK;
import eu.winwinit.bcc.model.ArticoloWithQuantita;
import eu.winwinit.bcc.model.OrdineInsertRequest;
import eu.winwinit.bcc.model.OrdineWithArticoliGet;
import eu.winwinit.bcc.model.OrdiniArticoliToInsert;
import eu.winwinit.bcc.repository.ArticoloRepository;
import eu.winwinit.bcc.repository.OrdineRepository;
import eu.winwinit.bcc.repository.OrdiniArticoliRepository;

@Service("ordineService")
public class OrdineServiceImpl implements OrdineService{

	@Autowired
	private OrdineRepository ordineRepository;
	@Autowired
	private OrdiniArticoliRepository ordiniArticoliRepository;
	@Autowired
	private ArticoloRepository articoloRepository;
	
	@Override
	public List<Ordine> findOrdineAll() 
	{
		return ordineRepository.findAll();
	}

//	@Override
//	public Optional<Ordine> findOrdineById(Integer id) 
//	{
//		return ordineRepository.findById(id);
//	}
	
	@Override
	public OrdineWithArticoliGet findOrdineById(Integer id) 
	{
		
		Ordine ordine = ordineRepository.findById(id).orElse(null);
		
		if(ordine!=null)
		{
			List<ArticoloWithQuantita> listArticoli = ordiniArticoliRepository.findByIdOrdine(id);

			OrdineWithArticoliGet ordArtToGet = new OrdineWithArticoliGet(id,ordine.getData(),ordine.getPrezzoTotale(),listArticoli);
			return ordArtToGet;
		}
		return null;
	}

	@Override
	public List<Ordine> findOrdineByDate(Date startDate, Date endDate) 
	{
		return ordineRepository.findByDate(startDate,endDate);
	}

	@Override
	public List<Ordine> findOrdineByPrezzo(Double prezzo) 
	{
		return ordineRepository.findByPrezzoTotale(prezzo);
	}

	@Override
	public String deleteOrdine(Integer id) 
	{
		Ordine ordineToDelete = ordineRepository.findById(id).orElse(null);
		if(ordineToDelete!=null)
		{
			ordineRepository.delete(ordineToDelete);
			return "deleted ordine with id: "+id;
		}
		return "ordine not found";
	}

	@Override
	public String updateOrdine(Integer idOrdine, Date data) 
	{
		Ordine ordineToUpdate = ordineRepository.findById(idOrdine).orElse(null);
		if(ordineToUpdate!=null)
		{
			ordineToUpdate.setData(data);
			ordineRepository.save(ordineToUpdate);
			return "ordine's date updated";
		}
		return "ordine not updated";
	}
	
	/*
	@Override
	public List<OrdiniArticoli> findArticoliOfOrdine(Integer id) 
	{
		
		return ordiniArticoliRepository.findByIdOrdine(id);
	}
	*/
	
	@Override
	public String insertOrder(OrdineInsertRequest ordInsReq) 
	{		

	    Date data = ordInsReq.getData();
		
		Ordine ordine = new Ordine(data);
		
		ordineRepository.save(ordine);
		
		List<OrdiniArticoliToInsert> list = ordInsReq.getListOrdiniArticoli();
		
		for(OrdiniArticoliToInsert next : list)
		{
			OrdiniArticoliPK ordArtPK = new OrdiniArticoliPK(ordine.getIdOrdine(),next.getIdArticolo());
			
			OrdiniArticoli ordArt = new OrdiniArticoli(ordArtPK, next.getQuantita());
			
			Articolo articolo = articoloRepository.findById(next.getIdArticolo()).orElse(null);
			
			if(articolo!=null)
			{
				ordArt.setArticolo(articolo);
			}
			else
			{
				ordineRepository.delete(ordine);
				return "id articolo not found.";
			}
			
			ordArt.setOrdine(ordine);
			
			Double prezzoTotale = Math.floor(ordine.getPrezzoTotale()+(ordArt.getQuantita()*articolo.getPrezzo())*100)/100;
			
			ordine.setPrezzoTotale(prezzoTotale); //quantitaordArt * prezzo->articoli
			
			
			ordiniArticoliRepository.save(ordArt);

		}
		
		ordineRepository.save(ordine);
		
		return "insert ordine successful";
	}
}
