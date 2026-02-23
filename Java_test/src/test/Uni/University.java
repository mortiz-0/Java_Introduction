package test.Uni;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class University {
	private ArrayList<ColombianCitizen> citizens = new ArrayList<>();
	private ArrayList<Estudiante> estudiantes = new ArrayList<>();
	private ArrayList<Profesor> profesores = new ArrayList<>();
	private Rector RECTOR = null;
	//Constructor
	public University(String Citizens_txt) {
		addCitizens(Citizens_txt);
	}
	//Methods
	private ArrayList<ColombianCitizen> addCitizens(String reader_filepath){
		try {
			FileReader file_txt = new FileReader(reader_filepath);
			BufferedReader br = new BufferedReader(file_txt);
			String line = br.readLine();
			while (line != null) {
		        String[] info = line.split(" ");
		        if (info[4].equals("est")){
		        	Estudiante est = new Estudiante(info[0], info[1], info[2], info[3]);
		            this.estudiantes.add(est);
		        }
		        else if (info[4].equals("rector")) {
		        	Rector rect = new Rector(info[0], info[1], info[2], info[3]);
		            this.citizens.add(rect);
		            RECTOR = rect;
		        }
		        else if (info[4].equals("prof")) {
		        	Profesor prof = new Profesor(info[0], info[1], info[2], info[3]);
		            this.citizens.add(prof);
		            this.profesores.add(prof);
		        }
		        else {
		            this.citizens.add(new ColombianCitizen(info[0], info[1], info[2], info[3]));		        	
		        }
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
		
	//get Citizens is just a view which points to the ArrayLists
	public List<AbstractAccion> getCitizens(){
	    return Stream.concat(this.estudiantes.stream(), this.profesores.stream()).toList();
	    }
	public List<Estudiante> getStudents(){
	    return this.estudiantes;
	    }
	public List<Profesor> getTeachers(){
	    return this.profesores;
	    }
	public Rector getRector() {
		return RECTOR;
	}
	protected void printListObjects(List<AbstractAccion> ls){
		ls.forEach(d->System.out.println(d.getNombre() + " " +
	    		d.getTipoDoc() + " " + d.getNumId() + " " + 
	    		d.getExpId() + " " + d.getcitizenType()));
	}
	
	//Main for tests
	public static void main(String[] args) {
		University Uni = new University("data/citizens.txt");
		Uni.printListObjects(Uni.getCitizens());
	}
}