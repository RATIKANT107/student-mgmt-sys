package AppPackage;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NavigationBar 
{
    public Color pressedColor, defaultColor, hoverColor;
    Color colorStatus;
    
    public NavigationBar(Color pressedColor, Color defaultColor, Color hoverColor)
    {
        this.pressedColor = pressedColor;
        this.defaultColor = defaultColor;
        this.hoverColor = hoverColor;
    }
    
    public void addComponent(JLabel ... label)
    {
        
        for (int i = 0; i<label.length; i++) 
        {                           
            label[i].addMouseListener(new java.awt.event.MouseAdapter() 
            {
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt)
                {
                     for(int x = 0; x<label.length; x++)
                     {
                        if(evt.getSource() == label[x])
                        {
                            colorStatus = label[x].getBackground();
                            label[x].setBackground(pressedColor);
                        }
                        else
                        {
                            label[x].setBackground(defaultColor);
                        }
                     }
                }   
                
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt)
                {
                     for(int x = 0; x<label.length; x++)
                     {
                        if(evt.getSource() == label[x])
                        {
                            colorStatus = label[x].getBackground();
                            label[x].setBackground(hoverColor);
                        }                        
                     }
                }   
                
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt)
                {
                     for(int x = 0; x<label.length; x++)
                     {
                        if(evt.getSource() == label[x])
                        {
                            label[x].setBackground(colorStatus);
                        }                        
                     }
                }   
                
                @Override
                public void mouseReleased(java.awt.event.MouseEvent evt)
                {
                     for(int x = 0; x<label.length; x++)
                     {
                        if(evt.getSource() == label[x])
                        {
                            colorStatus = label[x].getBackground();
                            label[x].setBackground(colorStatus);
                        }                        
                     }
                }   
                
            });
            
                       
        }
    }   
        
    public void addComponent(JPanel ... panel)
    {
        
        for (int i = 0; i<panel.length; i++) 
        {                           
            panel[i].addMouseListener(new java.awt.event.MouseAdapter() 
            {
                @Override
                public void mousePressed(java.awt.event.MouseEvent evt)
                {
                     for(int x = 0; x<panel.length; x++)
                     {
                        if(evt.getSource() == panel[x])
                        {
                            colorStatus = panel[x].getBackground();
                            panel[x].setBackground(pressedColor);
                        }
                        else
                        {
                            panel[x].setBackground(defaultColor);
                        }
                     }
                }   
                
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt)
                {
                     for(int x = 0; x<panel.length; x++)
                     {
                        if(evt.getSource() == panel[x])
                        {
                            colorStatus = panel[x].getBackground();
                            panel[x].setBackground(hoverColor);
                        }                        
                     }
                }   
                
                @Override
                public void mouseExited(java.awt.event.MouseEvent evt)
                {
                     for(int x = 0; x<panel.length; x++)
                     {
                        if(evt.getSource() == panel[x])
                        {
                            panel[x].setBackground(colorStatus);
                        }                        
                     }
                }   
                
                 @Override
                public void mouseReleased(java.awt.event.MouseEvent evt)
                {
                     for(int x = 0; x<panel.length; x++)
                     {
                        if(evt.getSource() == panel[x])
                        {
                            colorStatus = panel[x].getBackground();
                            panel[x].setBackground(colorStatus);
                        }                        
                     }
                }   
                
            });
            
                       
        }
    }   
    
}
