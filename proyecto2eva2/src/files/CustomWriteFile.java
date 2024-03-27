package files;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CustomWriteFile {
	public static void CloseWriteFile(BufferedWriter writer) {
		try {
			writer.close();
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error");
		}	
	}

	public void WriteJugadores() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/cayet/eclipse-workspace/proyecto2eva2/src/top.txt"));
			String line;
	        StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/cayet/eclipse-workspace/proyecto2eva2/src/top.txt"));
            Scanner scanner = new Scanner(System.in);
            System.out.println("Escribe algo para añadirlo al archivo");
            String newLine = scanner.nextLine();
            writer.write(newLine + "\n");
            writer.write(content.toString());
            writer.close();
		} catch(IOException e) {
			System.out.println("Ha ocurrido un error.");

		}
	}
}

