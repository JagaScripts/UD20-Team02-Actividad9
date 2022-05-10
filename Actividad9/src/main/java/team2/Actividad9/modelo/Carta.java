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
            = "../Imagenes/";
    /**
     * Imagen trasera de la carta.
     */
    public static final String IMAGEN_BLANCA = DIR_IMAGEN + "blanco.jpg";
    private int valor;
    private String imagen;
    private boolean adivinada;
    private Partida partida;
   
    
    /**
     * Constructor de las cartas.
     *
     * @param value int valor que define que imagen se asocia a la carta y que
     * nos sirve para realizar comprobaciones de igualdad de forma simple.
     * @param game Game partida a la que pertenece la carta.
     */
    public Carta(int valor, Partida partida) {
        this.partida = partida;
        this.valor = valor;
        this.imagen = DIR_IMAGEN + valor + ".JPG";
        this.adivinada = false;
    }

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
	 * @return the imagen
	 */
	public String getImagen() {
		return imagen;
	}
	/**
	 * @param imageN the imagen to set
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

	/**
	 * @return the partida
	 */
	public Partida getPartida() {
		return partida;
	}

	/**
	 * @param partida the partida to set
	 */
	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	@Override
    public boolean equals(Object carta) {
        if (carta == null) {
            return false;
        }
        if (getClass() != carta.getClass()) {
            return false;
        }
        final Carta segundaCarta = (Carta) carta;
        return this.valor == segundaCarta.valor;
    }
    
}
