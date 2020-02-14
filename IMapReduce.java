package provagb;

import java.io.File;
import java.io.IOException;

public interface IMapReduce {

	public void map(File file) throws IOException;

	public void reduce(WordCount wordCount);

	public void save(File file) throws IOException;

}
