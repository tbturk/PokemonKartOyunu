
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author bthn0
 */
public class InsanOyuncusu extends Oyuncu {//   subClass

    public InsanOyuncusu(String oyuncuAdi, int oyuncuID, int skor) {
        super(oyuncuAdi, oyuncuID, skor);
    }
    
    @Override
    int kartSec() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Oyuncunun Sahip Olduğu Kartlar:");
        getKartListesi();
        int ayniMi = 1;
        String secilenPokemon="pokemon";
        while (ayniMi == 1) {
            System.out.print("Oynamak İstediğiniz Pokemonun İsmini Giriniz: ");
            secilenPokemon = scanner.nextLine();
            ayniMi = 1;
            for (int k = 0; k < 3; k++) {
                if (secilenPokemon.equalsIgnoreCase(kartListesi[k][0])) {
                    ayniMi = 0;
                    kartListesi[k][0]=" ";
                }
            }            
        }
        System.out.println("Seni seçtim "+secilenPokemon);
        
        //return secilenPokemon;
        return 0;
    }
    
}
