package Lintcode.Yahoo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Parse_XML_CSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//class Page{}
////interface PageProcessor {
//class PageProcessor {
//	void process(Page page){};
//}
//
//class Read {
//	public static void main(String[] args) {
//
//		XMLManager.load(new PageProcessor() {
//			@Override
//			public void process(Page page) {
//				// Obviously you want to do something other than just printing,
//				// but I don't know what that is...
//				System.out.println(page);
//			}
//		});
//	}
//
//}
//
//class XMLManager {
//
//	public static void load(PageProcessor processor) {
//		SAXParserFactory factory = SAXParserFactory.newInstance();
//
//		try {
//
//			SAXParser parser = factory.newSAXParser();
//			File file = new File("pages-articles.xml");
//			PageHandler pageHandler = new PageHandler(processor);
//
//			parser.parse(file, pageHandler);
//
//		} catch (ParserConfigurationException e) {
//			e.printStackTrace();
//		} catch (SAXException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//
//	}
//}
//
//class PageHandler extends DefaultHandler{
//
//    private ArrayList<Page> pages = new ArrayList<Page>();
//    private Page page;
//    private StringBuilder stringBuilder;
//    private boolean idSet = false;
//
//    public PageHandler(){
//        super();
//    }
//    public PageHandler(PageProcessor processor){
//        super();
//    }
//
//    @Override
//    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//
//        stringBuilder = new StringBuilder();
//
//         if (qName.equals("page")){
//
//            page = new Page();
//            idSet = false;
//
//        } else if (qName.equals("redirect")){
//             if (page != null){
//                 page.setRedirecting(true);
//             }
//        }
//    }
//
//     @Override
//     public void endElement(String uri, String localName, String qName) throws SAXException {
//
//         if (page != null && !page.isRedirecting()){
//
//             if (qName.equals("title")){
//
//                 page.setTitle(stringBuilder.toString());
//
//             } else if (qName.equals("id")){
//
//                 if (!idSet){
//
//                     page.setId(Integer.parseInt(stringBuilder.toString()));
//                     idSet = true;
//
//                 }
//
//             } else if (qName.equals("text")){
//
//                 String articleText = stringBuilder.toString();
//
//                 articleText = articleText.replaceAll("(?s)<ref(.+?)</ref>", " "); //remove references
//                 articleText = articleText.replaceAll("(?s)\\{\\{(.+?)\\}\\}", " "); //remove links underneath headings
//                 articleText = articleText.replaceAll("(?s)==See also==.+", " "); //remove everything after see also
//                 articleText = articleText.replaceAll("\\|", " "); //Separate multiple links
//                 articleText = articleText.replaceAll("\\n", " "); //remove new lines
//                 articleText = articleText.replaceAll("[^a-zA-Z0-9- \\s]", " "); //remove all non alphanumeric except dashes and spaces
//                 articleText = articleText.trim().replaceAll(" +", " "); //convert all multiple spaces to 1 space
//
//                 Pattern pattern = Pattern.compile("([\\S]+\\s*){1,75}"); //get first 75 words of text
//                 Matcher matcher = pattern.matcher(articleText);
//                 matcher.find();
//
//                 try {
//                     page.setSummaryText(matcher.group());
//                 } catch (IllegalStateException se){
//                     page.setSummaryText("None");
//                 }
//                 page.setText(articleText);
//
//             } else if (qName.equals("page")){
//
//                 pages.add(page);
//                 page = null;
//
//            }
//        } else {
//            page = null;
//        }
//     }
//
//     @Override
//     public void characters(char[] ch, int start, int length) throws SAXException {
//         stringBuilder.append(ch,start, length); 
//     }
//
//     public ArrayList<Page> getPages() {
//         return pages;
//     }
//}