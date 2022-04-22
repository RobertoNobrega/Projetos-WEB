<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8">
		<title>Página 1</title>
	</head>
				<!-- Camada View, da Arquitura de Software  MVC   -->
	<body>
		<h1>Página 1 da Locadora de Filmes</h1>
		<%
			String filme1 = "A Lista de Schindler";
		    String filme2 = "The Terminator", filme3 = "Terminator 2 : Judgment Day", filme4 = "Terminator 3 : Rise of the Machines";
		    String filme5 = "O Cardeal Judeu";
		    int id1 = 1, id2 = 2, id3 = 3, id4 = 4, id5 = 5;
		%> <!--  Trecho de Código JSP.  Declaração e Atribuição de Variáveis. -->
		Logo Abaixo, temos uma pequena lista de filmes.
		<ol> <!--  Tag para indicar Lista Ordenada. li é a tag de item de lista. -->
			<li> <% out.print(filme1); %>; </li>
			<li> <% out.print(filme2); %>; </li>
			<li> <% out.print(filme3); %>; </li>
			<li> <%=filme4 %>; </li>
			<li> <%=filme5 %>. </li>
		</ol>
		Logo Abaixo, temos os id's de cada filme, respectivamente. Clique Nela, para obter informações sobre cada filme.
		<ul> <!-- Tag para criar Lista Não Ordenada. -->
			<li> <a href="pagina2.jsp?filme=<%=filme1 %>&id=<%=id1 %>"> <%=id1 %> </a> </li> <!--  Para cada chamada da pagina2 , está se fazendo
			  um uso do método GET (passando parâmetros para a página2, que nesse caso são os parâmetros do nome do filme e de
			  seu id) do HTTP. -->
			<li> <a href="pagina2.jsp?filme=<%=filme2 %>&id=<%=id2 %>"> <%=id2 %> </a> </li>
			<li> <a href="pagina2.jsp?filme=<%=filme3 %>&id=<%=id3 %>"> <%=id3 %> </a> </li>
			<li> <a href="pagina2.jsp?filme=<%=filme4 %>&id=<%=id4 %>"> <%=id4 %> </a> </li>
			<li> <a href="pagina2.jsp?filme=<%=filme5 %>&id=<%=id5 %>"> <%=id5 %> </a> </li>
		</ul>
		<h2>Deseja Sugerir um Filme na Locadora?</h2>
		<h3>Abaixo, temos o nosso formulário de sugestão</h3>
		<form action="pagina3.jsp" method="post">  <!-- Tag para declarar contrução de um formulário. Usaremos o método
		  POST, para enviar os dados para a pagina3.jsp, por meio de uso (neste caso) do Servidor de Aplicação. -->
			<fieldset> <!--  Tag para Agrupamento de Elementos de um formulário. -->
				<legend>Dados de Sugestão</legend>
				<p>
					<label for="nomeFilme">Nome do Filme</label>
					<input type="text" id="nomeFilme" name="nomeFilme" />
				</p>
				<p>
					<label for="anoFilme">Ano do Filme</label>
					<input type="number" id="anoFilme" name="anoFilme" />
				</p>
				<p>
					Gênero <br>
					<input type="radio" id="comedia" name="genero" value="1" />
					<label for="comedia">Comédia</label>
					<input type="radio" id="romance" name="genero" value="2" />
					<label for="romance">Romance</label>
					<input type="radio" id="acao" name="genero" value="3" />
					<label for="acao">Ação</label>
					<input type="radio" id="drama" name="genero" value="4" />
					<label for="drama">Drama</label>
					<input type="radio" id="outro" name="genero" value="5" />
					<label for="outro">Outro</label>
				</p>
				<p>
					<label for="sugestao">Sugestão(ões) para a Locadora</label> <br>
					<textarea id="sugestao" name="Sugestao"> </textarea>
				</p>
				<p>
					<input type="submit" value="Enviar Dados" />
				</p>
			</fieldset>
		</form>
	</body>
</html>