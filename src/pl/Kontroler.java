package pl;

import so.zaposleni.SONoviZaposleni;
import so.*;
import so.avion.*;
import so.zaposleni.*;
import so.association.*;
import so.pomocne.*;
import gui.ServerskaForma;
import db.DataBaseBroker;
import db.Util;
import domain.*;
import domain.association.*;
import domain.zaposleni.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import thread.NitKlijent;

/**
 *
 * @author Lazar Vujadinovic
 */
public class Kontroler {

    private static Kontroler INSTANCE;

    private final Map<String, Object> mapa;
    private final List<NitKlijent> onlineKlijenti;

    public static Kontroler getINSTANCE() {
        if (INSTANCE == null) {
            try {
                INSTANCE = new Kontroler();
            } catch (Exception ex) {

            }
        }
        return INSTANCE;
    }

    private Kontroler() throws Exception {
        mapa = new HashMap<>();
        onlineKlijenti = new ArrayList<>();
    }

    public Object vratiIzMape(String key) {
        return mapa.get(key);
    }

    public void staviUMapu(String key, Object value) {
        mapa.put(key, value);
    }

    public void ispisi(String zahtev) {
        ServerskaForma sf = (ServerskaForma) mapa.get("forma");
        sf.pristigaoZahtev(zahtev);
    }

    public void noviKorisnik(NitKlijent nk) {
        onlineKlijenti.add(nk);
    }

    public void izasaoKorisnik(NitKlijent nk) {
        onlineKlijenti.remove(nk);
    }

    public List<NitKlijent> getOnlineKlijenti() {
        return onlineKlijenti;
    }

//______________deo vezan za pomocne________________________________________________________
    public boolean login(String admin) throws Exception {
        SOLogin so = new SOLogin();
        so.izvrsiOperaciju(admin);
        return so.getRezultat();
    }

    public boolean logout(String admin) throws Exception {
        SOLogout so = new SOLogout();
        so.izvrsiOperaciju(admin);
        return so.getRezultat();
    }

    public Map<String, Object> vratiPodatkeOBazi(Object obj) {
        String baza = (String) obj;
        return Util.getINSTANCE().vratiPodatkeOBazi(baza);
    }

    public void promeniBazu(Object baza) throws Exception {
        String b = (String) baza;
        Util.getINSTANCE().postaviNovuBazu(b);
        DataBaseBroker.getINSTANCE().postavljenaJeNovaBaza();
    }

    public void novaBaza(String url, String user, String pass, String driver) throws Exception {
        Util.getINSTANCE().postaviNovuBazu(url, user, pass, driver);
        DataBaseBroker.getINSTANCE().postavljenaJeNovaBaza();
    }

//______________deo vezan za uloge__________________________________________________________
    public List<AbstractDomainObject> vratiUlogeZaKriterijum(Object kriterijum) throws Exception {
        SOVratiUloge so = new SOVratiUloge();
        so.izvrsiOperaciju(kriterijum);
        return so.getRezultat();
    }

    public boolean novaUloga(Object kriterijum) throws Exception {
        SONovaUloga so = new SONovaUloga();
        so.izvrsiOperaciju(kriterijum);
        return so.getRezultat();
    }

    public boolean izmenaUloge(Object kriterijum) throws Exception {
        SOIzmenaUloge so = new SOIzmenaUloge();
        so.izvrsiOperaciju(kriterijum);
        return so.getRezultat();
    }

    public boolean brisiUlogu(Uloga uloga) throws Exception {
        SOObrisiUlogu so = new SOObrisiUlogu();
        so.izvrsiOperaciju(uloga);
        return so.getRezultat();
    }

//______________deo vezan za licence__________________________________________________________
    public boolean novaLicenca(Licenca licenca) throws Exception {
        SONovaLicenca so = new SONovaLicenca();
        so.izvrsiOperaciju(licenca);
        return so.getRezultat();
    }

    public List<AbstractDomainObject> vratiLicenceZaKriterijum(Object parametar) throws Exception {
        SOVratiLicence so = new SOVratiLicence();
        so.izvrsiOperaciju(parametar);
        return so.getRezultat();
    }

    public boolean izmenaLicence(Object kriterijum) throws Exception {
        SOIzmenaLicence so = new SOIzmenaLicence();
        so.izvrsiOperaciju(kriterijum);
        return so.getRezultat();
    }

