package files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CustomWriteFile extends CustomReadFile{
	public static void CloseWriteFile(BufferedWriter writer) {
		try {
			writer.close();
		}catch(IOException e) {
			System.out.println("Ha ocurrido un error");
		}	
	}

	public void WriteJugadores(String[] matriz) {
		try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Users/cayet/git/Simon-Dicev3/proyecto2eva2/src/data/top.txt"));
            for (int i = 0; i < matriz.length; i++) {
            	if(matriz[i] != null) {
                writer.write(matriz[i] + " ");
                writer.write("\n");
            	}
            }
            writer.close();
		} catch(IOException e) {
			System.out.println("Ha ocurrido un error.");

		}
	}
}
