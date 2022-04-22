<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title>Página 2</title>
	</head>
				<!-- Camada View, da Arquitura de Software  MVC   -->
	<body>
		<h1>Página 2 : Exibindo Informações do Filme</h1>
		<%
			String nomeFilme = request.getParameter("filme");
			int idFilme = Integer.parseInt(request.getParameter("id"));
		%> <!-- Declaração e Atribuição de Variáveis. Aqui, neste exemplo, estamos obtendo os valores de dados
		        para os dois atributos, utilizando o método GET do Protocolo HTTP.
		   -->
		Nome do Filme: <%=nomeFilme %> <br>
		Id do Filme: <%=idFilme %>
	</body>
</html>