package co.com.curiosity.school.clases;

public class FrecuenciaZoo {

    private String tipoAnimal;
    private String consideraciones;
    private String error;
    private String frecuencia;

    public FrecuenciaZoo() {

        tipoAnimal = "";
        consideraciones = "";
        error = "";
    }

    public String getError() {
        return error;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public boolean validar() {

        if ("".equals(tipoAnimal)) {
            error = "Debe ingresar un tipo de animal";
            return false;
        }

        if ("".equals(consideraciones)) {
            error = "Debe ingresar una consideración";
            return false;
        }
        return true;
    }

    public boolean frecuencia() {

        try {

            if (!validar()) {
                return false;
            }

            switch (tipoAnimal) {

                case "Mamífero":
                    if ("Ha tenido problemas de salud en el semestre".equals(consideraciones)) {
                        frecuencia = "Quincenal";
                    } else if ("No Ha tenido problemas de salud en el semestre".equals(consideraciones)) {
                        frecuencia = "Mensual";
                    }

                    break;
                case "Pez":
                    frecuencia = "Bimestral";
                    break;

                case "Reptil":
                    frecuencia = "Semestral";
                    break;

                case "Ave":
                    frecuencia = "Trimestral";
                    break;

                default:
                    error = ".l.";

            }


        } catch (Exception ex) {
            throw ex;
        }


        return true;

    }


    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public void setConsideraciones(String consideraciones) {
        this.consideraciones = consideraciones;
    }
}
