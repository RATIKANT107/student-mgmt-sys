package AppPackage;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class HoverEffect
{
    int r, g, b, r2, g2, b2;
    
    JLabel label;    
    
    public HoverEffect(JLabel label)
    {
        this.label = label;
    }
       
    public void hoverBackground()
    {
       label.addMouseListener(new java.awt.event.MouseAdapter() 
       {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabelMouseEntered(evt);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabelMouseExited(evt);
            }

       } );
    } 
               
    private void jLabelMouseEntered(MouseEvent evt) 
    {
        label.setBackground(new Color(r, g, b));    
    }
              
    private void jLabelMouseExited(MouseEvent evt) 
    {
       label.setBackground(new Color(r2,g2, b2));       
    }
    
    private void jLabelMouseEnteredForeground(MouseEvent evt) 
    {
        label.setForeground(new Color(r, g, b));    
    }
              
    private void jLabelMouseExitedForeground(MouseEvent evt) 
    {
       label.setForeground(new Color(r2,g2, b2));       
    }
        
    public void setMouseEnteredColor(int r, int g, int b)
    {
        this.r = r;
        this.b = b;
        this.g = g;        
    }
    
    public void setMouseExitedColor(int r, int g, int b)
    {
        this.r2 = r;
        this.b2 = b;
        this.g2 = g;    
    }
    
    public void setMouseEnteredColor(Color c)
    {
       this.r = c.getRed();
       this.g = c.getGreen();
       this.b = c.getBlue();
    }
    
    public void setMouseExitedColor(Color c)
    {
        this.r2 = c.getRed();
        this.g2 = c.getGreen();
        this.b2 = c.getBlue();     
    }
    
    public void hoverForeground()
    {
       label.addMouseListener(new java.awt.event.MouseAdapter() 
       {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                jLabelMouseEnteredForeground(evt);
            }
            
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                jLabelMouseExitedForeground(evt);
            }

       } );
    } 
}
