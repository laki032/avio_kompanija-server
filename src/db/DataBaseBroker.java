package db;

import domain.AbstractDomainObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Lazar Vujadinovic
 */
public final class DataBaseBroker {

    private static DataBaseBroker INSTANCE;
    private Connection connection;

    private String url;
    private String user;
    private String password;
    private String driver;

    private DataBaseBroker() {
        postavljenaJeNovaBaza();
    }

    public static DataBaseBroker getINSTANCE() throws Exception {
        if (INSTANCE == null) {
            INSTANCE = new DataBaseBroker();
        }
        return INSTANCE;
    }

    public void postavljenaJeNovaBaza() {
        url = Util.getINSTANCE().getDBURL();
        user = Util.getINSTANCE().getDBUser();
        password = Util.getINSTANCE().getDBPassword();
        driver = Util.getINSTANCE().getDBDriver();
    }

    public void ucitajDrajver() throws Exception {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            throw new Exception("Sistem nije uspeo da ucita drajver.");
        }
    }

    public void otvoriKonekciju() throws Exception {
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da se poveze sa bazom.");
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            connection.commit();
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da sacuva transakciju.");
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da ponisti transakciju.");
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            connection.close();
        } catch (SQLException ex) {
            throw new Exception("Sistem nije uspeo da zatvori konkciju ka bazi.");
        }
    }

    public List<AbstractDomainObject> selectSve(AbstractDomainObject ado) throws Exception {
        try {//mozda zeza null u dajUslovZaSelect pa vrati na ado
            String upit = "SELECT * FROM " + ado.vratiNazivTabele() + " " + ado.dajUslovZaSelect(null) + " ORDER BY " + ado.vratiNazivTabele() + "." + ado.vratiNazivPK();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            return ado.napuni(rs, ado);
        } catch (Exception ex) {
            throw new Exception("Greska pri ucitavanju liste objekata!");
        }
    }

    public List<AbstractDomainObject> selectPoKriterijumu(AbstractDomainObject ado, AbstractDomainObject filter) throws Exception {
        try {
            String upit = "SELECT * " + ado.dajUslovZaSelect(filter) + " ORDER BY " + ado.vratiNazivTabele() + "." + ado.vratiNazivPK();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(upit);
            return ado.napuni(rs, ado);
        } catch (Exception ex) {
            throw new Exception("Greska pri ucitavanju liste objekata!");
        }
    }

    public int vratiSledecuSifruZa(AbstractDomainObject obj) throws Exception {
        try {
            String upit = "SELECT MAX (" + obj.vratiNazivPK() + ") AS sifra FROM " + obj.vratiNazivTabele();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(upit);
            rs.next();
            int sifra = rs.getInt(1);
            statement.close();
            return ++sifra;
        } catch (Exception ex) {
            throw new Exception("Greska pri trazenju sledece sifre!");
        }
    }

    public void kreirajNovi(AbstractDomainObject obj) throws Exception {
        try {
            String upit = "INSERT INTO " + obj.vratiNazivTabele() + " " + obj.vratiRedosledZaInsert() + " VALUES (" + obj.vratiVrednostiZaInsert() + ")";
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit);
            statement.close();
        } catch (Exception ex) {
            throw new Exception("Greska pri unosu novog objekta!");
        }
    }

    public void izmeni(AbstractDomainObject obj) throws Exception {
        try {
            String upit = "UPDATE " + obj.vratiNazivTabele() + " SET " + obj.vratiVrednostiZaUpdate()
                    + " WHERE " + obj.vratiNazivPK() + " = " + obj.vratiVrednostPK();
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit);
            statement.close();
        } catch (Exception ex) {
            throw new Exception("Greska pri izmeni objekta!");
        }
    }

    public void obrisi(AbstractDomainObject obj) throws Exception {
        try {
            String upit = "DELETE FROM " + obj.vratiNazivTabele()
                    + " WHERE " + obj.vratiNazivPK() + " = " + obj.vratiVrednostPK();
            Statement statement = connection.createStatement();
            statement.executeUpdate(upit);
            statement.close();
        } catch (Exception ex) {
            throw new Exception("Greska pri brisanju objekta!");
        }
    }

    public boolean validacijaAdmina(String kIme, String kSifra) throws Exception {
        try {
            String upit = "SELECT * FROM Admin WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setString(1, kIme);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String pass = rs.getString("password");
                if (pass.equals(kSifra)) {
                    rs.close();
                    ps.close();
                    ulogujIzlogujAdmina(kIme, true);
                    return true;
                }
            }
        } catch (Exception ex) {
            throw new Exception("Greska pri validaciji admina!");
        }
        return false;
    }

    public void ulogujIzlogujAdmina(String kIme, boolean uloguj) throws Exception {
        try {
            String upit = "UPDATE Admin SET ulogovan = ?, lastLogin = ? WHERE username = ?";
            PreparedStatement ps = connection.prepareStatement(upit);
            ps.setBoolean(1, uloguj);
            ps.setDate(2, new Date(new java.util.Date().getTime()));
            ps.setString(3, kIme);
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            throw new Exception("Greska pri izmeni objekta!");
        }
    }

}
