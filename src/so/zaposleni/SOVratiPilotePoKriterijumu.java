package so.zaposleni;

import db.DataBaseBroker;
import domain.AbstractDomainObject;
import domain.zaposleni.Pilot;
import java.util.List;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOVratiPilotePoKriterijumu extends SOOpsta {

    List<AbstractDomainObject> rezultat;

    public List<AbstractDomainObject> getRezultat() {
        return rezultat;
    }

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        //nema preduslova
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        rezultat = DataBaseBroker.getINSTANCE().selectPoKriterijumu(new Pilot(), (AbstractDomainObject) obj);
    }

}
