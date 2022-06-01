import javax.swing.*;
import java.awt.event.*;


public class DifficultyGraphic extends JFrame implements ActionListener {
	JButton boton1, boton2, boton3;
	private int difficultyNum;
	public DifficultyGraphic() {
		setLayout(null);
		boton1 = new JButton("Fácil");
		boton2 = new JButton("Medium");
		boton3 = new JButton("Dificil");
		boton1.setBounds(282, 250, 100, 30);
		boton2.setBounds(166, 150, 100, 30);
		boton3.setBounds(50, 50, 100, 30);
		add(boton1);
		add(boton2);
		add(boton3);
		boton1.addActionListener(this);
		boton2.addActionListener(this);
		boton3.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == boton1) {
			System.out.println("Has seleccionado dificultad Facil");
			difficultyNum = 0;
			System.exit(0);
		}else if(e.getSource() == boton2) {
			System.out.println("Has seleccionado dificultad Medio");
			difficultyNum = 1;
			System.exit(0);
		}else {
			System.out.println("Has seleccionado dificultad Dificil");
			difficultyNum = 2;
			System.exit(0);
		}
		
	}
	
	public int selectDifficultyGraphic() {
		DifficultyGraphic difficultad =new DifficultyGraphic();
        difficultad.setBounds(0,0,450,350);
        difficultad.setVisible(true);
        difficultad.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return difficultyNum; 
	}
}
