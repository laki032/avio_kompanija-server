package so.zaposleni;

import db.DataBaseBroker;
import domain.AbstractDomainObject;
import domain.association.Uloga;
import domain.zaposleni.AvioMehanicar;
import java.util.List;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOVratiMehanicarePoKriterijumu extends SOOpsta {

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
        rezultat = DataBaseBroker.getINSTANCE().selectPoKriterijumu(new AvioMehanicar(), (AbstractDomainObject) obj);
    }

}
