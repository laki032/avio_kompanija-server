package so.zaposleni;

import db.DataBaseBroker;
import domain.zaposleni.Pilot;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOIzmenaPilota extends SOOpsta {

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
            DataBaseBroker.getINSTANCE().izmeni((Pilot) obj);
            rezultat = true;
        } catch (Exception e) {
            throw e;
        }
    }

}