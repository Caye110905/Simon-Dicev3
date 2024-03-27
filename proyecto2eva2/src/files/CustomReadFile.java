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
	
	public  void LeerJugadores() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("C:/Users/cayet/eclipse-workspace/proyecto2eva2/src/top.txt"));
			String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                content.append(line).append("\n");
            }
            CloseReadFile(reader);
            // Guardarlo en un array
            String[] linesArray = content.toString().split("\n");
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error buscando el archivo");
		}
	}
}
