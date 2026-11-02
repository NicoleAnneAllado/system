
package jv.mavenproject1;

import Controller.HomepageController;
import Controller.LoginController;
import SystemUI.HomepageView;
import View.LogInView;

public class Mavenproject1 {

    public static void main(String[] args) {
        HomepageView hv = new HomepageView();
        hv.setVisible(true);
        new HomepageController(hv);
        
        
        
    }
}
