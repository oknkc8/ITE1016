import java.util.Random;

public class Student implements Voter{
	private String name;
	private int id;
	private Department department;
	
	public Student(String name, int id, Department D){
		this.name = name;
		this.id = id;
		this.department = D;
	}

	//name, id, department variables are private
	//define the getter
	public String getName() {
		return this.name;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDpt() {
		return this.department.name;
	}
	
	public void vote(){
		Random generator = new Random();
		int number_candidates = department.candidates.size(), idx;		
		idx = generator.nextInt(number_candidates);
		Candidate tmp_candidate = department.candidates.get(idx);
		tmp_candidate.setNumberVote(tmp_candidate.getNumberVote() + 1);
		department.candidates.set(idx, tmp_candidate);
	}
	
	//To use the compareTo function in Candidate class
	//override the function in Student class too
	@Override
	public int compareTo(Object o) {
		return 1;
	}
}