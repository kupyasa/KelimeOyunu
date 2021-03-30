/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelimeoyunu;

/**
 *
 * @author Yakup
 */
public class Oyuncu implements java.io.Serializable {

    String oyuncuAdı;
    int puan;
    int kalanSüre;
    String tarih;
    String zaman;

    public Oyuncu(String oyuncuAdı, int puan, int kalanSüre, String tarih, String zaman) {
        this.oyuncuAdı = oyuncuAdı;
        this.puan = puan;
        this.kalanSüre = kalanSüre;
        this.tarih = tarih;
        this.zaman = zaman;
    }

    public String getOyuncuAdı() {
        return oyuncuAdı;
    }

    public void setOyuncuAdı(String oyuncuAdı) {
        this.oyuncuAdı = oyuncuAdı;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getKalanSüre() {
        return kalanSüre;
    }

    public void setKalanSüre(int kalanSüre) {
        this.kalanSüre = kalanSüre;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getZaman() {
        return zaman;
    }

    public void setZaman(String zaman) {
        this.zaman = zaman;
    }

}
