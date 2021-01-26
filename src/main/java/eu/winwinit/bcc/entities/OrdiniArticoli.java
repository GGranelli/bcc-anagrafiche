package eu.winwinit.bcc.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="ordini_articoli")
public class OrdiniArticoli implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrdiniArticoliPK primaryKey;
	
	@ManyToOne
	@MapsId("idOrdini")
	@JoinColumn(name="id_ordine", insertable = false, updatable = false)
	private Ordine ordine;
	
	@ManyToOne
	@MapsId("idArticoli")
	@JoinColumn(name="id_articolo", insertable = false, updatable = false)
	private Articolo articolo;
	
	private Integer quantita;
	
	public OrdiniArticoli() {
	}
	
	public OrdiniArticoli(OrdiniArticoliPK primaryKey, Integer quantita)
	{
		this.primaryKey=primaryKey;
		this.quantita=quantita;
	}
	
	public OrdiniArticoliPK getPrimaryKey()
	{
		return primaryKey;
	}
	
	public void setPrimaryKey(Integer id1, Integer id2)
	{
		this.primaryKey.setIdOrdini(id1);
		this.primaryKey.setIdArticoli(id2);
	}
	
	public Integer getIdOrdini()
	{
		return this.primaryKey.getIdOrdini();
	}
	
	public Integer getIdArticoli()
	{
		return this.primaryKey.getIdArticoli();
	}
	
	@Column(name="quantita", unique=false, nullable=true)
	public Integer getQuantita() 
	{
		return quantita;
	}
	
	public void setQuantita(Integer quantita) 
	{
		this.quantita = quantita;
	}
	
	public Articolo getArticolo() 
	{
		return articolo;
	}
	
	public void setArticolo(Articolo articolo) 
	{
		this.articolo = articolo;
	}
	
	public Ordine getOrdine() 
	{
		return ordine;
	}
	
	public void setOrdine(Ordine ordine) 
	{
		this.ordine = ordine;
	}
	
}
