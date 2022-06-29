package AppPackage;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class SubJTable extends JTable {
    @Override
    public Component prepareRenderer(TableCellRenderer ren ,int r, int c)
{

        Component comp;
        comp = super.prepareRenderer(ren, r, c);

    if(r%2==0&&!isCellSelected(r , c))
        
        {
            comp.setBackground(new Color(44, 62, 80));
    
    
        }
    else if(!isCellSelected(r , c))
        {
            comp.setBackground(new Color(52, 73, 94));

        }
    else
    {
        comp.setBackground(comp.getBackground());
    
    }

      return comp;


    }
    
}
