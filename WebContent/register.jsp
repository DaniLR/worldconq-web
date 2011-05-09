<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/header.css" type="text/css">
<title>WorldConq - Register</title>
</head>
<body>
	
	<s:include value="header.jsp" />

	<s:div id="content">
		<h2>Registro</h2>

		<s:actionmessage />
		<s:actionerror />
			
		<s:form action="do_register">
			<s:textfield name="username" label="Usuario" />
			<s:password name="password" label="Contraseña" />
			<s:textfield name="email" label="Email" />
			<s:submit />
		</s:form>		

	</s:div>



</body>
</html>