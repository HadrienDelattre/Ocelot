import java.awt.Color;
import java.util.Date;

public class Preferences {
	static private URL url_accueil;
	static private URL url_aide;
	static private Date date_max_historique;
	static private Color couleur_liens;
	static private String police_par_defaut;
	static private Color couleur_police;
	static private Color couleur_fond;
		
	
	public Preferences(){
		
	}
	
	public void charger(){
		
	}

	public static URL getUrl_accueil() {
		return url_accueil;
	}

	public static URL getUrl_aide() {
		return url_aide;
	}

	public static Date getDate_max_historique() {
		return date_max_historique;
	}

	public static Color getCouleur_liens() {
		return couleur_liens;
	}

	public static String getPolice_par_defaut() {
		return police_par_defaut;
	}

	public static Color getCouleur_police() {
		return couleur_police;
	}

	public static Color getCouleur_fond() {
		return couleur_fond;
	}
}
