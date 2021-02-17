// Authors: Justin Orji, Gregory Manley
//
// //

public class Student implements Comparable<Student>{
	// Declaration of private variables and creation of constructor
	private String name;
	private int score;
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	// Getters for name and score
	public String getName() {
		return name;
	}
	public int getScore() {
		return score;
	}
	
	// Required toString and comparison functions. Comparison is by score
	@Override
	public String toString() {
		return name + " " + score;
	}
	
	// Comparison function will return whichever is greater
	// If they are equal, then the caller's score will be returned
	@Override
	public int compareTo(Student o) {
		// TODO Auto-generated method stub
		return this.score - o.getScore();
	}
	
}
