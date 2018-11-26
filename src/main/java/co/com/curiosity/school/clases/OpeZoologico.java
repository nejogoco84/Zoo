package co.com.curiosity.school.clases;

import co.com.curiosity.school.reglasnegocio.RNZoologico;

import java.util.List;

public class OpeZoologico {
    private RNZoologico zoologico;
    private String nombreVeterinario;
    private String tipoAnimal;
    private String nombreAnimal;
    private String consideraciones;
    private String cantidadMedicamento;
    private String frecuencia;
    private String error;
    private List<String> datosComboRN;
    private String consultarComboRN;

    public OpeZoologico() {
        nombreVeterinario = "";
        tipoAnimal = "";
        nombreAnimal = "";
        consideraciones = "";
        cantidadMedicamento = "";
        frecuencia = "";
        error = "";
    }

    public List<String> getDatosComboRN() {
        return datosComboRN;
    }
    public String getConsultarComboRN() {
        return consultarComboRN;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public String getNombreVeterinario() {
        return nombreVeterinario;
    }

    public void setNombreVeterinario(String nombreVeterinario) {
        this.nombreVeterinario = nombreVeterinario;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public String getConsideraciones() {
        return consideraciones;
    }

    public String getCantidadMedicamento() {
        return cantidadMedicamento;
    }

    public void setCantidadMedicamento(String cantidadMedicamento) {
        this.cantidadMedicamento = cantidadMedicamento;
    }

    public String getError() {
        return error;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }


    public boolean procesarCombo(String ruta) throws Exception {
        try {
            zoologico = new RNZoologico ();
            zoologico.valoresCombo ( ruta );
            error = zoologico.getError ();
            if ("".equals ( error )) {
                datosComboRN = zoologico.getCombos ();
                return true;
            }
            return false;

        } catch (Exception ex) {
            throw ex;
        }
    }

    public void procesarLogicaOpe(String tipoAnimal, String consideraciones) {
        this.error = "";
        if ("Mamifero".equals ( tipoAnimal ) && "Ha tenido problemas de salud en el semestre".equals ( consideraciones )) {
            cantidadMedicamento = "15 Cm";
            frecuencia = "Quincenal";
        } else if ("Mamifero".equals ( tipoAnimal ) && "No Ha tenido problemas de salud en el semestre".equals ( consideraciones )) {
            cantidadMedicamento = "0 Cm";
            frecuencia = "Mensual";
        } else if ("Pez".equals ( tipoAnimal ) && "Ninguna".equals ( consideraciones )) {
            cantidadMedicamento = "12 Cm";
            frecuencia = "Bimestral";
        } else if ("Reptil".equals ( tipoAnimal ) && "Ninguna".equals ( consideraciones )) {
            cantidadMedicamento = "20 Cm";
            frecuencia = "Semestral";
        } else if ("Ave".equals ( tipoAnimal ) && "Ninguna".equals ( consideraciones )) {
            cantidadMedicamento = "60 Cm";
            frecuencia = "Trimestral";
        } else {
            cantidadMedicamento = "";
            frecuencia = "";
            error = "Seleccion no valida";
        }
    }

    public void escribirLog(String ruta, List<String> lista){
        RNZoologico rnZoologico= new RNZoologico ();
        try {
            rnZoologico.escribirLog ( ruta, lista);
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }


/*    public List<String> tipoAnimalRN() {
        zoologico = new RNZoologico();
        return zoologico.comboTipoAnimal();
    }

    public List<String> consideracionesRN() {
        zoologico = new RNZoologico();
        return zoologico.consideraciones();
    }*/

}
