
package Controller;

import View.HomepageView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomepageController {
    HomepageView hv;
    
    public HomepageController(HomepageView temp){
        hv = temp;
        hv.allListeners(new AllActions());
        
    }
    class AllActions implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           System.out.println("hi");
        }
      }   
   }
