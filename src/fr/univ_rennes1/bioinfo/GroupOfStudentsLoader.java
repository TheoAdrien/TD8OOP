package fr.univ_rennes1.bioinfo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * A class containing methods for generating instances of the {@link GroupOfStudents} class from external resources.
 * The methods should normally belong to the GroupOfStudents class but were moved here for being shared without interfering with the GroupOfStudents class t be developed by the students.
 * 
 * @author Olivier Dameron
 *
 */
public class GroupOfStudentsLoader {
	
	/**
	 * Generates an instance of the {@link GroupOfStudents} class.
	 * Each line describes a student, with the identifier and the grade separated by a tabulation.
	 * 
	 * @param filePath path of the tab-separated file.
	 * @return an instance of GroupOfStudents composed of the students described in the file.
	 */
	public static GroupOfStudents loadTsvFile(String filePath) {
		GroupOfStudents GroupOfStudentsResults = new GroupOfStudents();
		try {
			Scanner scanner = new Scanner(new File(filePath));
			String currentLine = "";
			while (scanner.hasNextLine()){
				currentLine = scanner.nextLine();
				String[] currentValues = currentLine.replace("\n", "").split("\t");
				if (currentValues.length == 2) {
					//GroupOfStudentsResults.add(new Student(currentValues[0], Double.parseDouble(currentValues[1])));
					GroupOfStudentsResults.add(new Student(currentValues[0] + "_" + currentValues[1], Double.parseDouble(currentValues[1])));
				}
			}
			scanner.close();
		}
		catch (NullPointerException e) {
			e.printStackTrace();
			System.exit(1);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
			System.exit(2);
		}
		return GroupOfStudentsResults;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GroupOfStudents m1bio = GroupOfStudentsLoader.loadTsvFile("/path/to/grades_anonymized.tsv");
		
		System.out.println("Grade min: " + m1bio.getMinGrade());
		System.out.println("Grade max: " + m1bio.getMaxGrade());
		System.out.println("Average: " + m1bio.getAverageGrade());
	}

}
