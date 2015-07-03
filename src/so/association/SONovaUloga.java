package so.association;

import db.DataBaseBroker;
import domain.association.Uloga;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SONovaUloga extends SOOpsta {

    boolean rezultat;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        rezultat = false;
        Uloga u = (Uloga) obj;
        DataBaseBroker.getINSTANCE().kreirajNovi(u);
        rezultat = true;
    }

    public boolean getRezultat() {
        return rezultat;
    }

}
