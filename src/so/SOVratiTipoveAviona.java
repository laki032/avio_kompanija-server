package so;

import db.DataBaseBroker;
import domain.AbstractDomainObject;
import domain.TipAviona;
import java.util.List;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOVratiTipoveAviona extends SOOpsta {

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
        ls = DataBaseBroker.getINSTANCE().selectSve((TipAviona) obj);
    }

}
