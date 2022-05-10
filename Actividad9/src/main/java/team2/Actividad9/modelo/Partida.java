package team2.Actividad9.modelo;

import java.util.ArrayList;



/**
 * Actividad9 - team2.Actividad9.modelo - Partida
 *
 * @author Daniel Fernández Cacho
 * @author Joan Hurtado García
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 10/05/2022
 */
public class Partida {

		private Carta primeraSeleccion;
	    private Carta segundaSeleccion;
	    private Carta[][] tablero;
	    private ArrayList<Carta> cartas;
	    private int parejasAdivinadas;

	    /**
	     * Número de celdas que usaremos para cada dimensión del tablero.
	     */
	    public static final int TAMANO = 4;

	    /**
	     * Constructor por defecto.
	     */
	    public Partida() {
	        this(TAMANO);
	    }

	    /**
	     * Constructor que admite un número de celdas por dimensión.
	     *
	     * @param size int número de celdas.
	     */
	    public Partida(int tamano) {
	        tablero = new Carta[tamano][tamano];
	        cartas = new ArrayList<>();
	        primeraSeleccion = segundaSeleccion = null;
	        parejasAdivinadas = 0;
	        inicializar();
	    }

	    private ArrayList<Carta> crearCartas() {
	        for (int i = 0; i < (tablero.length * tablero[0].length / 2); i++) {
	            cartas.add(new Carta(i, this));
	            cartas.add(new Carta(i, this));
	        }
	        return cartas;
	    }

	    private Carta generarCartaAleatoria() {
	        int index = (int) (Math.random() * cartas.size());
	        Carta card = cartas.get(index);
	        cartas.remove(card);
	        return card;
	    }

	    private void inicializarTablero() {
	        for (Carta[] row : tablero) {
	            for (int j = 0; j < row.length; j++) {
	                row[j] = generarCartaAleatoria();
	            }
	        }
	    }

	    private void inicializar() {
	    	crearCartas();
	    	inicializarTablero();
	    }

	    /**
	     * Getter de la primera elección del usuario.
	     *
	     * @return primeraSeleccion Carta.
	     */
	    public Carta getPrimeraSeleccion() {
	        return primeraSeleccion;
	    }

	    /**
	     * Setter de la primera elección del usuario.
	     *
	     * @param primeraSeleccion Carta.
	     */
	    public void setPrimeraSeleccion(Carta primeraSeleccion) {
	        this.primeraSeleccion = primeraSeleccion;
	    }

	    /**
	     * Getter de la segunda elección del usuario.
	     *
	     * @return segundaSeleccion Carta.
	     */
	    public Carta getSegundaSeleccion() {
	        return segundaSeleccion;
	    }

	    /**
	     * Setter de la segunda elección del usuario.
	     *
	     * @param seconsegundaSelecciondPick Carta.
	     */
	    public void setSegundaSeleccion(Carta segundaSeleccion) {
	        this.segundaSeleccion = segundaSeleccion;
	    }

	    /**
	     * Getter del número de parejas adivinadas hasta el momento.
	     *
	     * @return parejasAdivinadas int.
	     */
	    public int getParejasAdivinadas() {
	        return parejasAdivinadas;
	    }

	    /**
	     * Setter del número de parejas adivinadas hasta el momento.
	     *
	     * @param parejasAdivinadas int.
	     */
	    public void setParejasAdivinadas(int parejasAdivinadas) {
	        this.parejasAdivinadas = parejasAdivinadas;
	    }

	    /**
	     * Getter de la matriz de cartas que almacena las posiciones en el tablero.
	     *
	     * @return board Card[][].
	     */
	    public Carta[][] getTablero() {
	        return tablero;
	    }

	    /**
	     * Setter de la matriz de cartas que almacena las posiciones en el tablero.
	     *
	     * @param tablero Carta[][].
	     */
	    public void setTablero(Carta[][] tablero) {
	        this.tablero = tablero;
	    }

	    /**
	     * Método que recupera una carta dadas sus coordenadas.
	     *
	     * @param i int fila.
	     * @param j int columna.
	     * @return Card en la posición especificada.
	     */
	    public Carta getCarta(int i, int j) {
	        return tablero[i][j];
	    }

	    /**
	     * Método que elimina las selecciones del usuario.
	     */
	    public void resetearSeleciones() {
	        primeraSeleccion = segundaSeleccion = null;
	    }

	    /**
	     * Método que compara las cartas seleccionadas.
	     *
	     * @return boolean true si los valores de la cartas son iguales.
	     */
	    public boolean sonPareja() {
	        return primeraSeleccion.equals(segundaSeleccion);
	    }

	    /**
	     * Método que aumenta el número de parejas acertadas en una unidad.
	     */
	    public void sumarAdivinadas() {
	    	parejasAdivinadas++;
	    }

	    /**
	     * Método que comprueba si el juego ha acabado. Esto sucede cuando el número
	     * de parejas acertadas es igual a la mitad del número de cartas.
	     *
	     * @return boolean true si los pares acertados son igual a la mitad de las
	     * posiciónes de la matriz.
	     */
	    public boolean aFinalizado() {
	        return parejasAdivinadas == tablero.length * tablero.length / 2;
	    }
}
