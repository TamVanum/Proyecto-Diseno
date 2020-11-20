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
                Login login = null;
                try {
                    login = new Login("Login"); // Al iniciar el programa creamos la ventana del Login
                } catch (SQLException throwables) {
                    JOptionPane.showMessageDialog(null, "Error de Conexion: " + throwables.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "No se encuentran los drivers: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        });

    }
}
