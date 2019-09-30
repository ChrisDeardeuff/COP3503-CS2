import java.io.*;
import java.util.*;
import java.io.PrintWriter;

public class ReadFileLineByLine {
	public static void main(String[] args) {
		String line;
		try {

			// Create a File instance
			java.io.File formulas = new java.io.File("formulas.txt");
			java.io.File results = new java.io.File("results.txt");

			// Create a Scanner for the file
			Scanner input = new Scanner(formulas);
			PrintWriter output = new PrintWriter(results);

			// Read data from a file
			while (input.hasNext()) {
				line = input.next();
				ArrayList<String> formulasList = new ArrayList<String>();// creates array list
				formulasList.add(line);// adds formulas to array list
				System.out.println("read <" + line + ">"); // prints formulas
				

				int index = line.indexOf("+");
				int index1 = line.indexOf("-");
				int index2 = line.indexOf("*");
				int index3 = line.indexOf("/");

				double result = 0;

				if (index > -1) {

					double First = Integer.parseInt(line.substring(0, 1));
					double Second = Integer.parseInt(line.substring(2));

					result = First + Second;

				} else if (index1 > -1) {

					double First = Integer.parseInt(line.substring(0, 1));
					double Second = Integer.parseInt(line.substring(2));

					result = First - Second;

				} else if (index2 > -1) {

					double First = Integer.parseInt(line.substring(0, 1));
					double Second = Integer.parseInt(line.substring(2));

					result = First * Second;

				} else if (index3 > -1) {

					double First = Integer.parseInt(line.substring(0, 1));
					double Second = Integer.parseInt(line.substring(2));

					result = First / Second;

				}

				System.out.println(formulasList.get(0) + " = " + result);

				// results
				output.println(formulasList.get(0) + " = " + result);

				// Close the files
			}
			output.close();
			input.close();

		} catch (FileNotFoundException e) {
			// Display meaningful error message

			System.out.print("No file found!");
		}
	}
}