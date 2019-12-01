/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bthn0
 */
public abstract class Oyuncu {// superclass

    private String oyuncuAdi;
    private int oyuncuID;
    private int skor;
    public String kartListesi[][] = new String[3][2];

    public Oyuncu(String oyuncuAdi, int oyuncuID, int skor) {
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuID = oyuncuID;
        this.skor = skor;
    }

    public Oyuncu() {
        this("Bilinmeyen", 0, 0);
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor += skor;
    }

    public String[][] getKartListesi() {
        for(int i=0; i<3;i++){
            System.out.println(kartListesi[i][0]);
        }
        return kartListesi;
    }

    public void setKartListesi(String[][] kartListesi) {
        this.kartListesi = kartListesi;
    }

    public void skorGoster() {
        System.out.println(this.oyuncuAdi + "Adlı Kullanıcının Skoru" + getSkor());
    }

    abstract int kartSec(String[][] a);  // oyuncu ve bilgisayar için overRide edilecek.

}
