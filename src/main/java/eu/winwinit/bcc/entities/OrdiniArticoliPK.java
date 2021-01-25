package eu.winwinit.bcc.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class OrdiniArticoliPK implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name="id_ordine", unique=false, nullable=false)
	private Integer idOrdini;
	
	@Column(name="id_articolo", unique=false, nullable=false)
	private Integer idArticoli;
	
	public OrdiniArticoliPK() {
	}
	
	public OrdiniArticoliPK(Integer idOrdini, Integer idArticoli)
	{
		this.idOrdini=idOrdini;
		this.idArticoli=idArticoli;
	}
	
	public Integer getIdOrdini() {
		return idOrdini;
	}
	
	public void setIdOrdini(Integer idOrdini) 
	{
		this.idOrdini = idOrdini;
	}
	
	public Integer getIdArticoli() 
	{
		return idArticoli;
	}
	
	public void setIdArticoli(Integer idArticoli) 
	{
		this.idArticoli = idArticoli;
	}
	
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

}
