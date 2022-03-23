package auto_radnja;

import java.util.List;
import auto_radnja.gume.AutoGuma;

/**
 * Predstavlja bilo koji tip radnje.
 * 
 * Sadrzi operacije dodavanja i pronalazenja automobilskih guma.
 * 
 * @author Dragon
 * @version 1.0.0
 *
 */
public interface Radnja {

	/**
	 * Dodaje automobilsku gumu u radnju.
	 * 
	 * Guma se dodaje u radnju samo ako nije vec u radnji i ako nije null.
	 * 
	 * @param a referenca na gumu koju treba uneti u radnju
	 * @throws java.lang.NullPointerException     u slucaju da je uneta referenca
	 *                                            null
	 * @throws java.lang.IllegalArgumentException u slucaju da uneta guma vec
	 *                                            postoji u radnji
	 */
	void dodajGumu(AutoGuma a);

	/**
	 * Vraca podatke o gumama koje imaju unetu vrednost marke i modela.
	 * 
	 * @param markaModel vrednost atributa markaModel prema kojem ce se pretrazivati
	 *                   gume
	 * @return podaci o odgovarjucim gumama kao lista klase AutoGuma
	 */
	List<AutoGuma> pronadjiGumu(String markaModel);

	/**
	 * Vraca podatke o svim gumama koje su trenutno u radnji.
	 * 
	 * @return podaci o svim gumama kao lista klase AutoGuma
	 */
	List<AutoGuma> vratiSveGume();
}
