package eg.edu.alexu.csd.oop.draw.cs23.view;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import eg.edu.alexu.csd.oop.draw.cs23.controller.Draw;
import eg.edu.alexu.csd.oop.draw.cs23.model.Polygon;

public class Gui {

	private JFrame frame;

	private JButton Polygonbtn;
	private JButton Linebtn;
	private JButton Elipsebtn;
	private JButton Trianglebtn;
	private JButton selectctbtn;
	private JButton penbtn;
	private JButton Enterbtn;
	private JButton BorderColorbtn;
	private JButton FillColorbtn;
	private JButton Undobtn;
	private JButton Redobtn;
	private JButton Savebtn;
	private JButton Loadbtn;
	private JButton BorderColorPropbtn;
	private JButton FillColorPropbtn;
	private JButton Applybtn;
	private JButton Removebtn;
	private JButton Helpbtn;
	private JButton Editbtn;
	private JButton Filebtn;
	private JButton Exitbtn;
	private JButton Help_2btn;
	private JButton Newbtn;
	private TextField Widthtxt;
	private TextField Heighttxt;
	private JTextField XProptxt;
	private JTextField YProptxt;
	private JTextField WidthProptxt;
	private JTextField HeigthProptxt;
	private JPanel LayersPanel;
	private JPanel controlPanel;
	private JPanel propPanel;
	private JPanel PlugPanle;
	private Color FillColor;
	private Color BorderColor;
	private ImageIcon img;
	private int xbegin = 73 , ybegin = 127;
	

