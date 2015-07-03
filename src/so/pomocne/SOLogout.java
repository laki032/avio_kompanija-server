package so.pomocne;

import db.DataBaseBroker;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOLogout extends SOOpsta {

    private boolean izlogovan = false;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        //nema preduslova
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        String admin = (String) obj;
        DataBaseBroker.getINSTANCE().ulogujIzlogujAdmina(admin, false);
        izlogovan = true;
    }

    public boolean getRezultat() {
        return izlogovan;
    }

}
