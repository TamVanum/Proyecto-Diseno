package org.santotomas.library_app;

import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatIntelliJLaf());
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Login("Login"); // Al iniciar el programa creamos la ventana del Login
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
