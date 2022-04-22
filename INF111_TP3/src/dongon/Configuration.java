package dongon;

/**
 * Configuration du dongon.
 * 
 * Il y a un set de configuration initiales, mais les configurations changent
 * en cours de partie.
 * 
 * La classe est construite selon le patron lazy Singleton, et une référence au configuration
 * peut-être obtenue de partout à l'aide de getInstance.
 * 
 * Les configurations sont accessible en lecture/écriture par l'entremise
 * de 2 méthodes: 
 * 	- setConfig
 * 	- getConfig
 * Pour chacune des méthodes, la configuration à accédé est définit à l'aide
 * d'une des constantes publiques définis.
 * 
 * On peut revenir aux configurations initiales à l'aide de remiseAZero
 * 
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

public class Configuration {


	// set de configuration initiales
	private static class ValeurInitiale {
		
		// dimension du dongon
		private static double nbLignes = 10;
		private static double nbColonnes = 10;

		// nombre de créature dans le donjon
		private static double nbCreatures = 3;

		// nombre de créature dans le donjon
		private static double nbTypeCreatures = 3;	

		// nombre de créature dans le donjon
		private static double nbEquipements = 4;	
	}
	
	// constantes à utiliser pour accéder au configurations
	public static final int NB_LIGNES = 0;
	public static final int NB_COLONNES = 1;
	public static final int NB_CREATURES = 2;
	public static final int NB_TYPES_CREATURES = 3;
	public static final int NB_EQUIPEMENTS = 4;
	
	// tableau contenant les configurations
	public static double[] tabConfig = {
			ValeurInitiale.nbLignes,
			ValeurInitiale.nbColonnes,
			ValeurInitiale.nbCreatures,
			ValeurInitiale.nbTypeCreatures,
			ValeurInitiale.nbEquipements
	};

	//référence à l'objet.
	private static final Configuration instance = new Configuration();

	//constructeur privée (Singleton)
	private Configuration(){}

	/**
	 * méthode permettant d'obtenir l'instance 
	 * 
	 * @return instance de Configuration
	 */
	public static Configuration getInstance(){
		return instance;
	}

	/**
	 * mutatrice, méthode pour modifier une configuration
	 * 
	 * @param configID, entier identifiant la configuration
	 * @param value, valeur à assigner
	 */
	public void setConfig(int configID, double value){
		this.tabConfig[configID] = value;
	}

	/**
	 * informatrice, méthode permettant d'obtenir la valeur de la configuration
	 * 
	 * @param configID, entier identifiant la configuration
	 * @return valeur assigné
	 */
	public double getConfig(int configID){
		return this.tabConfig[configID];
	}
	
	/**
	 * méthode permettant de réinitialiser les configurations.
	 */
	public static void remiseAZero(){
		tabConfig[NB_LIGNES] = ValeurInitiale.nbLignes;
		tabConfig[NB_COLONNES] = ValeurInitiale.nbColonnes;
		tabConfig[NB_CREATURES] = ValeurInitiale.nbTypeCreatures;
		tabConfig[NB_TYPES_CREATURES] = ValeurInitiale.nbCreatures;
		tabConfig[NB_EQUIPEMENTS] = ValeurInitiale.nbEquipements;
	}
}
