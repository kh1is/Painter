package eg.edu.alexu.csd.oop.draw.cs23.controller;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.cs23.json.JSONArray;
import eg.edu.alexu.csd.oop.draw.cs23.json.JSONObject;
import eg.edu.alexu.csd.oop.draw.cs23.json.parser.JSONParser;
import eg.edu.alexu.csd.oop.draw.cs23.json.parser.ParseException;
import eg.edu.alexu.csd.oop.draw.cs23.model.Elipse;
import eg.edu.alexu.csd.oop.draw.cs23.model.Line;
import eg.edu.alexu.csd.oop.draw.cs23.model.Polygon;
import eg.edu.alexu.csd.oop.draw.cs23.model.Triangle;
import eg.edu.alexu.csd.oop.draw.cs23.view.Gui;

public class Draw extends JPanel implements DrawingEngine {

	private String shape;
	private Color  borderColor ;
	private Color  fillColor ;
	private int x;
	private int y;
	
	private int currentSelected;
	private int currentSelected1;
	private final int base = 10;
	private ArrayList<String> nameOfShapes = new ArrayList<String>();
	
	
	private Stack<Shape> shapes = new Stack<Shape>();
	private Stack<Shape> undoShapes = new Stack<Shape>();
	private Stack<Shape> loadShapes = new Stack<Shape>();
	private Stack<Shape> classShapesAdded = new Stack<Shape>();
	
	//Gui g = new Gui();
	
	public void drawing() {
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		refresh(g);
		
	}

	public void setNameShape(String s) {
		this.shape = s;
		
	}
	
	public void setFillColor(Color c){
		this.fillColor = c;
		//g.setFillColor();
		
	}
	
	public void setBorderColor(Color c){
		this.borderColor = c;
	//	g.setBorderColor();
	}

	public void setParameters(JFrame f,int x, int y) {
		this.x = x;
		this.y = y;
		
		setShape(f);
	}
	
	public void setShape(JFrame f){
		if(this.shape == "line"){
			Shape s = new Line();
			Point p = new Point();
			p.x = this.x;
			p.y = this.y;
			Map<String , Double> prop = s.getProperties();
			
			String[] keys = new String[prop.size()];
			int h=0;
			for (String str: prop.keySet()) {
	            keys[h] = str;
				h++;
			}
			
			for(int i=0;i<prop.size();i++){
				String x = JOptionPane.showInputDialog(f, keys[i]);
				prop.put(keys[i], readNumber(x));
			}
			
			s.setPosition(p);
			s.setProperties(prop);
			s.setColor(this.borderColor);
			s.setFillColor(this.fillColor);
			this.nameOfShapes.add(this.shape);
			addShape(s);
			this.shape = null;
		}
		else if(this.shape == "polygon"){
			Shape s = new Polygon();
			Point p = new Point();
			p.x = this.x;
			p.y = this.y;
			Map<String , Double> prop = s.getProperties();
			
			String[] keys = new String[prop.size()];
			int h=0;
			for (String str: prop.keySet()) {
	            keys[h] = str;
				h++;
			}
			
			for(int i=0;i<prop.size();i++){
				String x = JOptionPane.showInputDialog(f, keys[i]);
				prop.put(keys[i], readNumber(x));
			}
			s.setPosition(p);
			s.setProperties(prop);
			s.setColor(this.borderColor);
			s.setFillColor(this.fillColor);
			this.nameOfShapes.add(this.shape);
			addShape(s);
			this.shape = null;
		}
		else if(this.shape == "elipse"){
			Shape s = new Elipse();
			Point p = new Point();
			p.x = this.x;
			p.y = this.y;
			Map<String , Double> prop = s.getProperties();
			
			String[] keys = new String[prop.size()];
			int h=0;
			for (String str: prop.keySet()) {
	            keys[h] = str;
				h++;
			}
			
			for(int i=0;i<prop.size();i++){
				String x = JOptionPane.showInputDialog(f, keys[i]);
				prop.put(keys[i], readNumber(x));
			}
			s.setPosition(p);
			s.setProperties(prop);
			s.setColor(this.borderColor);
			s.setFillColor(this.fillColor);
			this.nameOfShapes.add(this.shape);
			addShape(s);
			this.shape = null;
		}
		
		else if(this.shape == "triangle"){
			Shape s = new Triangle();
			Point p = new Point();
			p.x = this.x;
			p.y = this.y;
			Map<String , Double> prop = s.getProperties();
			
			String[] keys = new String[prop.size()];
			int h=0;
			for (String str: prop.keySet()) {
	            keys[h] = str;
				h++;
			}
			
			for(int i=0;i<prop.size();i++){
				String x = JOptionPane.showInputDialog(f, keys[i]);
				prop.put(keys[i], readNumber(x));
			}
			s.setPosition(p);
			s.setProperties(prop);
			s.setColor(this.borderColor);
			s.setFillColor(this.fillColor);
			this.nameOfShapes.add(this.shape);
			addShape(s);
			this.shape = null;
		}
		else{
			Shape s = classShapesAdded.get(currentSelected1);
			Point p = new Point();
			p.x = this.x;
			p.y = this.y;
			Map<String , Double> prop = s.getProperties();
			
			String[] keys = new String[prop.size()];
			int h=0;
			for (String str: prop.keySet()) {
	            keys[h] = str;
				h++;
			}
			
			for(int i=0;i<prop.size();i++){
				String x = JOptionPane.showInputDialog(f, keys[i]);
				prop.put(keys[i], readNumber(x));
			}
			s.setPosition(p);
			s.setProperties(prop);
			s.setColor(this.borderColor);
			s.setFillColor(this.fillColor);
			this.nameOfShapes.add("Shape" + currentSelected1);
			addShape(s);
		}
		
	}
	
