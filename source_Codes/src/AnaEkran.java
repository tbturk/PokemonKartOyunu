
import java.util.ArrayList;
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
public class AnaEkran {
    public static void basKartAta(ArrayList<Integer> kullanilanKartlar,ArrayList<Pokemon> pokemon,Oyuncu oyuncu){
        Random random = new Random();
        for (int j = 0; j < 3; j++) {
            int ayniMi = 1;// aynı kartın bir daha seçilmemesi için
            int rastgele=5;
            while (ayniMi == 1) {
                ayniMi = 0;
                rastgele = random.nextInt(10);
                for (int k = 0; k < kullanilanKartlar.size(); k++) {
                    if (rastgele == kullanilanKartlar.get(k)) {
                        ayniMi = 1;
                    }
                } 
            }
            kullanilanKartlar.add(rastgele);
            oyuncu.kartListesi[j]=pokemon.get(rastgele).getPokemonAdi();
        }
    }
    public static void main(String[] args) {
        ArrayList<Pokemon> pokemon = new ArrayList<>();
        ArrayList<Integer> kullanilanKartlar = new ArrayList<>();
        pokemon.add(new Pikachu("Pikachu", "Elektrik", 40));
        pokemon.add(new Bulbasaur("Bulbasaur", "Çim", 50));
        pokemon.add(new Charmander("Charmander", "Ateş", 60));
        pokemon.add(new Squirtle("Squirtle", "Su", 30));
        pokemon.add(new Zubat("Zubat", "Hava", 50));
        pokemon.add(new Psyduck("Psyduck", "Su", 20));
        pokemon.add(new Snorlax("Snorlax", "Normal", 30));
        pokemon.add(new Butterfree("Butterfree", "Hava", 10));
        pokemon.add(new Jigglypuff("Jigglypuff", "Ses", 70));
        pokemon.add(new Meowth("Meowth", "Normal", 40));

        //pokemon.forEach((n)->System.out.println(n));
        /*for (int i = 0; i < 10; i++) {
            System.out.println(pokemon.get(i).getPokemonTip());
        }*/
        Oyuncu oyuncu1 = new InsanOyuncusu("Batuhan", 1, 0);
        Oyuncu oyuncu2 = new InsanOyuncusu("İbrahim", 2, 0);
        basKartAta(kullanilanKartlar,pokemon,oyuncu1);
        basKartAta(kullanilanKartlar,pokemon,oyuncu2);
        System.out.println(oyuncu1.getOyuncuAdi()+"\n----------");
        oyuncu1.getKartListesi();
        System.out.println("\n"+oyuncu2.getOyuncuAdi()+"\n----------");
        oyuncu2.getKartListesi();
    }
}
