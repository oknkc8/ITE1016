
public class simTest {
	
	private static final String DEPARTMENT_INPUT_FILE_PATH = "input1.csv";
	private static final String STUDENT_INPUT_FILE_PATH = "input2.csv";
	private static final String OUTPUT_FILE_PATH = "output_file";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ElectionSim eSim = new ElectionSim(DEPARTMENT_INPUT_FILE_PATH, STUDENT_INPUT_FILE_PATH, OUTPUT_FILE_PATH);

		eSim.runSimulation();
	}

}