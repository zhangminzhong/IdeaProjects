package test1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created with IntelliJ IDEA.
 * User: zmz
 * Date: 16-7-12
 * Time: 下午3:00
 * To change this template use File | Settings | File Templates.
 */
public class TestActionEvent extends Frame {
    public TestActionEvent(){
        this.setBounds(200,200,600,800);
        Button b = new Button("press me");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("a button has been pressed");
            }
        });
        this.add(b,BorderLayout.CENTER);
        //this.pack();
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.setVisible(true);

    }
    public static void main(String[] args){
        new TestActionEvent();
    }
}
