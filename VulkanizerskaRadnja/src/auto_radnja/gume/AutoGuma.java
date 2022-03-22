package auto_radnja.gume;

/**
 * Predstavlja automobilsku gumu.
 * 
 * Automobilska guma sadrzi cetiri atributa koji predstavljaju relevantne
 * parametre za ovaj proizvod. Pomenuti atributi su markaModel, precnik, sirina
 * i visina gume.
 * 
 * @author Dragon
 * @version 1.0
 *
 */
public class AutoGuma {

	/**
	 * Marka i model automobilske gume, podrazumevana vrednost je null
	 */
	private String markaModel = null;

	/**
	 * Precnik automobilske gume, podrazumevana vrednost je -1
	 */
	private int precnik = -1;

	/**
	 * Sirina automobilske gume, podrazumevana vrednost je -1
	 */
	private int sirina = -1;

	/**
	 * Visina automobilske gume, podrazumevana vrednost je -1
	 */
	private int visina = -1;

	/**
	 * Postavlja atribute na podrazumevane vrednosti.
	 */
	public AutoGuma() {
	}

	/**
	 * Postavlja atribute markaModel, precnik, sirina i visina na unete vrednosti.
	 * 
	 * @param markaModel nova vrednost za marku i model
	 * @param precnik    nova vrednost za precnik
	 * @param sirina     nova vrednost za sirinu
	 * @param visina     nova vrednost za visinu
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca trenutnu vrednost atributa markaModel.
	 * 
	 * @return marka i model automobilske gume kao String
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja novu vrednost atributa markaModel.
	 * 
	 * @param markaModel nova vrednost atributa markaModel
	 * @throws java.lang.NullPointerException     u slucaju da je uneta vrednost
	 *                                            null
	 * @throws java.lang.IllegalArgumentException u slucaju da uneta vrednost sadrzi
	 *                                            manje od tri znaka
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new IllegalArgumentException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca trenutnu vrednost atributa precnik.
	 * 
	 * @return precnik automobilske gume kao ceo broj
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja novu vrednost atributa precnik.
	 * 
	 * @param precnik nova vrednost atributa precnik
	 * @throws java.lang.IllegalArgumentException u slucaju da je uneta vrednost
	 *                                            izvan dozvoljenog opsega (mora
	 *                                            biti izmedju 13 i 22 inkluzivno)
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new IllegalArgumentException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca trenutnu vrednost atributa sirina
	 * 
	 * @return sirina automobilske gume kao ceo broj
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja novu vrednost atributa sirina
	 * 
	 * @param sirina nova vrednost atributa sirina
	 * @throws java.lang.IllegalArgumentException u slucaju da je uneta vrednost
	 *                                            izvan dozvoljenog opsega (mora
	 *                                            biti izmedju 135 i 355 inkluzivno)
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new IllegalArgumentException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca trenutnu vrednost atributa visina
	 * 
	 * @return visina automobilske gume kao ceo broj
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja novu vrednost atributa visina
	 * 
	 * @param visina nova vrednost atributa visina
	 * @throws java.lang.IllegalArgumentException u slucaju da je uneta vrednost
	 *                                            izvan dozvoljenog opsega (mora
	 *                                            biti izmedju 25 i 95 inkluzivno)
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new IllegalArgumentException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca sve vrednosti atributa automobilske gume kao jedan String.
	 * 
	 * @return String koji sadrzi sve podatke o automobilskoj gumi tj. vrednosti
	 *         svih atributa
	 */

	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve automobilske gume po vrednostima svih atributa tj. po atributima:
	 * markaModel, precnik, sirina i visina.
	 * 
	 * @return
	 *         <ul>
	 *         <li>true - ukoliko su vrednosti svih atributa jednake kod dve
	 *         automobilske gume koje se porede</li>
	 *         <li>false - u svakom drugom slucaju</li>
	 *         </ul>
	 */

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}
}
