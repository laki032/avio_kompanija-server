package so.zaposleni;

import db.DataBaseBroker;
import domain.zaposleni.Pilot;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOBrisiPilota extends SOOpsta {

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
        DataBaseBroker.getINSTANCE().obrisi((Pilot) obj);
        rezultat = true;
    }

}
