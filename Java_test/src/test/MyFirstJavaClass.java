package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class MyFirstJavaClass {
	
	public static void main(String[] args) {
		fibonacci_file_to_file("data/randomNumbers.txt", "data/randomNumbersToFbnacci.txt");
	}
	
	public static int fibonacci(int x) {
		if (x==0) {
			return 1;
		}
		if (x==1) {
			return 1;
		}
		return fibonacci(x-1) + fibonacci(x-2);
	}
	public static void fibonacci_file_to_file(String reader_filepath, String writer_filepath) {
		try{
			FileReader file_txt = new FileReader(reader_filepath);	
			BufferedReader br = new BufferedReader(file_txt);
			String line = br.readLine();
			while (line != null) {
				write_txt(writer_filepath, line);
				line = br.readLine();
			}
			br.close();
			file_txt = new FileReader(writer_filepath);
			br = new BufferedReader(file_txt);
			line = br.readLine();
			while (line != null) {
				System.out.println(line);
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
	}
	public static void write_txt(String writer_filepath, String line) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(writer_filepath, true));
		String message = fibonacci(Integer.parseInt(line)) + "\n";
		writer.write(message);
		writer.close();
	}
}
