/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelimeoyunu;

import java.util.Objects;

/**
 *
 * @author Yakup
 */
public class Soru implements java.io.Serializable {

    String tanım;
    String kelime;

    public Soru(String tanım, String kelime) {
        this.tanım = tanım;
        this.kelime = kelime;
    }

    public String getTanım() {
        return tanım;
    }

    public void setTanım(String tanım) {
        this.tanım = tanım;
    }

    public String getKelime() {
        return kelime;
    }

    public void setKelime(String kelime) {
        this.kelime = kelime;
    }

    public boolean equals(Soru soru) {
        return (this.tanım.equals(soru.tanım) && this.kelime.equals(soru.kelime));
    }

}
