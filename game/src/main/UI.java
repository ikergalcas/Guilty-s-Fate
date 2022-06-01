package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.MenuItem;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.Popup;



public class UI {

	GameManager gm;
	
	JFrame window;
	public JTextArea messageText;
	//1 JPanel por background("fondo")
	public JPanel bgPanel[] = new JPanel[10];
	public JLabel bgLabel[] = new JLabel[10];
	
	
	public UI(GameManager gm) {
		this.gm = gm;
		
		createMainField();
		generateScene();
		
		window.setVisible(true);
	}
	
	public void createMainField() {
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.BLACK);
		window.setLayout(null);
		
		messageText= new JTextArea("TEXTO DE EJEMPLO");
		//Situar caja texto (posx,posy,base,altura)
		messageText.setBounds(50,410,700,120);
		//Color Fondo texto
		messageText.setBackground(Color.BLACK);
		//Color letra
		messageText.setForeground(Color.WHITE);
		//Desea que se pueda modificar texto
		messageText.setEditable(false);
		//
		messageText.setLineWrap(true);
		messageText.setWrapStyleWord(true);
		messageText.setFont(new Font("Book Antiqua",Font.PLAIN,26));
		window.add(messageText);
	}
	public void createBackground(int bgNum,String bgFileName) {
		
		bgPanel[bgNum]= new JPanel();
		bgPanel[bgNum].setBounds(50,0,700,400);
		bgPanel[bgNum].setBackground(Color.black);
		bgPanel[bgNum].setLayout(null);
		window.add(bgPanel[1]);
		//Pagina sin copyright para imagenes:pixabay
		//Este background Label se usará para mostrar imagen con tamaño //700x350
		bgLabel[bgNum] = new JLabel();
		bgLabel[bgNum].setBounds(0,0,700,400);
		
		ImageIcon bgIcon = new ImageIcon(getClass().getClassLoader().getResource(bgFileName));
		bgLabel[bgNum].setIcon(bgIcon);
		
		
		
	}
	
	public void createObject(int bgNum,int objx,int objy,int objanchura,int objaltura,String objFileName,String nombreaccion1,String nombreaccion2,String nombreaccion3,String nombreaccion4,String decision1,String decision2,String decision3,String decision4) {
		
		
		JPopupMenu popMenu = new JPopupMenu();
		
		//4 Acciones [1][2]][3][4]>>>> 4+1=5------------------
		JMenuItem menuItem[] = new JMenuItem[5];
		
		//Accion 1
		menuItem[1]= new JMenuItem(nombreaccion1);
		menuItem[1].addActionListener(gm.aHandler);
		menuItem[1].setActionCommand(decision1);
		popMenu.add(menuItem[1]);
		
		
		//Accion 2
		menuItem[2]= new JMenuItem(nombreaccion2);
		menuItem[2].addActionListener(gm.aHandler);
		menuItem[2].setActionCommand(decision2);
		popMenu.add(menuItem[2]);
		//Accion 3
		menuItem[3]= new JMenuItem(nombreaccion3);
		menuItem[3].addActionListener(gm.aHandler);
		menuItem[3].setActionCommand(decision3);
		popMenu.add(menuItem[3]);
		//Accion 4
		menuItem[4]= new JMenuItem(nombreaccion4);
		menuItem[4].addActionListener(gm.aHandler);
		menuItem[4].setActionCommand(decision4);
		popMenu.add(menuItem[4]);
		
		
		
		
		//--------------------------------------------
		JLabel objectLabel = new JLabel();
		//Situar caja texto (posx,posy,base,altura)
		objectLabel.setBounds(objx,objy,objanchura,objaltura);
		
		ImageIcon objectIcon = new ImageIcon(getClass().getClassLoader().getResource(objFileName));
		objectLabel.setIcon(objectIcon);
		
		
		objectLabel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				popMenu.show(objectLabel,e.getX(),e.getY());
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		bgPanel[bgNum].add(objectLabel);
		//El fondo se añade lo ultimo(abajo)
		
		
		
	}
	
	
	public void createArrowButton(int bgnum,int x,int y,int width,int height,String arrowFile,String command) {
		
		
		ImageIcon arrowIcon = new ImageIcon(getClass().getClassLoader().getResource(arrowFile));
	
		JButton arrowButton = new JButton();
		arrowButton.setBounds(x,y,width,height);
		arrowButton.setBackground(null);
		arrowButton.setContentAreaFilled(false);
		arrowButton.setFocusPainted(false);
		arrowButton.setIcon(arrowIcon);
		
		arrowButton.addActionListener(gm.aHandler);
		arrowButton.setActionCommand(command);
		arrowButton.setBorderPainted(false);
		bgPanel[bgnum].add(arrowButton);
	}
	
	
	public void generateScene() {
		
		
		//Screen 1
		createBackground(1, "Anden.png");
		//numScreen,posx,posy,objanchura,objaltura,nombrearchivo
		createObject(1,440,180,50,50, "Caja.jpg","Abrir1","Correr1","Cerrar1","Salir1","Hablar2","Abrir2","Correr2","Salir2");
		//75x75 == 2 personaje ( 1 personaje =25px)
		createArrowButton(1,0,150,50,50,"rightArrow.png","goScene2");
		
		
		bgPanel[1].add(bgLabel[1]);
		
	}
}
