package parsingv2;


public class Run {
	public static void main(String[] args) {
		
		String exampleHtml = "\n" + 
				"	\n" + 
				"<html dir=\"ltr\" lang=\"en\">\n" + 
				"<head>\n" + 
				"	<meta charset=\"utf-8\">\n" + 
				"	<title>Examples | HTML Dog</title>\n" + 
				"\n" + 
				"<!--[if !(lt IE 9)]><!-->\n" + 
				"\n" + 
				"	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\">\n" + 
				"\n" + 
				"	<link href=\"/rAF/arcticFox.css\" rel=\"stylesheet\">\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"	<link href=\"https://fonts.googleapis.com/css?family=Lato:300,400,700|Source+Code+Pro:300,400,500\" rel=\"stylesheet\">\n" + 
				"\n" + 
				"<!--<![endif]-->\n" + 
				"\n" + 
				"	<!--[if lt IE 9]><script src=\"/rAF/html5shiv.js\"></script><link href=\"/rAF/altBasic.css\" rel=\"stylesheet\"><![endif]--> \n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"	<link rel=\"icon\" type=\"image/png\" href=\"/favicon-32x32.png\" sizes=\"32x32\">\n" + 
				"	<link rel=\"icon\" type=\"image/png\" href=\"/android-chrome-192x192.png\" sizes=\"192x192\">\n" + 
				"	<link rel=\"icon\" type=\"image/png\" href=\"/favicon-96x96.png\" sizes=\"96x96\">\n" + 
				"	<link rel=\"icon\" type=\"image/png\" href=\"/favicon-16x16.png\" sizes=\"16x16\">\n" + 
				"	<link rel=\"manifest\" href=\"/manifest.json\">\n" + 
				"	<link rel=\"mask-icon\" href=\"/safari-pinned-tab.svg\">\n" + 
				"	<meta name=\"msapplication-TileColor\" content=\"#2d89ef\">\n" + 
				"	<meta name=\"msapplication-TileImage\" content=\"/mstile-144x144.png\">\n" + 
				"	<meta name=\"theme-color\" content=\"#0088ee\">\n" + 
				"\n" + 
				"</head>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"<body>\n" + 
				"\n" + 
				"\n<br>" + 
				"<header id=\"pageMeta\">\n" + 
				"<div class=\"accessAid\"><a href=\"/\" title=\"Home\"><img src=\"/rAF/htmldog.png\" width=\"180\" height=\"130\" alt=\"HTML Dog\"></a></div>\n" + 
				"	<div id=\"toNav\"><a href=\"#nav\">Skip to navigation</a></div>\n" + 
				"</header>\n" + 
				"\n" + 
				"<nav id=\"youAreHere\">\n" + 
				"<p><strong class=\"accessAid\">You are here: </strong><a href=\"/\" id=\"yahHome\">Home</a><span class=\"yahSec yahEg\"></span>&nbsp;&rarr;</p>\n" + 
				"</nav>\n" + 
				"\n" + 
				"<article>\n" + 
				"\n" + 
				"<header>\n" + 
				"\n" + 
				"\n" + 
				"	<h1>Examples</h1>\n" + 
				"\n" + 
				"\n" + 
				"	\n" + 
				"<aside class=\"foodH1\"><div id=\"bsap_1305903\" class=\"bsarocks bsap_42de178ce2c5601e0c8eebfd00a854ae\"></div></aside>\n" + 
				"<aside class=\"foodH1\">\n" + 
				"	<div id=\"bsap_1305780\" class=\"bsarocks bsap_42de178ce2c5601e0c8eebfd00a854ae\">\n" + 
				"		<div class=\"foodGoog\"><script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" + 
				"<ins class=\"adsbygoogle\" data-ad-client=\"ca-pub-2105257479089713\" data-ad-slot=\"4282714042\" data-ad-format=\"auto\"></ins>\n" + 
				"<script>(adsbygoogle = window.adsbygoogle || []).push({});</script></div>\n" + 
				"	</div>\n" + 
				"</aside>\n" + 
				"\n" + 
				"\n" + 
				"	<p>Stripped-down, bare-bone examples demonstrating various HTML elements and CSS properties.</p>\n" + 
				"\n" + 
				"<p>See them in action and tinker &#8212; play with the code and watch what happens.</p>\n" + 
				"\n" + 
				"\n" + 
				"</header>\n" + 
				"\n" + 
				"<section>\n" + 
				"\n" + 
				"	\n" + 
				"\n" + 
				"<h2>Text</h2>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li><a href=\"headings1/\">Headings</a>: <a href=\"/references/html/tags/h1h2h3h4h5h6/\" class=\"acode\"><code>h1</code></a> to <a href=\"/references/html/tags/h1h2h3h4h5h6/\" class=\"acode\"><code>h6</code></a> in their default style.</li>\n" + 
				"<li><a href=\"headings2/\">Size doesn&#8217;t matter</a>: Making headings any size you choose with CSS.</li>\n" + 
				"<li><a href=\"case/\">Bold, italics, case, and line height</a>: Using <a href=\"/references/css/properties/font-weight/\" class=\"acode\"><code>font-weight</code></a>, <a href=\"/references/css/properties/font-style/\" class=\"acode\"><code>font-style</code></a>, <a href=\"/references/css/properties/font-variant/\" class=\"acode\"><code>font-variant</code></a>, <a href=\"/references/css/properties/text-transform/\" class=\"acode\"><code>text-transform</code></a>, and <a href=\"/references/css/properties/line-height/\" class=\"acode\"><code>line-height</code></a>.</li>\n" + 
				"<li><a href=\"fontfamilies/\">Font families</a>: Font family lists and the generic fallback font families.</li>\n" + 
				"<li><a href=\"fontsizes/\">Font sizes</a>: Absolute and relative units.</li>\n" + 
				"<li><a href=\"textalign/\">Spacing out text</a>: <a href=\"/references/css/properties/text-align/\" class=\"acode\"><code>text-align</code></a>, <a href=\"/references/css/properties/text-indent/\" class=\"acode\"><code>text-indent</code></a>, <a href=\"/references/css/properties/word-spacing/\" class=\"acode\"><code>word-spacing</code></a>, and <a href=\"/references/css/properties/letter-spacing/\" class=\"acode\"><code>letter-spacing</code></a> properties.</li>\n" + 
				"<li><a href=\"verticalalign/\">Vertical alignment</a>: The <a href=\"/references/css/properties/vertical-align/\" class=\"acode\"><code>vertical-align</code></a> property.</li>\n" + 
				"<li><a href=\"superscript/\">Subscript and superscript</a>: Using positioning as an alternative to the <a href=\"/references/css/properties/vertical-align/\" class=\"acode\"><code>vertical-align</code></a> property.</li>\n" + 
				"<li><a href=\"textshadows/\">Text shadows</a>: Shadows. On text.</li>\n" + 
				"<li><a href=\"dropcaps1/\">Simple drop caps</a>: A simple way to achieve a common effect.</li>\n" + 
				"<li><a href=\"dropcapsFancy/\">Fancy drop caps</a>: Jazzing up that first letter.</li>\n" + 
				"<li><a href=\"dropcapsGraphical/\">Graphical drop caps</a>: Using images.</li>\n" + 
				"<li><a href=\"dropcaps3/\">First-paragraph drop caps</a>: Targeting the first letter of the first paragraph.</li>\n" + 
				"<li><a href=\"pullquotes1/\">Pull quotes 1</a>: A simple pull quote structure.</li>\n" + 
				"<li><a href=\"pullquotes2/\">Pull quotes 2</a>: Adding a bit of style.</li>\n" + 
				"<li><a href=\"pullquotes3/\">Pull quotes 3</a>: A more elaborate style.</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"<h2>Links</h2>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li><a href=\"underlines/\">Underlines</a>: Various ways of underlining (usually links), using <a href=\"/references/css/properties/text-decoration/\" class=\"acode\"><code>text-decoration</code></a>, <a href=\"/references/css/properties/border-bottom/\" class=\"acode\"><code>border-bottom</code></a>, and <a href=\"/references/css/properties/background-image/\" class=\"acode\"><code>background-image</code></a>.</li>\n" + 
				"<li><a href=\"target/\">Anchors and targets</a>: Linking to parts of a page, and styling them using the <code>:target</code> pseudo class.</li>\n" + 
				"<li><a href=\"rollovers1/\">Rollovers 1</a>: Graphical links that change when the cursor moves over them using <code>:hover</code>.</li>\n" + 
				"<li><a href=\"rollovers2/\">Rollovers 2</a>: Further interactive effects, utilizing the <code>:active</code> pseudo class.</li>\n" + 
				"<li><a href=\"rollovers3/\">Rollovers 3</a>: Fading in and out.</li>\n" + 
				"<li><a href=\"rollovers4/\">Rollovers 4</a>: Rotating, using <a href=\"/references/css/properties/transform/\" class=\"acode\"><code>transform</code></a>.</li>\n" + 
				"<li><a href=\"transitions1/\">Simple CSS transitions</a>: Subtle animations of text links when they are hovered over.</li>\n" + 
				"<li><a href=\"transitions2/\">More CSS transitions</a>: Using <a href=\"/references/css/properties/border-radius/\" class=\"acode\"><code>border-radius</code></a> and RGBa colors.</li>\n" + 
				"<li><a href=\"transitions3/\">CSS transition timing functions</a>: Handling acceleration and deceleration of animated transitions.</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"<h2>Colors, Images, and Backgrounds</h2>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li><a href=\"colors/\">Colors</a>: CSS colors, using <a href=\"/references/css/properties/color/\" class=\"acode\"><code>color</code></a> and <a href=\"/references/css/properties/background-color/\" class=\"acode\"><code>background-color</code></a> properties.</li>\n" + 
				"<li><a href=\"images1/\">HTML images</a>: The <a href=\"/references/html/tags/img/\" class=\"acode\"><code>img</code></a> element.</li>\n" + 
				"<li><a href=\"images2/\">Background images</a>: The <a href=\"/references/css/properties/background-image/\" class=\"acode\"><code>background-image</code></a> CSS property.</li>\n" + 
				"<li><a href=\"background-position/\">Positioning backgrounds</a>: Using the <a href=\"/references/css/properties/background-position/\" class=\"acode\"><code>background-position</code></a> property.</li>\n" + 
				"<li><a href=\"background-repeat/\">Repeating background images</a>: Using the <a href=\"/references/css/properties/background-repeat/\" class=\"acode\"><code>background-repeat</code></a> property.</li>\n" + 
				"<li><a href=\"background-attachment/\">Background attachment</a>: How a background behaves with scrolling content.</li>\n" + 
				"<li><a href=\"background-size/\">Background image size</a>: Using <a href=\"/references/css/properties/background-size/\" class=\"acode\"><code>background-size</code></a>.</li>\n" + 
				"<li><a href=\"multiplebackgrounds/\">Multiple backgrounds</a>: Layering backgrounds inside a single box.</li>\n" + 
				"<li><a href=\"gradients1/\">Linear gradients</a>: Creating gradient backgrounds with CSS.</li>\n" + 
				"<li><a href=\"gradients2/\">Radial gradients</a>: Circular and elliptical gradient backgrounds.</li>\n" + 
				"<li><a href=\"opacity/\">Opacity</a>: The transparency of a box.</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"<h2>Layout</h2>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li><a href=\"widthsheights/\">Widths and heights</a>: <a href=\"/references/css/properties/width/\" class=\"acode\"><code>width</code></a>, <a href=\"/references/css/properties/height/\" class=\"acode\"><code>height</code></a>, <a href=\"/references/css/properties/max-width/\" class=\"acode\"><code>max-width</code></a>, <a href=\"/references/css/properties/min-height/\" class=\"acode\"><code>min-height</code></a>, and so on.</li>\n" + 
				"<li><a href=\"borders/\">Borders</a>: Thick, thin, this color, that color, solid, dotted, dashed&#8230;</li>\n" + 
				"<li><a href=\"borderradius/\">Rounded corners</a>: Using the <a href=\"/references/css/properties/border-radius/\" class=\"acode\"><code>border-radius</code></a> property.</li>\n" + 
				"<li><a href=\"boxshadows/\">Box shadows</a>: Adding pop.</li>\n" + 
				"<li><a href=\"margincollapse/\">Margin collapsing</a>: How vertical margins merge, or &#8220;collapse&#8221;, into each other.</li>\n" + 
				"<li><a href=\"outlines/\">Outlines</a>: The &#8220;borders&#8221; that border borders.</li>\n" + 
				"<li><a href=\"overflow/\">Overflow</a>: Managing the portions of content that do not fit inside a box.</li>\n" + 
				"<li><a href=\"blockinline1/\">Block and inline 1</a>: Changing the behavior of boxes using the <a href=\"/references/css/properties/display/\" class=\"acode\"><code>display</code></a> property.</li>\n" + 
				"<li><a href=\"blockinline2/\">Block and inline 2</a>: More differences between block and inline boxes.</li>\n" + 
				"<li><a href=\"blockinline3/\">Block and inline 3</a>: Applying <code>display: inline-block</code>.</li>\n" + 
				"<li><a href=\"positioning1/\">Positioning: static</a>: Following the normal flow.</li>\n" + 
				"<li><a href=\"positioning2/\">Positioning: relative</a>: Offsetting from the box&#8217;s initial position.</li>\n" + 
				"<li><a href=\"positioning3/\">Positioning: absolute 1</a>: Positioning in relation to a box&#8217;s container.</li>\n" + 
				"<li><a href=\"positioning4/\">Positioning: absolute 2</a>: Inside a positioned box.</li>\n" + 
				"<li><a href=\"positioning5/\">Positioning: fixed</a>: In relation to the viewport.</li>\n" + 
				"<li><a href=\"z-index/\">Z-index</a>: Stacking positioned boxes.</li>\n" + 
				"<li><a href=\"float1/\">Floating 1</a>: A simple floated box.</li>\n" + 
				"<li><a href=\"float2/\">Floating 2</a>: Two floated boxes.</li>\n" + 
				"<li><a href=\"float3/\">Floating 3</a>: Clearing floated boxes.</li>\n" + 
				"<li><a href=\"pagelayout1/\">Page layout 1</a>: Two columns step 1: positioning a navigation column.</li>\n" + 
				"<li><a href=\"pagelayout2/\">Page layout 2</a>: Two columns step 2: using <a href=\"/references/css/properties/margin/\" class=\"acode\"><code>margin</code></a> to push the content out from under the navigation column.</li>\n" + 
				"<li><a href=\"pagelayout3/\">Page layout 3</a>: Using a border to provide the background for a column.</li>\n" + 
				"<li><a href=\"pagelayout4/\">Page layout 4</a>: Three columns.</li>\n" + 
				"<li><a href=\"pagelayout5/\">Page layout 5</a>: Adding a header.</li>\n" + 
				"<li><a href=\"pagelayout6/\">Page layout 6</a>: Footers won&#8217;t always work with absolute positioned columns&#8230;</li>\n" + 
				"<li><a href=\"pagelayout7/\">Page layout 7</a>: Adding a footer using floated columns.</li>\n" + 
				"<li><a href=\"darwin/\">Charles Darwin</a>:  A styled up version of the basic principles of previous examples.</li>\n" + 
				"<li><a href=\"transforms/\">2D Transforms</a>: Manipulating the size, shape, and position of boxes with the <a href=\"/references/css/properties/transform/\" class=\"acode\"><code>transform</code></a> property.</li>\n" + 
				"<li><a href=\"transform-origin/\">Transform origin</a>: Altering the point at which transformations are measured from.</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"<h2>Lists &amp; Navigation</h2>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li><a href=\"lists1/\">Basic lists</a>: <a href=\"/references/html/tags/ul/\" class=\"acode\"><code>ul</code></a>, <a href=\"/references/html/tags/ol/\" class=\"acode\"><code>ol</code></a>, and <a href=\"/references/html/tags/li/\" class=\"acode\"><code>li</code></a> elements.</li>\n" + 
				"<li><a href=\"lists2/\">Nested lists</a>: Lists inside lists.</li>\n" + 
				"<li><a href=\"lists3/\">Description lists</a>: <a href=\"/references/html/tags/dl/\" class=\"acode\"><code>dl</code></a>, <a href=\"/references/html/tags/dt/\" class=\"acode\"><code>dt</code></a>, and <a href=\"/references/html/tags/dd/\" class=\"acode\"><code>dd</code></a>.</li>\n" + 
				"<li><a href=\"lists4/\">List markers</a>: Changing bullets and numbering using <a href=\"/references/css/properties/list-style-type/\" class=\"acode\"><code>list-style-type</code></a>.</li>\n" + 
				"<li><a href=\"list-style-image/\">Images as list item markers</a>: Using <a href=\"/references/css/properties/list-style-image/\" class=\"acode\"><code>list-style-image</code></a>.</li>\n" + 
				"<li><a href=\"lists5/\">Inside and outside list markers</a>: Using <a href=\"/references/css/properties/list-style-position/\" class=\"acode\"><code>list-style-position</code></a>.</li>\n" + 
				"<li><a href=\"dropdowns1/\">Dropdowns 1</a>: The basics of a dropdown menu.</li>\n" + 
				"<li><a href=\"dropdowns2/\">Dropdowns 2</a>: A simple multi-level dropdown menu.</li>\n" + 
				"<li><a href=\"dropdowns3/\">Dropdowns 3</a>: Multi-level dropdown with more detailed design.</li>\n" + 
				"<li><a href=\"tabs1/\">Inline tabs</a>: Basic tabbed navigation using the <a href=\"/references/css/properties/display/\" class=\"acode\"><code>display</code></a> property.</li>\n" + 
				"<li><a href=\"tabs2/\">Floated tabs</a>: Basic tabs using the <a href=\"/references/css/properties/float/\" class=\"acode\"><code>float</code></a> property.</li>\n" + 
				"<li><a href=\"tabs3/\">More tabs</a>: Making tabs more tab-like.</li>\n" + 
				"<li><a href=\"tabs4/\">Yet more tabs</a>: An alternative tab style.</li>\n" + 
				"<li><a href=\"tabs5/\">Skinny tabs</a>: Using simple underlines.</li>\n" + 
				"<li><a href=\"tabs7/\">Fancy tabs</a>: Going wild with CSS.</li>\n" + 
				"<li><a href=\"showhide1/\">Show / hide navigation (JavaScript)</a>: Toggling display using JavaScript.</li>\n" + 
				"<li><a href=\"showhide2/\">Show / hide navigation (target)</a>: Toggling display using the <code>:target</code> pseudo class.</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"<h2>Tables</h2>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li><a href=\"basictable/\">Basic table</a>: <a href=\"/references/html/tags/table/\" class=\"acode\"><code>table</code></a>, <a href=\"/references/html/tags/tr/\" class=\"acode\"><code>tr</code></a>, and <a href=\"/references/html/tags/td/\" class=\"acode\"><code>td</code></a> elements.</li>\n" + 
				"<li><a href=\"headercells/\">Header cells</a>: <a href=\"/references/html/tags/th/\" class=\"acode\"><code>th</code></a> elements.</li>\n" + 
				"<li><a href=\"rowspan/\">Merging cells 1</a>: The <code>rowspan</code> attribute.</li>\n" + 
				"<li><a href=\"colspan/\">Merging cells 2</a>: The <code>colspan</code> attribute.</li>\n" + 
				"<li><a href=\"bordercollapse1/\">Border collapsing 1</a>: Collapsing table cell borders.</li>\n" + 
				"<li><a href=\"bordercollapse2/\">Border collapsing 2</a>: Collapsing table cell borders and table borders.</li>\n" + 
				"<li><a href=\"colgroup/\">Column groups</a>: <a href=\"/references/html/tags/col/\" class=\"acode\"><code>col</code></a> and <a href=\"/references/html/tags/colgroup/\" class=\"acode\"><code>colgroup</code></a> elements.</li>\n" + 
				"<li><a href=\"emptycells/\">Empty cells</a>: Using the <a href=\"/references/css/properties/empty-cells/\" class=\"acode\"><code>empty-cells</code></a> property to specify how empty cells should be displayed.</li>\n" + 
				"<li><a href=\"tablelayout1/\">Automatic table layout</a>: The default layout algorithm that tables use.</li>\n" + 
				"<li><a href=\"tablelayout2/\">Fixed table layout</a>: Set using the <a href=\"/references/css/properties/table-layout/\" class=\"acode\"><code>table-layout</code></a> property.</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"<h2>Forms</h2>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li><a href=\"inputtextboxes/\">Text boxes</a>: Text and password type <a href=\"/references/html/tags/input/\" class=\"acode\"><code>input</code></a> elements.</li>\n" + 
				"<li><a href=\"inputcheckboxes/\">Checkboxes and radio buttons</a>: More <a href=\"/references/html/tags/input/\" class=\"acode\"><code>input</code></a> element types.</li>\n" + 
				"<li><a href=\"inputfile/\">File input</a>: For uploading.</li>\n" + 
				"<li><a href=\"textarea/\">Text areas</a>: The <a href=\"/references/html/tags/textarea/\" class=\"acode\"><code>textarea</code></a> element.</li>\n" + 
				"<li><a href=\"select1/\">Select boxes</a>: Basic use of <a href=\"/references/html/tags/select/\" class=\"acode\"><code>select</code></a> and <a href=\"/references/html/tags/option/\" class=\"acode\"><code>option</code></a> elements.</li>\n" + 
				"<li><a href=\"select2/\">Select box option groups</a>: Using the <a href=\"/references/html/tags/optgroup/\" class=\"acode\"><code>optgroup</code></a> element.</li>\n" + 
				"<li><a href=\"select3/\">Multiple selection select boxes</a>: Using the <code>multiple</code> attribute.</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"</section>\n" + 
				"\n" + 
				"<footer id=\"related\">\n" + 
				"\n" + 
				"	<h2>Related pages</h2>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"  <ul>\n" + 
				"  <li><a href=\"/guides/\">Tutorials</a></li>\n" + 
				"  <li><a href=\"/techniques/\">Techniques</a></li>\n" + 
				"  </ul>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"</footer>\n" + 
				"\n" + 
				"</article>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"<nav id=\"nav\">\n" + 
				"	\n" + 
				"	<section id=\"theThreeNaviteers\">\n" + 
				"	\n" + 
				"		<section id=\"navMain\">\n" + 
				"			<h2>Main menu</h2>\n" + 
				"			<ul>\n" + 
				"				<li><a href=\"/guides/\" id=\"navTut\">Tutorials</a>\n" + 
				"					<ul>\n" + 
				"						<li><a href=\"/guides/html/\">HTML</a></li>\n" + 
				"						<li><a href=\"/guides/css/\">CSS</a></li>\n" + 
				"						<li><a href=\"/guides/javascript/\">JavaScript</a></li>\n" + 
				"					</ul>\n" + 
				"				</li>\n" + 
				"				<li><a href=\"/techniques/\" id=\"navTech\">Techniques</a></li>\n" + 
				"				<li><a href=\"/examples/\" id=\"navEg\">Examples</a></li>\n" + 
				"				<li><a href=\"/references/\" id=\"navRef\">References</a>\n" + 
				"					<ul>\n" + 
				"            	        <li><a href=\"/references/html/\">HTML</a>\n" + 
				"							<ul>\n" + 
				"								<li><a href=\"/references/html/tags/\">Tags</a></li>\n" + 
				"								<li><a href=\"/references/html/globalattributes/\">Attributes</a></li>\n" + 
				"								<li><a href=\"/references/html/characters/\">Characters</a></li>\n" + 
				"							</ul>\n" + 
				"						</li>\n" + 
				"						<li><a href=\"/references/css/\">CSS</a>\n" + 
				"							<ul>\n" + 
				"								<li><a href=\"/references/css/properties/\">Properties</a></li>\n" + 
				"								<li><a href=\"/references/css/selectors/\">Selectors</a></li>\n" + 
				"								<li><a href=\"/references/css/values/\">Values</a></li>\n" + 
				"							</ul>\n" + 
				"						</li>\n" + 
				"					</ul>\n" + 
				"				</li>\n" + 
				"			</ul>\n" + 
				"		</section>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"		<section id=\"navSupp\">\n" + 
				"			<h2>Supplemental menu</h2>\n" + 
				"			<ul>\n" + 
				"				<li><a href=\"/about/\">About Us</a></li>\n" + 
				"				<li><a href=\"/contact/\">Contact Us</a></li>\n" + 
				"				<li><a href=\"/linkto/\">Link to Us</a></li>\n" + 
				"				<li><a href=\"/advertise/\">Advertise With Us</a></li>\n" + 
				"				<li><a href=\"/webhosting/\">Web Hosting</a></li>\n" + 
				"				<li><a href=\"/sitemap/\">Site Map</a></li>\n" + 
				"				<li><a href=\"/\" id=\"navHome\" title=\"Home\">Home</a></li>		\n" + 
				"			</ul>\n" + 
				"		</section>\n" + 
				"	\n" + 
				"	</section>\n" + 
				"\n" + 
				"	<form action=\"/search/\" id=\"search\">\n" + 
				"		<label for=\"sInput\">Search</label>\n" + 
				"		<input name=\"q\" id=\"sInput\">\n" + 
				"		<input type=\"submit\" value=\"Go!\" id=\"sGo\">\n" + 
				"	</form>\n" + 
				"\n" + 
				"	<a href=\"#\" id=\"toTop\">&#8593; Top</a>\n" + 
				"\n" + 
				"</nav>\n" + 
				"\n" + 
				"<footer id=\"siteFooter\">\n" + 
				"	\n" + 
				"<aside class=\"foodF\"><div id=\"bsap_1305782\" class=\"bsarocks bsap_42de178ce2c5601e0c8eebfd00a854ae\"></div></aside>\n" + 
				"<aside id=\"foodF1\" class=\"foodF\"><div class=\"foodGoog\"><script async src=\"//pagead2.googlesyndication.com/pagead/js/adsbygoogle.js\"></script>\n" + 
				"<ins class=\"adsbygoogle\" data-ad-client=\"ca-pub-2105257479089713\" data-ad-slot=\"4282714042\" data-ad-format=\"horizontal\"></ins>\n" + 
				"<script>(adsbygoogle = window.adsbygoogle || []).push({});</script></div></aside>\n" + 
				"\n" + 
				"	\n" + 
				"<p>� 2003�2019. <a href=\"/terms/\">Terms of use</a>.<br><a href=\"/edinburgh/\">Web design and development by <strong>HTML Dog, Edinburgh</strong></a>.</p>\n" + 
				"\n" + 
				"</footer>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"<script src=\"//s3.buysellads.com/ac/bsa.js\"></script>\n" + 
				"<script>\n" + 
				"  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" + 
				"  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" + 
				"  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" + 
				"  })(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" + 
				"\n" + 
				"  ga('create', 'UA-49412703-1', 'htmldog.com');\n" + 
				"  ga('send', 'pageview');\n" + 
				"\n" + 
				"</script>\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"</body>\n" + 
				"\n" + 
				"</html>";
		
		// Document faz o parse do HTML
		Document dok = Document.factory(exampleHtml);
		System.out.println(dok.getTreeString());
		
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
