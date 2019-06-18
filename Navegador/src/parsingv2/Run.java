package parsingv2;


public class Run {
	public static void main(String[] args) {
		Tree<String> document = null;
		
		document = new Tree<String>("<HTML>");
		
		//FIND CHILD
		Node<String> firstChild = new Node<String>("HEAD");
		Node<String> secondChild = new Node<String>("BODY");
		
		document.getRoot().addChild(firstChild);
		document.getRoot().addChild(secondChild);
		
		Node<String> netoBody1 = new Node<String>("DIV");
		Node<String> netoBody2 = new Node<String>("TABLE");
		
		secondChild.addChild(netoBody1);
		secondChild.addChild(netoBody2);
		
		
		Document dok = Document.parseHTML(new Document(), null, "teste");
		
		System.out.println("linebreak");
		
//		String regex = "(<??)([A-Z][A-Z0-9]*)(\\b[^>]*>)([.\\s\\S]*?)<\\/\\2>";
//		Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
//		
//		Matcher m = p.matcher(exampleHtml);
////		
////		boolean matches = m.matches();
////		boolean find = m.find();
////		int groups = m.groupCount();
//
//		while(m.find()) {
//			System.out.println(m.group(0));
//			String next = m.group(4);
//			System.out.println(next);
//		}
//		
//		
//		
//		
//		System.out.println();
//	
		
		}
}
