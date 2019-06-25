package webcrawler.parser;


public class Teste {
	
	public static void main(String[] args) {
	}
	
	public static String html = "<html>\n" + 
			"<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" + 
			"<head>\n" + 
			"    <title>Pudim</title>\n" + 
			"    <link rel=\"stylesheet\" href=\"estilo.css\">\n" + 
			"<!-- this is a comment -->"+
			"</head>\n" + 
			"<body>\n" + 
			"<div>\n" + 
			"    <div class=\"container\">\n" + 
			"        <div class=\"image\">\n" + 
			"            <img src=\"pudim.jpg\" alt=\"\">\n" + 
			"        </div>\n" + 
			"        <div class=\"email\">\n" + 
			"            <a href=\"mailto:pudim@pudim.com.br\">pudim@pudim.com.br</a>\n" + 
			"        </div>\n" + 
			"    </div>\n" + 
			"</div>\n" + 
			"<script>\n" + 
			"    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" + 
			"                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" + 
			"            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" + 
			"    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" + 
			"\n" + 
			"    ga('create', 'UA-28861757-1', 'auto');\n" + 
			"    ga('send', 'pageview');\n" + 
			"" + 
			"</script>" + 
			"</body>" + 
			"</html>";
	public static String html2 = "<script>\n" + 
			"    (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" + 
			"                (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" + 
			"            m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" + 
			"    })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" + 
			"\n" + 
			"    ga('create', 'UA-28861757-1', 'auto');\n" + 
			"    ga('send', 'pageview');\n" + 
			"" + 
			"</script>" ;

}
