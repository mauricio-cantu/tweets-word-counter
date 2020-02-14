package provagb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MapReduce implements IMapReduce {

	private SinglyLinkedList<WordCount> words = new SinglyLinkedList<>();

	@Override
	public void map(File file) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("#Unisinos")){					
					line = line.replaceAll("#Unisinos|,|\\.|;|\\?|!|_|-", "");
					for (String w : line.split(" ")) {
						if (w.length() >= 3){							
							WordCount word = new WordCount(w);
							reduce(word);
						}
					}
				}
			}
		}
	}

	@Override
	public void reduce(WordCount wordCount) {
		int pos;
		if ((pos = words.search(wordCount)) == -1)
			words.insertLast(wordCount);
		else
			words.get(pos).increaseFrequency();

	}

	@Override
	public void save(File file) throws IOException {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for (int i = 0; i < words.numElements; i++) {
				bw.write(words.get(i).toString());
				bw.newLine();
			}
		}

	}

}
