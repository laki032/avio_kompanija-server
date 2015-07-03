package so.zaposleni;

import db.DataBaseBroker;
import domain.zaposleni.Pilot;
import domain.zaposleni.Zaposleni;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SONoviPilot extends SOOpsta {

    private boolean ubacen = false;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        DataBaseBroker.getINSTANCE().kreirajNovi((Zaposleni) obj);
        ubacen = true;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DataBaseBroker.getINSTANCE().kreirajNovi((Pilot) obj);
        ubacen = true;
    }

    public boolean getRezultat() {
        return ubacen;
    }

}