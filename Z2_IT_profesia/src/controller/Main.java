/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import view.HomeFrame;

/**
 * Tento projekt vznikol v ramci predmetu VAVA na FIIT STU.
 * 
 * @author Akos Kappel
 */
public class Main {

    public static void main(String[] args) {

        File directory = new File(DataSerializer.DIRECTORY_NAME);
        if (!directory.exists()) {
            directory.mkdir();
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.INFO,
                    "Created new directory - {0}\n", DataSerializer.DIRECTORY_NAME);
        }

        HomeFrame mainFrame = new HomeFrame();
        mainFrame.runGUI(args);
    }

}
