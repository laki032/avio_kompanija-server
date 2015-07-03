package so.pomocne;

import db.DataBaseBroker;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SOLogin extends SOOpsta{

    private boolean ulogovan = false;
    
    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
        //nema preduslova
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        String admin = (String) obj;
        String[] podaci = admin.split("/");
        ulogovan = DataBaseBroker.getINSTANCE().validacijaAdmina(podaci[0], podaci[1]);
    }
    
    public boolean getRezultat(){
        return ulogovan;
    }
    
}