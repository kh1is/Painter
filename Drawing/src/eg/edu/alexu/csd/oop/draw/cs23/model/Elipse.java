package eg.edu.alexu.csd.oop.draw.cs23.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Elipse implements Shape {

	protected Point p;
    protected Map<String, Double> prop;
    protected Color c;
    protected Color fc;
    
    public Elipse(){
    	
    	  prop = new HashMap<>();
	      prop.put("Width", 0.0);
	      prop.put("Length", 0.0);
	      
    }
    
    
	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub

		p = position;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return p;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub

		prop = properties;
	}

	@Override
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub
		return prop;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub

		c = color;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public void setFillColor(Color color) {
		// TODO Auto-generated method stub

		fc = color;
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return fc;
	}

	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub

		 ((Graphics2D) canvas).setColor(getFillColor());
		 ((Graphics2D) canvas).fillOval((int) p.getX(), (int) p.getY(), 
				 					(int) prop.get("Width").intValue(),
				 					(int) prop.get("Length").intValue());
		 ((Graphics2D) canvas).setStroke(new BasicStroke(2));
	     ((Graphics2D) canvas).setColor(getColor());
	     ((Graphics2D) canvas).drawOval((int) p.getX(), (int) p.getY(), 
					(int) prop.get("Width").intValue(),
					(int) prop.get("Length").intValue());
	}

	 @Override
	 public Object clone() throws CloneNotSupportedException {
		 
		 Shape r = new Elipse();
		 r.setColor(c);
	     r.setFillColor(fc);
	     r.setPosition(p);
	     Map newprop = new HashMap<>();
	     for (Map.Entry s: prop.entrySet())
	            newprop.put(s.getKey(), s.getValue());
	     r.setProperties(newprop);
	     
	     return r;
		 
	 }
	 
	 
	 
	 
}
