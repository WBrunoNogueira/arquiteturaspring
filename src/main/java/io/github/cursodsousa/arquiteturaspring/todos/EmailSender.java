package io.github.cursodsousa.arquiteturaspring.todos;

import org.springframework.stereotype.Component;

@Component
public class EmailSender {
    public void encviar(String mensagem){
        System.out.println("ENviado email: " + mensagem);
    }
}
