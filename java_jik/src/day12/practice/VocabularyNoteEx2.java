package day12.practice;

public class VocabularyNoteEx2 {

	public static void main(String[] args) {
		Word wordList[] = {
				new Word("abc"),
				new Word("def","def is define")
		};

		VocabularyNote note = new VocabularyNote(wordList);
		note.print();
	}

}











