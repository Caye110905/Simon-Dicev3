package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CustomReadFile {
	public  void CloseReadFile(BufferedReader reader) {
		try {
			reader.close();
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error");
		}
	}
	
	public String[] LeerJugadores() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/cayet/git/Simon-Dicev3/proyecto2eva2/src/data/top.txt"));
			String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            CloseReadFile(reader);
            // Guardarlo en un array
            String[] linesArray = content.toString().split("\n");
            return linesArray;
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error buscando el archivo");
			String[] linesArray = new String[2];
			return linesArray;
		}
	}
}
