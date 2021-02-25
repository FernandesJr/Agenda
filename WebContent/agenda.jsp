<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import = "model.JavaBeans" %>
<%@ page import = "java.util.ArrayList" %>
<%
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda</title>
<link rel="stylesheet" href="style.css">
<link rel="icon" href="img/favicon.png">
</head>
<body class="e-center">

	<header>
		<h1>Agenda de contatos</h1>
		<div>
			<a href="novo_user.html" class="botaoBase">Novo contato</a> <a href="index.html" class="botaoSair">sair</a>
		</div>
	</header>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>Email</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody id = "table">
			<% for (int i = 0; i < lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getFone() %></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td>
						<input type="button" value="EDITAR" class="b-size botaoBase" onclick="editarContato(<%=lista.get(i).getId()%>)">
						<input type="button" value="EXCLUIR" class="botaoExcluir" onclick="exluirContato(<%=lista.get(i).getId()%>)">
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<script src="scripts/editarTable.js"></script>
</body>
</html>