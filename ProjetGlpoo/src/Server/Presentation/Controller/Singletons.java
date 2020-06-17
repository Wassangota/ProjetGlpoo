package Server.Presentation.Controller;

public class Singletons {
	
	private static BouclePrincipale bouclePrincipaleInstance;
	
	public static BouclePrincipale getBouclePrincipale() {
		if(bouclePrincipaleInstance != null) return bouclePrincipaleInstance;
		else return null;
	}
	
	public static void setBP(BouclePrincipale bp) {
		bouclePrincipaleInstance = bp;
	}

}
