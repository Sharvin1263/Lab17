
public class Country {

	protected String name;
	protected int population;

	public Country() {
		super();
	}

	public Country(String name, int population) {
		super();
		this.name = name;
		this.population = population;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Countries [name=" + name + ", population=" + population + "]";
	}

}
