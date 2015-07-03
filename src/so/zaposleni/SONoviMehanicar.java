package so.zaposleni;

import db.DataBaseBroker;
import domain.Avion;
import domain.zaposleni.AvioMehanicar;
import domain.zaposleni.Zaposleni;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SONoviMehanicar extends SOOpsta {

    private boolean ubacen = false;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        DataBaseBroker.getINSTANCE().kreirajNovi((Zaposleni) obj);
        ubacen = true;
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        DataBaseBroker.getINSTANCE().kreirajNovi((AvioMehanicar) obj);
        ubacen = true;
    }

    public boolean getRezultat() {
        return ubacen;
    }

}
