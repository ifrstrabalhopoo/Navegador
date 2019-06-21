package webcrawler.parser.fragments_old;

/**
 * Contem os elementos HTML (Tags) que o parser irá suportar,
 * Lista completa dos elementos retiradas do Mozilla Developer Network 
 * 
 * 
 * @see: <a href="https://developer.mozilla.org/pt-BR/docs/Web/HTML/Element">Site MDN</a>
 * @author everton
 *
 * @param tagname Nome da tag
 * @param tagOmission	Se o fechamento da tag é omitido, como por exemplo a tag "br"
 * @param shouldRender		Se esta tag deve ser renderizada setar para true
 * @param textEffect		Efeito de texto (negrito, alinhamento, etc)
 */
public enum EnumHTMLElement {
	//			tagname		omission	render	textEffect
	A			("a", 			false, 	true,	"href"),
		//!acronym  (not supported)
    	//!abbr
	ADDRESS		("address", 	false,	true,	"none"),	
    	//!applet 
	AREA		("area", 		false,	true,	"none"),
    ARTICLE		("article", 	false,	true,	"none"),
    ASIDE		("aside", 		false,	true,	"none"),
    	//!audio
    B			("b",			false,	true,	"textBold"),
    	//!base
    	//!bdi
    BDO			("bdo",			false,	true,	"textInverted"),
    	//!bgsound
    	//!big
    	//!blink
    BLOCKQUOTE	("blockquote", 	false,	true,	"none"),
    BODY		("body",		false,	true,	"none"),
    BR			("br", 			true,	true,	"displayNewline"),
    BUTTON		("button",		false,	true,	"asButton"),
    	//!canvas
    CAPTION		("caption",		false,	true,	"textBold"),
    CENTER		("center", 		false,	true,	"textCenter"),
    	//!cite
    	//!code
    COLGROUP	("colgroup", 	false,	true,	"none"),
    	//!command
    CONTENT		("content", 	false,	true,	"none"),
    	//!data
    	//!datalist
    	//!dd
    	//!del
    	//!details
    	//!dfn
    	//!dialog
    	//!dir
    DIV			("div", 		false,	true,	"none"),
    	//!dl
		//!dt
    	//!element
    EM			("em", 			false,	true,	"none"),
    EMBED		("embed",		false,	true,	"none"),
    	//!fieldset
    	//!figcaption
    	//!figure
    	//!font
    		//TODO: adicionar suporte à tag <font> - ela possui elementos de formatação de texto
    FOOTER		("footer", 		false,	true,	"none"),
    FORM		("form",	 	false,	true,	"none"),
    	//!frame
    	//!frameset
    HEAD		("head", 		false,	false,	"none"),
    HEADER		("header", 		false,	true,	"none"),
    	//!hgroup
    HR			("blockquote", 	false,	true,	"horizontalRuler"),
    HTML		("html",	 	false,	true,	"none"),
    I			("i", 			false,	true,	"none"),
    	//!iframe
    	//!image
    IMG			("img", 		false,	true,	"displayImage"),
    	//!input
    		//TODO: verificar se será possivel renderizar forms (inputs)
    INS			("ins",		 	false,	true,	"none"),
    	//!isindex
    	//!kbd
    	//!keygen
    LABEL		("label",	 	false,	true,	"textAsLabel"),
    LEGEND		("legend",	 	false,	true,	"textAsLabel"),
    LI			("li", 			false,	true,	"textAsListItem"),
    LINK		("link",	 	false,	false,	"none"),
    	//!listing
    MAIN		("main",	 	false,	true,	"none"),
    	//!map
    MARK		("mark",	 	false,	true,	"textMarked"),
    	//!marquee
    	//!menu
    	//!menuitem
    META		("blockquote", 	true,	false,	"none"),
    	//!meter
    	//!multicol
    NAV			("nav", 		false,	true,	"none"),
    	//!nextid
    	//!nobr
    	//!noembed
    	//!noframes
    	//!noscript
    	//!object
    OL			("ol", 			false,	true,	"none"),
    OPTGROUP	("optgroup", 	false,	true,	"none"),
    OPTION		("option", 		false,	true,	"none"),
    	//!output
    P			("p",		 	false,	true,	"none"),
    	//!param
    	//!picture
    	//!plaintext
    PRE			("pre",		 	false,	true,	"none"),
    	//!progress
    	//!q
    	//!rb
    	//!rp
    	//!rt
    	//!rtc
    	//!ruby
    	//!s
    	//!samp
    SCRIPT		("script", 		false,	false,	"none"),
    SECTION		("section", 	false,	true,	"none"),
    SELECT		("select", 		false,	true,	"none"),
    	//!shadow
    	//!slot
    	//!small
    	//!source
    	//!spacer
    SPAN		("span",	 	false,	true,	"none"),
    	//!strike
    STRONG		("strong", 		false,	true,	"textBold"),
    	//!style
    	//!sub
    SUMMARY		("summary", 	false,	true,	"none"),
    	//!sup
    	// TABLE		("table",	 	false,	true,	"none"),
    	//!tbody
    	// TD			("td", 				false,	true,	"none"),
    	//!template
    	//!textarea
    	//!tfoot
    	//!th
    	//!thead
    		// não vamos dar suporte à tabelas por enquanto
    	//!time
    TITLE		("title",	 	false,	false,	"none"),
    	//!tr
    	//!track
    	//!tt
    U			("u",		 	false,	true,	"textSmall"),
    UL			("ul", 			false,	true,	"none"),
    	//!var
    	//!video
    	//!wbr
    	//!xmp
	TEXTNODE	("textnode",	false,	true,	"displayText");
    
    
    
    
    private String 		tagname;
    private boolean 	tagOmission;
    private boolean 	shouldRender;
    private String 		textEffect;
 
    /**
     * 
     * @param tagname Nome da tag
     * @param tagOmission	Se o fechamento da tag é omitido, como por exemplo a tag "br"
     * @param shouldRender		Se esta tag deve ser renderizada setar para true
     * @param textEffect		Efeito de texto (negrito, alinhamento, etc)
     */
    private EnumHTMLElement(String tagname, boolean tagOmission, boolean shouldRender, String textEffect) {
    	this.tagname = tagname;
    	this.tagOmission = tagOmission;
    	this.shouldRender = shouldRender;
    	this.textEffect = textEffect;
	}
    
 
    public String tagname() {
        return tagname;
    }
    public boolean shouldRender() {
    	return shouldRender;
    }
    public boolean isTagOmitive() {
    	return tagOmission;
    }
    public String textEffect() {
    	return textEffect;
    }
    /**
     * Verifica se o enum contem a string (tag) especificada
     * @param compare valor(tag) a comparar 
     * @return se contém
     */
    public static boolean contains(String compare) {
    	boolean result = false;
    	for(EnumHTMLElement value : EnumHTMLElement.values()) {
    		if(value.tagname().equals(compare)) {
    			result = true;
    		}
    	}
    	return result;
    }
    /**
     * Return o valor de um enum caso exista o valor do tagname
     * @param str tagname a ser comparado
     * @return valor do enum or null
     */
    public static EnumHTMLElement fromString(String str) 
    {
    	for (EnumHTMLElement tag : EnumHTMLElement.values()) 
    	{
    		if(tag.tagname.equals(str.toLowerCase())) 
    		{
    			return tag;
    		}
    	}
    	
    	return null;
    }
    
}
