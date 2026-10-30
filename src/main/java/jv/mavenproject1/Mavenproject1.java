/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package jv.mavenproject1;

import Controller.HomepageController;
import Controller.LoginController;
import View.HomepageView;
import View.LogInView;

/**
 *
 * @author NICS
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        HomepageView hv = new HomepageView();
        hv.setVisible(true);
        new HomepageController(hv);
    }
}
