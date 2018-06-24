import java.util.*;

public class Department {
	public String name;
	public int id;
	public ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	public ArrayList<Student> students = new ArrayList<Student>();
	
	public Department(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	public Candidate getMostVote_Candidate() {
		Collections.sort(candidates);	//sort the candidate array by the number of votes
		return candidates.get(0);		//return the candidate get the most
	}
}

