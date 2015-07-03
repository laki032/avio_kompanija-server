package so.association;

import db.DataBaseBroker;
import domain.association.Licenca;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SONovaLicenca extends SOOpsta {

    boolean rezultat;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        rezultat = false;
        Licenca l = (Licenca) obj;
        DataBaseBroker.getINSTANCE().kreirajNovi(l);
        rezultat = true;
    }

    public boolean getRezultat() {
        return rezultat;
    }

}
