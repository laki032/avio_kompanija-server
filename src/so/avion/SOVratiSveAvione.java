package so.avion;

import db.DataBaseBroker;
import domain.AbstractDomainObject;
import domain.Avion;
import java.util.List;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOVratiSveAvione extends SOOpsta {

    List<AbstractDomainObject> ls;

    public List<AbstractDomainObject> getLs() {
        return ls;
    }

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        //nema preduslova
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        ls = DataBaseBroker.getINSTANCE().selectSve((Avion) obj);
    }
}
