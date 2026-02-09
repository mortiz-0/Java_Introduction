package test;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class University {
	static ArrayList<ColombianCitizen> citizens = new ArrayList<>();
	public University(String Citizens_txt) {
		addCitizens(Citizens_txt);
	}
	private static ArrayList<ColombianCitizen> addCitizens(String reader_filepath){
	try {
		FileReader file_txt = new FileReader(reader_filepath);
		BufferedReader br = new BufferedReader(file_txt);
		String line = br.readLine();
		while (line != null) {
	        String[] info = line.split(" "); 
            citizens.add(new ColombianCitizen(info[0], info[1], info[2], info[3]));
	        line = br.readLine();
	    }
	    br.close();
	}
	catch(FileNotFoundException e) {
		System.out.println("Filo does not exists.");
	}
	catch(IOException e) {
		System.out.println("Can't read the file.");
	}
	catch(Exception e){
		System.out.println("Unexpected error: "+e.getMessage());
	}
	return citizens;
}
	public void getCitizens(){
	    for(int i = 0; i < citizens.size(); i++) {
	        System.out.println(citizens.get(i).getNombre() + " " + citizens.get(i).getTipoDoc() + " " + citizens.get(i).getNumId() + " " + citizens.get(i).getExpId());
	    }
	}
	public static void main(String[] args) {
		University Uni = new University("data/citizens.txt");
		Uni.getCitizens();
	}
}
