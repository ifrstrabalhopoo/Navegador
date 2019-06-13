package parsingv2;

public enum EnumHTMLTag {
	HTML("html", null, false),
    HEAD("head", null, false),
    BODY("body", null, true);
    
    
    private String tagname;
    private String effect;
    private boolean isVisible;
 
    private EnumHTMLTag(String tagname, String effect, boolean isVisible) {
    	this.tagname = tagname;
    	this.effect = effect;
    	this.isVisible = isVisible;
	}
    
 
    public String tagname() {
        return tagname;
    }
    public String effect() {
    	return effect;
    }
    public boolean isVisible() {
    	return isVisible;
    }
    /**
     * Verifica se o enum contem a string (tag) especificada
     * @param compare valor(tag) a comparar 
     * @return se contém
     */
    public static boolean contains(String compare) {
    	boolean result = false;
    	for(EnumHTMLTag value : EnumHTMLTag.values()) {
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
    public static EnumHTMLTag fromString(String str) 
    {
    	for (EnumHTMLTag tag : EnumHTMLTag.values()) 
    	{
    		if(tag.tagname.equals(str.toLowerCase())) 
    		{
    			return tag;
    		}
    	}
    	
    	return null;
    }
    
}
