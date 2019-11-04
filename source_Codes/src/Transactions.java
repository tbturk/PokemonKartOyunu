
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
public class Transactions {

    ArrayList<Pokemon> pokemon = new ArrayList<>();
    ArrayList<Integer> kullanilanKartlar = new ArrayList<>();

    public void basKartAta(ArrayList<Integer> kullanilanKartlar, ArrayList<Pokemon> pokemon, Oyuncu oyuncu) {
        Random random = new Random();
        for (int j = 0; j < 3; j++) {
            int ayniMi = 1;// aynı kartın bir daha seçilmemesi için
            int rastgele = 5;
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
            oyuncu.kartListesi[j] = pokemon.get(rastgele).getPokemonAdi();
        }
    }

    public void yeniKart(ArrayList<Integer> kullanilanKartlar, ArrayList<Pokemon> pokemon, Oyuncu oyuncu) {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            if (oyuncu.kartListesi[i].equalsIgnoreCase(" ")) {
                int ayniMi = 1;// aynı kartın bir daha seçilmemesi için
                int rastgele = 5;
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
                oyuncu.kartListesi[i] = pokemon.get(rastgele).getPokemonAdi();
            }
        }

    }

    public int kartBittiMi(Oyuncu oyuncu) {
        int toplam = 0;
        for (int i = 0; i < 3; i++) {
            if (oyuncu.kartListesi[i].equalsIgnoreCase(" ")) {
                toplam++;
            }
        }
        if (toplam == 3) {
            return 1;
        }
        return 0;
    }

    public ArrayList<Pokemon> kartlariOlustur() {
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

        return pokemon;
    }

}
