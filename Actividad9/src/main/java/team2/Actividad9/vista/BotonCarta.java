package team2.Actividad9.vista;

import java.awt.Dimension;

import javax.swing.JToggleButton;

import team2.Actividad9.modelo.Carta;
/**
 * Actividad9 - team2.Actividad9.vista - Carta
 *
 * @author Daniel Fernández Cacho
 * @author Joan Hurtado García
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 10/05/2022
 */
public class BotonCarta extends JToggleButton {

	 private Carta carta;
	/**
     * Constructor por defecto que prepara el componente con las propiedades
     * configuradas como necesitamos y que admite una carta como parámetro.
     *
     * @param Carta carta.
     */
    public BotonCarta(Carta carta) {
    	Dimension dimension = new Dimension(150, 150);
        this.setPreferredSize(dimension);
        this.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource(
                carta.IMAGEN_BLANCA)));
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                carta.getImagen())));
        this.addMouseListener(new BotonCartaListener());
        this.setEnabled(carta.isAdivinada());
    }
}
