import java.util.LinkedList;


public class Liste extends Element{
	LinkedList<Item> items;
	public Liste(int largeur, int hauteur, int x, int y, LinkedList<Item> i){
		super(largeur, hauteur, x, y);
		this.items = i;
	}
}