    public boolean brisiLicencu(Licenca l) throws Exception {
        SOObrisiLicencu so = new SOObrisiLicencu();
        so.izvrsiOperaciju(l);
        return so.getRezultat();
    }

//______________deo vezan za avione________________________________________________________
    public List<AbstractDomainObject> ucitajAvione() throws Exception {
        SOVratiSveAvione so = new SOVratiSveAvione();
        so.izvrsiOperaciju(new Avion());
        return so.getLs();
    }

    public boolean kreirajNoviAvion(Avion avion) throws Exception {
        SOKreirajNoviAvion so = new SOKreirajNoviAvion();
        so.izvrsiOperaciju(avion);
        return so.getRezultat();
    }

    public boolean izmeniAvion(Avion avion) throws Exception {
        SOIzmeniAvion so = new SOIzmeniAvion();
        so.izvrsiOperaciju(avion);
        return so.getRezultat();
    }

    public boolean obrisiAvion(Avion avion) throws Exception {
        SOObrisiAvion so = new SOObrisiAvion();
        so.izvrsiOperaciju(avion);
        return so.getRezultat();
    }

    public List<AbstractDomainObject> vratiTipoveAviona() throws Exception {
        SOVratiTipoveAviona so = new SOVratiTipoveAviona();
        so.izvrsiOperaciju(new TipAviona());
        return so.getLs();
    }

//______________deo vezan za zaposlene________________________________________________________
    public List<Pilot> vratiSvePilote() throws Exception {
        SOVratiSvePilote so = new SOVratiSvePilote();
        so.izvrsiOperaciju(new Pilot());
        return so.getRezultat();
    }

    public boolean noviZaposleni(AbstractDomainObject zap) throws Exception {
        SONoviZaposleni so = new SONoviZaposleni();
        so.izvrsiOperaciju(zap);
        return so.getRezultat();
    }

    public List<Zaposleni> vratiSveZaposlene() throws Exception {
        SOVratiSveZaposlene so = new SOVratiSveZaposlene();
        so.izvrsiOperaciju(new Zaposleni());
        return so.getRezultat();
    }

    public List<AbstractDomainObject> vratiPiloteZaKriterijum(Object parametar) throws Exception {
        SOVratiPilotePoKriterijumu so = new SOVratiPilotePoKriterijumu();
        so.izvrsiOperaciju(parametar);
        return so.getRezultat();
    }

    public List<AbstractDomainObject> vratiMehanicareZaKriterijum(Object parametar) throws Exception {
        SOVratiMehanicarePoKriterijumu so = new SOVratiMehanicarePoKriterijumu();
        so.izvrsiOperaciju(parametar);
        return so.getRezultat();
    }

    public List<AbstractDomainObject> vratiZaposleneZaKriterijum(Object parametar) throws Exception {
        SOVratiZaposlenePoKriterijumu so = new SOVratiZaposlenePoKriterijumu();
        so.izvrsiOperaciju(parametar);
        return so.getRezultat();
    }

    public boolean izmenaPilota(Pilot pilot) throws Exception {
        SOIzmenaPilota so = new SOIzmenaPilota();
        so.izvrsiOperaciju(pilot);
        return so.getRezultat();
    }

    public boolean izmenaZaposlenog(Zaposleni zaposleni) throws Exception {
        SOIzmenaZaposlenog so = new SOIzmenaZaposlenog();
        so.izvrsiOperaciju(zaposleni);
        return so.getRezultat();
    }

    public boolean izmenaMehanicara(AvioMehanicar avioMehanicar) throws Exception {
        SOIzmenaMehanicara so = new SOIzmenaMehanicara();
        so.izvrsiOperaciju(avioMehanicar);
        return so.getRezultat();
    }

    public boolean obrisiZaposlenog(Zaposleni zaposleni) throws Exception {
        SOBrisiZaposlenog so = new SOBrisiZaposlenog();
        so.izvrsiOperaciju(zaposleni);
        return so.getRezultat();
    }

    public boolean obrisiPilota(Pilot pilot) throws Exception {
        SOBrisiPilota so = new SOBrisiPilota();
        so.izvrsiOperaciju(pilot);
        return so.getRezultat();
    }

    public boolean obrisiMehanicara(AvioMehanicar avioMehanicar) throws Exception {
        SOBrisiMehanicara so = new SOBrisiMehanicara();
        so.izvrsiOperaciju(avioMehanicar);
        return so.getRezultat();
    }

}
