package org.santotomas.library_app;

import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        Login window = new Login("Administrador de Libreria"); // Al iniciar el programa creamos la ventana del Login
    }
}
