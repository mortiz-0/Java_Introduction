package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ventana extends JFrame {
	int n = 1;

	private static final long serialVersionUID = 1L;

	public Ventana() {
		setLayout(new BorderLayout());

		JLabel izquierda = new JLabel("Izquierda");
		izquierda.setBackground(Color.BLUE);
		izquierda.setOpaque(true);
		
		JLabel centro = new JLabel("Centro");
		centro.setBackground(Color.CYAN);
		centro.setOpaque(true);
		
		JTextField arriba = new JTextField("Arriba");
		
		JLabel xLabel = new JLabel("Mama");
		xLabel.setOpaque(true);
		xLabel.setVisible(false);
		
		JDialog dialog = new JDialog(this, "Alo?");
		dialog.setSize(150,150);
		JPanel dialogPanel = new JPanel();
		dialogPanel.setSize(100,100);
		dialogPanel.setBackground(Color.YELLOW);
		dialog.add(dialogPanel);
		dialogPanel.add(xLabel);
		
		JButton button = new JButton("Botton");
		button.setSize(50,50);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogPanel.add(new JLabel(((Integer)n).toString()));
				if (n==1) {
					xLabel.setVisible(true);
				}
				n += 1;
				if (n%2==0) {
					xLabel.setText("YO MAMAA");	
				}
				else {
					xLabel.setText("Mama");
				}
			}
		});
		dialogPanel.add(button);
		
		add(izquierda, BorderLayout.WEST);
		add(centro, BorderLayout.CENTER);
		add(arriba, BorderLayout.NORTH);
		
		
		dialog.setVisible(true);

		setTitle("Ventana swing");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 350);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Ventana();
	}

}
