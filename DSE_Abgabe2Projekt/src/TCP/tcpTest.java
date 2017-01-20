package TCP;

import management.Benutzerverwaltung;
import management.Produktgruppeverwaltung;
import management.Produktverwaltung;
import modell.Benutzer;
import modell.Produkt;
import modell.Produktgruppe;

import java.util.List;

/**
 * Created by josefweber on 20.01.17.
 */
public class tcpTest {

    public static void main(String args[]){

        Produktverwaltung prodver = Produktverwaltung.getinstance();

        List<Produkt> produkte = prodver.getProduktListe();
        for (Produkt p : produkte){
            System.out.println(p.getName() + " - " + " - " + p.getAktuellesGebot());
        }


        Produktgruppeverwaltung pg = Produktgruppeverwaltung.getinstance();

        List<Produktgruppe> pgl = pg.getProduktgruppeList();
        for (Produktgruppe p : pgl){
            System.out.println(p.getName());
        }

/*
        //Benutzerverwaltung bv = Benutzerverwaltung.getInstance();
        Benutzerverwaltung benver = Benutzerverwaltung.getInstance();

        List<Benutzer> benutzer = benver.getBenutzerListe();

        if (benutzer.size() != 0) {
            System.out.println("Size: " + benutzer.size());
            for (Benutzer b : benutzer) {
                System.out.println(b.getUsername() + " - " + b.getPassword());
            }
        }
*/

    }
}
