package eu.winwinit.bcc.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import eu.winwinit.bcc.constants.AuthorityRolesConstants;
import eu.winwinit.bcc.entities.Ordine;
import eu.winwinit.bcc.model.OrdineInsertRequest;
import eu.winwinit.bcc.service.OrdineService;

@RequestMapping("/api/v1/ordine")
@RestController
public class OrdineController {
	
	@Autowired
	OrdineService ordineService;
	
	@RequestMapping(value="/getAll", method = RequestMethod.GET)
	public List<Ordine> getOrdineAll(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken)
	{
		return ordineService.findOrdineAll();
	}
	
	@RequestMapping(value="/getOrdineById", method = RequestMethod.GET)
	public Ordine getOrdineByIdOrdine(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
									  @RequestParam(value="idOrdine")Integer idOrdine)
	{
		return ordineService.findOrdineById(idOrdine).orElse(null);
	}
	
	
	@RequestMapping(value="/getByDateBetween", method = RequestMethod.GET)
	public List<Ordine> getOrdineByDate(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
										@RequestParam(value="startDate") Date startDate,
										@RequestParam(value="endDate") Date endDate)
	{
		return ordineService.findOrdineByDate(startDate,endDate);
	}
	
	@RequestMapping(value = "/updateData", method = RequestMethod.PUT)
	public void updateOrdine(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
							 @RequestParam(value="idOrdine")Integer idOrdine,
							 @RequestParam(value="data") Date data)
	{
		ordineService.updateOrdine(idOrdine,data);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public void deleteOrdine(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
							   @RequestParam(value="idOrdine") Integer ordineId)
	{
		ordineService.deleteOrdine(ordineId);
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<String> insertOrdine(@RequestHeader(value=AuthorityRolesConstants.HEADER_STRING) String jwtToken,
    														 @RequestBody OrdineInsertRequest ordineInsertRequest) 
	{

		String stato = ordineService.insertOrder(ordineInsertRequest);
        
    	return ResponseEntity.ok(stato);
    }
	
}
