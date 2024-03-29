package Main3;

import files.CustomWriteFile;
import files.CustomReadFile;

public class Record extends CustomWriteFile{
	
	private int MAX_JUGADORES = 10;
	private Persona3[] jugadores = new Persona3[MAX_JUGADORES];
	private int salida = 0;
	
	public void escribirRanking(){
		String[] jugadores2 = new String[10];
        for(int i = 0; i < jugadores.length -1 && jugadores[i] != null; i++) {
        	if(jugadores[i] != null) {
        		jugadores2[i] = jugadores[i].getNombre() + "   " + String.valueOf(jugadores[i].getPuntuacion());
        	}
        }
        WriteJugadores(jugadores2);
	}
	
	public void ordenarRanking(){
		int f = 0;
		int posicion = 0;
		Persona3[] jugadores2 = new Persona3[10];
        int[] puntuaciones = new int[MAX_JUGADORES];
        for (int i = 0; i <jugadores.length && jugadores[i] != null ; i++) {
            puntuaciones[i] = jugadores[i].getPuntuacion();
        }
        ordenarArray(puntuaciones);
        for(f = 0; f <jugadores.length; f++) {
        	for(int i = 0; i<jugadores.length && jugadores[i] != null; i++) {
        		if(puntuaciones[f] == jugadores[i].getPuntuacion() && puntuaciones[f] != 0) {
        			 jugadores2[posicion] = jugadores[i];
        			 jugadores[i] = new Persona3();
        			 posicion++;
        		}
        	}
            puntuaciones[f] = 0;
        }
        for(int i = 0; i < jugadores2.length -1; i++) {
        	jugadores[i] = jugadores2[i];
        }
        escribirRanking();
	}
	
	public void ordenarArray(int[] array) {
		int numero = array.length;
		for(int i = 0; i < numero -1; i++) {
			for(int j = 0; j < numero -1; j++) {
				if(array[j] < array[j + 1]) {
					 int temp = array[j];
	                    array[j] = array[j + 1];
	                    array[j + 1] = temp;
				}
			}
		}
	}
	
	public void showRanking() {
		for(int i = 0; i<jugadores.length - 1; i++){
			if(jugadores[i] != null) {
				System.out.println(jugadores[i].getPuntuacion() + "   " + jugadores[i].getNombre());
			}
		}
	}
	
	public void showBestPlayer () {
		System.out.println(jugadores[0].getPuntuacion() + "   " + jugadores[0].getNombre());
	}
	public void añadirJugador(String name) {
		Persona3 persona = new Persona3();
		persona.setNombre(name);
		int i = 0;
		while(jugadores[i] != null && i<MAX_JUGADORES-1){
			i++;
		}
		if(i<=MAX_JUGADORES-1) {
			jugadores[i] = persona;
		}
		salida = i;
	}
	
	public void setPuntuacionRecord(int puntuacion) {
		jugadores[salida].setPuntuacion(puntuacion);
	}
	
	public int getPuntuacionRecord() {
		return jugadores[salida].getPuntuacion();
	}
	
	public String getNombreRecord() {
		return jugadores[salida].getNombre();
	}
}