	Draw d = new Draw();

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == Linebtn) {
				d.setNameShape("line");
				controlPanel.validate();
				controlPanel.repaint();
				controlPanel.setVisible(true);
				propPanel.setVisible(false);
			}
			if (e.getSource() == Polygonbtn) {
				d.setNameShape("polygon");
				controlPanel.validate();
				controlPanel.repaint();
				controlPanel.setVisible(true);
				propPanel.setVisible(false);
			}
			if (e.getSource() == Elipsebtn) {
				d.setNameShape("elipse");
				controlPanel.validate();
				controlPanel.repaint();
				controlPanel.setVisible(true);
				propPanel.setVisible(false);
			}
			if (e.getSource() == Trianglebtn) {
				d.setNameShape("triangle");
				controlPanel.validate();
				controlPanel.repaint();
				controlPanel.setVisible(true);
				propPanel.setVisible(false);
			}
			if (e.getSource() == Enterbtn) {
				d.setParameters(frame,xbegin-73, ybegin-127);
				d.DynamicPanel(LayersPanel);
				LayersPanel.validate();
				LayersPanel.repaint();
				controlPanel.setVisible(false);
				propPanel.setVisible(true);
			}
			if (e.getSource() == FillColorbtn) {
				Color c = JColorChooser.showDialog(frame, "Choose background color", Color.white);
				FillColor = c;
				d.setFillColor(c);
				setFillColor(c);
			}
			if (e.getSource() == BorderColorbtn) {
				Color c = JColorChooser.showDialog(frame, "Choose Border color", Color.black);
				BorderColor = c;
				d.setBorderColor(c);
				setBorderColor(c);
			}
			if (e.getSource() == Undobtn){
				d.undo();
				d.DynamicPanel(LayersPanel);;
				LayersPanel.validate();
				LayersPanel.repaint();
			}
			if(e.getSource() == Redobtn){
				d.redo();
				d.DynamicPanel(LayersPanel);;
				LayersPanel.validate();
				LayersPanel.repaint();
			}
			if(e.getSource() == Savebtn){
				JFileChooser fs = new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("Save File");
				int n  = fs.showSaveDialog(null);
				if( n == fs.APPROVE_OPTION){
					d.save(fs.getSelectedFile().getAbsolutePath());	
				
				}
			}
			if(e.getSource() == Loadbtn){
				JFileChooser fs = new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("Load File");
				int n  = fs.showOpenDialog(null);
				if( n == fs.APPROVE_OPTION){
					d.load(fs.getSelectedFile().getAbsolutePath());	
					
				}
				d.DynamicPanel(LayersPanel);;
				LayersPanel.validate();
				LayersPanel.repaint();
			}
			if(e.getSource() == BorderColorPropbtn){
				BorderColor = JColorChooser.showDialog(frame, "Choose Border color", Color.black);
				setBorderColor(BorderColor);
				d.setBorderColor(BorderColor);
			}
			if(e.getSource() == FillColorPropbtn){
				FillColor = JColorChooser.showDialog(frame, "Choose background color", Color.white);
				setFillColor(FillColor);
				d.setFillColor(FillColor);
			}
			if(e.getSource() == Applybtn){
				d.setUpdateShape(frame,BorderColor, FillColor, xbegin-73, ybegin-127);
				d.DynamicPanel(LayersPanel);
				LayersPanel.validate();
				LayersPanel.repaint();
			}
			if(e.getSource() == Removebtn){
				d.remove();
				d.DynamicPanel(LayersPanel);
				LayersPanel.validate();
				LayersPanel.repaint();
			}
			if(e.getSource() == Helpbtn){
				JOptionPane.showMessageDialog(null,
						  "Welcome to our Programme Photoshop ÈÇáÚÑÈí\n"
						+ "---------------------------------------------------------------- \n"
						+ "1-Choose the Shape you want to draw\n"
						+ "2-click in any palce to choose start point\n"
						+ "3-Add Shape window will appeare fill it\n"
						+ "4-Press Enter and watch the shape being drawen\n"
						+ "5-click on the shape in the layers to Modify it\n"
						+ "---------------------------------------------------------------- \n"
						+ "You can also try undo , redo , save and load buttons\n"
						+ "---------------------------------------------------------------- \n"
						+ "Feel free to use the programme ^_^", 
						
						"Help Box", JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getSource() == Editbtn){
				final JPopupMenu menu = new JPopupMenu("Menu"); 
				menu.add(new JMenuItem(new AbstractAction("Undo") {
                    public void actionPerformed(ActionEvent e) {
                    	d.undo();
        				d.DynamicPanel(LayersPanel);;
        				LayersPanel.validate();
        				LayersPanel.repaint();
                    }
                }));
				menu.add(new JMenuItem(new AbstractAction("Redo") {
                    public void actionPerformed(ActionEvent e) {
                    	d.redo();
        				d.DynamicPanel(LayersPanel);;
        				LayersPanel.validate();
        				LayersPanel.repaint();
                    }
                }));
				menu.show(Editbtn, 20, 27);
                menu.setBackground(Color.BLACK);
			}
			if(e.getSource() == Filebtn){
				final JPopupMenu menu = new JPopupMenu("Menu");
				menu.add(new JMenuItem(new AbstractAction("New") {
                    public void actionPerformed(ActionEvent e) {
                    	mainGui();
                    }
                }));
                menu.add(new JMenuItem(new AbstractAction("Save") {
                    public void actionPerformed(ActionEvent e) {
                    	JFileChooser fs = new JFileChooser(new File("c:\\"));
        				fs.setDialogTitle("Save File");
        				int n  = fs.showSaveDialog(null);
        				if( n == fs.APPROVE_OPTION){
        					d.save(fs.getSelectedFile().getAbsolutePath());	
        				}
                    }
                }));
                menu.add(new JMenuItem(new AbstractAction("Load") {
                    public void actionPerformed(ActionEvent e) {
                    	JFileChooser fs = new JFileChooser(new File("c:\\"));
        				fs.setDialogTitle("Load File");
        				int n  = fs.showOpenDialog(null);
        				if( n == fs.APPROVE_OPTION){
        					d.load(fs.getSelectedFile().getAbsolutePath());	
        				}
                    }
                }));
                menu.add(new JMenuItem(new AbstractAction("Exit") {
                    public void actionPerformed(ActionEvent e) {
                    	System.exit(0); 
                    }
                }));
                menu.show(Filebtn, 20, 27);
                menu.setBackground(Color.BLACK);
			}
			if(e.getSource() == Exitbtn){
				System.exit(0);
			}
			if(e.getSource() == Help_2btn){
				JOptionPane.showMessageDialog(null,
						  "Welcome to our Programme Photoshop ÈÇáÚÑÈí\n"
						+ "---------------------------------------------------------------- \n"
						+ "1-Choose the Shape you want to draw\n"
						+ "2-click in any palce to choose start point\n"
						+ "3-Press enter in 'Add Shape' window on the up right\n"
						+ "4-Enter the dimensions in the pop uo menu\n"
						+ "5-click on the shape in the layers to Modify it\n"
						+ "---------------------------------------------------------------- \n"
						+ "You can also try undo , redo , save , load and plug in buttons\n"
						+ "---------------------------------------------------------------- \n"
						+ "Feel free to use the programme ^_^", 
						
						"Help Box", JOptionPane.INFORMATION_MESSAGE);
			}
			if(e.getSource() == Newbtn){
				mainGui();
			}
			if(e.getSource() == selectctbtn){
				JFileChooser fs = new JFileChooser(new File("c:\\"));
				fs.setDialogTitle("Load Jar File");
				int n  = fs.showOpenDialog(null);
				if( n == fs.APPROVE_OPTION){
					d.classLoader(fs.getSelectedFile().getAbsolutePath());
					
				}
				d.DynamicPlgIn(PlugPanle,controlPanel,propPanel);
				PlugPanle.validate();
				PlugPanle.repaint();
			}
		}
	};
	
	public MouseListener mouseHandler = new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			xbegin = arg0.getX();
			ybegin = arg0.getY();
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			
			
		
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		
		}
	
	};
	
	public void mainGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//-----------------------------------Start Initialize------------------------------------------//
		
		frame = new JFrame("Photoshop ÈÇáÚÑÈí");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setBounds(-5, -5, 1380, 740);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.addMouseListener(mouseHandler);
	
		d.drawing();
		JPanel panel_1 = d;
		panel_1.setBounds(65, 97, 1009, 594);
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1);
		
		Panel HLine = new Panel();
		HLine.setBackground(Color.BLACK);
		HLine.setBounds(200, 35, 2, 55);
		frame.getContentPane().add(HLine);
		
		Panel VLine = new Panel();
		VLine.setBackground(Color.BLACK);
		VLine.setBounds(0, 30, 1380, 2);
		frame.getContentPane().add(VLine);

		Filebtn = new JButton("File");
		Filebtn.setForeground(Color.WHITE);
		Filebtn.setToolTipText("File");
		Filebtn.setBounds(4, 4, 60, 23);
		Filebtn.setContentAreaFilled(false);
		Filebtn.setFocusPainted(false);
		Filebtn.setBorderPainted(false);
		Filebtn.addActionListener(actionListener);
		frame.getContentPane().add(Filebtn);
		
		Editbtn = new JButton("Edit");
		Editbtn.setForeground(Color.WHITE);
		Editbtn.setToolTipText("Edit");
		Editbtn.setBounds(75, 4, 60, 23);
		Editbtn.setContentAreaFilled(false);
		Editbtn.setFocusPainted(false);
		Editbtn.setBorderPainted(false);
		Editbtn.addActionListener(actionListener);
		frame.getContentPane().add(Editbtn);
		
		Helpbtn = new JButton("Help");
		Helpbtn.setForeground(Color.WHITE);
		Helpbtn.setToolTipText("Help");
		Helpbtn.setBounds(145, 4, 60, 23);
		Helpbtn.setContentAreaFilled(false);
		Helpbtn.setFocusPainted(false);
		Helpbtn.setBorderPainted(false);
		Helpbtn.addActionListener(actionListener);
		frame.getContentPane().add(Helpbtn);
		
		//------------------------------------End Initialize-------------------------------------------//
		
		//-----------------------------------Start Save & Load-----------------------------------------//
		
		Savebtn = new JButton();
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\save.png");
		Savebtn.setIcon(img);
		Savebtn.setForeground(Color.WHITE);
		Savebtn.setToolTipText("Save");
		Savebtn.setBounds(220, 40, 70, 50);
		Savebtn.setContentAreaFilled(false);
		Savebtn.setFocusPainted(false);
		Savebtn.setBorderPainted(false);
		Savebtn.addActionListener(actionListener);
		frame.getContentPane().add(Savebtn);
		
		Loadbtn = new JButton();
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\download.png");
		Loadbtn.setIcon(img);
		Loadbtn.setForeground(Color.WHITE);
		Loadbtn.setToolTipText("Load");
		Loadbtn.setBounds(300, 40, 70, 50);
		Loadbtn.setContentAreaFilled(false);
		Loadbtn.setFocusPainted(false);
		Loadbtn.setBorderPainted(false);
		Loadbtn.addActionListener(actionListener);
		frame.getContentPane().add(Loadbtn);
		
		//------------------------------------End Save & Load------------------------------------------//
		
		//-----------------------------------Start Undo & Redo-----------------------------------------//
		
		Redobtn = new JButton();
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\redo.png");
		Redobtn.setIcon(img);
		Redobtn.setBounds(50, 40, 70, 50);
		Redobtn.setForeground(Color.WHITE);
		Redobtn.setToolTipText("Redo");
		Redobtn.setContentAreaFilled(false);
		Redobtn.setFocusPainted(false);
		Redobtn.setBorderPainted(false);
		Redobtn.addActionListener(actionListener);
		frame.getContentPane().add(Redobtn);
		
		Undobtn = new JButton();
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\undo.png");
		Undobtn.setIcon(img);
		Undobtn.setBounds(120, 40, 70, 50);
		Undobtn.setForeground(Color.WHITE);
		Undobtn.setToolTipText("Undo");
		Undobtn.setContentAreaFilled(false);
		Undobtn.setFocusPainted(false);
		Undobtn.setBorderPainted(false);
		Undobtn.addActionListener(actionListener);
		frame.getContentPane().add(Undobtn);
		
		//------------------------------------End Undo & Redo------------------------------------------//
		
		//--------------------------------------Start Shapes-------------------------------------------//

		Linebtn = new JButton("L");
		Linebtn.setToolTipText("Line");
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\Line.png");
		Linebtn.setIcon(img);
		Linebtn.setContentAreaFilled(false);
		Linebtn.setFocusPainted(false);
		Linebtn.setBorderPainted(false);
		Linebtn.addActionListener(actionListener);
		Linebtn.setBounds(5, 219, 70, 50);
		frame.getContentPane().add(Linebtn);

		Polygonbtn = new JButton("p");
		Polygonbtn.setToolTipText("Polygon");
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\Polygon.png");
		Polygonbtn.setIcon(img);
		Polygonbtn.setContentAreaFilled(false);
		Polygonbtn.setFocusPainted(false);
		Polygonbtn.setBorderPainted(false);
		Polygonbtn.addActionListener(actionListener);
		Polygonbtn.setBounds(5, 280, 70, 50);
		frame.getContentPane().add(Polygonbtn);

		Elipsebtn = new JButton("E");
		Elipsebtn.setToolTipText("Elipse");
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\ellipse.png");
		Elipsebtn.setIcon(img);
		Elipsebtn.setContentAreaFilled(false);
		Elipsebtn.setFocusPainted(false);
		Elipsebtn.setBorderPainted(false);
		Elipsebtn.addActionListener(actionListener);
		Elipsebtn.setBounds(5, 341, 70, 50);
		frame.getContentPane().add(Elipsebtn);

		Trianglebtn = new JButton("T");
		Trianglebtn.setToolTipText("Triangle");
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\triangle.png");
		Trianglebtn.setIcon(img);
		Trianglebtn.setContentAreaFilled(false);
		Trianglebtn.setFocusPainted(false);
		Trianglebtn.setBorderPainted(false);
		Trianglebtn.addActionListener(actionListener);
		Trianglebtn.setBounds(5, 402, 70, 50);
		frame.getContentPane().add(Trianglebtn);

		selectctbtn = new JButton("S");
		selectctbtn.setToolTipText("Selcet Plugin");
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\select.png");
		selectctbtn.setIcon(img);
		selectctbtn.setContentAreaFilled(false);
		selectctbtn.setFocusPainted(false);
		selectctbtn.setBorderPainted(false);
		selectctbtn.setBounds(5, 97, 70, 50);
		selectctbtn.addActionListener(actionListener);
		frame.getContentPane().add(selectctbtn);

		penbtn = new JButton("P");
		penbtn.setToolTipText("Pen");
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\pen.png");
		penbtn.setIcon(img);
		penbtn.setContentAreaFilled(false);
		penbtn.setFocusPainted(false);
		penbtn.setBorderPainted(false);
		penbtn.setBounds(5, 158, 70, 50);
		frame.getContentPane().add(penbtn);
		
		//--------------------------------------End Shapes--------------------------------------------//
		
		//----------------------------------Start Control Panel---------------------------------------//

		controlPanel = new JPanel();
		controlPanel.setBackground(Color.WHITE);
		controlPanel.setBounds(1080, 97, 272, 70);
		frame.getContentPane().add(controlPanel);
		controlPanel.setLayout(null);
		controlPanel.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Add Shape");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setBounds(96, 6, 89, 23);
		controlPanel.add(lblNewLabel);

		Enterbtn = new JButton("Enter");
		Enterbtn.setToolTipText("Enter");
		Enterbtn.addActionListener(actionListener);
		Enterbtn.setBounds(96, 31, 89, 23);
		controlPanel.add(Enterbtn);
		
		//------------------------------------End Control Panel-----------------------------------------//
		
		//------------------------------------Start Layers Panel----------------------------------------//
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(1080, 185, 272, 48);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Layers");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setForeground(SystemColor.textHighlight);
		lblNewLabel_5.setBounds(107, 11, 59, 26);
		panel_5.add(lblNewLabel_5);

		LayersPanel = new JPanel();
		LayersPanel.setBackground(Color.WHITE);
		LayersPanel.setBounds(1080, 233, 272, 458);
		frame.getContentPane().add(LayersPanel);
		LayersPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		//------------------------------------End Layers Panel-----------------------------------------//
		
		//------------------------------------Start Prop Panel-----------------------------------------//
		
		propPanel = new JPanel();
		propPanel.setBackground(Color.WHITE);
		propPanel.setBounds(1080, 97, 272, 70);
		frame.getContentPane().add(propPanel);
		propPanel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("UPDATE & Remove");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setForeground(SystemColor.textHighlight);
		lblNewLabel_4.setBounds(63, 11, 164, 14);
		propPanel.add(lblNewLabel_4);
		
		Applybtn = new JButton("Apply");
		Applybtn.setToolTipText("Apply");
		Applybtn.setBounds(10, 36, 89, 23);
		Applybtn.addActionListener(actionListener);
		propPanel.add(Applybtn);
		
		Removebtn = new JButton("Remove");
		Removebtn.setToolTipText("Remove");
		Removebtn.addActionListener(actionListener);
		Removebtn.setBounds(173, 36, 89, 23);
		propPanel.add(Removebtn);
		
		//------------------------------------End Prop Panel-----------------------------------------//
		
		//----------------------------------Start close buttons------------------------------------//
		
		Exitbtn = new JButton("Exit");
		Exitbtn.setToolTipText("Exit");
		Exitbtn.setBounds(1282, 40, 70, 40);
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\close.png");
		Exitbtn.setIcon(img);
		Exitbtn.setContentAreaFilled(false);
		Exitbtn.setFocusPainted(false);
		Exitbtn.setBorderPainted(false);
		Exitbtn.addActionListener(actionListener);
		frame.getContentPane().add(Exitbtn);
		
		Help_2btn = new JButton("Help");
		Help_2btn.setToolTipText("Help");
		Help_2btn.setBounds(1202, 40, 70, 40);
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\help.png");
		Help_2btn.setIcon(img);
		Help_2btn.setContentAreaFilled(false);
		Help_2btn.setFocusPainted(false);
		Help_2btn.setBorderPainted(false);
		Help_2btn.addActionListener(actionListener);
		frame.getContentPane().add(Help_2btn);
		
		Newbtn = new JButton("New");
		Newbtn.setToolTipText("New");
		Newbtn.setBounds(1122, 40, 70, 40);
		img = new ImageIcon(
				"C:\\Users\\HP\\workspace\\paint\\src\\eg\\edu\\alexu\\csd\\oop\\draw\\cs23\\view\\file.png");
		Newbtn.setIcon(img);
		Newbtn.setContentAreaFilled(false);
		Newbtn.setFocusPainted(false);
		Newbtn.setBorderPainted(false);
		Newbtn.addActionListener(actionListener);
		frame.getContentPane().add(Newbtn);
		
		//-----------------------------------End close buttons-------------------------------------//
		
		//-----------------------------------Start color buttons----------------------------------//
		
		BorderColorbtn = new JButton("");
		BorderColorbtn.setToolTipText("Choose Border Color");
		BorderColorbtn.addActionListener(actionListener);
		BorderColorbtn.setBounds(730, 54, 31, 23);
		frame.add(BorderColorbtn);

		FillColorbtn = new JButton("");
		FillColorbtn.setToolTipText("Choose Fill Color");
		FillColorbtn.addActionListener(actionListener);
		FillColorbtn.setBounds(585, 54, 31, 23);
		frame.add(FillColorbtn);
		
		JLabel lblFillColor = new JLabel("Fill Color :");
		lblFillColor.setForeground(Color.WHITE);
		lblFillColor.setBounds(515, 58, 60, 14);
		frame.getContentPane().add(lblFillColor);
		
		JLabel lblBorderColor = new JLabel("Border Color :");
		lblBorderColor.setForeground(Color.WHITE);
		lblBorderColor.setBounds(642, 58, 80, 14);
		frame.getContentPane().add(lblBorderColor);
		
		//-----------------------------------End color buttons----------------------------------//
		
		//-----------------------------------Start plugin--------------------------------------//
		
		PlugPanle = new JPanel();
		PlugPanle.setBackground(Color.DARK_GRAY);
		PlugPanle.setForeground(Color.DARK_GRAY);
		PlugPanle.setBounds(11, 459, 50, 232);
		frame.getContentPane().add(PlugPanle);
		
		//-----------------------------------------End plugin-----------------------------------//
	}
	
	public void setFillColor(Color c){
		FillColorbtn.setBackground(c);
		FillColorbtn.setForeground(c);
	}
	
	public void setBorderColor(Color c){
		BorderColorbtn.setBackground(c);
		BorderColorbtn.setForeground(c);;
	}
}
