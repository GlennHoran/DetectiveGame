package website.views;

import java.io.OutputStream;
import java.io.PrintWriter;

import gamev2.AbstractResponder;
import gamev2.Actor;
import gamev2.Actor1;
import gamev2.Actor2;
import gamev2.Actor3;
import gamev2.Actor4;
import web.WebRequest;
import web.WebResponse;

public class InternalIndex extends DynamicWebPage {

	Actor a1 = new Actor1("neutral", "Caitlin");
	Actor a2 = new Actor2("neutral", "John");
	Actor a3 = new Actor3("neutral", "Verity");
	Actor a4 = new Actor4("neutral", "Samantha");

	public boolean process(WebRequest toProcess) {
		if (toProcess.path.equalsIgnoreCase("Index.html")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/homepage.html");
			return true;
		} else
		// pop javascript reference links in here
		if (toProcess.path.equalsIgnoreCase("img/room1.jpg")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/img/room1.jpg");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("menu.html")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/menu.html");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("homepage.html")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/homepage.html");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("actor1.html")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/actor1.html");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("actor2.html")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/actor2.html");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("actor3.html")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/actor3.html");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("actor4.html")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/actor4.html");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("img/actor11jpg.jpg")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/img/actor11jpg.jpg");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("img/background1.jpg")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/img/background1.jpg");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("img/4_queens_library.jpg")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/img/4_queens_library.jpg");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("img/conference-room.jpg")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/img/conference-room.jpg");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("img/hw.jpg")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/img/hw.jpg");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("img/howto.png")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/img/howto.png");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("img/actor3.jpg")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/img/actor3.jpg");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("img/actor2.jpg")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/img/actor2.jpg");
			return true;
		} else

		if (toProcess.path.equalsIgnoreCase("img/actor41.jpg")) {
			toProcess.r = WebResponse.serveFile(toProcess.parms, "WebContent/img/actor41.jpg");
			return true;
		} else if (toProcess.path.startsWith("Index1.cgi")) {
			int ind = toProcess.path.indexOf("/");
			String function = toProcess.path.substring(ind + 1);
			if (function.equalsIgnoreCase("input")) {
				// var for who is speaking
				String words = toProcess.parms.get("words");
				String reply = AbstractResponder.handle(words, a1);
				if (a1.getMood().equalsIgnoreCase("neutral")){
					reply = "neutral " + reply;
				} else if (a1.getMood().equalsIgnoreCase("nervous")){
					reply = "nervous " + reply;
				} else if (a1.getMood().equalsIgnoreCase("open")){
					reply = "open " + reply;
				}
				
				if (a1.getCaseSolved()){
					reply = "solved " + reply;
				}
				toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, reply);
				return true;
			}
		} 
		else if (toProcess.path.startsWith("Index2.cgi")) {
			int ind = toProcess.path.indexOf("/");
			String function = toProcess.path.substring(ind + 1);
			if (function.equalsIgnoreCase("input")) {
				// var for who is speaking
				String words = toProcess.parms.get("words");
				String reply = AbstractResponder.handle(words, a2);
				//append string with message for when case is solved here, add java script to look forthis string at the start of the reply
				if (a2.getMood().equalsIgnoreCase("neutral")){
					reply = "neutral " + reply;
				} else if (a2.getMood().equalsIgnoreCase("nervous")){
					reply = "nervous " + reply;
				} else if (a2.getMood().equalsIgnoreCase("open")){
					reply = "open " + reply;
				}
				toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, reply);
				return true;
			}
		}else if (toProcess.path.startsWith("Index3.cgi")) {
			int ind = toProcess.path.indexOf("/");
			String function = toProcess.path.substring(ind + 1);
			if (function.equalsIgnoreCase("input")) {
				// var for who is speaking
				String words = toProcess.parms.get("words");
				String reply = AbstractResponder.handle(words, a3);
				//append string with message for when case is solved here, add java script to look forthis string at the start of the reply
				if (a3.getMood().equalsIgnoreCase("neutral")){
					reply = "neutral " + reply;
				} else if (a3.getMood().equalsIgnoreCase("nervous")){
					reply = "nervous " + reply;
				} else if (a3.getMood().equalsIgnoreCase("open")){
					reply = "open " + reply;
				}
				toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, reply);
				return true;
			}
		}else if (toProcess.path.startsWith("Index4.cgi")) {
			int ind = toProcess.path.indexOf("/");
			String function = toProcess.path.substring(ind + 1);
			if (function.equalsIgnoreCase("input")) {
				// var for who is speaking
				String words = toProcess.parms.get("words");
				String reply = AbstractResponder.handle(words, a4);
				//append string with message for when case is solved here, add java script to look forthis string at the start of the reply
				if (a4.getMood().equalsIgnoreCase("neutral")){
					reply = "neutral " + reply;
				} else if (a4.getMood().equalsIgnoreCase("nervous")){
					reply = "nervous " + reply;
				} else if (a4.getMood().equalsIgnoreCase("open")){
					reply = "open " + reply;
				}
				toProcess.r = new WebResponse(WebResponse.HTTP_OK, WebResponse.MIME_HTML, reply);
				return true;
			}
		}
		return false;
	}

	// public void out(WebRequest r, Object metadata, OutputStream s) {
	// PrintWriter pw = new PrintWriter(s);
	// pw.append("<html>");
	// pw.append("Hello world");
	// pw.append("<img src=\"/Index.png\" />");

	// pw.append("</html>");

	// pw.flush();
	// }
	public void out(WebRequest r, Object metadata, OutputStream s) {
		PrintWriter pw = new PrintWriter(s);

		pw.append("<head>");
		pw.append(" <meta charset=\"utf-8\">");
		pw.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		pw.append(
				"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\" type=\"text/css\">");
		pw.append(
				"<link rel=\"stylesheet\" href=\"https://pingendo.github.io/templates/blank/theme.css\" type=\"text/css\"> </head>");
		pw.append("<style>");
		pw.append("#speech1 {padding: 10px;border-style: solid;}");
		pw.append("height: 100px;");
		pw.append(" font-size: 140%}");
		// pw.append("#notepad {background-image:
		// url('WebContent\img\notepad.jpg');
		// pw.append("height: 100px;");
		// pw.append("font-size: 140%");
		// pw.append("}");
		pw.append("</style>");
		pw.append("</head>");
		pw.append("<body>");
		pw.append(" <div class=\"container\">");
		pw.append(" <div class=\"container\">");
		pw.append("<div class=\"row\">");
		pw.append("<div class=\"col\">");
		pw.append("<ul class=\"nav nav-pills\">");
		pw.append("<li class=\"nav-item\">");
		pw.append("<a href=\"#\" class=\"active nav-link\"> <i class=\"fa fa-home fa-home\"></i>&nbsp;Home");
		pw.append("<br> </a>");
		pw.append("</li>");
		pw.append(" <li class=\"nav-item\">");
		pw.append("<a href=\"#\" class=\"active nav-link\"> <i class=\"fa fa-home fa-home\"></i>&nbsp;John");
		pw.append("<br> </a>");
		pw.append("</li>");
		pw.append("<li class=\"nav-item\">");
		pw.append("<a href=\"#\" class=\"active nav-link\"> <i class=\"fa fa-home fa-home\"></i>&nbsp;Verity");
		pw.append("<br> </a>");
		pw.append("</li>");
		pw.append("<li class=\"nav-item\">");
		pw.append("<a href=\"#\" class=\"active nav-link\"> <i class=\"fa fa-home fa-home\"></i>&nbsp;Sam");
		pw.append("<br> </a>");
		pw.append("</li>");
		pw.append("</ul>");
		pw.append("</div>");
		pw.append(" </div>");
		pw.append(" </div>");
		pw.append("<div class=\"row\" id=\"notepad\">");
		pw.append("<div class=\"col\">");
		pw.append("<h2> John </h2>");
		// pw.append("<img src=\"WebContent\img\actor1.jpg\" class=\"avatars\"
		// style=\"height:300px\">");
		pw.append(" </div>");
		pw.append("<div id=\"notepad\">");
		pw.append(" <h2>Try asking :</h2>");
		pw.append("<ul>");
		pw.append("<li id=\"list\"> How he is? </li>");
		pw.append("<li id=\"list\"> How did he feel about the proposal </li>");
		pw.append("<li id=\"list\"> Where was he when the victim was murdered? </li>");
		pw.append("<li id=\"list\">Does he know where anyone else was? </li>");
		pw.append("<li id=\"list\">Does he think anyone could murder the victim </li>");
		pw.append("<li id=\"list\">What was the fight about? </li>");
		pw.append("</ul>");
		pw.append("</div>");
		pw.append(" </div>");
		pw.append("</div>");
		pw.append("<div class=\"row\">");
		pw.append("<div class=\"col\">");
		pw.append("<p class=\"\"> <span id=\"speech\"></span> <span id=\"interim\"></span> </p>");
		pw.append("</div>");
		pw.append("</div>");
		pw.append("<div class=\"row\">");
		pw.append("<div class=\"col\">");
		pw.append("<p class=\"\"> <span id=\"reply\"></span> </p>");
		pw.append("</div>");
		pw.append("</div>");
		pw.append(" <script src=\"https://code.jquery.com/jquery-3.1.1.min.js\"></script>");
		pw.append("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js\"></script>");
		pw.append("<script src=\"https://pingendo.com/assets/bootstrap/bootstrap-4.0.0-alpha.6.min.js\"></script>");
		pw.append("<script>");
		pw.append("function upgrade() {");
		pw.append("alert('Please use Google Chrome for best experience');");
		pw.append("}");
		pw.append("window.onload = function() {");
		pw.append("if (!(window.webkitSpeechRecognition) && !(window.speechRecognition)) {");
		pw.append("upgrade();");
		pw.append(" } else {");
		pw.append("var recognizing,");
		pw.append("transcription = document.getElementById('speech');");
		pw.append("interim_span = document.getElementById('interim');");
		pw.append("interim_span.style.opacity = '0.5';");
		pw.append("function reset() {");
		pw.append(" recognizing = false;");
		pw.append("interim_span.innerHTML = '';");
		pw.append("transcription.innerHTML = '';");
		pw.append("speech.start();");
		pw.append("}");
		pw.append("var speech = new webkitSpeechRecognition() || speechRecognition();");
		pw.append("speech.continuous = true;");
		pw.append("speech.interimResults = false;");
		pw.append("speech.lang = 'en-US';");
		pw.append("speech.start();");
		pw.append("speech.onstart = function() {");
		pw.append("recognizing = true;");
		pw.append(" };");
		pw.append("speech.onresult = function(event) {");
		pw.append("var interim_transcript = '';");
		pw.append("var final_transcript = '';");
		pw.append(" for (var i = event.resultIndex; i < event.results.length; ++i) {");
		pw.append(" if (event.results[i].isFinal) {");
		pw.append("final_transcript += event.results[i][0].transcript;");
		pw.append("} else {");
		pw.append("interim_transcript += event.results[i][0].transcript;");
		pw.append("}");
		pw.append("}");
		pw.append("transcription.innerHTML = final_transcript;");
		pw.append("interim_span.innerHTML = interim_transcript;");
		pw.append("var xmlhttp;");
		pw.append("if(window.XMLHttpRequest)");
		pw.append("{");
		pw.append("xmlhttp = new XMLHttpRequest();");
		pw.append("}");
		pw.append("else");
		pw.append("{");
		pw.append("xmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\"); ");
		pw.append("}");
		pw.append("xmlhttp.onreadystatechange = function()");
		pw.append("{");
		pw.append("if((xmlhttp.readyState==4) && (xmlhttp.status==200))");
		pw.append("{");
		pw.append("reply_span = document.getElementById(\"reply\");");
		pw.append("var reply = xmlhttp.responseText;");
		pw.append("reply_span.innerHTML = reply;");
		pw.append("var msg = new SpeechSynthesisUtterance(\"\");");
		pw.append("var voices = window.speechSynthesis.getVoices();");
		pw.append("msg.voice = voices[4];");
		pw.append("msg.pitch =0;");
		pw.append("msg.text = reply;");
		pw.append("window.speechSynthesis.speak(msg);");
		pw.append(" }");
		pw.append(" }");
		pw.append("xmlhttp.open(\"GET\",\"/Index.cgi/input?words=\"+final_transcript,true);");
		pw.append("xmlhttp.send();");
		pw.append("};");
		pw.append("speech.onerror = function(event) {");
		pw.append("console.error(event.error);");
		pw.append("};");
		pw.append("speech.onend = function() {");
		pw.append("reset();");
		pw.append("};");
		pw.append("}");
		pw.append("};");
		pw.append("</script>");
		pw.append("</body>");
		pw.append("</html>");

		pw.flush();
	}

}
