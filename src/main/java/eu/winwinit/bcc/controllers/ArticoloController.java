package eu.winwinit.bcc.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.winwinit.bcc.constants.AuthorityRolesConstants;
import eu.winwinit.bcc.entities.Articolo;
import eu.winwinit.bcc.service.ArticoloService;

@RestController
@RequestMapping("/api/v1/articolo")
public class ArticoloController {
	
	@Autowired
	private ArticoloService articoloService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public List<Articolo> getArticoloAll(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken)
	{
		return articoloService.findArticoloAll();
	}
	
	@RequestMapping(value = "/getById", method = RequestMethod.GET)
	public Optional<Articolo> getArticoloById(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
			   								  @RequestParam(value="idArticolo")Integer idArticolo)
	{
		return articoloService.findArticoloById(idArticolo);
	}
	
	@RequestMapping(value = "/getByCodiceFornitore", method = RequestMethod.GET)
	public List<Articolo> getArticoloByCodiceFornitore(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
													   @RequestParam(value="codiceFornitore")Integer codiceFornitore)
	{
		return articoloService.findArticoloByCodiceFornitore(codiceFornitore);
	}
	
	@RequestMapping(value = "/getByNome", method = RequestMethod.GET)
	public List<Articolo> getArticoloByNome(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
											@RequestParam(value="nome") String nome)
	{
		return articoloService.findArticoloByNome(nome);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insertArticolo(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
    						   @RequestBody Articolo articolo)
    {
		return articoloService.insertArticolo(articolo);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String updateArticolo(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
							   @RequestParam(value="id") Integer id,
							   @RequestBody Articolo articolo)
	{
		return articoloService.updateArticoloById(id,articolo);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String deleteArticolo(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
							   @RequestParam(value="idArticolo") Integer id)
	{
		return articoloService.deleteArticoloById(id);
	}
	
}
