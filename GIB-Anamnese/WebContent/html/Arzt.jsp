<%@page import="htwg.in.gib.anam.control.DatenbankAnbindung"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Anamnese</title>
<link rel="shortcut icon" href="/GIB-Anamnese/html/favicon.ico"
	type="image/x-icon" />
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
		<br>



		<form>
			<div id="anamneseliste">
				Neue Anamnesen: <br>
				<br>
				<br>

			</div>
			<div class="antwort">
				<%
					DatenbankAnbindung dba = new DatenbankAnbindung();
					List<String> list = dba.selectAerzte();
					for (int i = 0; i < list.size(); i++) {
						String bogen = list.get(i);
				%>
				<a name="bogen<%=i%>"><%=bogen%>nachname-vorname-gebDat</a>
				<%
					}
				%>

				<br> <br>

				<button id="herunterladen">Alle Herunterladen</button>
				<button id="löschen">Alle löschen</button>
				<button id="markieren">Alle markieren</button>
				<button id="markierterunterladen">Markierte herunterladen</button>
				<br> <br> <br> <br>
			</div>


		</form>
		<br>
	</div>
	</div>

</body>
</html>