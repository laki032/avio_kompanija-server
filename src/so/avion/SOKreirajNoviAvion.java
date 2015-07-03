package so.avion;

import db.DataBaseBroker;
import domain.Avion;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOKreirajNoviAvion extends SOOpsta {

    private boolean ubacen = false;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
//        "nema preduslova"
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        int sifra = DataBaseBroker.getINSTANCE().vratiSledecuSifruZa((Avion) obj);
        Avion avion = (Avion) obj;
        avion.setAvionID(sifra);
        try {
            DataBaseBroker.getINSTANCE().kreirajNovi((Avion) obj);
            ubacen = true;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean getRezultat() {
        return ubacen;
    }

}
