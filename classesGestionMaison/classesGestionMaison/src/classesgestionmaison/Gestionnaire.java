/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesgestionmaison;

/**
 *
 * @author Pietro
 */
public class Gestionnaire {

    private Courtier courtier;
    private Maison maison;
    
    Gestionnaire(){
        courtier = new Courtier();
        maison = new Maison();
    }
    
    public Courtier getCourtier() {
        return courtier;
    }

    public void setCourtier(Courtier courtier) {
        this.courtier = courtier;
    }

    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }
    
}
