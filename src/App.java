import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import controllers.EstudianteController;
import models.Estudiante;

public class App {
    public static void main(String[] args) throws Exception {
                List<Estudiante> estudiantes = crearEstudiantes();
        EstudianteController controller = new EstudianteController();

        Set<Estudiante> ordenados = controller.ordenarPorPromedio(estudiantes);
        System.out.println("====== Estudiantes ordenados por promedio ======");
        int i = 1;
        for (Estudiante e : ordenados) {
            System.out.printf("%d.- %s\n", i++, e);
        }

        Map<String, List<Estudiante>> clasificados = controller.clasificarPorPorcentaje(ordenados);
        System.out.println("\n====== Clasificación por porcentaje de caracteres únicos ======");
        for (String categoria : clasificados.keySet()) {
            System.out.print("- Categoría " + categoria + ": [ ");
            for (Estudiante e : clasificados.get(categoria)) {
                System.out.print(e.getNombre() + "; ");
            }
            System.out.println("]");
        }

        List<Estudiante> destacados = controller.obtenerEstudiantesDestacados(estudiantes);
        System.out.println("\n====== Estudiantes destacados (promedio > 7.0) ======");
        if (destacados.isEmpty()) {
            System.out.println("No hay estudiantes destacados.");
        } else {
            for (Estudiante e : destacados) {
                System.out.println("- " + e.getNombre());
            }
        }

        String nombreBuscado = "Camila Vera";
        Estudiante encontrado = controller.buscarPorNombre(destacados, nombreBuscado);
        System.out.println("\n====== Buscar estudiante por nombre: \"" + nombreBuscado + "\" ======");
        if (encontrado != null) {
            System.out.println("Estudiante encontrado: " + encontrado);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

        
    static List<Estudiante> crearEstudiantes() {
        return Arrays.asList(
                new Estudiante("Ana Torres", "0101010101", Arrays.asList(8.5, 9.0, 7.5, 10.0, 9.5, 8.0)),
                new Estudiante("Luis Luis", "0202020202", Arrays.asList(6.0, 7.5, 8.0, 6.5, 7.0, 6.0)),
                new Estudiante("Camila Vera", "0303030303", Arrays.asList(10.0, 10.0, 10.0, 9.5, 9.0, 9.5)),
                new Estudiante("Marco Luis Luis", "0202020202", Arrays.asList(8.0, 7.5, 9.0, 8.5, 7.0, 8.0)), // Cedula
                // repetida
                new Estudiante("Elena Ruiz", "0404040404", Arrays.asList(5.0, 1.0, 4.5, 6.0, 5.5, 6.5)),
                new Estudiante("Carlos Díaz", "0505050505", Arrays.asList(9.5, 1.0, 3.5, 10.0, 10.0, 10.0)),
                new Estudiante("Luis  Luis Luis Luis", "0606060606",
                        Arrays.asList(1.0, 2.0, 7.0, 1.0, 7.0, 7.0)),
                new Estudiante("Luis  Luis Luis Luis", "0606060602",
                        Arrays.asList(1.0, 2.0, 7.0, 1.0, 7.0, 7.0)),
                new Estudiante("Luis  Luis Luis Luis", "0606060603",
                        Arrays.asList(1.0, 2.0, 7.0, 1.0, 7.0, 7.0)),
                new Estudiante("Luis  Luis Luis Luis", "0606060604",
                        Arrays.asList(1.0, 2.0, 7.0, 3.0, 7.0, 7.0)),
                new Estudiante("Luis  Luis Luis Luis", "0606060605",
                        Arrays.asList(5.0, 2.0, 7.0, 5.0, 7.0, 7.0)),

                new Estudiante("Pedro Gómez", "0707070707", Arrays.asList(7.0, 8.0, 9.0, 6.5, 8.5, 7.5)),
                new Estudiante("Sofía Martínez", "0808080808", Arrays.asList(9.0, 8.5, 9.5, 10.0, 9.0, 8.0)),
                new Estudiante("Javier Pérez", "0909090909", Arrays.asList(6.0, 7.0, 8.0, 7.5, 6.5, 7.0)),
                new Estudiante("Valeria Castro", "1010101010", Arrays.asList(8.5, 9.0, 8.0, 9.5, 8.5, 9.0)),
                new Estudiante("Mateo Herrera", "1111111111", Arrays.asList(7.5, 8.0, 7.0, 8.5, 7.5, 8.0)),
                new Estudiante("Lucía Ríos", "1212121212", Arrays.asList(9.5, 9.0, 8.5, 9.0, 9.5, 10.0)),
                new Estudiante("Andrés Molina", "1313131313", Arrays.asList(6.5, 7.0, 6.0, 7.5, 6.5, 7.0)),
                new Estudiante("Paula Jiménez", "1414141414", Arrays.asList(8.0, 8.5, 9.0, 8.5, 8.0, 9.0)),
                new Estudiante("Diego Vargas", "1515151515", Arrays.asList(7.0, 7.5, 8.0, 7.5, 7.0, 8.0)),
                new Estudiante("María López", "1616161616", Arrays.asList(9.0, 9.5, 10.0, 9.5, 9.0, 10.0)),
                new Estudiante("Fernando Cruz", "1717171717", Arrays.asList(6.0, 6.5, 7.0, 6.5, 6.0, 7.0)),
                new Estudiante("Gabriela Salazar", "1818181818", Arrays.asList(8.5, 9.0, 8.5, 9.0, 8.5, 9.0)),
                new Estudiante("Ricardo Paredes", "1919191919", Arrays.asList(7.5, 8.0, 7.5, 8.0, 7.5, 8.0)),
                new Estudiante("Carla Mendoza", "2020202020", Arrays.asList(9.0, 9.5, 9.0, 9.5, 9.0, 9.5)),
                new Estudiante("Esteban Ortiz", "2121212121", Arrays.asList(6.5, 7.0, 6.5, 7.0, 6.5, 7.0)),
                new Estudiante("Natalia Flores", "2222222222", Arrays.asList(8.0, 8.5, 8.0, 8.5, 8.0, 8.5)),
                new Estudiante("Tomás Silva", "2323232323", Arrays.asList(7.0, 7.5, 7.0, 7.5, 7.0, 7.5)),
                new Estudiante("Isabel Ramírez", "2424242424", Arrays.asList(9.5, 10.0, 9.5, 10.0, 9.5, 10.0)),
                new Estudiante("Sebastián León", "2525252525", Arrays.asList(6.0, 6.5, 6.0, 6.5, 6.0, 6.5)),
                new Estudiante("Camila Ortega", "2626262626", Arrays.asList(8.5, 9.0, 8.5, 9.0, 8.5, 9.0)),
                new Estudiante("Martín Aguirre", "2727272727", Arrays.asList(7.5, 8.0, 7.5, 8.0, 7.5, 8.0)),
                new Estudiante("Daniela Peña", "2828282828", Arrays.asList(9.0, 9.5, 9.0, 9.5, 9.0, 9.5)),
                new Estudiante("Alejandro Bravo", "2929292929", Arrays.asList(6.5, 7.0, 6.5, 7.0, 6.5, 7.0)),
                new Estudiante("Patricia Cedeño", "3030303030", Arrays.asList(8.0, 8.5, 8.0, 8.5, 8.0, 8.5)),
                new Estudiante("Felipe Zambrano", "3131313131", Arrays.asList(7.0, 7.5, 7.0, 7.5, 7.0, 7.5)),
                new Estudiante("Lorena Castillo", "3232323232", Arrays.asList(9.5, 10.0, 9.5, 10.0, 9.5, 10.0)),
                new Estudiante("Hugo Benítez", "3333333333", Arrays.asList(6.0, 6.5, 6.0, 6.5, 6.0, 6.5)),
                new Estudiante("Verónica Espinoza", "3434343434", Arrays.asList(8.5, 9.0, 8.5, 9.0, 8.5, 9.0)),
                new Estudiante("Samuel Torres", "3535353535", Arrays.asList(7.5, 8.0, 7.5, 8.0, 7.5, 8.0)),
                new Estudiante("Mónica Andrade", "3636363636", Arrays.asList(9.0, 9.5, 9.0, 9.5, 9.0, 9.5)));
    }

}
