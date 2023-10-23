package br.com.janes_lima.desafio_to_do_list.Service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.janes_lima.desafio_to_do_list.Model.To_Do;
import br.com.janes_lima.desafio_to_do_list.Repository.ToDoRepository;

@Service
public class ToDoService {

    private ToDoRepository acaoBanco;
    
    public ToDoService(ToDoRepository ToDoRepository){
        this.acaoBanco = ToDoRepository;
    }

    public Iterable<To_Do> listar(){
        Sort ordenacao = Sort.by("prioridade").descending().and(
            Sort.by("nome").ascending()
        );
        return acaoBanco.findAll(ordenacao);
    }

    public Iterable<To_Do> criar(To_Do entidade){
        acaoBanco.save(entidade);
        return listar();
    }

    public Iterable<To_Do> atualizar(To_Do entidade){
        acaoBanco.save(entidade);
        return listar();
    }

    public Iterable<To_Do> deletar(Long id){
        acaoBanco.deleteById(id);
        return listar();
    }
}
