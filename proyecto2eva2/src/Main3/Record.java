package Main3;

import files.CustomWriteFile;

/**
 * Clase Record
 * @author cayet
 */
public class Record extends CustomWriteFile{
	
	private int MAX_JUGADORES = 10;
	private Persona3[] jugadores = new Persona3[MAX_JUGADORES];
	private int salida = 0;
	
	/**
	 * Metodo que nos escribe los jugadores en el array. Tambien nos monta  el string de jugadores
	 */
	public void escribirRanking(){
		String[] jugadores2 = new String[MAX_JUGADORES];
        for(int i = 0; i < jugadores.length && jugadores[i] != null; i++) {
        	if(jugadores[i] != null) {
        		jugadores2[i] = jugadores[i].getNombre() + " " + String.valueOf(jugadores[i].getPuntuacion());
        	}
        }
        WriteJugadores(jugadores2);
	}
	
	/**
	 * Metodo que nos carga los jugadores en el array desde el fichero
	 */
	public void cargarRanking(){
		String[] jugadores2 = LeerJugadores();
        for(int i = 0; i < jugadores2.length;i++) {
        	Persona3 persona = new Persona3();
        	String split[] = jugadores2[i].split(" ");
        	int num = Integer.parseInt(split[1]);
        	persona.setNombre(split[0]);
        	persona.setPuntuacion(num);
        	jugadores[i] = persona;
        }
	}
	
	/**
	 * Metodo para ordenar de mayor a menos los jugadores
	 */
	public void ordenarRanking(){
		int f = 0;
		int posicion = 0;
		Persona3[] jugadores2 = new Persona3[MAX_JUGADORES];
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
        for(int i = 0; i < MAX_JUGADORES; i++) {
        	jugadores[i] = jugadores2[i];
        }
        escribirRanking();
	}
	
	/**
	 * Metodo para ordenar el array
	 */
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
	
	/**
	 * Metodo que nos muestra el ranking ordenado del mejor al peor respecto a los puntos
	 */
	public void showRanking() {
		for(int i = 0; i<jugadores.length - 1; i++){
			if(jugadores[i] != null) {
				System.out.println(jugadores[i].getPuntuacion() + "   " + jugadores[i].getNombre());
			}
		}
	}
	
	/**
	 * Este metodo nos muestra el mejor o la mejor jugadora, pero, si hay mas de un jugador/a con la 
	 * misma puntuacion, se mostraran todos q cumplan esta condicion 
	 */
	public void showBestPlayer () {
		System.out.println(jugadores[0].getPuntuacion() + "   " + jugadores[0].getNombre());
	}
	
	/**
	 * Metodo en el que buscamos un jugador en la array de jugadores y lo devolvemos
	 * @param persona Persona que queremos buscar
	 * @return nombre
	 */
	public int buscarJugador(String persona) {
		for(int i = 0; i<jugadores.length; i++){
			if(jugadores[i] != null && jugadores[i].getNombre().equalsIgnoreCase(persona) == true) {
				return i;
			}
		}
		return 20;
	}
	
	/**
	 * Metodo en el que se anade el jugaor a la array de jugadores
	 * @param name Nombre que queremos anadir
	 * @return nombre
	 */
	public int anadirJugador(String name) {
		if(buscarJugador(name) == 20) {
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
		}else {
			int puntuacion = jugadores[salida].getPuntuacion();
			salida = buscarJugador(name);
			jugadores[salida].setPuntuacion(0);
			return puntuacion;
		}
		return 0;
	}
	
	/**
	 * Este metodo obtiene la puntuacion de la persona
	 */
	public void setPuntuacionRecord(int puntuacion) {
		jugadores[salida].setPuntuacion(puntuacion);
	}
	
	/**
	 * Este método establece el nombre de la persona
	 */
	public void setNombreRecord(String nombre) {
		jugadores[salida].setNombre(nombre);
	}
	
	/**
	 * Este método establece el nombre de la persona.
	 * @return nombre
	 */
	public int getPuntuacionRecord() {
		return jugadores[salida].getPuntuacion();
	}
	
	/**
	 * Este metodo obtiene el nombre de la persona.
	 * @return  nombre
	 */
	public String getNombreRecord() {
		return jugadores[salida].getNombre();
	}
}