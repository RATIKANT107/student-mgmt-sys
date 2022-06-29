package AppPackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TitleBar extends JFrame
{
    JFrame frame;
    int xMouse, yMouse;
    JPanel panel; 
    
    public TitleBar(JFrame frame)
    {
        this.frame = frame;
        frame.setUndecorated(true);
        frame.setResizable(false);
    }
    
    public TitleBar(JPanel panel, JFrame frame)
    {
        this.panel = panel;     
        this.frame = frame;
    }
    
    public void setJFrameMovable()
    {
       frame.addMouseMotionListener(new MouseMotionAdapter() 
       {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();
                
                frame.setLocation(x-xMouse, y-yMouse);
            }

       }
       );
       
       frame.addMouseListener(new MouseAdapter() 
       {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
               xMouse = evt.getX();
               yMouse = evt.getY();
            }

       }
       );
       
    }
    
    public void setJPanelMovable()
    {
       panel.addMouseMotionListener(new MouseMotionAdapter() 
       {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt)
            {
                int x = evt.getXOnScreen();
                int y = evt.getYOnScreen();
                
                frame.setLocation(x-xMouse, y-yMouse);
            }

       }
       );
       
       panel.addMouseListener(new MouseAdapter() 
       {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt)
            {
               xMouse = evt.getX();
               yMouse = evt.getY();
            }
       }
       );
       
    }
    
    
}
