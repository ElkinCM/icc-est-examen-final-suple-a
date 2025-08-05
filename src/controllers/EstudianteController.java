package controllers;

import java.util.*;
import models.*;

public class EstudianteController {

    public Set<Estudiante> ordenarPorPromedio (List<Estudiante> estudiantes){
        Comparator<Estudiante> comparator = (a,b) -> {
            if(a.getCedula().equals(b.getCedula())){
                return 0;
            }
            int cmp = Integer.compare(b.getPromedio(), a.getPromedio());
            if(cmp != 0){
                return cmp;
            }
            cmp = a.getNombre().compareTo(b.getNombre());
            if(cmp != 0){
                return cmp;
            }
            return a.getCedula().compareTo(b.getCedula()); 
        };
        Set<Estudiante> treeSet = new TreeSet<>(comparator);
        treeSet.addAll(estudiantes);
        return treeSet;
    }

    public Map<String, List<Estudiante>> clasificarPorPorcentaje (Set<Estudiante> ordenados){
        Map<String, List<Estudiante>> map = new LinkedHashMap<>();
        for (Estudiante e : ordenados) {
            int pct = e.getPorcentajeUnicos();
            String cat;
            if (pct >= 90) cat = "A";
            else if (pct >= 70) cat = "B";
            else if (pct >= 50) cat = "C";
            else if (pct >= 30) cat = "D";
            else cat = "E";
            map.computeIfAbsent(cat, k -> new java.util.LinkedList<>()).add(e);
        }
        return map;
    }

        public List<Estudiante> obtenerEstudiantesDestacados(List<Estudiante> lista) {
        List<Estudiante> destacados = new ArrayList<>();
        for (Estudiante e : lista) {
            if (e.getPromedio() > 7) {
                destacados.add(e);
            }
        }
        destacados.sort(Comparator.comparing(Estudiante::getNombre));
        return destacados;
    }

        public Estudiante buscarPorNombre(List<Estudiante> lista, String nombre) {
        int left = 0, right = lista.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = lista.get(mid).getNombre().compareTo(nombre);
            if (cmp == 0) {
                return lista.get(mid);
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

}