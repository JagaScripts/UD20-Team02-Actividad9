package team2.Actividad9.vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Hashtable;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import team2.Actividad9.modelo.Carta;
import team2.Actividad9.modelo.Partida;
/**
 * 
 * Actividad9 - team2.Actividad9.vista - CartasVista
 *
 * @author Daniel Fernández Cacho
 * @author Joan Hurtado García
 * @author Jose Antonio González Alcántara
 * 
 * Fecha de creación 11/05/2022
 */
public class CartasVista extends JFrame {

	public static final int TOTAL_CARTAS = 16;
	private JPanel contentPane;
	private BotonCarta botonCarta;
	private Partida partida;
	Hashtable<String, BotonCarta> botonesCarta = new Hashtable<String, BotonCarta>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CartasVista frame = new CartasVista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CartasVista() {
		setTitle("Parejas de cartas");
		
		partida = new Partida(4);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		int posicionX;
		int posicionY;
		
		for (int i = 0; i < TOTAL_CARTAS / 4; i++) {
			for (int j = 0; j < TOTAL_CARTAS / 4; j++) {
				Carta carta = partida.getCarta(i, j);
				botonCarta = new BotonCarta(carta);
				posicionX = (i * 150) + 10;
				posicionY = (j * 150) + 10;
				botonCarta.setBounds(posicionX, posicionY, 150, 150);
				botonesCarta.put("" + i + j , botonCarta);
				botonCarta.setBotonesCarta(botonesCarta);
				contentPane.add(botonCarta);
				
				
			}
			
		}
	}
}
