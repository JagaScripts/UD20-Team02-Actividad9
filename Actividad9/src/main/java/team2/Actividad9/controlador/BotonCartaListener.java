/**
 * 
 */
package team2.Actividad9.controlador;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Enumeration;

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
                boton.setPrimerBoton(boton);
            } else if (carta.getPartida().getSegundaSeleccion() == null) {
                carta.getPartida().setSegundaSeleccion(carta);
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        BotonCarta boton = (BotonCarta) e.getSource();
        Carta carta = boton.getCarta();
        Partida partida = carta.getPartida();
        if (partida.getPrimeraSeleccion() != null && partida.getSegundaSeleccion() != null) {
            if (partida.sonPareja()) {
                partida.getPrimeraSeleccion().setAdivinada(true);
                partida.getSegundaSeleccion().setAdivinada(true);
                partida.sumarAdivinadas();
                partida.resetearSeleciones();
                if (partida.aFinalizado()) {
                    JOptionPane.showMessageDialog(null, "Enhorabuena as ganado!!!");
                }
            } else {
                partida.getPrimeraSeleccion().setAdivinada(false);
                partida.getSegundaSeleccion().setAdivinada(false);
                Enumeration<BotonCarta> enumBotEnumeration =  boton.getBotonesCarta().elements();
                while (enumBotEnumeration.hasMoreElements()) {
                	BotonCarta botonCarta = (BotonCarta) enumBotEnumeration.nextElement();
                	if (botonCarta.getPrimerBoton() != null) {
						
                		botonCarta.setEnabled(false);
                		botonCarta.setPrimerBoton(null);
                		
					}
					
				}
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
