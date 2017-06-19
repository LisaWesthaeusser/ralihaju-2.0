<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Anamnese</title>
<link rel="shortcut icon" href="/GIB-Anamnese/html/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="/GIB-Anamnese/css/Style.css">
</head>
<body>
	<div class="container">
		<a href=/GIB-Anamnese/html/Anamnesebogen.html><img id="Logo"
					src="/GIB-Anamnese/img/GALOGO.png" /></a><br>
			
		<div class="tab">

			<a href=/GIB-Anamnese/html/Anamnesebogen.html>
				<button class="tablinks" onclick="openTab(event, 'Anamnesebogen')">Anamnesebogen</button>
			</a> <a href=/GIB-Anamnese/html/Kontakt.html>
				<button class="tablinks" onclick="openTab(event, 'Kontakt')">Kontakt</button>
			</a> <a href=/GIB-Anamnese/Impressum.html><button class="tablinks"
					onclick="openTab(event, 'Impressum')">Impressum</button></a> <a
				href=/GIB-Anamnese/Arzt.html>
				<button class="tablinks" onclick="openTab(event, 'Arzt')">Arzt</button>
			</a>

		</div>


		<div class="bogen">
			<br>
			<div id="anmeldenA">
			<a style="color: red"> Der Nutzername und das Passwort stimmen nicht mit unseren
			 Unterlagen überein. Bitte überprüfen Sie Ihre Angaben und versuchen Sie es erneut.</a>
				<form name="login" method="post" action="/GIB-Anamnese/login">
					<label class="anmelden" for="Klinik">Klinikum: </label> <input
						type="text" id="AnmeldenA" name="Klinik"> <br> <label
						class="anmelden" for="Passwort">Passwort:</label> <input
						type="password" id="AnmeldenA" name="Passwort"> <br>
					<a id="vergessen">Passwort vergessen? </a><a id="Regi" style="color: blue" href="/GIB-Anamnese/html/Registrieren.jsp">
						Registrieren</a> <input id="anmeldenButton" type="submit"
						value="Anmelden"> <br>
				</form>
			</div>
			<br>
			<br>
		</div>
	</div>

</body>
</html>