package pairmatching.view.input.namereader;

import java.io.IOException;
import java.util.List;

public interface CrewNameReader {
    List<String> read(final String source) throws IOException;
}
