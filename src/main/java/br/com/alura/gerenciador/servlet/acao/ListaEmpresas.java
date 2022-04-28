package br.com.alura.gerenciador.servlet.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.servlet.modelo.Banco;
import br.com.alura.gerenciador.servlet.modelo.Empresa;

public class ListaEmpresas implements Acao{
	
	public String executa(HttpServletRequest request,HttpServletResponse response ) throws IOException, ServletException{
		
		System.out.println("Listando Empresa mostra");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		
		request.setAttribute("empresas", lista);
		
		return "forward:listaEmpresas.jsp";
	}

}
