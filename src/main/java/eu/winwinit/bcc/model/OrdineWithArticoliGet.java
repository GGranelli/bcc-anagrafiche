package eu.winwinit.bcc.model;

import java.sql.Date;
import java.util.List;

import eu.winwinit.bcc.entities.Articolo;

public class OrdineWithArticoliGet {
	
	private Integer idOrdine;
	private Date data;
	private Double prezzoTotale;
	private List<ArticoloWithQuantita> articoli;
	
	public OrdineWithArticoliGet() {
	}
	
	public OrdineWithArticoliGet(Integer idOrdine, Date data, Double prezzoTotale, List<ArticoloWithQuantita> articoli) 
	{
		this.idOrdine=idOrdine;
		this.data=data;
		this.prezzoTotale=prezzoTotale;
		this.articoli=articoli;
	}
	
	public Integer getIdOrdine() {
		return idOrdine;
	}
	public void setIdOrdine(Integer idOrdine) {
		this.idOrdine = idOrdine;
	}
	
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	public Double getPrezzoTotale() {
		return prezzoTotale;
	}
	public void setPrezzoTotale(Double prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}
	
	public List<ArticoloWithQuantita> getList() {
		return articoli;
	}
	public void setList(List<ArticoloWithQuantita> articoli) {
		this.articoli = articoli;
	}
	

}
