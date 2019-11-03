/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bthn0
 */
public class Squirtle extends Pokemon {//   subClass

   private int hasarPuani;
    private boolean kartKullanildiMi;

    public Squirtle(String pokemonAdi, String pokemonTip, int hasarPuani) {
        super(pokemonAdi, pokemonTip);
        this.hasarPuani = hasarPuani;
    }

    public Squirtle() {
        super("Bilinmeyen", "Bilinmeyen");
        this.hasarPuani = 0;
    }

    public int getHasarPuani() {
        return hasarPuani;
    }

    public void setHasarPuani(int hasarPuani) {
        this.hasarPuani = hasarPuani;
    }

    public boolean isKartKullanildiMi() {
        return kartKullanildiMi;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }

    @Override
    public void hasarPuaniGoster() {
        System.out.println(getPokemonAdi() + " Adlı Pokemonun Hasar Puanı: " + getHasarPuani());
    }

}