package so.avion;

import db.DataBaseBroker;
import domain.Avion;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOObrisiAvion extends SOOpsta {

    private boolean rezultat = false;

    public boolean getRezultat() {
        return rezultat;
    }

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        //admin ulogovan
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        try {
            DataBaseBroker.getINSTANCE().obrisi((Avion) obj);
            rezultat = true;
        } catch (Exception e) {
            throw e;
        }
    }

}