	public void setUpdateShape(JFrame f,Color borderC,Color fillC,int x, int y){
		this.x = x;
		this.y = y;
		
		
		Shape s = shapes.get(currentSelected);
		Point p = new Point();
		p.x = this.x;
		p.y = this.y;
		Map<String , Double> prop = s.getProperties();
		
		String[] keys = new String[prop.size()];
		int h=0;
		for (String str: prop.keySet()) {
            keys[h] = str;
			h++;
		}
		
		for(int i=0;i<prop.size();i++){
			String o = JOptionPane.showInputDialog(f, keys[i]);
			prop.put(keys[i], readNumber(o));
		}
		s.setPosition(p);
		s.setProperties(prop);
		s.setColor(borderC);
		s.setFillColor(fillC);
		
		updateShape(shapes.get(currentSelected),s);
	}
	
	public void DynamicPanel(JPanel p) {
		p.removeAll();
		int i;
		for (i = 0; i < this.shapes.size(); i++) {
			JButton temp = new JButton("Shape" + i);
			temp.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentSelected = temp.getText().charAt(temp.getText().length() - 1) - '0';
				}
			});
			p.add(temp);
		}
	}
	
	public void DynamicPlgIn(JPanel p,JPanel p1,JPanel p2) {
		p.removeAll();
		int i;
		for (i = 0; i < this.classShapesAdded.size(); i++) {
			JButton temp = new JButton("Shape" + i);temp.setContentAreaFilled(false);
			temp.setFocusPainted(false);
			temp.setBorderPainted(false);
			temp.setForeground(Color.WHITE);
			temp.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					currentSelected1 = temp.getText().charAt(temp.getText().length() - 1) - '0';
					p1.validate();
					p1.repaint();
					p1.setVisible(true);
					p2.setVisible(false);
				}
			});
			p.add(temp);
		}
	}
	
	
	public void remove(){
		removeShape(shapes.get(this.currentSelected));
	}
	

	private double readNumber(final String s) {
		double num = 0;
		int p = s.length(); // point initial place
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				p = i;
				break;
			}
		}
		if (p != s.length()) {
			int t = -1;
			for (int i = p + 1; i < s.length(); i++) {
				num = num + (s.charAt(i) - '0') * Math.pow(this.base, t);
				t--;
			}
		}
		int t = 0;
		for (int i = p - 1; i > -1; i--) {
			num = num + (s.charAt(i) - '0') * Math.pow(this.base, t);
			t++;
		}
		return num;
	}
	
	public void classLoader(String path){
		try {
			JarInputStream jarFile = new JarInputStream(new FileInputStream(path));
			File myJar = new File(path);
			URL url = myJar.toURI().toURL();
			Class[] parameters = new Class[] { URL.class };
			URLClassLoader sysLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
			Class sysClass = URLClassLoader.class;
								
			//DRAW_ENGINE.supportedClasses.add(sysClass);
			Method method = sysClass.getDeclaredMethod("addURL", parameters);
			method.setAccessible(true);
			method.invoke(sysLoader, new Object[] { url });
			JarEntry jarEntry;
			while (true) {
				jarEntry = jarFile.getNextJarEntry();
				if (jarEntry == null) {
					break;
				}
				if (jarEntry.getName().endsWith(".class")) {
					String name = jarEntry.getName().replaceAll("/", "\\.").replace(".class", "");
					JOptionPane.showMessageDialog(null, name);
					Constructor cs = ClassLoader.getSystemClassLoader().loadClass(name).getConstructor();
					Shape x = (Shape) cs.newInstance();
					classShapesAdded.add(x);
				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "error");
		}

	}
	
	

	@Override
	public void refresh(Graphics canvas) {
		// TODO Auto-generated method stub
		
		
		for(int i=0;i<shapes.size();i++){
			shapes.get(i).draw(canvas);
		}
		
	}

	@Override
	public void addShape(Shape shape) {
		// TODO Auto-generated method stub
		
		shapes.push(shape);
		undoShapes.clear();
		repaint();
	}

	@Override
	public void removeShape(Shape shape) {
		// TODO Auto-generated method stub
		for(int i=0;i<shapes.size();i++){
			if(shapes.get(i).equals(shape)){
				shapes.remove(i);
				nameOfShapes.remove(i);
			}
		}
		undoShapes.clear();
		repaint();
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		// TODO Auto-generated method stub
		for(int i=0;i<shapes.size();i++){
			if(shapes.get(i).equals(oldShape)){
				
				shapes.set(i, newShape);
			}
		}
		undoShapes.clear();
		repaint();
	}

	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
		Shape[] s = new Shape[shapes.size()];
		for(int i=0;i<shapes.size();i++){
			s[i] = shapes.get(i);
		}
		
		return s;
		
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		LinkedList<Class<? extends Shape>> supportedShapes = new LinkedList<>();
		supportedShapes.add(Line.class);
		supportedShapes.add(Elipse.class);
		supportedShapes.add(Polygon.class);
		supportedShapes.add(Triangle.class);
		return supportedShapes;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		if(shapes.size() > 0){
			if(undoShapes.size() < 20){
				undoShapes.push(shapes.pop());
			}
			else if(undoShapes.size() == 20){
				undoShapes.remove(0);
				undoShapes.push(shapes.pop());
			}
			repaint();
		}
	
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		if(undoShapes.size()>0){
			shapes.push(undoShapes.pop());
			repaint();
		}
		
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public void save(String path) {
		// TODO Auto-generated method stub
		
		for(int i=path.length()-1;i>0;i--){
			if(path.charAt(i) == '.'){
				
				if(path.charAt(i+1) == 'x'){
					try{
						FileOutputStream fos = new FileOutputStream(new File(path));
						XMLEncoder encoder = new XMLEncoder(fos);
						encoder.writeObject(shapes.size());
						for(int j=0;j<shapes.size();j++){
							encoder.writeObject(nameOfShapes.get(j));
							encoder.writeObject(shapes.get(j));
						}
						encoder.close();
						fos.close();
					}
					catch(IOException ex){
						ex.printStackTrace();
					}
				}
				
				if(path.charAt(i+1) == 'j'){
					
					JSONObject obj = new JSONObject();
					
					JSONArray names = new JSONArray();
					JSONArray pX = new JSONArray();
					JSONArray pY = new JSONArray();
					JSONArray width = new JSONArray();
					JSONArray length = new JSONArray();
					JSONArray pX2 = new JSONArray();
					JSONArray pY2 = new JSONArray();
					JSONArray color = new JSONArray();
					JSONArray fillcolor = new JSONArray();
					
					
					for(int j=0;j<shapes.size();j++){
						names.add(nameOfShapes.get(j));
						pX.add(shapes.get(j).getPosition().getX());
						pY.add(shapes.get(j).getPosition().getY());
						width.add(shapes.get(j).getProperties().get("Width"));
						length.add(shapes.get(j).getProperties().get("Length"));
						if(nameOfShapes.get(j).equalsIgnoreCase("triangle")){
							pX2.add(shapes.get(j).getProperties().get("X2"));
							pY2.add(shapes.get(j).getProperties().get("Y2"));
						}
						color.add(shapes.get(j).getColor().hashCode());
						fillcolor.add(shapes.get(j).getFillColor().hashCode());
					}
					obj.put("names", names);
					obj.put("pX", pX);
					obj.put("pY", pY);
					obj.put("width", width);
					obj.put("length", length);
					obj.put("pX2", pX2);
					obj.put("pY2", pY2);
					obj.put("color", color);
					obj.put("fillcolor", fillcolor);
				
					
					try(FileWriter file = new FileWriter(path))
					{
						file.write(obj.toJSONString());
						
						file.flush();
						
					}
					catch(IOException ex){
						ex.printStackTrace();
					}
					
				}
			}
		}
		
		//undoShapes.clear();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		
		for(int i=path.length()-1;i>0;i--){
			if(path.charAt(i) == '.'){
				if(path.charAt(i+1) == 'x'){
					try{
						FileInputStream fis = new FileInputStream(new File(path));
						XMLDecoder decoder = new XMLDecoder(fis);
						int numShape = (int)decoder.readObject();
						System.out.println("c=" + numShape);
						for(int j=0;j<numShape;j++){
							nameOfShapes.add((String)decoder.readObject());
							loadShapes.push((Shape)decoder.readObject());
						}
						decoder.close();
						fis.close();
						
					}
					catch(IOException ex){
						ex.printStackTrace();
					}
					
				
				}
				
				if(path.charAt(i+1) == 'j'){
					
					
					JSONParser parser = new JSONParser();

			        try {

			            Object obj = parser.parse(new FileReader(path));
						
						JSONObject jsonObject = (JSONObject) obj;
						
						JSONArray names = (JSONArray)jsonObject.get("names");
						JSONArray pX = (JSONArray)jsonObject.get("pX");
						JSONArray pY = (JSONArray)jsonObject.get("pY");
						JSONArray width = (JSONArray)jsonObject.get("width");
						JSONArray length = (JSONArray)jsonObject.get("length");
						JSONArray pX2 = (JSONArray)jsonObject.get("pX2");
						JSONArray pY2 = (JSONArray)jsonObject.get("pY2");
						JSONArray color = (JSONArray)jsonObject.get("color");
						JSONArray fillcolor = (JSONArray)jsonObject.get("fillcolor");
						
						Iterator<String> iterator = names.iterator();
						Iterator<Double> iterator2 = pX.iterator();
						Iterator<Double> iterator3 = pY.iterator();
						Iterator<Double> iterator4= width.iterator();
						Iterator<Double> iterator5 = length.iterator();
						Iterator<Long> iterator6 = color.iterator();
						Iterator<Long> iterator7 = fillcolor.iterator();
						Iterator<Double> iterator8 = pX2.iterator();
						Iterator<Double> iterator9 = pY2.iterator();
						
						
						ArrayList<String> name = new ArrayList<String>();
						
						int counter = 0;
						while(iterator.hasNext()){
							String ss = iterator.next();
							name.add(ss);
							nameOfShapes.add(ss);
							counter++;	
						}
						
						
						int k1=0,k2=0,k3=0,k4=0,k5=0,k6=0,k7=0,k8=0;
						Point[] p = new Point[counter];
						double[] X2 = new double[counter];
						double[] Y2 = new double[counter];
						Map<String ,Double>[] prop = new HashMap[counter];
						Color[] colorB = new Color[counter];
						Color[] colorF = new Color[counter];
						while(iterator2.hasNext()){
							
							p[k1] = new Point();
							p[k1].x = (int)readNumber(iterator2.next().toString());
							k1++;
						
						}
						while(iterator3.hasNext()){
							
							p[k2].y = (int)readNumber(iterator3.next().toString());
							
							k2++;
							
						}
						while(iterator4.hasNext()){
							
							prop[k3] = new HashMap();
							prop[k3].put("Width", iterator4.next());
							
							k3++;
							
							
							
						}
						while(iterator5.hasNext()){
						
							prop[k4].put("Length", iterator5.next());
						
							k4++;
							
							
						}
						
						while(iterator6.hasNext()){
							Long l = iterator6.next();
							int w = Integer.parseInt(l.toString());
							colorB[k5] = new Color(w);
							k5++;
						}
						
						
						while(iterator7.hasNext()){
							Long l = iterator7.next();
							int w = Integer.parseInt(l.toString());
							colorF[k6] = new Color(w);
							k6++;
						}
						
						while(iterator8.hasNext()){
							
							X2[k7] = iterator8.next();
							k7++;
						}
						
						while(iterator9.hasNext()){
							
							Y2[k8] = iterator9.next();
							k8++;
						}
						int o=0;
						for(int u=0;u<name.size();u++){
							if(name.get(u).equalsIgnoreCase("triangle")){
								prop[u].put("X2", X2[o]);
								prop[u].put("Y2", Y2[o]);
								o++;
							}
						}
						for(int z=0;z<counter;z++){
							if(name.get(z).equalsIgnoreCase("line")){
								
								Shape s = new Line();
								s.setPosition(p[z]);
								s.setProperties(prop[z]);
								s.setColor(colorB[z]);
								s.setFillColor(colorF[z]);
								loadShapes.push(s);
							}
							if(name.get(z).equalsIgnoreCase("polygon")){
								Shape s = new Polygon();
								s.setPosition(p[z]);
								s.setProperties(prop[z]);
								s.setColor(colorB[z]);
								s.setFillColor(colorF[z]);
								loadShapes.push(s);
							}
							if(name.get(z).equalsIgnoreCase("elipse")){
								Shape s = new Elipse();
								s.setPosition(p[z]);
								s.setProperties(prop[z]);
								s.setColor(colorB[z]);
								s.setFillColor(colorF[z]);
								loadShapes.push(s);
							}
							if(name.get(z).equalsIgnoreCase("triangle")){
								
								Shape s = new Triangle();
								s.setPosition(p[z]);
								s.setProperties(prop[z]);
								s.setColor(colorB[z]);
								s.setFillColor(colorF[z]);
								loadShapes.push(s);
							}

						}
						
						
					}
					catch(FileNotFoundException e){e.printStackTrace();}
					catch(IOException e){e.printStackTrace();}
					catch(ParseException e){e.printStackTrace();}
					catch(Exception e){e.printStackTrace();}
					
					
					
				}
		    }
		}
		
		for(int d=0;d<loadShapes.size();d++){
			addShape(loadShapes.get(d));
		}
	
	}

}
