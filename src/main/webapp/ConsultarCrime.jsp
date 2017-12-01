<!DOCTYPE html>

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
      				<a class="nav-item nav-link" href="index.html">Página inicial <span class="sr-only">(current)</span></a>
      				<a class="nav-item nav-link active" href="report.jsp">Reportar crime</a>
      				<a class="nav-item nav-link active" href="ConsultarCrime.jsp">Consultar crime</a>
    			</div>
  			</div>
		</nav>
		<!-- Fim da navbar -->
		
		<!-- Começo do formulário -->
		<form action="CrimeController?action=consultar" role="form" method="POST">
			<div class="container">
				<div class="card">
	  				<div class="card-body">
	  					<h2>Digite seu e-mail e senha:</h2>
	  					<div class="form-group">
	  						<label for="inputEmail">E-mail:</label>
	  						<input type="email" class="form-control" name="inputEmail" id="inputEmail" placeholder="exemplo@exemplo.com" required></input>
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
		
		<script type="text/javascript" src="js/googleMaps.js"></script>	
    	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
	</body>
</html>