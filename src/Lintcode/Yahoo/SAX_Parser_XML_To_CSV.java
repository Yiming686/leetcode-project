package Lintcode.Yahoo;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAX_Parser_XML_To_CSV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();

			DefaultHandler handler = new DefaultHandler() {

				boolean isName = false;
				boolean isPrice = false;
				boolean isDescripiton = false;
				boolean isCalories = false;

				public void startElement(String uri, String localName, String elementName, Attributes attributes)
						throws SAXException {

					System.out.println("Start Element :" + elementName);

					if (elementName.equalsIgnoreCase("name")) {
						isName = true;
					}

					if (elementName.equalsIgnoreCase("price")) {
						
						isPrice = true;
					}

					if (elementName.equalsIgnoreCase("description")) {
						isDescripiton = true;
					}

					if (elementName.equalsIgnoreCase("calories")) {
						isCalories = true;
					}

				}

				public void endElement(String uri, String localName, String elementName) throws SAXException {

					System.out.println("End Element :" + elementName);

				}

				public void characters(char ch[], int start, int length) throws SAXException {

					if (isName) {
						System.out.println("name : " + new String(ch, start, length));
						isName = false;
					}

					if (isPrice) {
						System.out.println("price : " + new String(ch, start, length));
						isPrice = false;
					}

					if (isDescripiton) {
						System.out.println("description : " + new String(ch, start, length));
						isDescripiton = false;
					}

					if (isCalories) {
						System.out.println("calories : " + new String(ch, start, length));
						isCalories = false;
					}

				}

			};

			saxParser.parse("/Users/yiming/Downloads/largesize.2.part2.xml", handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
