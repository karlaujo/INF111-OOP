package programme;


public class programmePrincipal {

	/**
	 * Programme principal, lance la vue du programme
	 * @author Quang-Long-Paul Nguyen, Karl-Eric Jolicoeur, Luji Victor Zhou
	 * @param args, inutilisé
	 */
    public static void main(String[] args){
    	
    	// lance le view-controller (à compléter)
    	Thread t = new Thread(new vue.CadrePrincipal());
    	t.start();
    	
    }
    
}

