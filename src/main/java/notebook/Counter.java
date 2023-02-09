package notebook;

public class Counter {
	
	static String[] words;
	static String[] paragraphs;
	
	public static int charCount(String str) {
		return str.length();
	}

	public static int wordCount(String str) {
		if (str == null || str.isEmpty()) {
		      return 0;
		    }
		words = str.split("\\s+");
		return words.length;
	}
	
	public static int withoutSpacesCount(String str) {
		return str.replace(" ", "").replace("	", "").replace("\n", "").length();
	}
	
	public static int paragraphCount(String str) {
		if (str == null || str.isEmpty()) {
		      return 0;
		    }
		paragraphs = str.split("\\R+");
		return paragraphs.length;
	}
}