package eu.winwinit.bcc.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "articoli")
public class Articolo implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer idArticolo;
	private String nome;
	private Integer codiceFornitore;
	private Double prezzo;
	
	@OneToMany(mappedBy="articolo")
	private List<OrdiniArticoli> ordiniArticoli;
	
	public Articolo(){
	}
	
	public Articolo(String nome, Integer codiceFornitore, Double prezzo)
	{
		this.nome=nome;
		this.codiceFornitore=codiceFornitore;
		this.prezzo=prezzo;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	@Column(name="id_articolo", unique=true, nullable=false)
	public Integer getIdArticolo() 
	{
		return this.idArticolo;
	}
	
	public void setIdArticolo(Integer idArticolo)
	{
		this.idArticolo=idArticolo;
	}
	
	@Column(name="nome", nullable=false, length=25)
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	
	@Column(name="codice_fornitore", nullable=true)
	public Integer getCodiceFornitore()
	{
		return this.codiceFornitore;
	}
	
	public void setCodiceFornitore(Integer codiceFornitore)
	{
		this.codiceFornitore=codiceFornitore;
	}
	
	@Column(name="prezzo", nullable=true)
	public Double getPrezzo()
	{
		return this.prezzo;
	}
	
	public void setPrezzo(Double prezzo)
	{
		this.prezzo=prezzo;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void setOrdiniArticoli(OrdiniArticoli ordiniArticoli) 
	{
		this.ordiniArticoli.add(ordiniArticoli);
	}
	
	
}
