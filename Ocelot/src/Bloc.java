import java.util.LinkedList;

public class Bloc extends Element{
	private LinkedList<Element> elements;
	private int indentation;
	
	public LinkedList<Element> getElements() {
		return elements;
	}

	public void setElements(LinkedList<Element> elements) {
		this.elements = elements;
	}

	public int getIndentation() {
		return indentation;
	}

	public Bloc(int largeur, int hauteur, int x, int y, LinkedList<Element> e, int indentation){
		super(largeur, hauteur, x, y);
		this.elements = e;
		this.indentation = indentation;
	}
}
