<%@page import="htwg.in.gib.anam.control.DatenbankAnbindung"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
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
		if (document.absenden.gebDat.value == "") {
			alert("Bitte Ihren Geburtsdatum eingeben!");
			document.absenden.gebDat.focus();
			return false;
		}
		if (document.absenden.Str.value == "") {
			alert("Bitte Ihre Straße eingeben!");
			document.absenden.Str.focus();
			return false;
		}
		if (document.absenden.PLZ.value == "") {
			alert("Bitte Ihre PLZ eingeben!");
			document.absenden.PLZ.focus();
			return false;
		}
		if (document.absenden.Ort.value == "") {
			alert("Bitte Ihren Ort eingeben!");
			document.absenden.Ort.focus();
			return false;
		}
		
	}
	function checkForm(form)
	  {
	   
	    if(!form.Datenschutz.checked) {
	      alert("Bitte akzeptieren Sie die Datenschutzbestimmungen!");
	      form.Datenschutz.focus();
	      return false;
	    }
	    return true;
	  }

	 </script>
</head>
<body>
	<div class="container">
	
		<a href=../html/Anamnesebogen.html><img id="Logo"
					src="../img/GALOGO.png" /></a>
		<br>
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
			<a href=../html/Anamnesebogen
			
			.html><button id="zurück">zurück</button></a>
			<br> <br> <br>
			<h1>Fachrichtung Anästhesie</h1>
			<p class="unterschrift">Bitte füllen Sie alles aus</p>
			
			<form name="absenden" method="post"
				action="/GIB-Anamnese/anamnesebogenAnaesthesie" onsubmit="return checkForm(this);">
				<div class="frage">
					Vorname<span style="display: inline-block; width: 100px;color:red;">*</span><input
						type="text" id="Textfeld" name="Vorname" required pattern="[A-za-z]{2,20}+" >
					<p>
						Nachname<span style="display: inline-block; width: 82px;color:red;">*</span><input
							type="text" id="Textfeld" name="Nachname" required pattern="[A-za-z]{2,20}+">
					</p>
					<p>
						Geschlecht<span style="display: inline-block; width: 70px;color:red;">*</span>
						<input type="radio" id="ja" name="Geschlecht" value="weiblich">weiblich
						<span style="display: inline-block; width: 80px;"></span> <input
							type="radio" id="ja" name="Geschlecht" value="männlich" >männlich




					
					<p>
						Geburtsdatum<span style="display: inline-block; width: 49px ;color:red;" > *</span><input
							type="date" id="Textfeld" name="gebDat" placeholder="TT.MM.JJJJ" required pattern="[0-9]{2}.[0-9]{2}.[0-9]{4}">
					</p>
					<p>
						Straße<span style="display: inline-block; width: 123px;color:red;"> *</span><input
							type="text" id="Textfeld" name="Str" required pattern="[A-za-z]{2,40}+[0-9]{1,3}">
					</p>
					<p>
						PLZ<span style="display: inline-block; width: 150px;color:red;"> *</span><input
							type="text" id="Textfeld" name="PLZ" required pattern="[0-9]{5}" >
					</p>
					<p>
						Ort<span style="display: inline-block; width: 160px;color:red;">*</span><input
							type="text" id="Textfeld" name="Ort" required pattern="[A-za-z]{2,40}+">
					</p>
					<br>	
					<div class="pflichtfelder">
				* Pflichtfelder bitte ausfüllen
				</div>
				</div>
			

				<div class="antwort"></div>
				<br>


				<div class="frage">
					1. Beruf <br> <input type="text" id="Textfeld" name="Beruf">
				</div>
				<div class="antwort">
					<br>
				</div>
				<br>



				<div class="frage">2. Ist in letzter Zeit eine andere
					ärztliche Behandlungerfolgt?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort002" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort002" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, wann und weswegen? <br>
						<textarea name="nachricht001" rows="3" cols="37"></textarea>
				</div>


				<br>
				<div class="frage">3. Besteht akut/Bestand in den letzten vier
					Wochen ein Infekt(z.B. Erkältung, Fieber, Magen-Darm)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort003" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort003" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welcher? <input type="text" id="Textfeld" name="Frage001">
					</p>
				</div>


				<br>
				<div class="frage">4. Besteht/Bestand eine Infektionskrankheit
					(z.B. Hepatitis, Tuberkulose, HIV/AIDS)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort004" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort004" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage002">
					</p>
				</div>
				<br>

				<div class="frage">5. Werden regelmäßig oder derzeit
					Medikamente eingenommen (z.B. gerinngungshemmende Mittel (z.B.
					Aspirin, Marcumar, Pradaxa, Plavix, Xarelto, Lixiana, Heparin),
					Schmerzmittel, Herz-/Kreislauf- Medikamente, Hormonpräparate,
					Schlaf- oder Beruhigungsmittel, Antidiabetika)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort005" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort005" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage003">
					</p>
				</div>
				<br>

				<div class="frage">6. Werden pflanzliche
					Mittel/Ergänzungspräparate eingenommen (z.B. Johanniskraut, Gingko,
					Vitamine)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort006" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort006" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche/wann? <br>
						<textarea name="nachricht002" rows="6" cols="37"></textarea>
				</div>
				<br>
				<div class="frage">7. Wurde schon einmal eine Operation
					durchgeführt?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort007" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort007" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche/wann? <br>
						<textarea name="Frage004" rows="2" cols="37"></textarea>
				</div>
				<br>
				<div class="frage">8. Wurde schon einmal eine Narkose,
					Regionalanästhesie oder örtliche Betäubung (z.B. beim Zahnarzt)
					durchgeführt? j/n Wenn ja, gab es dabei Komplikationen?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort008" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort008" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage005">
					</p>
				</div>
				<br>
				<div class="frage">9. Traten bei Blutsverwandten Probleme im
					Zusammenhang mit einer Anästhesie auf?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort009" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort009" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
				</div>
				<br>
				<div class="frage">10. Besteht eine Neigung zu
					Übelkeit/Erbrechen?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort010" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort010" value="nein"> <label
						class="antworten" for="nein"> Nein</label>

				</div>

				<br>
				<div class="frage">11. Besteht bei Ihnen bzw. Blutsverwandten
					die Veranlagung zu hohem Fieber bei/nach Narkose (maligne
					Hyperthermie)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort011" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort011" value="nein"> <label
						class="antworten" for="nein"> Nein</label>

				</div>
				<br>

				<div class="frage">12. Ist schon einmal eine Übertragung von
					Blut/Blutbestandteilen(Transfusion) erfolgt? j/n Wenn ja, gab es
					dabei Komplikationen?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort012" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort012" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage006">
					</p>
				</div>
				<br>
				<div class="frage">13. Haben Sie für den geplanten Eingriff
					Eigenblut gespendet?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort013" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort013" value="nein"> <label
						class="antworten" for="nein"> Nein</label>

				</div>
				<br>
				<div class="frage">14. Besteht eine Allergie wie Heuschnupfen
					oder allergisches Asthma oder eine Unverträglichkeit bestimmter
					Substanzen (z.B. Medikamente, Latex, Desinfektionsmittel,
					Betäubungsmittel, Röntgenkontrastmittel, Jod, Pflaster, Pollen)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort014" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort014" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage007">
					</p>
				</div>
				<br>
				<div class="frage">15. Besteht eine
					Sojaunverträglichkeit/-allergie?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort015" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort015" value="nein"> <label
						class="antworten" for="nein"> Nein</label>

				</div>
				<br>
				<div class="frage">16. Besteht bei Ihnen oder in Ihrer
					Blutsverwandtschaft eine erhöhte Blutungsneigung wie z.B. häufig
					Nasen-/Zahnfleischbluten, blaue Flecken, Nachbluten nach
					Operationen?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort016" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort016" value="nein"> <label
						class="antworten" for="nein"> Nein</label>

				</div>
				<br>

				<div class="frage">17. Besteht/Bestand eine Gefäßerkrankung
					(z.B. Durchblutungsstörung, Arteriosklerose, Aneurysma,
					Krampfadern)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort017" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort017" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage008">
					</p>
				</div>
				<br>

				<div class="frage">18. Kam es schon einmal zu einem
					Gefäßverschluss durch Blutgerinnsel (Thrombose/Embolie)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort018" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort018" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage009">
					</p>
				</div>
				<br>
				<div class="frage">19. Besteht/Bestand eine
					Herz-Kreislauf-Erkrankung (z.B. Herzfehler, Herzklappenfehler,
					Angina pectoris, Herzinfarkt, Schlaganfall, Rhythmusstörungen,
					Herzmuskelentzündung, hoher Blutdruck)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort019" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort019" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage010">
					</p>
				</div>
				<br>
				<div class="frage">20. Tritt Atemnot bei Anstrengung auf?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort020" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort020" value="nein"> <label
						class="antworten" for="nein"> Nein</label>

				</div>
				<br>

				<div class="frage">21. Besteht/Bestand eine
					Atemwegs-/Lungenerkrankung (z.B. Asthma bronchiale, chronische
					Bronchitis, Lungenentzündung, Lungenblähung)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort021" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort021" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage011">
					</p>
				</div>
				<br>
				<div class="frage">22. Tritt starkes Schnarchen auf, liegt
					eine Schlafapnoe vor oder besteht eine
					Stimmband-/Zwerchfelllähmung?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort022" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort022" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, was? <input type="text" id="Textfeld" name="Frage012">
					</p>
				</div>
				<br>
				<div class="frage">23. Besteht/Bestand eine Erkrankung des
					Verdauungssystems (z.B. Speiseröhre, Magen, Bauchspeicheldrüse,
					Darm)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort023" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort023" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage013">
					</p>
				</div>
				<br>

				<div class="frage">24. Tritt Sodbrennen auf oder besteht eine
					Refluxkrankheit?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort024" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort024" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
				</div>
				<br>
				<div class="frage">25. Besteht/Bestand eine Erkrankung der
					Leber, Gallenblase/-wege (z.B. Entzündung, Fettleber, Zirrhose,
					Gallensteine)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort025" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort025" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage014">
					</p>
				</div>
				<br>
				<div class="frage">26. Besteht/Bestand eine Erkrankung oder
					Fehlbildung der Nieren bzw. Harnorgane (z.B.
					Nierenfunktionsstörung, Nierenentzündung, Nierensteine,
					Blasenentleerungsstörung)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort026" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort026" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage015">
					</p>
				</div>
				<br>
				<div class="frage">27. Besteht eine Stoffwechselerkrankung
					(z.B. Zuckerkrankheit, Gicht)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort026" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort026" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage016">
					</p>
				</div>
				<br>
				<div class="frage">28. Besteht/Bestand eine
					Schilddrüsenerkrankung (z.B. Überfunktion, Unterfunktion, Kropf)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort027" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort027" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage017">
					</p>
				</div>
				<br>
				<div class="frage">29. Besteht/Bestand eine Muskel- oder
					Skeletterkrankung (z.B. Muskelschwäche, Gelenkerkrankung,
					Osteoporose)?</div>
				<div class="antwort">
					<input type="radio" id="ja" name="Antwort028" value="ja"> <label
						class="antworten" for="ja"> Ja</label> <input type="radio"
						id="nein" name="Antwort028" value="nein"> <label
						class="antworten" for="nein"> Nein</label>
					<p>
						Wenn ja, welche? <input type="text" id="Textfeld" name="Frage018">
					</p>
				</div>
				<br>

				<div class="frage">
					<label>30. Hier können Sie Ihren Medikamentennplan, die
						Verpackung Ihrer Medikamente, Arztbriefe usw. hochladen. Wählen
						Sie dazu eine Datei von Ihrem Rechner aus.<br> <br> <input
						name="datei" type="file" size="50"> <br> <input
						name="datei" type="file" size="50"> <br> <input
						name="datei" type="file" size="50">
					</label>
				</div>
				<div class="antwort">


					<button id="hochladen">Hochladen</button>
					<br>
					<br>
				</div>



				<br> <br>

				<div class="frage">31. Haben Sie noch Fragen?</div>
				<div class="antwort">
					<textarea name="nachricht003" rows="6" cols="37"></textarea>
				</div>
				
				<br>
				
				<div class="frage">Welchem Arzt möchten Sie Ihren Anamnesebogen senden?</div>
								<div class="antwort"> 
					<select name="anWelchenArzt" required>
				<% 	DatenbankAnbindung dba = new DatenbankAnbindung();
					List<String> list = dba.selectAerzte();
					for(int i = 0; i < list.size(); i++){
						String arzt = list.get(i);
					%>
						<option value="<%=arzt%>"><%=arzt%></option>
					<% } %>
					</select>
				</div>

				<br>
				
				<div class="frage"><span style="color: red;">* </span>Datenschutzbestimmungen</div>
				<div class="antwort">
					<input type="checkbox" id="ja" name="Datenschutz" value="ja" required>
					<label class="antworten" for="ja"> Im Impressum gelesen und
						zugestimmt </label>

				</div>
				<br>
				<br> <input id="senden" type="submit" value="Absenden" onclick="Senden();">
			</form>
			<a href=../html/Anamnesebogen.html><button id="zurückUnten"  >zurück</button></a>

			<br> <br>
		</div>
	</div>
</body>
</html>