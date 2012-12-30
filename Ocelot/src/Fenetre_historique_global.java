import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Fenetre_historique_global {
  private boolean visibilite;
  private Historique_global historique_global;
  
  public Fenetre_historique_global() throws IOException, ParseException{
	  this.visibilite = false;
	  this.historique_global = new Historique_global();
		JFrame liste_historique = new JFrame();
		Historique_global hg = new Historique_global();
		hg.charger();
		LinkedList<URL> urls =hg.getUrls();
		Object[][] tab = new Object[urls.size()][4];
		for (int i=0;i<urls.size();i++)
		{

		tab[i][0] = urls.get(i).getTitre();
		tab[i][1] = urls.get(i).getUrl();
		tab[i][2] = urls.get(i).getDate();
		}


		String title[] = {"Nom", "Url", "Date de navigation"};
		JTable tableau = new JTable(tab, title);
		liste_historique.getContentPane().add(new JScrollPane(tableau));
		liste_historique.setVisible(true);
		liste_historique.setTitle("Historique de navigation");
		liste_historique.setSize(200,200);
  }
  
  public void activer(){
	  this.visibilite = true;
  }
  
  public void desactiver(){
	  this.visibilite = false;
  }
}
