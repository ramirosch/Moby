package main.java.com.pil.moby.evaluacion_tencica.segundo_cuestionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EvaluacionTecnicaPil2 {

    public static void main(String[] args) {
        imprimirBienvenidaEvaluacionTecnica();

        imprimirMensajePunto(1);
        List<Candidato> candidatos = inicializarCandidatos();
        resolverPunto1(candidatos);

        imprimirMensajePunto(2);
        resolverPunto2(candidatos);

        imprimirMensajePunto(3);
        resolverPunto3(candidatos);

        imprimirMensajePunto(4);
        resolverPunto4(candidatos);

        imprimirMensajePunto(5);
        resolverPunto5(candidatos);
    }

    private static List<Candidato> inicializarCandidatos() {
        List<Candidato> candidatos = new ArrayList<>();
        candidatos.add(new Candidato(3L, "Jhon", "Doe", 2, 5000.0, List.of(new Tecnologia(1L, "Java"), new Tecnologia(2L, "Angular"), new Tecnologia(3L, "SQL"))));
        candidatos.add(new Candidato(7L, "Matías", "Otamendi", 9, 3000.0, List.of(new Tecnologia(8L, "NodeJS"), new Tecnologia(1L, "Java"), new Tecnologia(3L, "SQL"))));
        candidatos.add(new Candidato(1L, "Joaquín", "Tagliafico", 6, 2000.0, List.of(new Tecnologia(7L, "MongoDB"), new Tecnologia(4L, "NoSQL"))));
        candidatos.add(new Candidato(4L, "Gastón", "Mac Allister", 1, 5000.50, List.of(new Tecnologia(5L, "Vue"), new Tecnologia(3L, "SQL"), new Tecnologia(1L, "Java"))));
        candidatos.add(new Candidato(5L, "Pablo", "De Paul", 4, 9000.50, List.of(new Tecnologia(1L, "Java"))));
        candidatos.add(new Candidato(2L, "Lucas", "Di María", 7, 6000.0, List.of(new Tecnologia(1L, "Java"), new Tecnologia(2L, "Angular"), new Tecnologia(3L, "SQL"))));
        candidatos.add(new Candidato(10L, "Lionel", "Messi", 10, 10000.10, List.of(new Tecnologia(3L, "SQL"), new Tecnologia(5L, "Vue"), new Tecnologia(1L, "Java"))));
        candidatos.add(new Candidato(9L, "Julián", "Álvarez", 3, 5000.0, List.of(new Tecnologia(4L, "NoSQL"), new Tecnologia(7L, "MongoDB"), new Tecnologia(3L, "SQL"), new Tecnologia(1L, "Java"))));
        candidatos.add(new Candidato(8L, "Lula", "Martínez", 2, 1000.0, List.of(new Tecnologia(6L, ".NET"), new Tecnologia(1L, "Java"), new Tecnologia(2L, "Angular"))));
        candidatos.add(new Candidato(6L, "Agustín", "Dybala", 2, 1000.0, List.of(new Tecnologia(1L, "Java"), new Tecnologia(6L, ".NET"), new Tecnologia(2L, "Angular"))));
        return candidatos;
    }

    private static void resolverPunto1(List<Candidato> candidatos) {
        candidatos.forEach(System.out::println);
    }

    private static void resolverPunto2(List<Candidato> candidatos) {
        candidatos.stream()
                .sorted(Comparator.comparingLong(Candidato::getId))
                .forEach(candidato -> System.out.println(candidato.getId() + " " + candidato.getNombre() + " " + candidato.getApellido()));
    }

    private static void resolverPunto3(List<Candidato> candidatos) {
        candidatos.stream()
                .sorted(Comparator.comparingDouble(Candidato::getPretensionSalarial).reversed())
                .forEach(candidato -> System.out.println(candidato.getPretensionSalarial() + " " + candidato.getNombre() + " " + candidato.getApellido()));
    }

    private static void resolverPunto4(List<Candidato> candidatos) {
        Candidato candidatoConMasExperiencia = candidatos.stream()
                .max(Comparator.comparingInt(Candidato::getAniosExperiencia))
                .orElseThrow();
        System.out.println(candidatoConMasExperiencia);
        candidatoConMasExperiencia.ordenarTecnologias().forEach(System.out::println);
    }

    private static void resolverPunto5(List<Candidato> candidatos) {
        Candidato candidatoConMasTecnologias = candidatos.stream()
                .max(Comparator.comparingInt(c -> c.getTecnologias().size()))
                .orElseThrow();
        System.out.println(candidatoConMasTecnologias);
        candidatoConMasTecnologias.getTecnologias().stream()
                .filter(Tecnologia::esIdPar)
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void imprimirBienvenidaEvaluacionTecnica() {
        System.out.println("\n*******************************************");
        System.out.println("Bienvenidos a la segunda Evaluación Técnica.\nLes deseamos muchos éxitos!");
        System.out.println("*******************************************\n");
    }

    private static void imprimirMensajePunto(int numeroPunto) {
        System.out.println("\n*******");
        System.out.println("PUNTO " + numeroPunto);
        System.out.println("*******\n");
    }
}