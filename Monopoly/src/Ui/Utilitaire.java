package Ui;

import static java.lang.Math.random;

public class Utilitaire {
    
        

	public static int[] lancerDés() {
            int[] valDes = {0,0};
            
            int val1 = (int)(Math.random()*(5))+1;
            int val2 = (int)(Math.random()*(5))+1;
            
            valDes[0] = 2;
            valDes[1] = 3;
            
            return valDes;
	}
        
        
    

}