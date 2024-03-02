package Main3;


public class Record {

	public Persona3[] showRanking(Persona3 jugadores[]) {
		int k = 0;
		int f = 0;
		int g = 0;
		int contador = 0;
		Persona3[] jugadores2 = new Persona3[10];
		int puntuaciones[] = new int[10];
		while(jugadores[k] != null && k<9){
			puntuaciones[k] = jugadores[k].getPuntuacion();
			k++;
		}
		while(jugadores[contador] != null && contador<9){
			int h = 0;
			for(f = 0; f<puntuaciones.length-1; f++){
				if(puntuaciones[f]>h) {
					h = puntuaciones[f];
				}
			}
			f = 0;
			while(jugadores[f] != null && f<9){
				if(h == jugadores[f].getPuntuacion() && h != 0) {
					System.out.println(jugadores[f].getPuntuacion() + "   " + jugadores[f].getNombre());
					puntuaciones[f] = 0;
					jugadores2[contador] = jugadores[f];
					g++;
				}
			if(g>1) {
				jugadores2[contador] = jugadores[f];
				g = 1;
			}
				f++;
			}
			contador++;
		}
		return jugadores;
	}
	public void showBestPlayer (Persona3 jugadores[]) {
		int k = 0;
		int f = 0;
		int y = 0;
		int contador = 0;
		int puntuaciones[] = new int[10];
		while(jugadores[k] != null && k<9){
			puntuaciones[k] = jugadores[k].getPuntuacion();
			k++;
		}
		while(jugadores[contador] != null && contador != 3){
			int h = 0;
			for(f = 0; f<puntuaciones.length-1; f++){
				if(puntuaciones[f]>h) {
					h = puntuaciones[f];
				}
			}
			f = 0;
			while(jugadores[f] != null && f<9){
				if(h == jugadores[f].getPuntuacion()) {
					System.out.println(jugadores[f].getPuntuacion() + "   " + jugadores[f].getNombre());
					puntuaciones[f] = 0;
				}
				f++;
			}
			contador++;
		}
	}
}
