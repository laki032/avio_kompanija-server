package so.zaposleni;

import db.DataBaseBroker;
import domain.zaposleni.AvioMehanicar;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOIzmenaMehanicara  extends SOOpsta {

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
            DataBaseBroker.getINSTANCE().izmeni((AvioMehanicar) obj);
            rezultat = true;
        } catch (Exception e) {
            throw e;
        }
    }

}
