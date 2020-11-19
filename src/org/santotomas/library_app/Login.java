package org.santotomas.library_app;

import org.santotomas.library_app.dao.Database;
import org.santotomas.library_app.dao.UserDAO;
import org.santotomas.library_app.models.User;

import javax.swing.*; // Importamos las librerías necesarias para crear una GUI
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Clase con la que definimos nuestra ventana de login
 * que hereda de JFrame para tener el comportamiento de una ventana
 */
public class Login extends JFrame implements ActionListener {

    // Declaramos los componentes de nuestra ventama
    private JPanel pTop, pMain, pBottom;
    private JLabel lblTitle, lblUserName, lblPassword;
    private JTextField txtUserName;
    private JPasswordField pswPassword;
    private JButton btnSend;

    /* Para crear grids 'personalizadas' necesitamos ajustar unos parámetros, los cuales los tenemos mediante
     * el GridBagConstraints */
    private GridBagConstraints gbc = new GridBagConstraints();
    private static final Insets LEFT_MARGIN = new Insets(4, 4, 4, 0);
    private static final Insets RIGHT_MARGIN = new Insets(4, 0, 4, 4);
    private Dimension txtSize = new Dimension(140, 26);

    private Database myDatabase;

    /**
     * Constructor, donde definimos las propiedades de la ventana
     * @param title Como el constructor del padre pide un titulo, se lo pasamos por parámetro
     */
    public Login(String title) throws SQLException, ClassNotFoundException {

        // Configuramos nuestra ventana
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(360, 200));
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 25, 25));

        // Agregando imagen de fondo
        Image img = Toolkit.getDefaultToolkit().getImage("src/org/santotomas/library_app/img/background.png");
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, this);
            }
        });
        setVisible(true);

        String contraSantiago = "1324";
        String contraGaston = "";
        myDatabase = new Database("localhost", "library", "root", contraSantiago);

        // Inicializamos y configuramos el Panel principal donde tendremos los campos para logearse
        pMain = new JPanel();
        pMain.setLayout(new GridBagLayout()); // le asignamos el GridBagLayout para crear grids "personalizadas'
        pMain.setOpaque(false);

        // Inicializamos y configuramos el label del nombre de usuario
        lblUserName = new JLabel("Nombre de usuario:");
        setGridCustom(0, 0, 1, 1, LEFT_MARGIN);
        pMain.add(lblUserName, gbc); // Agregamos el texto en panel principal

        // Inicializamos y configuramos el campo de texto del nombre de usuario
        txtUserName = new JTextField();
        txtUserName.setPreferredSize(txtSize); // cambiamos el tamaño del text field
        setGridCustom(1, 0, 2, 1, RIGHT_MARGIN);
        pMain.add(txtUserName, gbc);

        // Inicializamos y configuramos el label de la contraseña
        lblPassword = new JLabel("Contraseña:");
        setGridCustom(0, 1, 1, 1, LEFT_MARGIN);
        gbc.insets = new Insets(4, 4, 4, 0);
        pMain.add(lblPassword, gbc);

        // Inicializamos y configuramos el campo de texto de la constraseña
        pswPassword = new JPasswordField();
        pswPassword.setPreferredSize(txtSize);
        setGridCustom(1, 1, 2, 1, RIGHT_MARGIN);
        pMain.add(pswPassword, gbc);

        // Agregamos el panel principal al panel de la ventana (que tiene un BorderLayout) y lo dejamos al centro
        add(pMain);

        // Inicializamos y configuramos el utlimo panel donde dejarémos el boton centrado para entrar
        pBottom = new JPanel();
        pBottom.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Le asignamos un FlowLayout para centrar el btn
        pBottom.setOpaque(false);

        // Inicializamos y configuramos el botón
        btnSend = new JButton("Entrar");
        btnSend.setPreferredSize(new Dimension(80, 30));
        btnSend.setMnemonic(KeyEvent.VK_E); // Con alt+e podemos 'optimizar' el proceso de logeo

        // Le indicamos que se llega a presionar el boton, la logica estará en esta misma clase (actionPerformed)
        btnSend.addActionListener(this);

        pBottom.add(btnSend); // Agregamos el boton al ultimo panel

        // agregamos el ultimo panel a nuestra ventana y lo dejamos al final de nuestra GUI (abajo de la ventana)
        add(pBottom);

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
        gbc.gridx      = x;      // lo dejamos en la fila x
        gbc.gridy      = y;      // lo dejamos en la columna y
        gbc.gridwidth  = w;      // queremos que ocupe w espacio de ancho
        gbc.gridheight = h;      // queremos que ocupe h espacio de alto
        gbc.insets = margin; // Los Margenes del componente (que tan alejado está de los otros C)
    }

    /**
     * Funcion que nos ayuda a formatear el formulario de login para que el usuario pueda volver
     * a ingresar sus credenciales
     */
    private void resetForm() {
        txtUserName.setText("");
        pswPassword.setText("");
        txtUserName.requestFocus();
    }

    /**
     * Funcion que nos ayuda a comprobar si los campos de texto están vacios
     * @param userName se necesita el nombre de usuario para comprobar si está vacio
     * @param password se necesita la contraseña para comprobar si está vacia
     * @return true: si uno de los 2 campos está vacio - false: si los 2 campos contienen carácteres
     * que no sean espacios
     */
    private boolean isTxtVoid(String userName, String password) {
        boolean isUserNameVoid = userName == null || userName.equalsIgnoreCase("");
        boolean isPasswordVoid = password == null || password.equalsIgnoreCase("");
        return isUserNameVoid || isPasswordVoid;
    }

    /**
     * Funcion que nos obliga a configurar el comportamiento de nuestros botones
     * @param e parámetro que captura el evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Si se ejecuta un evento que proviene del boton de enviar....
        if (e.getSource() == btnSend) {
            String userName = txtUserName.getText().trim();
            String password = new String( pswPassword.getPassword() ).trim();


            // Validar si uno de los campos está vacio
            if ( isTxtVoid(userName, password) ) {
                JOptionPane.showMessageDialog(this, "Campos Vacios", "Error", JOptionPane.ERROR_MESSAGE);
                resetForm();
            } else {
                UserDAO userDAO = new UserDAO(myDatabase);

                // Validamos que los valores se encuentren en nuestra bd (ArrayList)
                try {
                    if ( userDAO.login(userName, password) != null ) {
                        dispose();
                        new MenuLibreria("Bienvenid@ ", userName);
                    } else {
                        JOptionPane.showMessageDialog(this, "No se encuentra usuario en nuestra BD", "Alerta", JOptionPane.WARNING_MESSAGE);
                        resetForm();
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }

        }
    }
}
