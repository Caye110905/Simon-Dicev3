package files;

import java.io.IOException;
import java.util.ArrayList;

import Main3.Persona3;

/**
 * Interfaz que va a aplicar CustomReadFile
 */
public interface ICustomReadFile {
    public ArrayList<Persona3> leerJugador();
    public void closeReadFile() throws IOException;
}
