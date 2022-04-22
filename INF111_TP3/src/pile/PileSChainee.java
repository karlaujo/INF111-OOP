package pile;


/**
 * Ce fichier implémente une pile simplement chaînée. Utilise une
 * classe interne (Noeud)
 * 
 * Les services offerts:
 *  - enpiler, permet d'ajouter un élément au début
 *  - depiler, permet d'enlever l'élément du debut
 *  - regarder, permet d'obtenir l'élément du debut sans l'enlever
 *  - estVide, permet de savoir si la pile est vide
 * 
 * Le fichier définit également la classe privée Noeud.
 * 
 * @author Fred Simard, ETS
 * @version Été 2018
 * 
 */
 
 

public class PileSChainee
{
    

    /**
     * Classe privée qui définit un Noeud de la pile, il s'agit d'un noeud simplement chainée
     * auquel est attaché un élément de type Object.
     * 
     * Il contient une référence sur le noeuds suivant et un constructeur
     * pour simplifer l'initialisation
     */
	
    class Noeud
    {
        private Object element;
        private Noeud suivant = null;
        
        public Noeud(){}
        
        public Noeud(Object element){
            this.element = element;
        }
        
    }
    
    private Noeud tete = null;
    
    public PileSChainee(){};
    
    /**
     * méthode pour ajouter un élément à la pile
     * @param element, élément à ajouter
     */
    public void empiler(Object element){
    	Noeud noeud = new Noeud(element);
    	noeud.suivant = tete;
        tete = noeud;
    }
    
    /**
     * méthode pour dépiler un élément
     * @return l'élément dépilé
     */
    public Object depiler(){
    	
    	if(tete==null){
    		return null;
    	}
    	
    	Object element = tete.element;
    	tete = tete.suivant;
    	return element;
    }

    /**
     * méthode pour regarder l'élément sur la pile, sans l'enlever
     * @return l'élément du dessus
     */
    public Object regarder(){
        return tete.element;
    }

    /**
     * méthode pour savoir si la liste est vide
     * @return true, si la liste est vide, false sinon
     */
    public boolean estVide(){
        if(tete==null){
        	return true;
        }
    	return false;
    }
    
}
