package so.zaposleni;

import db.DataBaseBroker;
import domain.AbstractDomainObject;
import domain.zaposleni.Pilot;
import java.util.ArrayList;
import java.util.List;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOVratiSvePilote extends SOOpsta {

    List<AbstractDomainObject> rezultat;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        rezultat = DataBaseBroker.getINSTANCE().selectSve(new Pilot());
    }

    public List<Pilot> getRezultat() {
        List<Pilot> lp = new ArrayList<>();
        for (AbstractDomainObject ado : rezultat) {
            lp.add((Pilot) ado);
        }
        return lp;
    }

}
