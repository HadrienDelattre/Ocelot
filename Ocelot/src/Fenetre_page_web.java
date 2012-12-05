import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;



public class Fenetre_page_web extends JFrame{
	
	//chargement des images
	ImageIcon logo = new ImageIcon("images/logo.jpg");
	
	//Cr�ation du menu (en haut de la fenetre)
	JToolBar barre_menu = new JToolBar();
	JButton nouvelle_fenetre = new JButton(new ImageIcon("images/favoris.png"));
	JButton	afficher_historique = new JButton(new ImageIcon("images/favoris.png"));
	JButton	afficher_favoris = new JButton(new ImageIcon("images/favoris.png"));
	JButton	aide = new JButton(new ImageIcon("images/favoris.png"));
	JButton	ajouter_onglet = new JButton(new ImageIcon("images/favoris.png"));
	JTabbedPane barre_onglet = new JTabbedPane();
	
	//Cr�ation de la barre de  navigation (en bas de la fenetre)
	JToolBar barre_navigation = new JToolBar();
	JTextField barre_adresse = new JTextField("google.com",50);  
	JButton	bouton_ok = new JButton(new ImageIcon("images/favoris.png"));
	JButton	bouton_precedent = new JButton(new ImageIcon("images/favoris.png"));
	JButton	home = new JButton(new ImageIcon("images/favoris.png"));
	JButton	raffraichir = new JButton(new ImageIcon("images/favoris.png"));
	JButton	ajouter_favoris = new JButton(new ImageIcon("images/favoris.png"));
	JButton	bouton_suivant = new JButton(new ImageIcon("images/favoris.png"));   
	JLabel barre_statut = new JLabel("Url charg�",JLabel.CENTER);
	
	//Cr�ation des �couteurs
	private nouvelle_fenetre_listener nfListener = new nouvelle_fenetre_listener();
	private afficher_historique_listener ahListener = new afficher_historique_listener();
	private afficher_favoris_listener afListener = new afficher_favoris_listener();
	private aide_listener aListener = new aide_listener();
	private ajouter_onglet_listener aoListener = new ajouter_onglet_listener();
	private bouton_ok_listener boListener = new bouton_ok_listener();
	private bouton_precedent_listener bpListener = new bouton_precedent_listener();
	private home_listener hListener = new home_listener();
	private raffraichir_listener rListener = new raffraichir_listener();
	private ajouter_favoris_listener ajfListener = new ajouter_favoris_listener();
	private bouton_suivant_listener bsListener = new bouton_suivant_listener();
	
	
	//constructeur 
	public Fenetre_page_web() {
		
		//initialisation de la fenetre
		this.setSize(700, 500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //initialisation du menu
	    this.initMenu();
	    //initialisation de la barre de navigation
	    this.initNavigation();
	    
	    //initialisation de la barre d'onglet
	    this.initOnglet();
	    
	    //on rend notre fenetre visible et on la nomme
	    this.setVisible(true);
	    this.setTitle("Ocelot");
	    this.setIconImage(logo.getImage());

	}
	
	private void initMenu(){
		
		//Ajout des actionlistener aux elements
		nouvelle_fenetre.addActionListener(nfListener);
		afficher_historique.addActionListener(ahListener);
		afficher_favoris.addActionListener(afListener);
		aide.addActionListener(aListener);
		ajouter_onglet.addActionListener(aoListener);
		
		//Ajout des elements � la barre de menu
		barre_menu.add(nouvelle_fenetre);
		barre_menu.add(afficher_historique);
		barre_menu.add(afficher_favoris);
		barre_menu.add(aide);
		barre_menu.add(ajouter_onglet);
		
		
		this.getContentPane().add(barre_menu, BorderLayout.NORTH);


	    }
	
	private void initOnglet(){
		
		
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		barre_onglet.addTab("Onglet 1",panel1);
		barre_onglet.addTab("Onglet 2",panel2);
		this.getContentPane().add(barre_onglet, BorderLayout.CENTER);


	    }
	
	
	private void initNavigation(){
		
		//Ajout des actionlistener aux elements
		bouton_ok.addActionListener(boListener);
		bouton_precedent.addActionListener(bpListener);
		home.addActionListener(hListener);
		raffraichir.addActionListener(rListener);
		ajouter_favoris.addActionListener(ajfListener);
		bouton_suivant.addActionListener(bsListener);
		
		//Ajout des elements � la barre de menu
		barre_navigation.add(barre_statut);
		barre_navigation.add(barre_adresse);
		barre_navigation.add(bouton_ok);
		barre_navigation.add(bouton_precedent);
		barre_navigation.add(home);
		barre_navigation.add(raffraichir);
		barre_navigation.add(ajouter_favoris);
		barre_navigation.add(bouton_suivant);
		
		this.getContentPane().add(barre_navigation, BorderLayout.SOUTH);
	}
	
	
	 class nouvelle_fenetre_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }
	 
	 class afficher_historique_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }
	 
	 class afficher_favoris_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }
	 
	 class aide_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }
	 
	 class ajouter_onglet_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }
	 
	 class bouton_ok_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }
	 
	 class bouton_precedent_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }

	 class home_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }

	 class raffraichir_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }

	 class ajouter_favoris_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }

	 class bouton_suivant_listener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	
		    }
		    
	 }



}
