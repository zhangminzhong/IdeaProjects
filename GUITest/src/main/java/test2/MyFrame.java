package test2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-12
 * Time: 下午3:44
 * To change this template use File | Settings | File Templates.
 */
public class MyFrame extends Frame {
    private ArrayList<Point> points = null;
    public MyFrame(String s){
        super(s);
        points = new ArrayList<Point>();
        this.setBounds(200,200,800,600);
        this.setVisible(true);
        this.addMouseListener(new MouseMonitor());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public static void main(String[] args){
        new MyFrame("Drawing...");
    }
    public void paint(Graphics g){
        Iterator<Point> iterator = points.iterator();
        while(iterator.hasNext()){
            Point p = iterator.next();
            g.setColor(Color.BLUE);
            g.fillOval(p.x,p.y,10,10);
        }
    }
    private class MouseMonitor extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            points.add(new Point(e.getX(),e.getY()));
            repaint();
        }
    }

}
