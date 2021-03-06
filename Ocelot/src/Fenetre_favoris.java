import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Fenetre_favoris {
	  private boolean visibilite;
	  private Favoris favoris;
	  
	  public Fenetre_favoris(){
		  this.visibilite = false;
		  this.favoris = new Favoris();
			JFrame liste_favoris = new JFrame();
			Favoris f = new Favoris();
			f.charger();
			LinkedList<URL> urls = f.getUrls();
			Object[][] tab = new Object[urls.size()][4];
			for (int i=0;i<urls.size();i++)
			{

			tab[i][0] = urls.get(i).getTitre();
			tab[i][1] = urls.get(i).getUrl();
			tab[i][2] = urls.get(i).getDate();
			}


			String title[] = {"Nom", "Url", "Date de navigation"};
			JTable tableau = new JTable(tab, title);
			liste_favoris.getContentPane().add(new JScrollPane(tableau));
			liste_favoris.setVisible(true);
			liste_favoris.setTitle("Vos favoris");
			liste_favoris.setSize(200,200);
	  }
	  
	  public void activer(){
		  this.visibilite = true;
	  }
	  
	  public void desactiver(){
		  this.visibilite = false;
	  }
}
