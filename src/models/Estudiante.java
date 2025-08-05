package models;
import java.util.*;

public class Estudiante {
    private String nombre, cedula;
    private List<Double> calificaciones;
    private int porcentajeUnicos;

    public Estudiante(String nombre, String cedula, List<Double> calificaciones, int porcentajeUnicos) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.calificaciones = calificaciones;
        this.porcentajeUnicos = calcularPorcentajesUnicos();    
    }

    public String getNombre() { return nombre;    }

    public String getCedula() { return cedula;    }

    public List<Double> getCalificaciones() {   return calificaciones;    }

    public int getPorcentajeUnicos() {  return porcentajeUnicos;    }

    public int getPromedio(){
        double suma=0;
        for (double nota: calificaciones){
            suma+= nota;
        }
        return (int) (suma/ calificaciones.size());
    }

    public int calcularPorcentajesUnicos() {
        String sinEspacios = nombre.replace(" ", "").toLowerCase();
        Set<Character> unicos = new HashSet<>();
        for (char c : sinEspacios.toCharArray()) {
            unicos.add(c);
        }
        if (sinEspacios.length() == 0) return 0;
        return (unicos.size() * 100) / sinEspacios.length();
    }

    @Override
    public boolean equals(Object o) {
        if (this==o){
            return true;
        } 
        if (!(o instanceof Estudiante)){
            return false;
        } 
        Estudiante e = (Estudiante) o;
        return cedula.equals(e.cedula);
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(cedula);
    }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ") Porcentaje de caracteres únicos: "
            + porcentajeUnicos + "%, Promedio: " + getPromedio();
    }

}
