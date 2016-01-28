package Lintcode.Yahoo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ConvertXML2CSV {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

//		long start = System.nanoTime();
		long start = System.currentTimeMillis();

//		String inputFileName  = "/Users/Test/Downloads/inputXMLFile1.xml";
//		String outPutFileName = "/Users/Test/Downloads/outPutCSVFile1.txt";

		String inputFileName = "/Users/yiming/Downloads/largesize.2.part1.xml";
		String outPutFileName = "/Users/yiming/Downloads/largesize.2.part2.output.txt";

		convertXML2CSV(inputFileName, outPutFileName);

//		long end = System.nanoTime();
		long end = System.currentTimeMillis();

		System.out.println("Time Elapsed : " + (end - start) + " ms !");

	}

	static void convertXML2CSV(String inputFileName, String outPutFileName)
			throws ParserConfigurationException, SAXException, IOException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		File csv2 = new File(outPutFileName);
		BufferedWriter bw = new BufferedWriter(new FileWriter(csv2.getAbsoluteFile()));
		MyHandler handler = new MyHandler(bw);
		saxParser.parse(inputFileName, handler);
		bw.close();
	}

	static class MyHandler extends DefaultHandler {

		@Override
		public void startElement(String uri, String localName, String elementName, Attributes attributes)
				throws SAXException {

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

		@Override
		public void characters(char ch[], int start, int length) throws SAXException {

			try {
				if (isName) {
					bufferedWriter.write(new String(ch, start, length) + ", ");
					isName = false;
				}
				if (isPrice) {
					bufferedWriter.write(new String(ch, start, length) + ", ");
					isPrice = false;
				}
				if (isDescripiton) {
					bufferedWriter.write(new String(ch, start, length) + ", ");
					isDescripiton = false;
				}
				if (isCalories) {
					bufferedWriter.write(new String(ch, start, length) + " \n");
					isCalories = false;
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public MyHandler(BufferedWriter bufferedWriter) {
			// TODO Auto-generated constructor stub
			this.bufferedWriter = bufferedWriter;
			init();
		}

		boolean isName = false;
		boolean isPrice = false;
		boolean isDescripiton = false;
		boolean isCalories = false;

		BufferedWriter bufferedWriter;

		public void init() {
			try {
				bufferedWriter.write("name, " + "price, " + "description, " + "calories \n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
