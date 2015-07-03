package so.zaposleni;

import db.DataBaseBroker;
import domain.AbstractDomainObject;
import domain.zaposleni.Zaposleni;
import java.util.ArrayList;
import java.util.List;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOVratiSveZaposlene extends SOOpsta {

    List<AbstractDomainObject> rezultat;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        rezultat = DataBaseBroker.getINSTANCE().selectSve(new Zaposleni());
    }

    public List<Zaposleni> getRezultat() {
        List<Zaposleni> lp = new ArrayList<>();
        for (AbstractDomainObject ado : rezultat) {
            lp.add((Zaposleni) ado);
        }
        return lp;
    }

}
