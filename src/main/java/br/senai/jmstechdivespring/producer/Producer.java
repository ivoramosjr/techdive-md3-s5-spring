package br.senai.jmstechdivespring.producer;

import br.senai.jmstechdivespring.entity.ProduceMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Producer {

    private final JmsTemplate template;

    public Producer(JmsTemplate template) {
        this.template = template;
    }

    @PostMapping(value = "/publish", consumes = "application/json")
    public ResponseEntity<String> publishMessage(@RequestBody ProduceMessage message){
        try{
            template.convertAndSend("fila", message);
            return new ResponseEntity<>("Enviado com sucesso", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
