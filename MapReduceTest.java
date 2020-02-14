package provagb;

import java.io.File;
import java.io.IOException;

public class MapReduceTest {

	public static void main(String[] args) {

		MapReduce mapReduce = new MapReduce();
		try {
			mapReduce.map(new File("C:\\Users\\mauriciocantu\\Documents\\tweets.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			mapReduce.save(new File("C:\\Users\\mauriciocantu\\Documents\\tweets_Saida.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
