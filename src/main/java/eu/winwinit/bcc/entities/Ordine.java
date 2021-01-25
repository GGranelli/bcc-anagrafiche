package eu.winwinit.bcc.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ordini")
public class Ordine implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer idOrdine;
	private Date data;
	private Double prezzoTotale;
	
	@OneToMany(mappedBy="ordine")
	private List<OrdiniArticoli> ordiniArticoli;
	
	public Ordine() {
	}
	
	public Ordine(Date data)
	{
		this.data=data;
		this.prezzoTotale=0.0;
	}
	
	public Ordine(Date data, Double prezzoTotale)
	{
		this.data=data;
		this.prezzoTotale=prezzoTotale;
	}
	
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name="id_ordine", unique=true, nullable=false)
	public Integer getIdOrdine() 
	{
		return idOrdine;
	}
	
	public void setIdOrdine(Integer idOrdine) 
	{
		this.idOrdine = idOrdine;
	}
	
	@Column(name="data", nullable=true)
	public Date getData() 
	{
		return data;
	}
	
	public void setData(Date data) 
	{
		this.data = data;
	}
	
	@Column(name="prezzo_totale", nullable=true)
	public Double getPrezzoTotale() 
	{
		return prezzoTotale;
	}
	
	public void setPrezzoTotale(Double prezzoTotale) 
	{
		this.prezzoTotale = prezzoTotale;
	}
	
	public void setOrdiniArticoli(OrdiniArticoli ordiniArticoli) 
	{
		this.ordiniArticoli.add(ordiniArticoli);
	}
	
	
	
}
