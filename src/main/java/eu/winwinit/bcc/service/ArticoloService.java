package eu.winwinit.bcc.service;

import java.util.List;
import java.util.Optional;

import eu.winwinit.bcc.entities.Articolo;

public interface ArticoloService {
	
	public List<Articolo> findArticoloAll();
	
	public Optional<Articolo> findArticoloById(Integer idArticolo);
	
	public List<Articolo> findArticoloByNome(String nome);
	
	public List<Articolo> findArticoloByCodiceFornitore(Integer codiceFornitore);
	
	public String insertArticolo(Articolo articolo);
	
	public String deleteArticoloById(Integer idArticolo);
	
	public String updateArticoloById(Integer id,Articolo articolo);
}
