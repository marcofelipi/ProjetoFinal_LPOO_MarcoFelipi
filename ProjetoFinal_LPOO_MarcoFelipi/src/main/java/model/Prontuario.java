/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "tbl_prontuario")
public class Prontuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "diagnostico", length = 200)
    private String diagnostico;

    @Column(name = "tratamento", length = 200)
    private String tratamento;

    @Column(name = "anotacoes", length = 500)
    private String anotacoes;
    
    
    // CHAVE ESTRANGEIRA LIGADA AO AGENDAMENTO
    @OneToOne
    @JoinColumn(name = "agendamento_id", nullable = false)
    private Agendamento agendamento;

    public Prontuario() {
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnoetico) {
        this.diagnostico = diagnoetico;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    @Override
    public String toString() {
        return "Diagnóstico: " + diagnostico + " | Tratamento: " + tratamento;
    }
}

