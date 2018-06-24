
public class Candidate extends Student{
	private int number_vote;
	
	public Candidate(String name, int id, Department D){
		super(name, id, D);
	}
	
	//number_vote variable is private member
	//define the getter
	public int getNumberVote() {
		return this.number_vote;
	}
	
	public void setNumberVote(int number) {
		this.number_vote = number;
	}
	
	//sort by descending order of the number of votes
	@Override
	public int compareTo(Object o) {
		Candidate obj = (Candidate)o;
		if(this.number_vote < obj.getNumberVote()) return 1;
		else if(this.number_vote > obj.getNumberVote()) return -1;
		else return 0;
	}
}
