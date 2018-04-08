import java.io.*;

public class LetterTransformator {

	public static void main(String[] args) {
		try {
			File file_in1 = new File("properties.txt"), file_in2 = new File("template_file.txt");
			FileReader filereader_in11 = new FileReader(file_in1), filereader_in12 = new FileReader(file_in1), filereader_in2 = new FileReader(file_in2);
			BufferedReader bufReader_countLine = new BufferedReader(filereader_in11), bufReader1 = new BufferedReader(filereader_in12);
			BufferedReader bufReader2 = new BufferedReader(filereader_in2);
			
			FileOutputStream output = new FileOutputStream("output.txt");
			
			int count=0;
			while(bufReader_countLine.readLine() != null) count++;
			
			KeyValue[] keys = new KeyValue[count];
			for(int i=0;i<count;i++) {
				String line = bufReader1.readLine();
				keys[i] = new KeyValue(line);
			}
			
			String template_line = "";
			while((template_line = bufReader2.readLine()) != null) {
				int open_index;
				while((open_index = template_line.indexOf('{'))>=0) {
					int close_index = template_line.indexOf('}');
					output.write(template_line.substring(0,open_index).getBytes());
					
					String property = template_line.substring(open_index+1,close_index);
					for(int i=0;i<count;i++) {
						if(property.equals(keys[i].getKey())) {
							output.write(keys[i].getValue().getBytes());
							break;
						}
					}	
					template_line = template_line.substring(close_index+1, template_line.length());
				}
				template_line+="\n";
				output.write(template_line.getBytes());
			}
		}
		catch(FileNotFoundException e) {}
		catch(IOException e) {}	
	}
}