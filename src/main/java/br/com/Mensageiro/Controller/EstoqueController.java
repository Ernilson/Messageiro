package br.com.Mensageiro.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Mengeiro.Constantes.RabbitmqConstantes;
import br.com.Mensageiro.Service.MensageiroService;
import br.com.Mensageiro.dto.EstoqueDto;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {
	
	@Autowired
	private MensageiroService service;
	
	@PutMapping
	private ResponseEntity alteraEstoque(@RequestBody EstoqueDto dto) {
		
		System.out.println(dto.codigoProduto);
		
		this.service.enviaMensagem(RabbitmqConstantes.FILA_ESTOQUE, dto);
		return new ResponseEntity(HttpStatus.OK);
	}

}
