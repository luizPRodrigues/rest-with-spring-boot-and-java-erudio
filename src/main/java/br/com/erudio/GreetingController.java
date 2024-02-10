package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	
	//constante que contém um modelo de saudação.
	private static final String template = "Hello, %s!";
	//variável AtomicLong que é usada para gerar identificadores mockados para as saudações.
	private final AtomicLong counter = new AtomicLong();
	
	/*
	  Método greeting:
	  Este método é mapeado para o endpoint /greeting e é responsável por criar e retornar um objeto Greeting.
      O parâmetro name é obtido a partir da solicitação HTTP usando a anotação @RequestParam, com um valor padrão definido como "world".
      Um novo objeto Greeting é criado com um ID obtido a partir do counter (incrementado de forma atômica) e uma mensagem formatada usando o modelo template.
      
      Retorno do Método:
      O método greeting retorna o objeto Greeting, que será automaticamente convertido em JSON e enviado de volta ao cliente pela estrutura Spring MVC.
	*/
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name){
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
		
	}

}
