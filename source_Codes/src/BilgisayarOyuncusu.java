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
    int kartSec() {
        
        return 0;
    }

    
    
    
}
