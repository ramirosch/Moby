package main.java.com.pil.moby.evaluacion_tencica.segundo_cuestionario;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Candidato implements Comparable<Candidato> {
    private Long id;
    private String nombre;
    private String apellido;
    private Integer aniosExperiencia;
    private Double pretensionSalarial;
    private List<Tecnologia> tecnologias;

    public Candidato(Long id, String nombre, String apellido, Integer aniosExperiencia, Double pretensionSalarial, List<Tecnologia> tecnologias) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.aniosExperiencia = aniosExperiencia;
        this.pretensionSalarial = pretensionSalarial;
        this.tecnologias = tecnologias;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getAniosExperiencia() {
        return aniosExperiencia;
    }

    public Double getPretensionSalarial() {
        return pretensionSalarial;
    }

    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public List<Tecnologia> ordenarTecnologias() {
        return tecnologias.stream()
                .sorted(Comparator.comparing(Tecnologia::getNombre))
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Candidato otroCandidato) {
        return this.id.compareTo(otroCandidato.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidato candidato = (Candidato) o;
        return id.equals(candidato.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return nombre + " " + apellido + " - " + aniosExperiencia + " años de experiencia, Pretensión Salarial: $" + pretensionSalarial;
    }
}