import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.io.*;

public class ElectionSim {
	public String pathInput_Department, pathInput_Student, pathOutput;
	public ArrayList<Department> departments = new ArrayList<Department>();
	public ArrayList<Candidate> candidates = new ArrayList<Candidate>();
	
	ElectionSim(String str1, String str2, String str3){
		this.pathInput_Department = str1;
		this.pathInput_Student = str2;
		this.pathOutput = str3;
		
		BufferedReader bufReader = null;
		try {
			//Reading input1.csv (Department)
			bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(pathInput_Department),"UTF-8"));
			bufReader.readLine();	//Skip the first line
			String str = "";
			while((str = bufReader.readLine()) != null) {
				int comma_index = str.indexOf(',');
				int num = Integer.parseInt(str.substring(0,comma_index));
				String dpt = str.substring(comma_index+1, str.length());
				
				Department D = new Department(dpt, num);
				departments.add(D);
			}
			
			//Reading input2.csv (Student Information)
			bufReader = new BufferedReader(new InputStreamReader(new FileInputStream(pathInput_Student),"UTF-8"));
			bufReader.readLine();	//Skip the first line
			str="";
			while((str = bufReader.readLine()) != null) {
				int comma_index = str.indexOf(',');
				int student_id = Integer.parseInt(str.substring(0,comma_index));
				str = str.substring(comma_index+1, str.length());
				
				comma_index = str.indexOf(',');
				int dpt_id = Integer.parseInt(str.substring(0,comma_index));
				str = str.substring(comma_index+1, str.length());
				
				comma_index = str.indexOf(',');
				String name = str.substring(0,comma_index);
				str = str.substring(comma_index+1, str.length());
				
				for(int i = 0; i < departments.size(); i ++) {
					if(departments.get(i).id == dpt_id) {
						Department tmp = departments.get(i);
						//When a student is candidate
						if(str.equals("TRUE")) {
							Candidate c = new Candidate(name, student_id, tmp);
							tmp.candidates.add(c);
						}
						Student s = new Student(name, student_id, tmp);
						tmp.students.add(s);
						departments.set(i, tmp);
					}
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Error, file not found or may be open.");
		}
		catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void saveData() {
		Collections.sort(this.candidates);
		PrintWriter outputStream = null;
		try {
			outputStream = new PrintWriter(new FileOutputStream(pathOutput));
			for(Candidate c : this.candidates) {
				outputStream.println("======== Elected Candidate ========");
				outputStream.println("Department name: " + c.getDpt());
				outputStream.print("Student_id: ");
				outputStream.println(c.getId());
				outputStream.print("Votes: ");
				outputStream.println(c.getNumberVote());
				outputStream.println("===================================");
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Error, Opening file");			
		}
		try {
			if(outputStream!=null) outputStream.close();
		}
		catch(Exception e) {}
	}
	
	public void runSimulation() {		
		for(Department d : this.departments){
			//Using iterator
			ListIterator<Student> ltr = d.students.listIterator();
			while(ltr.hasNext()) {
				ltr.next().vote();
			}
			
			candidates.add(d.getMostVote_Candidate());
		}
		
		this.saveData();
	}
}
