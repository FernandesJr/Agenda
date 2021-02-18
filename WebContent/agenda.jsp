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
<body>
	<h1 id="tit">Agenda de contatos</h1>
	<a href="novo_user.html" class="botaoBase">Novo contato</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>id</th>
				<th>nome</th>
				<th>fone</th>
				<th>email</th>
			</tr>
		</thead>
		<tbody>
			<% for (int i = 0; i < lista.size(); i++){ %>
				<tr>
					<td><%=lista.get(i).getId()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getFone() %></td>
					<td><%=lista.get(i).getEmail()%></td>
				</tr>
			<%} %>
		</tbody>
	</table>
</body>
</html>