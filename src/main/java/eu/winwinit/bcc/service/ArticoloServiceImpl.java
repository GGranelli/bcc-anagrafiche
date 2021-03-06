package eu.winwinit.bcc.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.winwinit.bcc.entities.Articolo;
import eu.winwinit.bcc.repository.ArticoloRepository;
import eu.winwinit.bcc.repository.OrdineRepository;

@Service("articoloService")
public class ArticoloServiceImpl implements ArticoloService{
	
	@Autowired
	private ArticoloRepository articoloRepository;
	
	
	@Override
	public List<Articolo> findArticoloAll()
	{
		return articoloRepository.findAll();
	}
	
	@Override
	public Optional<Articolo> findArticoloById(Integer idArticolo)
	{
		return articoloRepository.findById(idArticolo);
	}
	
	@Override
	public List<Articolo> findArticoloByNome(String nome)
	{
		return articoloRepository.findArticoloByNome(nome);
	}
	
	@Override
	public List<Articolo> findArticoloByCodiceFornitore(Integer codiceFornitore)
	{
		return articoloRepository.findArticoloByCodiceFornitore(codiceFornitore);
	}
	
	@Override
	public String insertArticolo(Articolo articolo)
	{
		articoloRepository.save(articolo);
		return "inserted articolo with id: "+articolo.getIdArticolo(); //return id
	}
	
	@Override
	public String deleteArticoloById(Integer idArticolo)
	{
		Articolo articolo = findArticoloById(idArticolo).orElse(null);
		if(articolo!=null)
		{
			articoloRepository.delete(articolo);
			return "deleted articolo with id: "+idArticolo;
		}
		return "articolo not found";
	}
	
	@Override
	public String updateArticoloById(Integer id,Articolo articolo)
	{
		Articolo oldArticolo = findArticoloById(id).orElse(null);
		if(oldArticolo!=null)
		{
			if(articolo.getNome()!=null) oldArticolo.setNome(articolo.getNome());
			if(articolo.getPrezzo()!=null) oldArticolo.setPrezzo(articolo.getPrezzo());
			if(articolo.getCodiceFornitore()!=null) oldArticolo.setCodiceFornitore(articolo.getCodiceFornitore());
			
			articoloRepository.save(oldArticolo);
			return "update articolo successful";
		}
		return "articolo not found";
	}

}
