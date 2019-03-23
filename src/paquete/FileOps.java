/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Sistemas
 */
public class FileOps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle("choosertitle");
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);

    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
     // System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
     // System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
    } else {
     // System.out.println("No Selection ");
    }
        //File folder = new File("\\Projects\\sample");
        
        String ruta=chooser.getSelectedFile()+"";
        File folder = new File(ruta);
        
        File[] listOfFiles = folder.listFiles();
        String[] NombresDeArchivoConExtension = new String[listOfFiles.length];
        String[] NombresDeArchivo = new String[listOfFiles.length];
        String[] ExtensionesDeArchivo = new String[listOfFiles.length];
        
        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                NombresDeArchivoConExtension[i]=listOfFiles[i].getName();
                if(NombresDeArchivo[i].contains("."))
                {
                    NombresDeArchivo[i]=NombresDeArchivoConExtension[i].substring(0,NombresDeArchivoConExtension[i].lastIndexOf('.'));
                    System.out.println(NombresDeArchivo[i].substring(NombresDeArchivo[i].lastIndexOf('.'), NombresDeArchivo[i].length()));
                }
                File f = new File(ruta+listOfFiles[i].getName()); 
                
                //System.out.println(listOfFiles[i].getName());
                f.renameTo(new File(ruta+i));
            }
        }

        System.out.println("conversion is done");
    }
    
}
