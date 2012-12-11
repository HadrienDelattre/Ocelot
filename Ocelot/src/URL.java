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

	/*
	 * Met une URL à jour en se servant d'un nouvel exemplaire
	 * de l'url comme modèle
	 * @param u nouvelle url
	 */
	public void update(URL u) {
		this.date = u.getDate();
		// this.titre = u.getTitre(); ? 
	}
}
