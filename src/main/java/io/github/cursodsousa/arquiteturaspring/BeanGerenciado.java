package io.github.cursodsousa.arquiteturaspring;

import io.github.cursodsousa.arquiteturaspring.todos.TodoEntity;
import io.github.cursodsousa.arquiteturaspring.todos.TodoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanGerenciado {

    //injeção via construtor


    //injeção via propriedade
    @Autowired
    private TodoValidator validator;

    //injeção via construtor
    @Autowired
    public BeanGerenciado(TodoValidator validator) {
        this.validator = validator;
    }


    public void validar(){
        var todo = new TodoEntity();
        validator.validar(todo);
    }

    // injeção via metodo setter
    @Autowired
    public  void setValidator(TodoValidator validator){
        this.validator = validator;
    }
}
