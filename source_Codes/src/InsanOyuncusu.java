/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bthn0
 */
public class InsanOyuncusu extends Oyuncu{//   subClass
    
    public InsanOyuncusu(String oyuncuAdi, int oyuncuID, int skor) {
        super(oyuncuAdi, oyuncuID, skor);
    }
    
    @Override
    void kartSec() {
        getKartListesi();
    }
    
}
