package org.santotomas.library_app;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuLibreria extends JFrame implements ActionListener {
    private JPanel pnlPanel;
    private JTabbedPane tbdHome;
    private JPanel pnlBuscar;
    private JTextField txtBuscar;
    private JCheckBox chkCategoriaTerror;
    private JCheckBox chkCategoriaFantasia;
    private JCheckBox chkCategoriaMagia;
    private JCheckBox chkCategoriaSuspenso;
    private JCheckBox chkCategoriaRomance;
    private JTable tblMuestraLibros;
    private JButton btnBuscar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JLabel lblCategorias;
    private JPanel pnlAgregar;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JCheckBox suspensoCheckBox;
    private JCheckBox terrorCheckBox;
    private JCheckBox fantasiaCheckBox;
    private JCheckBox romanceCheckBox;
    private JTextField textField5;
    private JCheckBox magiaCheckBox;
    private JPanel pnlCerrarSesion;
    private JButton btnCloseSession;

    /**
     * Constructor en el cual definimos lo primero que haga nuestra ventana de menu al crearse (instanciarse)
     * @param titulo titulo de la ventana
     * @param nombre nombre del usuario
     */
    public MenuLibreria(String titulo, String nombre){
        /* Configuramos nuestra ventana */
        super(titulo + nombre);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);


        btnCloseSession.setIcon(new ImageIcon("src/org/santotomas/library_app/img/close_icon.png"));
        btnCloseSession.addActionListener(this);

        DefaultTableModel dtmLibros = new DefaultTableModel();
        dtmLibros.addColumn("Nombre");

        /** add panel */
        add(pnlPanel);
        pack();
        btnCloseSession.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                btnCloseSession.setIcon(new ImageIcon("src/org/santotomas/library_app/img/close_icon_pressed.png"));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                btnCloseSession.setIcon(new ImageIcon("src/org/santotomas/library_app/img/close_icon.png"));
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnCloseSession.setIcon(new ImageIcon("src/org/santotomas/library_app/img/close_icon_hover.png"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnCloseSession.setIcon(new ImageIcon("src/org/santotomas/library_app/img/close_icon.png"));
            }
        });
    }

    /**
     * Funcion que nos obliga a configurar el comportamiento de nuestros botones
     * @param e parámetro que captura el evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == btnActualizar) {
            new UpdateBook();
        } else if (e.getSource() == btnEliminar) {
            JOptionPane.showConfirmDialog(this, "Está seguro,", "Eliminar libro", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        } else if ( e.getSource() == btnCloseSession ) {
            dispose();
            new Login("Bienvenid@");
        }
    }
}
