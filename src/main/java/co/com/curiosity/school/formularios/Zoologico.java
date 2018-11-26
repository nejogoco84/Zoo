package co.com.curiosity.school.formularios;

import co.com.curiosity.school.clases.OpeZoologico;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Zoologico extends JFrame {
    private JComboBox cmbTipoAnimal;
    private JComboBox cmbConsideraciones;
    private JButton calcularFrecuenciaButton;
    private JPanel pnlZoologico;
    private JTextField txtMedicamento;
    private JTextField txtVeterinario;
    private JTextField txtNombreAnimal;
    private JTextField txtFrecuencia;
    private String rutaCboAnimales = "D:\\Zoologico\\TipoAnimal.txt";
    private String rutaCboConsideraciones = "D:\\Zoologico\\Consideraciones.txt";
    private String rutaLog = "D:\\Zoologico\\Log.txt";

    public Zoologico() {

        this.setResizable ( false );
        add ( pnlZoologico );
        setTitle ( "Zoologico SantaFe" );
        setSize ( 600, 300 );
        llenarCombos ();


        calcularFrecuenciaButton.addActionListener ( new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarLogica ();
            }
        } );
    }

    private boolean validar() {
        if (this.cmbTipoAnimal.getSelectedIndex () <= 0) {
            JOptionPane.showMessageDialog ( pnlZoologico, "Debe seleccionar un tipo de animal" );
            return false;
        }
        if (this.cmbConsideraciones.getSelectedIndex () <= 0) {
            JOptionPane.showMessageDialog ( pnlZoologico, "Debe seleccionar una consideracion" );
            return false;
        }
        if ("".equals ( this.txtVeterinario.getText () )) {
            JOptionPane.showMessageDialog ( pnlZoologico, "Debe ingresar el nombre del veterinario" );
            return false;
        }
        if ("".equals ( this.txtNombreAnimal.getText () )) {
            JOptionPane.showMessageDialog ( pnlZoologico, "Debe ingresar el nombre del animal" );
            return false;
        }
        return true;
    }

    public void cargarDatos(String ruta, JComboBox combo, String mensajeError) {
        try {
            OpeZoologico opeZoologico = new OpeZoologico ();
            if (opeZoologico.procesarCombo ( ruta )) {
                List<String> listaCombo = opeZoologico.getDatosComboRN ();
                for (int i = 0; i < listaCombo.size (); i++) {
                    combo.addItem ( listaCombo.get ( i ) );
                }

            } else {
                mensajeError = opeZoologico.getError ();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog ( pnlZoologico, ex.getMessage () );
        }
    }

    public void llenarCombos() {
        String errorcboAnimal = "";
        String errorcboConsideracion = "";
        cargarDatos ( rutaCboAnimales, cmbTipoAnimal, errorcboAnimal );
        cargarDatos ( rutaCboConsideraciones, cmbConsideraciones, errorcboConsideracion );
    }

    public void procesarLogica() {

        if (validar ()) {
            OpeZoologico opeZoologico = new OpeZoologico ();
            opeZoologico.procesarLogicaOpe ( this.cmbTipoAnimal.getSelectedItem ().toString (), this.cmbConsideraciones.getSelectedItem ().toString () );
            this.txtFrecuencia.setText ( opeZoologico.getFrecuencia () );
            this.txtMedicamento.setText ( opeZoologico.getCantidadMedicamento () );
           if(!"".equals ( opeZoologico.getError () )){
               JOptionPane.showMessageDialog ( pnlZoologico, opeZoologico.getError () );
           }else {
               List<String> datosLog= new ArrayList<> (  );
               datosLog.add ( "Nombre Veterinario :" + txtVeterinario.getText () );
               datosLog.add ( "Nombre Animal :" + txtNombreAnimal.getText () );
               datosLog.add ( "Frecuencia Medicamento :" + txtFrecuencia.getText () );



               opeZoologico.escribirLog ( rutaLog, datosLog  );
           }
        }

    }

}