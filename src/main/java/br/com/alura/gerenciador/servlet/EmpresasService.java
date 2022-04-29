package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
<<<<<<< HEAD
import com.thoughtworks.xstream.XStream;
=======
>>>>>>> e20cadab624cc788a3bc8eef319471c260a518ab

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;


@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Empresa> empresas = new Banco().getEmpresas();
		
<<<<<<< HEAD
		String valor = request.getHeader("Accept");
		
		if (valor.contains("xml")) {
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xml = xstream.toXML(empresas);
			response.setContentType("application/xml");
			response.getWriter().println(xml);
		}
		else if (valor.contains("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);		
			response.setContentType("application/json");
			response.getWriter().println(json);
		}else {
			response.getWriter().println("no content!!!");
		}


=======
		
		
		Gson gson = new Gson();
		String json = gson.toJson(empresas);  
		
		
		response.setContentType("application/json");
		response.getWriter().println(json);
		
>>>>>>> e20cadab624cc788a3bc8eef319471c260a518ab
		
	}

}
