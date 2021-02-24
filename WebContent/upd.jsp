<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "model.JavaBeans" %>
<%
	JavaBeans contato = (JavaBeans) request.getAttribute("contato");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda-Editar</title>
<link rel="icon" href="img/favicon.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar contato</h1>
	<form name="frmEditContato" action="updDB">
		<table>
			<tr>
				<td>
					<input type="text" name="id" class="inputStatic"  id="id" readonly value="<%=contato.getId()%>">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="nome" placeholder="*Nome" class="input01"  id="nome" value="<%=contato.getNome()%>">
				</td>
			</tr>
			<tr class="col">
				<td>
					<input type="tel" name="fone" placeholder="*Fone" class="input02" id="fone" value="<%=contato.getFone()%>">
				</td>
			</tr>
			<tr>
				<td>
					<input type="email" name="email" placeholder="Email" class="input01" id="email" value="<%=contato.getEmail()%>">
				</td>
			</tr>
		</table>
	</form>
	<input type="button" value="Editar" class="botaoBase" onclick="editarContato()">
	<a href="main" class="botaoBase">Voltar</a>
	
<script src="scripts/editTable.js"></script>
</body>
</html>