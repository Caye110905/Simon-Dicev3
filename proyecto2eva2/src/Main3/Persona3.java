package Main3;

/**
 * Clase persona. 
 * @author cayet
 */
public class Persona3 {

	private String nombre;
	private int puntuacion;
	
	/**
	 * Este metodo obtiene el nombre de la persona.
	 * @return nombre
	 */
	public String getNombre() {
		return this.nombre;
	}
	
	/**
	 * Este método establece el nombre de la persona
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Este metodo obtiene la puntuacion de la persona
	 */
	public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
	
	/**
	 * Este método establece el nombre de la persona. 
	 * @return nombre
	 */
	public int getPuntuacion() {
        return this.puntuacion;
    }
}
