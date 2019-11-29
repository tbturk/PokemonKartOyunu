
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bthn0
 */
public class BilgisayarOyuncusu extends Oyuncu{//   subClass

    public BilgisayarOyuncusu(String oyuncuAdi, int oyuncuID, int skor) {
        super(oyuncuAdi, oyuncuID, skor);
    }

    @Override
    int kartSec(String[][] a) {
        int temp;
        while(true){
            Random random = new Random();
            temp = random.nextInt(3);
            if(a[temp][0].equals(" ")){
                continue;
            }
            break;
        }
        return temp;
    }

    
    
    
}
