package br.com.janes_lima.desafio_to_do_list.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.janes_lima.desafio_to_do_list.Model.To_Do;
import br.com.janes_lima.desafio_to_do_list.Service.ToDoService;

@RestController
@RequestMapping("/todos")
public class ToDoController {

    private ToDoService servico;

    public ToDoController(ToDoService servico){
        this.servico = servico;
    }

    @PostMapping
    Iterable<To_Do> create(@RequestBody To_Do entidade){
        return servico.criar(entidade);
    }

    @PutMapping 
    Iterable<To_Do> update(@RequestBody To_Do entidade){
        return servico.atualizar(entidade);
    }

    @GetMapping
    Iterable<To_Do> list(){
        return servico.listar();
    }

    @DeleteMapping("/{id}")
    Iterable<To_Do> delete(@PathVariable Long id){
        return servico.deletar(id);
    }

    
}
