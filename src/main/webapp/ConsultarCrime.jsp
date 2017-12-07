<!DOCTYPE html>
<%@page import="java.util.*"%>
<%@page import="jpa.Crime"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="javax.persistence.NoResultException"%>
<%@page import="javax.persistence.Persistence"%>
<%@page import="javax.persistence.TypedQuery"%>
<% EntityManagerFactory emf = Persistence.createEntityManagerFactory("CrimesEmGoiania"); %>
<html>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<head>
		<meta charset="UTF-8">
		<title>Consultar Crime</title>
	</head>
	<body>
		<!-- Começo da navbar -->
		<nav class="navbar sticky-top navbar-expand-lg navbar-dark bg-dark">
  			<a class="navbar-brand" href="#">Menu</a>
  			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    			<span class="navbar-toggler-icon"></span>
  			</button>
  			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
    			<div class="navbar-nav">
      				<a class="nav-item nav-link" href="index.jsp">Página inicial </a>
      				<a class="nav-item nav-link" href="report.jsp">Reportar crime</a>
      				<a class="nav-item nav-link active" href="ConsultarCrime.jsp">Consultar crime</a>
    			</div>
  			</div>
		</nav>
		<!-- Fim da navbar -->
		<br>
		<!-- Começo do formulário -->
		<form action="CrimeController?action=consultar" role="form" method="POST">
			<div class="container">
				<div class="card">
	  				<div class="card-body">
	  					<h3>Aqui você pode consultar e excluir os crimes que voce reportou</h3>
	  					<h5>Digite seu e-mail e senha para buscar:</h5>
	  					<div class="form-group">
	  						<label for="inputEmail">E-mail:</label>
	  						<input type="text" class="form-control" name="inputEmail" id="inputEmail" placeholder="exemplo@exemplo.com" required></input>
	  					</div>	
	  					<div class="form-group">
    						<label for="inputSenha">Senha:</label>
    						<input type="password" class="form-control" name="inputSenha" id="inputSenha" placeholder="Digite sua senha" required></input>
  						</div>
  	  				</div>
	  			</div>
	  			<h1></h1>
	  			<button type="submit" class="btn btn-default">Consultar</button>
	  		</div>
		</form>
		<br>
		<div class="container">
			<div class="card">
				<h3>Lista de todos os Crimes:</h3>
				<table class="table">
      				<thead>
        				<th>ID</th>
        				<th>Tipo</th>
        				<th>Arma</th>
        				<th>Descrição</th>
        				<th>Região</th>
        				<th>Ações</th>
      				</thead>
      				<%
      				//EntityManager em = emf.createEntityManager();
      				//Não é SQL! É JPQL.
      				//String jpql = "FROM Crime";
      				//TypedQuery<Crime> query = em.createQuery(jpql, Crime.class);
      				//List<Crime> result = query.getResultList();
      				//em.close();
      				ArrayList<Crime> crimes = (ArrayList<Crime>) request.getAttribute("crimes");
      				if(crimes != null){
      					for (Crime crime : crimes) {
      				%>
      				<tbody>
      				<tr>
        				<td><%=crime.getID()%></td>
       					<td><%=crime.getTipo()%></td>
       					<td><%=crime.getArma()%></td>
       					<td><%=crime.getDescricao()%></td>
        				<td><%=crime.getRegiao()%></td>
        				<td><a href="CrimeController?action=excluir&id=<%=crime.getID()%>">Excluir</a></td>
      				</tr>
      				</tbody>
      				<%	}
      				}
      				%>
    			</table>
			</div>
		</div>
    	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	</body>
</html>