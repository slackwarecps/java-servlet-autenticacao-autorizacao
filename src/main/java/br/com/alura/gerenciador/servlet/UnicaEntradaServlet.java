package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String paramAcao = request.getParameter("acao");
		
		HttpSession sessao = request.getSession();		
		boolean usuarioNaoEstaLogado = (sessao.getAttribute("usuarioLogado")==null);
		boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm") );
		
		if (ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			
			response.sendRedirect("redirect:entrada?acao=LoginForm");
			return;
		}
		
      
        
        String nomeDaClasse = "br.com.alura.gerenciador.acao."+ paramAcao;
        
        String nome;
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
				| ServletException e) {
			throw new ServletException(e);
		}
        
        String[] tipoEEndereco = nome.split(":");
        System.out.println("comando 0: "+ tipoEEndereco[0]);
        System.out.println("comando 1: "+ tipoEEndereco[1]);
		
        if (tipoEEndereco[0].equals("forward")) {
        	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEEndereco[1]);
    		rd.forward(request, response);
        }else {
        	response.sendRedirect(tipoEEndereco[1]);        	
        }
        

		
		
	}
}
