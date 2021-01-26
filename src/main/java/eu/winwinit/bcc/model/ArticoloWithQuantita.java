package eu.winwinit.bcc.model;

public class ArticoloWithQuantita {
	
	private Integer idArticolo;
	private String nome;
	private Integer codiceFornitore;
	private Double prezzo;
	private Integer quantita;
	
	public ArticoloWithQuantita(){
	}
	
	public ArticoloWithQuantita(Integer idArticolo, String nome, Integer codiceFornitore, Double prezzo, Integer quantita)
	{
		this.idArticolo=idArticolo;
		this.nome=nome;
		this.codiceFornitore=codiceFornitore;
		this.prezzo=prezzo;
		this.quantita=quantita;
	}
	
	public Integer getIdArticolo() 
	{
		return this.idArticolo;
	}
	
	public void setIdArticolo(Integer idArticolo)
	{
		this.idArticolo=idArticolo;
	}
	
	public String getNome()
	{
		return this.nome;
	}
	
	public void setNome(String nome)
	{
		this.nome=nome;
	}
	
	public Integer getCodiceFornitore()
	{
		return this.codiceFornitore;
	}
	
	public void setCodiceFornitore(Integer codiceFornitore)
	{
		this.codiceFornitore=codiceFornitore;
	}
	
	public Double getPrezzo()
	{
		return this.prezzo;
	}
	
	public void setPrezzo(Double prezzo)
	{
		this.prezzo=prezzo;
	}
	
	public Integer getQuantita() 
	{
		return quantita;
	}
	
	public void setQuantita(Integer quantita) 
	{
		this.quantita = quantita;
	}
}
