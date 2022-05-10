/**
 * 
 */
package team2.Actividad9.vista;

import java.awt.Dimension;

import javax.swing.JToggleButton;

import es.seas.unidad3.extras.parejas.model.entities.Card;
import es.seas.unidad3.extras.parejas.view.components.CardButtonListener;

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

	/**
     * Constructor por defecto que prepara el componente con las propiedades
     * configuradas como necesitamos y que admite una carta como parámetro.
     *
     * @param card Card.
     */
    public BotonCarta() {
    	Dimension dimension = new Dimension(140, 140);
        this.setPreferredSize(dimension);
        this.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource(
                Card.BACK_IMAGE)));
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource(
                card.getImage())));
        this.addMouseListener(new CardButtonListener());
        this.setEnabled(card.isGuessed());
    }
}
