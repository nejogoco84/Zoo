package co.com.curiosity.school.formularios;

import co.com.curiosity.school.clases.FrecuenciaZoo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Zoologico extends JFrame {
    private JComboBox cmbTipoAnimal;
    private JComboBox cmbConsideraciones;
    private JButton calcularFrecuenciaButton;
    private JLabel lblFrecuencia;
    private JPanel pnlZoologico;


    public Zoologico() {

        this.setResizable(false);
        add(pnlZoologico);
        setTitle("Zoologico SantaFe");
        setSize(600, 300);

        llenarTipoAnimal();
        llenarConsideraciones();


        calcularFrecuenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarTipoAnimal();
                calcularFrecuencia();

            }
        });

    }

    public void llenarTipoAnimal() {
        this.cmbTipoAnimal.addItem("Seleccione");
        this.cmbTipoAnimal.addItem("Mamífero");
        this.cmbTipoAnimal.addItem("Pez");
        this.cmbTipoAnimal.addItem("Reptil");
        this.cmbTipoAnimal.addItem("Ave");

    }

    public void llenarConsideraciones() {
        this.cmbConsideraciones.addItem("Seleccione");
        this.cmbConsideraciones.addItem("Ha tenido problemas de salud en el semestre");
        this.cmbConsideraciones.addItem("No Ha tenido problemas de salud en el semestre");
        this.cmbConsideraciones.addItem("Niguna");
    }

    public boolean validar(){

        if("Seleccione".equals(this.cmbTipoAnimal.getSelectedItem())){
            JOptionPane.showMessageDialog(pnlZoologico,"Debe ingresar un tipo de animal ");
            return false;
        } else if ("Seleccione".equals(this.cmbConsideraciones.getSelectedItem())){
            JOptionPane.showMessageDialog(pnlZoologico,"Debe ingresar un tipo de animal ");
            return false;
        }


            if("Pez".equals(this.cmbTipoAnimal.getSelectedItem().toString())){
            this.cmbConsideraciones.setEnabled(false);
        } else if("Reptil".equals(this.cmbTipoAnimal.getSelectedItem().toString())){
            this.cmbConsideraciones.setEnabled(false);
        } else if("Ave".equals(this.cmbTipoAnimal.getSelectedItem().toString())){
            this.cmbConsideraciones.setEnabled(false);
        }



        return true;
    }

    public void calcularFrecuencia(){

        try{
            if(!validar()){
                return;
            }

            FrecuenciaZoo frecuenciaZoo = new FrecuenciaZoo();
            frecuenciaZoo.setTipoAnimal(this.cmbTipoAnimal.getSelectedItem().toString());
            frecuenciaZoo.setConsideraciones(this.cmbConsideraciones.getSelectedItem().toString());

            if(!frecuenciaZoo.frecuencia()){
                JOptionPane.showMessageDialog(pnlZoologico,frecuenciaZoo.getError());
                return;
            }

            this.lblFrecuencia.setText(frecuenciaZoo.getFrecuencia());

        }catch (Exception e){
            throw e;
        }


    }

    public void validarTipoAnimal(){

    }
}
