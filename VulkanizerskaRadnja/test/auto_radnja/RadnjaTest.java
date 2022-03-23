package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Linglong");
		ag.setPrecnik(20);
		ag.setSirina(227);
		ag.setVisina(40);

		radnja.dodajGumu(ag);

		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(ag, radnja.vratiSveGume().get(0));
	}

	@Test
	void testDodajGumuViseGuma() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Linglong");
		ag1.setPrecnik(20);
		ag1.setSirina(227);
		ag1.setVisina(40);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Continental");
		ag2.setPrecnik(17);
		ag2.setSirina(150);
		ag2.setVisina(80);

		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);

		assertEquals(2, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(ag1));
		assertTrue(radnja.vratiSveGume().contains(ag2));
	}

	@Test
	void testDodajGumuPonavljanje() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Linglong");
		ag1.setPrecnik(20);
		ag1.setSirina(227);
		ag1.setVisina(40);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Linglong");
		ag2.setPrecnik(20);
		ag2.setSirina(227);
		ag2.setVisina(40);

		radnja.dodajGumu(ag1);

		assertThrows(RuntimeException.class, () -> radnja.dodajGumu(ag2));
	}

	@Test
	void testDodajGumuNull() {
		assertThrows(NullPointerException.class, () -> radnja.dodajGumu(null));
	}

	@Test
	void pronadjiGumuNull() {
		List<AutoGuma> autoGume = radnja.pronadjiGumu(null);

		assertEquals(null, autoGume);
	}

	@Test
	void pronadjiGumuPraznaLista() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Linglong");
		ag1.setPrecnik(20);
		ag1.setSirina(227);
		ag1.setVisina(40);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Continental");
		ag2.setPrecnik(17);
		ag2.setSirina(150);
		ag2.setVisina(80);

		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);

		List<AutoGuma> autoGume = radnja.pronadjiGumu("Michelin");

		assertEquals(0, autoGume.size());
	}

	@Test
	void pronadjiGumuJednaGuma() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Linglong");
		ag1.setPrecnik(20);
		ag1.setSirina(227);
		ag1.setVisina(40);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Linglong");
		ag2.setPrecnik(17);
		ag2.setSirina(150);
		ag2.setVisina(80);

		AutoGuma ag3 = new AutoGuma();
		ag3.setMarkaModel("Continental");
		ag3.setPrecnik(17);
		ag3.setSirina(150);
		ag3.setVisina(80);

		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);
		radnja.dodajGumu(ag3);

		List<AutoGuma> autoGume = radnja.pronadjiGumu("Continental");

		assertEquals(1, autoGume.size());
	}

	@Test
	void pronadjiGumuViseGuma() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Linglong");
		ag1.setPrecnik(20);
		ag1.setSirina(227);
		ag1.setVisina(40);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Linglong");
		ag2.setPrecnik(17);
		ag2.setSirina(150);
		ag2.setVisina(80);

		AutoGuma ag3 = new AutoGuma();
		ag3.setMarkaModel("Continental");
		ag3.setPrecnik(17);
		ag3.setSirina(150);
		ag3.setVisina(80);

		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);
		radnja.dodajGumu(ag3);

		List<AutoGuma> autoGume = radnja.pronadjiGumu("Linglong");

		assertEquals(2, autoGume.size());
	}

	@Test
	void vratiSveGume() {
		AutoGuma ag1 = new AutoGuma();
		ag1.setMarkaModel("Linglong");
		ag1.setPrecnik(20);
		ag1.setSirina(227);
		ag1.setVisina(40);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Linglong");
		ag2.setPrecnik(17);
		ag2.setSirina(150);
		ag2.setVisina(80);

		radnja.dodajGumu(ag1);
		radnja.dodajGumu(ag2);

		assertEquals(2, radnja.vratiSveGume().size());
		assertTrue(radnja.vratiSveGume().contains(ag1));
		assertTrue(radnja.vratiSveGume().contains(ag2));

	}
}
