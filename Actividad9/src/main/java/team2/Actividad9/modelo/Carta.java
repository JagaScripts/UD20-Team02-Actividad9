/**
 * 
 */
package team2.Actividad9.modelo;

/**
 * Actividad9 - team2.Actividad9.modelo - Carta
 *
 * @author Daniel Fernández Cacho
 * @author Joan Hurtado García
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 10/05/2022
 */
public class Carta {
	
	/**
     * Ruta al directorio con las imágenes.
     */
    public static final String DIR_IMAGEN
            = "/Actividad9/src/main/java/team2/Actividad9/Imagenes/";
    /**
     * Imagen trasera de la carta.
     */
    public static final String IMAGEN_BLANCA = DIR_IMAGEN + "blanco.JPG";
    private int valor;
    private String imagen;
    private boolean adivinada;
	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	/**
	 * @return the imageN
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param imageN the imageN to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	/**
	 * @return the adivinada
	 */
	public boolean isAdivinada() {
		return adivinada;
	}
	/**
	 * @param adivinada the adivinada to set
	 */
	public void setAdivinada(boolean adivinada) {
		this.adivinada = adivinada;
	}

    
}
