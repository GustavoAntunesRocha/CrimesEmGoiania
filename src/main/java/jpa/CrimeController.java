package jpa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
            HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		 
        if (action == null) {
            throw new ServletException("No action specified.");
        } else if (action.equals("incluir")) {
            criarCrime(request, response);
            RequestDispatcher r = request.getRequestDispatcher( "report.jsp" );
            r.forward( request, response );
        } else if(action.equals("consultar")) {
        	consultarCrime(request, response);
        	RequestDispatcher r = request.getRequestDispatcher( "ConsultarCrime.jsp" );
            r.forward( request, response );
        } else if(action.equals("excluir")) {
        	excluirCrime(request, response);
        	RequestDispatcher r = request.getRequestDispatcher( "ConsultarCrime.jsp" );
            r.forward( request, response );
        }
	}
	
	protected void excluirCrime(HttpServletRequest req, HttpServletResponse resp) {
		int id = Integer.parseInt(req.getParameter("id"));
		CrimeDao.excluir(id);
	}
	protected void consultarCrime(HttpServletRequest req, HttpServletResponse resp) {
		String email = req.getParameter("inputEmail");
		String senha = req.getParameter("inputSenha");
		req.setAttribute("crimes", CrimeDao.consultar(email, senha));
	}
	protected void criarCrime(HttpServletRequest req, HttpServletResponse resp)  {
			String msg;
			String tipo = req.getParameter("inputTipo");
			String arma = req.getParameter("inputArma");
			String descricao = req.getParameter("inputDesc");
			String email = req.getParameter("inputEmail");
			String senha = req.getParameter("inputSenha");
			String regiao = req.getParameter("inputRegiao");
			
			CrimeDao.inclui(tipo, arma, descricao, email, senha, regiao);
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
