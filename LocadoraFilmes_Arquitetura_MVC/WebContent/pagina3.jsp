<%@page import="controller.LocadoraFilmes_Controller" %>  <!-- Importando a classe LocadoraFilmes_Controller , do
   pacote controller. -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title>Página 3</title>
	</head>
	<!--  Camada Controller, do Modelo Arquitetural MVC -->
	<body>
		<%
			String nomeFilme = request.getParameter("nomeFilme");
			int anoFilme = Integer.parseInt(request.getParameter("anoFilme"));
			String sugestao = request.getParameter("Sugestao");
			String generoFilme = "";
			int opcaoGeneroFilme = Integer.parseInt(request.getParameter("genero"));
			switch(opcaoGeneroFilme){
				case 1:
					generoFilme = "Comédia";
					break;
				case 2:
					generoFilme = "Romance";
					break;
				case 3:
					generoFilme = "Ação";
					break;
				case 4:
					generoFilme = "Drama";
					break;
				default:
					generoFilme = "Outro";
			}
			
			LocadoraFilmes_Controller locadoraController = new LocadoraFilmes_Controller();
			String mensagemDaModel = locadoraController.cadastrarFilme(nomeFilme, anoFilme, generoFilme);
		%>  <!-- Neste código JSP, estamos obtendo os valores dos atributos, enviados pelo método POST, da página1.jsp . 
		         Depois, estamos enviando estes dados para um objeto instanciado da classe LocadoraFilmes_Controller, para
		         que se possa registrar os dados por meio da camada Model.
		    -->
				
		<h1>Página 3 : Recebendo os Dados da Página 1</h1>
		<p> Nome do Filme: <%=nomeFilme %> </p>
		<p> Ano do Filme: <%=anoFilme %> </p>
		<p> Gênero do Filme: <%=generoFilme %> </p>
		<p> Sugestão: <%=sugestao %> </p>
		
		<h3>A Mensagem da Model foi: <%=mensagemDaModel %> </h3>
		
	</body>
</html>