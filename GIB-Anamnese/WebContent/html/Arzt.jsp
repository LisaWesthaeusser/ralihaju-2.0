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
			</a> <a href=/GIB-Anamnese/html/Impressum.html><button
					class="tablinks" onclick="openTab(event, 'Impressum')">Impressum</button></a>
			<a href=/GIB-Anamnese/html/Arzt.html>
				<button class="tablinks" onclick="openTab(event, 'Arzt')">Arzt</button>
			</a>

		</div>
		
<br>


		<form  name="absenden" method="post" action="/GIB-Anamnese/abrufen">
			<div id="anamneseliste">
				Neue Anamnesen:
			</div>
			<div class="antwort">
				<form>
					<table>
						<%
							String id = (String) request.getAttribute("variable");
							DatenbankAnbindung dba = new DatenbankAnbindung();
							List<String> ids = dba.selectBoegenEinesAccounts(id);
							int size = ids.size();
							for (int i = 0; i < size; i++) {
								String abc = ids.get(i);
								List<String> grunddaten = dba.selectInhalteinesBogens(abc);
								String daten = grunddaten.get(1) + ", " + grunddaten.get(0) + ": geb. am: " + grunddaten.get(3);
						%>
						<tr>
							

							<td><input type="radio" name="parameter" value="<%=abc%>">
								<%=abc%> </input></td>
															<td></td>
								<td><%=daten%>:</td>

							<br>
							<br>
							<%
								}
							%>
						
					</table>
					<input id="senden" type="submit" value="Bogen aufrufen">
				</form>
				</a> <br> <br>
			</div>


		</form>
		<br>
	</div>
	</div>

</body>
</html>