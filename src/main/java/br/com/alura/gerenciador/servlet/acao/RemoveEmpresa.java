package br.com.alura.gerenciador.servlet.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;

public class RemoveEmpresa  implements Acao{
	
	public String executa(HttpServletRequest request,HttpServletResponse response ) throws IOException, ServletException{
		   String paramId = request.getParameter("id");
		   Integer id = Integer.valueOf(paramId);
		   
		   System.out.println("codigo recebido para exclusao "+ id);
		   
		   Banco banco = new Banco();
		   banco.removeEmpresa(id);
		   
		   
		   return "redirect:entrada?acao=ListaEmpresas"; 
	}

}
