import java.util.*;
import java.io.*;

public class ScoreTrakker {
	public void loadDataFromFile(String name) {
		BufferedReader reader;
		try {
			File inputFile =  new File(name);
			reader = new BufferedReader(new FileReader(inputFile));
			
			try {
				String i;
				int runNum = 0;
				String tempName = "Ignore";
				while ((i = reader.readLine()) != null) {
					//System.out.println(i);
					runNum++;
					
					if ((runNum % 2) == 0) {	
						int tempInt = 0;
						try {
							tempInt = Integer.parseInt(i);
							
							if (tempInt <= 0) {
								throw new NumberFormatException();
							}
						} catch (NumberFormatException e) {
							badInt = "Incorrect format for " + tempName + " not a valid score: " + tempInt;
						}
							
						Student temp = new Student(tempName, tempInt);
						
						students.add(temp);
					} else {
						tempName = i;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			badFile = "Can't open file: " + name;
		}

	}
	
	// Sorts and prints students
	public void printlnOrder() {
		Collections.sort(students);
		for(Student person : students) {
			System.out.println(person.toString());
		}
	}
	
	// Calls loadDataFromFile & printInOrder
	public void processFiles() {
		for(String fileName : files) {
			students = new ArrayList<Student>();
			
			this.loadDataFromFile(fileName);
			
			System.out.println("Student Score List");
			this.printlnOrder();
			
			System.out.println("");
			System.out.println(this.badFile);
			System.out.println(this.badInt);
			System.out.println("");
		}
		
	}
	
	public static void main(String[] args) {
		ScoreTrakker trackScores = new ScoreTrakker();
		trackScores.processFiles();
	}
	
	// Private arrayList to hold all student objects 
	private ArrayList<Student> students;
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	private String badFile = "";
	private String badInt = "";
	
}
