package provagb;

public class WordCount {

	private String word;
	private int frequency;

	public WordCount(String word) {
		this.word = word;
		this.frequency = 1;
	}

	public void increaseFrequency() {
		this.frequency++;
	}

	@Override
	public String toString() {
		return String.format("%s;%s", word, frequency);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WordCount other = (WordCount) obj;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

}
