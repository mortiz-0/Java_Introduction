package test;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import test.Uni.Estudiante;

public class Scratch {
	public static ArrayList<Estudiante> students = new ArrayList<Estudiante>();
	public static void main(String[] args) throws IOException {
	for(int i = 0; i < 10; i++) {
		students.add(new Estudiante("Student " + i, "C.C", "12345", "2000-01-01"));
	}
		serialization();
	}
	public static void serialization() throws IOException {
		try(ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream("data/students.txt"))) {
			ois.writeObject(students);
			System.out.println("Students serialized successfully.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
