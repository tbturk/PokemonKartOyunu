/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bthn0
 */
public abstract class Pokemon {//   superclass

    private int pokemonID;
    private String pokemonAdi;
    private String pokemonTip;

    public Pokemon() {//parametresiz constructor 
        /*this.pokemonAdi = "Adi Bilinmeyen";
        this.pokemonTip = "Tipi Bilinmeyen";*/ //Aşağıdaki yanımmlamada daha basite indirgedik.
        this("Bilinmeyen", "Bilinmeyen");
    }

    public Pokemon(String pokemonAdi, String pokemonTip) {//parametreli constructor (overload ettik)
        this.pokemonAdi = pokemonAdi;
        this.pokemonTip = pokemonTip;
    }

    public int getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
    }

    public String getPokemonAdi() {
        return pokemonAdi;
    }

    public void setPokemonAdi(String pokemonAdi) {
        this.pokemonAdi = pokemonAdi;
    }

    public String getPokemonTip() {
        return pokemonTip;
    }

    public void setPokemonTip(String pokemonTip) {
        this.pokemonTip = pokemonTip;
    }
    
    

    abstract void hasarPuaniGoster();
    
}
