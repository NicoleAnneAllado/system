
package Controller;

import View.LogInView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginController {
    LogInView lv;
    
    public LoginController(LogInView temp){
        lv = temp;
        lv.allListeners(new AllActions());
        
    }
    class AllActions implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
      }   
   }
