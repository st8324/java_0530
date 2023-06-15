package day12.practice;

public class VocabularyNoteEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Word word1 = new Word("vocabulary", "the words that make up a language");
		word1.print();
		word1.addMeaning("all of the words known and used by a person");
		word1.print();
		word1.removeMeaning(1);
		word1.print();
	}

}











