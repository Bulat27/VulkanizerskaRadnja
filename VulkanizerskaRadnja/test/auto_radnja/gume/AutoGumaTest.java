package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma ag;

	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void TestAutoGuma() {
		assertEquals(null, ag.getMarkaModel());
		assertEquals(-1, ag.getPrecnik());
		assertEquals(-1, ag.getSirina());
		assertEquals(-1, ag.getVisina());
	}

	@Test
	void TestAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Michelin", 15, 150, 70);

		assertEquals("Michelin", ag.getMarkaModel());
		assertEquals(15, ag.getPrecnik());
		assertEquals(150, ag.getSirina());
		assertEquals(70, ag.getVisina());
	}

	@ParameterizedTest
	@CsvSource({ "Continental", "Michelin", "Sava", "Linglong" })
	void testSetMarkaModel(String markaModel) {
		ag.setMarkaModel(markaModel);

		assertEquals(markaModel, ag.getMarkaModel());
	}

	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> ag.setMarkaModel(null));
	}

	@Test
	void testSetMarkaModelIzvanDozvoljenogOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setMarkaModel("Z"));
	}

	@ParameterizedTest
	@CsvSource({ "18", "21", "13", "22", "15", "17" })
	void testSetPrecnik(int precnik) {
		ag.setPrecnik(precnik);

		assertEquals(precnik, ag.getPrecnik());
	}

	@Test
	void testSetPrecniklPrekoDozvoljenogOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setPrecnik(27));
	}

	@Test
	void testSetPrecniklIspodDozvoljenogOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setPrecnik(3));
	}

	@ParameterizedTest
	@CsvSource({ "270", "210", "156", "333", "273", "355" })
	void testSetSirina(int sirina) {
		ag.setSirina(sirina);

		assertEquals(sirina, ag.getSirina());
	}

	@Test
	void testSetSirinaPrekoDozvoljenogOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setSirina(1000));
	}

	@Test
	void testSetSirinaIspodDozvoljenogOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setSirina(20));
	}

	@ParameterizedTest
	@CsvSource({ "27", "33", "55", "66", "70", "93" })
	void testSetVisina(int visina) {
		ag.setVisina(visina);

		assertEquals(visina, ag.getVisina());
	}

	@Test
	void testSetVisinaPrekoDozvoljenogOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setVisina(100));
	}

	@Test
	void testSetVisinaIspodDozvoljenogOpsega() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setVisina(15));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("Linglong");
		ag.setPrecnik(20);
		ag.setSirina(200);
		ag.setVisina(27);

		String str = ag.toString();

		assertTrue(str.contains("Linglong"));
		assertTrue(str.contains("20"));
		assertTrue(str.contains("200"));
		assertTrue(str.contains("27"));
	}

	@ParameterizedTest
	@CsvSource({ "Continental, 15, 212, 50, Continental, 15, 212, 50, true",
			"Continental, 15, 212, 50, Linglong, 15, 212, 50, false",
			"Continental, 20, 212, 50, Continental, 15, 212, 50, false",
			"Continental, 15, 212, 50, Continental, 15, 213, 50, false",
			"Continental, 15, 212, 59, Continental, 15, 212, 50, false",
			"Sava, 17, 243, 66, Linglong, 15, 212, 50, false", })
	void testEquals(String markaModel1, int precnik1, int sirina1, int visina1, String markaModel2, int precnik2,
			int sirina2, int visina2, boolean result) {

		ag.setMarkaModel(markaModel1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);

		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel(markaModel2);
		ag2.setPrecnik(precnik2);
		ag2.setSirina(sirina2);
		ag2.setVisina(visina2);

		assertEquals(result, ag.equals(ag2));
	}
}
