package br.senai.jmstechdivespring.consumer;

import br.senai.jmstechdivespring.entity.ProduceMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @JmsListener(destination = "fila")
    public void messageListner(ProduceMessage message){
        System.out.println("Mensagem recebida: "+message.getTitulo()+"-"+message.getDescricao());
    }
}
