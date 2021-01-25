package eu.winwinit.bcc.model;

import java.sql.Date;
import java.util.List;

public class OrdineInsertRequest {
	
	private Date data;
	private Double prezzoTotale;
	private List<OrdiniArticoliToInsert> listOrdiniArticoli;
	
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
	
	public List<OrdiniArticoliToInsert> getListOrdiniArticoli() {
		return listOrdiniArticoli;
	}
	
	public void setListOrdiniArticoli(List<OrdiniArticoliToInsert> listOrdiniArticoli) {
		this.listOrdiniArticoli = listOrdiniArticoli;
	}

}
