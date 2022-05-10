/**
 * 
 */
package team2.Actividad9.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import team2.Actividad9.modelo.Carta;
import team2.Actividad9.modelo.Partida;
import team2.Actividad9.vista.BotonCarta;



/**
 * Actividad9 - team2.Actividad9.vista - BotonCartaListener
 *
 * @author Daniel Fernández Cacho
 * @author Joan Hurtado García
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 10/05/2022
 */
public class BotonCartaListener extends MouseAdapter {

	private BotonCarta primerBoton;
	/**
	 *
	 */
	@Override
    public void mouseClicked(MouseEvent e) {
        BotonCarta boton = (BotonCarta) e.getSource();
        Carta carta = boton.getCarta();
        if (!carta.isAdivinada()) {
            boton.setEnabled(true);
            if (carta.getPartida().getPrimeraSeleccion() == null) {
                carta.getPartida().setPrimeraSeleccion(carta);
                this.setPrimerBoton(boton);
            } else if (carta.getPartida().getSegundaSeleccion() == null) {
                carta.getPartida().setSegundaSeleccion(carta);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        BotonCarta boton = (BotonCarta) e.getSource();
        //System.out.println("boton " + boton.);
        Carta carta = boton.getCarta();
        Partida partida = carta.getPartida();
        if (partida.getPrimeraSeleccion() != null && partida.getSegundaSeleccion() != null) {
            if (partida.sonPareja()) {
                partida.getPrimeraSeleccion().setAdivinada(true);
                partida.getSegundaSeleccion().setAdivinada(true);
                partida.sonPareja();
                partida.resetearSeleciones();
                if (partida.isFinished()) {
                    JOptionPane.showMessageDialog(null, "Enhorabuena as ganado!!!");
                }
            } else {
                partida.getPrimeraSeleccion().setAdivinada(false);
                partida.getSegundaSeleccion().setAdivinada(false);
                ((BotonCarta)this.getPrimerBoton()).setEnabled(false);
                this.setPrimerBoton(null);
                boton.setEnabled(false);
                partida.resetearSeleciones();
            }
        }
    }

	/**
	 * @return the primerBoton
	 */
	public BotonCarta getPrimerBoton() {
		return primerBoton;
	}

	/**
	 * @param primerBoton the primerBoton to set
	 */
	public void setPrimerBoton(BotonCarta primerBoton) {
		this.primerBoton = primerBoton;
	}
    
    
}
