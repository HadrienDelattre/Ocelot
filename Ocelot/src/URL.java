import java.util.Date;


public class URL {
    private String url;
    private String titre;
    private Date date;
    private int statut;
    
    public URL(String url, String titre, Date date, int statut){
    	this.url = url;
    	this.titre = titre;
    	this.date = date;
    	this.statut = statut;
    }
    
	public String getUrl() {
		return url;
	}
	public String getTitre() {
		return titre;
	}
	public Date getDate() {
		return date;
	}
	public int getStatut() {
		return statut;
	}
	
	public String toString()
	{
		
		String url_toString= this.getTitre()+"\t"+this.getUrl()+"\t"+this.getDate()+"\t"+ this.getStatut();
		return url_toString;
	}

	/*
	 * Met une URL a jour en se servant d'un nouvel exemplaire
	 * de l'url comme modele
	 * @param u nouvelle url
	 */
	public void update(URL u) {
		this.date = u.getDate();
		// this.titre = u.getTitre(); ? 
	}
}
