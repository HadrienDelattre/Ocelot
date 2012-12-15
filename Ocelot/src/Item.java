import java.awt.Image;
import java.util.LinkedList;


public class Item {
	private LinkedList<Element> elements;
	private Image puce;
	
	public Item(LinkedList<Element> e, Image puce){
		this.elements = e;
		this.puce = puce;
	}

	public LinkedList<Element> getElements() {
		return elements;
	}

	public Image getPuce() {
		return puce;
	}
}
