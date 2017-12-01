package jpa;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CrimeController")
public class CrimeController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void processarRequisicao(HttpServletRequest request,
            HttpServletResponse response) throws ServletException {
		String action = request.getParameter("action");
		 
        if (action == null) {
            throw new ServletException("No action specified.");
        } else if (action.equals("incluir")) {
            criarCrime(request, response);
        } else if(action.equals("consultar")) {
        	consultarCrime(request, response);
        }
	}
	
	protected void consultarCrime(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("inputEmail");
		String senha = req.getParameter("inputSenha");
		Crime crime = CrimeDao.consultar(email, senha);
		req.setAttribute("inputTipo", crime.getTipo());
		req.setAttribute("inputArma", crime.getArma());
		req.setAttribute("inputDesc", crime.getDescricao());
	}
	protected void criarCrime(HttpServletRequest req, HttpServletResponse resp)  {
			String msg;
			String tipo = req.getParameter("inputTipo");
			String arma = req.getParameter("inputArma");
			String descricao = req.getParameter("inputDesc");
			String email = req.getParameter("inputEmail");
			String senha = req.getParameter("inputSenha");
			
			CrimeDao.inclui(tipo, arma, descricao, email, senha);
			msg = "Inclusão realizada com sucesso.";
			req.setAttribute("msg", msg);
			
	}
	protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processarRequisicao(request, response);
    }
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processarRequisicao(request, response);
    }
}
