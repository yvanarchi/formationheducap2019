package javainterfacesForm;

// une interface se d�clare comme une classe
// sauf qu'on utilise le mot clef interface a la place de class
public interface Compte {
	
	void deposer(double montant);
	boolean retirer(double montant);
	double getSolde();

}
