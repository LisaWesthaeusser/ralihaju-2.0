<%@page import="htwg.in.gib.anam.control.DatenbankAnbindung"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Anamnese</title>
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="../css/Style.css">
<script>
var elem = document.getElementById('senden');
elem.addEventListener('click', absenden);

function Senden() {
	if (document.absenden.Vorname.value == "") {
		alert("Bitte Ihren Vornamen eingeben!");
		document.absenden.Vorname.focus();
		return false;
	}
	if (document.absenden.Nachname.value == "") {
		alert("Bitte Ihren Nachamen eingeben!");
		document.absenden.Nachname.focus();
		return false;
	}
	if (document.absenden.Account.value == "") {
		alert("Bitte geben Sie Ihren Account-Namen ein!");
		document.absenden.Account.focus();
		return false;
	}
	
	
    if(document.absenden.Passwort1.value != document.absenden.Passwort2.value) {
      alert("Bitte überprüfen Sie ihre Passwortangaben!");
      document.absenden.Account.focus();
      return false;
    }
    
    
    <% DatenbankAnbindung dba = new DatenbankAnbindung();
    	List<String> list = dba.selectAccounts();
    	for(int i = 0; i < list.size(); i++){
				String account = list.get(i);%>						
    
    if(document.absenden.Account.value == <%=account%>) {
        alert("Ihr gewünschter Benutzername ist bereits vergeben. Bitt wählen Sie einen anderen!");
        document.absenden.Account.focus();
        return false;
      }
   
    <% } %>
  }
	

</script>
<body>
	<div class="container">

		<a href=../html/Anamnesebogen.html><img id="Logo"
			src="../img/GALOGO.png" /></a> <br>
		<div class="tab">


			<a href=../html/Anamnesebogen.html>
				<button class="tablinks" onclick="openTab(event, 'Anamnesebogen')">Anamnesebogen</button>
			</a> <a href=../html/Kontakt.html>
				<button class="tablinks" onclick="openTab(event, 'Kontakt')">Kontakt</button>
			</a> <a href=../html/Impressum.html><button class="tablinks"
					onclick="openTab(event, 'Impressum')">Impressum</button></a> <a
				href=../html/Arzt.html>
				<button class="tablinks" onclick="openTab(event, 'Arzt')">Arzt</button>
			</a>
		</div>
		<div class="bogen">
			<a href=../html/Anamnesebogen><button id="zurück">zurück</button></a>
			<br> <br> <br>
			<h1>Formular zur Registrierung</h1>
			<p class="unterschrift">Bitte füllen Sie alles aus</p>

			<form name="absenden" method="post"
				action="/GIB-Anamnese/registrieren"
				onsubmit="return checkForm(this);">
				<div class="frage">
				<br>
					Vorname<span
						style="display: inline-block; width: 100px; color: red;">*</span><input
						type="text" id="Textfeld" name="Vorname" required>
					<p>
						Nachname<span
							style="display: inline-block; width: 82px; color: red;">*</span><input
							type="text" id="Textfeld" name="Nachname" required>
					</p>
					<p>
						Titel<span style="display: inline-block; width: 147px; color: red;"></span><input
							type="text" id="Textfeld" name="Titel">
					</p>
					<p>
						Institution<span style="display: inline-block; width: 94px; color: red;"></span><input
							type="text" id="Textfeld" name="Institution">
					</p>
					<p>
						Straße<span
							style="display: inline-block; width: 122px; color: red;"></span><input
							type="text" id="Textfeld" name="Strasse">
					</p>
					<p>
						Hausnummer<span
							style="display: inline-block; width: 55px; color: red;"></span><input
							type="text" id="Textfeld" name="Hausnummer">
					</p>
					<p>
						PLZ<span style="display: inline-block; width: 147px; color: red;"></span><input
							type="text" id="Textfeld" name="PLZ">
					</p>
					<p>
						Ort<span style="display: inline-block; width: 157px; color: red;"></span><input
							type="text" id="Textfeld" name="Ort">
					</p>
					<p>
						E-Mail-Adresse<span
							style="display: inline-block; width: 38px; color: red;"></span><input
							type="text" id="Textfeld" name="E-Mail">
					</p>
					<p>
						Account-Name<span
							style="display: inline-block; width: 42px; color: red;">*</span><input
							type="text" id="Textfeld" name="Account" required>
					</p>
					<p>
						Passwort<span
							style="display: inline-block; width: 99px; color: red;">*</span><input
							type="text" id="pw1" name="Passwort1" required>
					</p>
					<p>
						Bestätigen Sie <br>Ihr Passwort<span
							style="display: inline-block; width: 65px; color: red;">*</span><input
							type="text" id="pw2" name="Passwort2" required>
					</p><br></div>
					<div class="antwort"></div>	
					<br><input id="senden" type="submit" value="Absenden" onclick="Senden();">
						  
				
			</form>
			<br><br>
		</div>
	</div>

</body>
</html>