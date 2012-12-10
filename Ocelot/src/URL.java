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
}
