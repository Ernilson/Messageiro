package br.com.Mensageiro.Service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MensageiroService {
	
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	public void enviaMensagem(String nomeFila, Object messagem) {
		this.rabbitTemplate.convertAndSend(nomeFila, messagem);
	}

}
