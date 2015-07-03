package so.zaposleni;

import db.DataBaseBroker;
import domain.zaposleni.AvioMehanicar;
import domain.zaposleni.Pilot;
import domain.zaposleni.Zaposleni;
import so.SOOpsta;

/**
 *
 * @author Lazar Vujadinovic
 */
public class SONoviZaposleni extends SOOpsta {

    boolean rezultat;

    @Override
    protected void proveriPreduslov(Object obj) throws Exception {
    }

    @Override
    protected void izvrsiKonkretnuOperaciju(Object obj) throws Exception {
        Zaposleni z = (Zaposleni) obj;
        Zaposleni novi = new Zaposleni(z.getJmbg(), z.getImePrezime(), z.getGodinaRodjenja());
        DataBaseBroker.getINSTANCE().kreirajNovi(novi);
        try{
            Pilot p = (Pilot) z;
            DataBaseBroker.getINSTANCE().kreirajNovi(p);
        } catch(Exception e){
            AvioMehanicar am = (AvioMehanicar) z;
            DataBaseBroker.getINSTANCE().kreirajNovi(am);
        }
    }

    public boolean getRezultat() {
        return rezultat;
    }

}
