import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CountryIoApp {

	public static void main(String[] args) throws IOException {

		Scanner scnr = new Scanner(System.in);

		boolean flag1 = false;
		boolean isValid;

		System.out.print("Welcome to the Countries Maintenance Application!\n");

		do {
			int userInput = 0;
			do {
				System.out.println("\nPlease choose from the following options:");
				System.out.println("-----------------------------------------");
				System.out.println("1. Display the list of countries");
				System.out.println("2. Add the name of a country");
				System.out.println("3. Exit");

//Validate user input against non integers.

				try {
					userInput = scnr.nextInt();

					isValid = true;
					scnr.nextLine();

				} catch (InputMismatchException ex) {
					scnr.nextLine();
					System.out.println("Invalid entry. Please try again.");
					isValid = false;
					continue;
				}
			} while (!isValid);

//User input selection.

			// Print country list.

			if (userInput == 1) {

				List<Country> country = CountryFileUtil.readFile();

				System.out.println("Country          Population");
				System.out.println("---------------------------");

				for (Country c : country) {
					System.out.printf("%-15s %,-10d\n", c.getName(), c.getPopulation());
				}

				// Enter country and population.

			} else if (userInput == 2) {

				System.out.println("Enter the name of a country: ");
				String name = scnr.nextLine();

				System.out.print("Enter the country's current population: ");
				int population = scnr.nextInt();

				Country newCountry = new Country(name, population);
				newCountry.setName(name);
				newCountry.setPopulation(population);

				CountryFileUtil.appendToFile(newCountry);

				// End session

			} else if (userInput == 3) {
				System.out.println("Goodbye!");
				flag1 = true;

				// Check for correct integer input.

			} else {
				System.out.println("Invalid entry. Please try again");
			}

		} while (!flag1);
		scnr.close();
	}

}
