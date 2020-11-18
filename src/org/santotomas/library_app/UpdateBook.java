package org.santotomas.library_app;

/* Paquetes necesarios para crear nuestra ventana */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana con la cual modificamos los datos de un libro existente
 */
public class UpdateBook extends JFrame implements ActionListener {

    /* Componentes de nuestra ventana */
    private JPanel pMain, pCategories;
    private JLabel lblTitle, lblNameBook, lblNameAuthor, lblISBN, lblDescription, lblCategories, lblStock;
    private JTextField txtNameBook, txtNameAuthor, txtISBN, txtDescription, txtStock;
    private JCheckBox chkMagic, chkSuspense, chkTerror, chkFantasy, chkRomance;
    private JButton btnActualizar;

    /* Utilidades que nos ayudaran a configurar nuestros componentes */
    private Dimension txtSize = new Dimension(200, 26);
    private static final Insets LEFT_MARGIN = new Insets(4, 4, 4, 0);
    private static final Insets RIGHT_MARGIN = new Insets(4, 0, 4, 4);
    private static final Insets Y_MARGIN = new Insets(4, 0, 4, 0);
    private GridBagConstraints gbc = new GridBagConstraints();

    /**
     * Constructor donde definimos lo primero que queremos que haga nuestra ventana cuando se crea (instancia)
     */
    public UpdateBook () {

        /* Configuramos nuestra ventana*/
        super("Actualizar Libro");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        setLayout(new BorderLayout(25, 25));

        /* Definir nuestro titulo y lo dejamos en la parte de arriba de nuestra ventana */
        lblTitle = new JLabel("Modificar Libro", SwingConstants.CENTER);
        add(lblTitle, BorderLayout.PAGE_START);

        /* Creamos nuestro panel con el que ordenaremos nuestro componentes de "Formulario" */
        pMain = new JPanel();
        pMain.setLayout(new GridBagLayout()); // con la ayuda de un GridBagLayout


        /* Nombre del Libro */
        lblNameBook = new JLabel("Nombre Libro:");
        setGridCustom(0, 0, 1, 1, LEFT_MARGIN);
        pMain.add(lblNameBook, gbc);

        txtNameBook = new JTextField();
        txtNameBook.setPreferredSize(txtSize);
        setGridCustom(1, 0, 2, 1, RIGHT_MARGIN);
        pMain.add(txtNameBook, gbc);


        /* Nombre del autor */
        lblNameAuthor = new JLabel("Autor:");
        setGridCustom(0, 1, 1, 1, LEFT_MARGIN);
        pMain.add(lblNameAuthor, gbc);

        txtNameAuthor = new JTextField();
        txtNameAuthor.setPreferredSize(txtSize);
        setGridCustom(1, 1, 2, 1, RIGHT_MARGIN);
        pMain.add(txtNameAuthor, gbc);


        /* ISBN */
        lblISBN = new JLabel("ISBN:");
        setGridCustom(0, 2, 1, 1, LEFT_MARGIN);
        pMain.add(lblISBN, gbc);

        txtISBN = new JTextField();
        txtISBN.setEnabled(false);
        txtISBN.setPreferredSize(txtSize);
        setGridCustom(1, 2, 2, 1, RIGHT_MARGIN);
        pMain.add(txtISBN, gbc);


        /* Descripcion */
        lblDescription = new JLabel("Descripcion:");
        setGridCustom(0, 3, 1, 1, LEFT_MARGIN);
        pMain.add(lblDescription, gbc);

        txtDescription = new JTextField();
        txtDescription.setPreferredSize(txtSize);
        setGridCustom(1, 3, 2, 1, RIGHT_MARGIN);
        pMain.add(txtDescription, gbc);


        /* Stock */
        lblStock = new JLabel("Stock:");
        setGridCustom(0, 6, 1, 1, LEFT_MARGIN);
        pMain.add(lblStock, gbc);

        txtStock = new JTextField();
        txtStock.setPreferredSize(txtSize);
        setGridCustom(1, 6, 2, 1, RIGHT_MARGIN);
        pMain.add(txtStock, gbc);


        /* Categorias */
        lblCategories = new JLabel("Categorias");
        setGridCustom(0, 4, 3, 1, Y_MARGIN);
        pMain.add(lblCategories, gbc);

        pCategories = new JPanel();
        pCategories.setLayout(new GridLayout(4, 5, 10, 10));

        chkMagic = new JCheckBox("Magia");
        pCategories.add(chkMagic);

        chkSuspense = new JCheckBox("Suspenso");
        pCategories.add(chkSuspense);

        chkTerror = new JCheckBox("Terror");
        pCategories.add(chkTerror);

        chkFantasy = new JCheckBox("Fantasia");
        pCategories.add(chkFantasy);

        chkRomance = new JCheckBox("Romance");
        pCategories.add(chkRomance);

        setGridCustom(0, 5, 3, 1, Y_MARGIN);
        pMain.add(pCategories, gbc);


        /* Boton de actualizacion */
        btnActualizar = new JButton("Actualizar");
        setGridCustom(1, 7, 1, 1, Y_MARGIN);
        btnActualizar.addActionListener(this);
        pMain.add(btnActualizar, gbc);

        add(pMain, BorderLayout.CENTER);

        pack();
    }

    /**
     * Funcion que nos ayuda a no repetir el codigo en cuanto a modificar nuestra 'Custom Grid' del GridBagLayout
     * @param x fila donde va nuestro componente
     * @param y columna donde va nuestro componente
     * @param w width o ancho en español - le indicamos cuantas filas queremos que ocupe nuestro componente
     * @param h height o alto en español - le indicamos cuantas columnas (hacia abajo) queremos que ocupe nuestro componente
     * @param margin Tenemos constantes que le dan un poco de espacio entre componentes, ya que estarian todos pegados
     * sin este parametro - Las constantes pueden ser LEFT_MARGIN o RIGHT_MARGIN
     */
    private void setGridCustom(int x, int y, int w, int h, Insets margin) {
        gbc.gridx      = x;
        gbc.gridy      = y;
        gbc.gridwidth  = w;
        gbc.gridheight = h;
        gbc.insets = margin;
    }

    /**
     * Funcion que nos obliga a configurar el comportamiento de nuestros botones
     * @param e parámetro que captura el evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ( e.getSource() == btnActualizar ) { // si el boton de actualizar es presionado
            dispose();
        }
    }
}
