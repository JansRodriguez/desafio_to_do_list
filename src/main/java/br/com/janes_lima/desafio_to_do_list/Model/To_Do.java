package br.com.janes_lima.desafio_to_do_list.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tb_toDo")
@Data
public class To_Do {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private Boolean realizado;
    private int prioridade;

    @CreationTimestamp
    private LocalDateTime criadoEm;

    
}
