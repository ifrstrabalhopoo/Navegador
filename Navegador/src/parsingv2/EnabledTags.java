package parsingv2;

public enum EnabledTags {
	HTML("html"),
    HEAD("head"),
    BODY("body");
    
    
    private String tag;
 
    private EnabledTags(String tag) {
    	this.tag = tag;
	}
    
 
    public String tagname() {
        return tag;
    }
    
    /**
     * Verifica se o enum contém a string (tag) especificada
     * @param compare valor(tag) a comparar 
     * @return se contém
     */
    public static boolean contains(String compare) {
    	boolean result = false;
    	for(EnabledTags value : EnabledTags.values()) {
    		if(value.tagname().equals(compare)) {
    			result = true;
    		}
    	}
    	return result;
    }
}
