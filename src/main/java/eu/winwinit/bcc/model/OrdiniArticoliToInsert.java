package eu.winwinit.bcc.model;

public class OrdiniArticoliToInsert {
	
	private Integer idArticolo;
	private Integer quantita;
	
	public OrdiniArticoliToInsert() {
	}
	
	public OrdiniArticoliToInsert(Integer idArticolo, Integer quantita) 
	{
		this.idArticolo=idArticolo;
		this.quantita=quantita;
	}
	
	public Integer getIdArticolo() {
		return idArticolo;
	}
	
	public void setIdArticolo(Integer idArticolo) {
		this.idArticolo = idArticolo;
	}
	
	public Integer getQuantita() {
		return quantita;
	}
	
	public void setQuantita(Integer quantita) {
		this.quantita = quantita;
	}
	
}
