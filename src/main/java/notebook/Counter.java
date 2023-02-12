package notebook;

public final class Counter {

	private static String[] words;
	private static String[] paragraphs;

	private Counter(){ }
	
	public static int charCount(String str) {
		return str == null ? 0 : str.length();
	}

	public static int wordCount(String str) {
		if (str == null || str.trim().isEmpty()) {
		      return 0;
		    }
		words = str.replaceAll("\\s", " ").trim().split("\\s+");
		return words.length;
	}
	
	public static int withoutSpacesCount(String str) {
		return str == null ? 0 : str.replaceAll("\\s", "").length();
	}
	
	public static int paragraphCount(String str) {
		if (str == null || str.trim().isEmpty()) {
		      return 0;
		    }
		paragraphs = str.split("\\R+");
		return paragraphs.length;
	}
}