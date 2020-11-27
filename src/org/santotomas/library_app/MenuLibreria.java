package org.santotomas.library_app;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.santotomas.library_app.dao.BookDAO;
import org.santotomas.library_app.dao.Database;
import org.santotomas.library_app.models.Book;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class MenuLibreria extends JFrame implements ActionListener {

    // region Components
    private JPanel pnlPanel;
    private JTabbedPane tbdHome;
    private JPanel pnlBuscar;
    private JTextField txtBuscar;
    private JCheckBox chkCategoriaTerror;
    private JCheckBox chkCategoriaFantasia;
    private JCheckBox chkCategoriaMagia;
    private JCheckBox chkCategoriaSuspenso;
    private JCheckBox chkCategoriaRomance;
    private JButton btnBuscar;
    private JButton btnActualizar;
    private JButton btnEliminar;
    private JLabel lblCategorias;
    private JPanel pnlAgregar;
    private JTextField txtNombreLibro;
    private JTextField txtAutor;
    private JTextField txtDescripcion;
    private JTextField txtStock;
    private JPanel pnlCerrarSesion;
    private JButton btnCloseSession;
    private JScrollPane jspLibros;
    private JTable table1;
    private JLabel lblNombreLibro;
    private JLabel lblDescripcion;
    private JLabel lblCategoria;
    private JLabel lblAutor;
    private JLabel lblStock;
    private JButton btnAgregar;
    private JPanel pCategorias;
    private JLabel lblPrecio;
    private JSpinner spnPrecio;
    private JSpinner spnStock;
    private JRadioButton rMagia;
    private JRadioButton rSuspenso;
    private JRadioButton rTerror;
    private JRadioButton rFantasia;
    private JRadioButton rRomance;
    private JPanel pnlGrafico;
    private JPanel pnlContenidoGrafico;
    private JPanel pnlGraficador;
    private JTextField txtSemana1;
    private JTextField txtSemana2;
    private JTextField txtSemana3;
    private JTextField txtSemana4;
    private JButton btnGraficar;
    private JButton btnActualizarTabla;
    // endregion

    private Database myDatabase;
    private DefaultTableModel dtmLibros;
    private ButtonGroup bgCategorias;


    /**
     * Constructor en el cual definimos lo primero que haga nuestra ventana de menu al crearse (instanciarse)
     * @param titulo titulo de la ventana
     * @param nombre nombre del usuario
     */
    public MenuLibreria(String titulo, String nombre) throws SQLException, ClassNotFoundException {
        /* Configuramos nuestra ventana */
        super(titulo + nombre);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1280, 640));
        setPreferredSize(new Dimension(1280, 640));
        setVisible(true);

        //Colores tbdHome
        pnlPanel.setBackground(Color.decode("#212121"));
        tbdHome.setBackgroundAt(0, Color.decode("#212121"));
        tbdHome.setBackgroundAt(1, Color.decode("#212121"));
        tbdHome.setBackgroundAt(2, Color.decode("#212121"));
        tbdHome.setBackgroundAt(3, Color.decode("#212121"));

        tbdHome.setForegroundAt(0, Color.decode("#ffffff"));
        tbdHome.setForegroundAt(1, Color.decode("#ffffff"));
        tbdHome.setForegroundAt(2, Color.decode("#ffffff"));
        tbdHome.setForegroundAt(3, Color.decode("#ffffff"));


        String contraSantiago = "1324";
        String contraGaston = "";
        myDatabase = new Database("localhost", "library", "root", contraSantiago);

        // region Buttons & Mnemonics
        tbdHome.setMnemonicAt(0, KeyEvent.VK_1);
        tbdHome.setMnemonicAt(1, KeyEvent.VK_2);
        tbdHome.setMnemonicAt(2, KeyEvent.VK_3);
        tbdHome.setMnemonicAt(3, KeyEvent.VK_4);

        btnBuscar.setMnemonic(KeyEvent.VK_B);
        btnAgregar.setMnemonic(KeyEvent.VK_A);
        btnActualizar.setMnemonic(KeyEvent.VK_A);
        btnActualizarTabla.setMnemonic(KeyEvent.VK_T);
        btnEliminar.setMnemonic(KeyEvent.VK_E);

        btnBuscar.addActionListener(this);
        btnAgregar.addActionListener(this);
        btnActualizar.addActionListener(this);
        btnEliminar.addActionListener(this);
        btnActualizarTabla.addActionListener(this);

        // region Radio Buttons Group
        bgCategorias = new ButtonGroup();
        bgCategorias.add(rMagia);
        bgCategorias.add(rSuspenso);
        bgCategorias.add(rTerror);
        bgCategorias.add(rRomance);
        bgCategorias.add(rFantasia);

        rMagia.setActionCommand("Magia");
        rSuspenso.setActionCommand("Suspenso");
        rTerror.setActionCommand("Terror");
        rFantasia.setActionCommand("Fantasia");
        rRomance.setActionCommand("Romance");
        // endregion

        btnCloseSession.setIcon(new ImageIcon("src/org/santotomas/library_app/img/close_icon.png"));
        btnCloseSession.addActionListener(this);
        // endregion

        dtmLibros = new DefaultTableModel();
        dtmLibros.addColumn("ISBN");
        dtmLibros.addColumn("Titulo");
        dtmLibros.addColumn("Descripcion");
        dtmLibros.addColumn("Precio");
        dtmLibros.addColumn("Categoria");
        dtmLibros.addColumn("Autor(a)");
        dtmLibros.addColumn("Stock");
        dtmLibros.addColumn("Fecha Salida");
        table1.setModel(dtmLibros);

        updateTable();

        /** add panel */

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

        add(pnlPanel);
        pack();

        //Color boton
        btnBuscar.setBackground(Color.decode("#f57f17"));
        btnBuscar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnBuscar.setBackground(Color.decode("#ffb04c"));
                btnBuscar.setForeground(Color.decode("#000000"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnBuscar.setBackground(Color.decode("#f57f17"));
                btnBuscar.setForeground(Color.decode("#000000"));
            }
        });


        //Color boton Eliminar
        btnEliminar.setBackground(Color.decode("#dd2c00"));
        btnEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnEliminar.setBackground(Color.decode("#ff6434"));
                btnEliminar.setForeground(Color.decode("#000000"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnEliminar.setBackground(Color.decode("#dd2c00"));
                btnEliminar.setForeground(Color.decode("#000000"));
            }
        });

        //Color boton acualizar
        btnActualizar.setBackground(Color.decode("#f57f17"));
        btnActualizar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnActualizar.setBackground(Color.decode("#ffb04c"));
                btnActualizar.setForeground(Color.decode("#000000"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnActualizar.setBackground(Color.decode("#f57f17"));
                btnActualizar.setForeground(Color.decode("#000000"));
            }
        });

        //Color boton agregar
        btnAgregar.setBackground(Color.decode("#f57f17"));
        btnAgregar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnAgregar.setBackground(Color.decode("#ffb04c"));
                btnAgregar.setForeground(Color.decode("#000000"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnAgregar.setBackground(Color.decode("#f57f17"));
                btnAgregar.setForeground(Color.decode("#000000"));
            }
        });


        //Color pnlGraficador
        pnlGraficador.setBackground(Color.decode("#ffb04c"));
        btnGraficar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                pnlGraficador.setOpaque(true);
                XYSeries oSeries = new XYSeries("Stock de libros");

                int semana1 = Integer.parseInt(txtSemana1.getText());
                int semana2 = Integer.parseInt(txtSemana2.getText());
                int semana3 = Integer.parseInt(txtSemana3.getText());
                int semana4 = Integer.parseInt(txtSemana4.getText());

                oSeries.add(1, semana1);
                oSeries.add(2, semana2);
                oSeries.add(3, semana3);
                oSeries.add(4, semana4);

                XYSeriesCollection oDataset = new XYSeriesCollection();
                oDataset.addSeries(oSeries);

                JFreeChart oChart = ChartFactory.createXYLineChart("Venta de libros", "Semanas", "Cantidad", oDataset, PlotOrientation.VERTICAL, true, false, false);

                ChartPanel oPanel = new ChartPanel(oChart);
                pnlGraficador.setLayout(new java.awt.BorderLayout());
                pnlGraficador.add(oPanel);

            }
        });
        //Color boton graficar
        btnGraficar.setBackground(Color.decode("#f57f17"));
        btnGraficar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnGraficar.setBackground(Color.decode("#ffb04c"));
                btnGraficar.setForeground(Color.decode("#000000"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnGraficar.setBackground(Color.decode("#f57f17"));
                btnGraficar.setForeground(Color.decode("#000000"));
            }
        });

        //Color boton Actualizar
        btnActualizarTabla.setBackground(Color.decode("#f57f17"));
        btnActualizarTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btnGraficar.setBackground(Color.decode("#ffb04c"));
                btnGraficar.setForeground(Color.decode("#000000"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                btnGraficar.setBackground(Color.decode("#f57f17"));
                btnGraficar.setForeground(Color.decode("#000000"));
            }
        });

    }

    public void updateTable() throws SQLException {
        BookDAO bookDAO = new BookDAO(myDatabase);
        List<Book> books = bookDAO.getAll();

        for (int i = dtmLibros.getRowCount(); i > 0; i--) {
            dtmLibros.removeRow(i - 1);
        }

        for (Book book : books) {
            dtmLibros.addRow(new Object[] {
                    book.getIsbn(),
                    book.getTitle(),
                    book.getDescription(),
                    book.getPrice(),
                    book.getCategoryId(),
                    book.getAuthor(),
                    book.getStock(),
                    book.getRelease_date()
            });
        }
    }

    /**
     * Funcion que nos obliga a configurar el comportamiento de nuestros botones
     * @param e parámetro que captura el evento
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if ( e.getSource() == btnBuscar ) {
            BookDAO bookDAO = new BookDAO(myDatabase);
            List<Book> books = null;

            String[] chkStrings = new String[] {
                    chkCategoriaFantasia.isSelected() ? "4" : " ",
                    chkCategoriaMagia.isSelected() ? "1" : " ",
                    chkCategoriaRomance.isSelected() ? "5" : " ",
                    chkCategoriaSuspenso.isSelected() ? "2" : " ",
                    chkCategoriaTerror.isSelected() ? "3" : " "
            };

            String categories = "(";
            for (String chk: chkStrings) {
                categories += chk + "";
            }
            categories += ")";

            System.out.println(categories);

            try {
                books = bookDAO.getByLike(txtBuscar.getText(), chkStrings);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            for (int i = dtmLibros.getRowCount(); i > 0; i--) {
                dtmLibros.removeRow(i - 1);
            }

            for (Book book : books) {
                dtmLibros.addRow(new Object[] {
                        book.getIsbn(),
                        book.getTitle(),
                        book.getDescription(),
                        book.getPrice(),
                        book.getCategoryId(),
                        book.getAuthor(),
                        book.getStock(),
                        book.getRelease_date()
                });
            }
        }

        if ( e.getSource() == btnAgregar) {
            try {
                String titulo = txtNombreLibro.getText();
                String autor = txtAutor.getText();
                String descripcion = txtDescripcion.getText();
                int precio = Integer.parseInt(spnPrecio.getValue().toString());
                int stock = Integer.parseInt(spnStock.getValue().toString());
                int categoria = 0;

                switch ( bgCategorias.getSelection().getActionCommand() ) {
                    case "Magia":
                        categoria = 1;
                        break;
                    case "Suspenso":
                        categoria = 2;
                        break;
                    case "Terror":
                        categoria = 3;
                        break;
                    case "Fantasia":
                        categoria = 4;
                        break;
                    case "Romance":
                        categoria = 5;
                        break;

                    default: categoria = 0;
                }

                Book book = new Book();
                book.setTitle(titulo);
                book.setAuthor(autor);
                book.setDescription(descripcion);
                book.setPrice(precio);
                book.setStock(stock);
                book.setCategoryId(categoria);

                BookDAO bookDAO = new BookDAO(myDatabase);

                bookDAO.add(book);

                // print result in table
                updateTable();

                // reset form
                txtNombreLibro.requestFocus();

                JOptionPane.showMessageDialog(this, "Libro registrado exitosamente", "Exito!", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Palabras en Stock o en precio", "Error", JOptionPane.ERROR_MESSAGE);
                ex.getStackTrace();
            } catch (SQLException throwables) {
                JOptionPane.showMessageDialog(this, "Error al Registrar el libro", "Error", JOptionPane.ERROR_MESSAGE);
                throwables.getStackTrace();
            }


        }

        if ( e.getSource() == btnActualizar) {
            Book book = new Book(
                    String.valueOf(dtmLibros.getValueAt(table1.getSelectedRow(), 0)),
                    String.valueOf(dtmLibros.getValueAt(table1.getSelectedRow(), 1)),
                    String.valueOf(dtmLibros.getValueAt(table1.getSelectedRow(), 2)),
                    Integer.parseInt(String.valueOf(dtmLibros.getValueAt(table1.getSelectedRow(), 3))),
                    Integer.parseInt(String.valueOf(dtmLibros.getValueAt(table1.getSelectedRow(), 4))),
                    String.valueOf(dtmLibros.getValueAt(table1.getSelectedRow(), 5)),
                    Integer.parseInt(String.valueOf(dtmLibros.getValueAt(table1.getSelectedRow(), 6))),
                    Date.valueOf(String.valueOf(dtmLibros.getValueAt(table1.getSelectedRow(), 7)))
            );

            try {
                new UpdateBook(book);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }

        if (e.getSource() == btnEliminar) {
            String uuid = String.valueOf(dtmLibros.getValueAt(table1.getSelectedRow(), 0));
            int option = JOptionPane.showConfirmDialog(this, "Está seguro,", "Eliminar libro", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (option == JOptionPane.YES_OPTION) {
                BookDAO bookDAO = new BookDAO(myDatabase);
                try {
                    bookDAO.delete(uuid);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

            try {
                updateTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if ( e.getSource() == btnActualizarTabla ) {
            try {
                updateTable();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if ( e.getSource() == btnCloseSession ) {
            dispose();
            try {
                new Login("Bienvenid@");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        }
    }
}
