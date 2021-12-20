package pairmatching.view.input.namereader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CrewNameFileReader implements CrewNameReader {
    public List<String> read(final String filePath) throws IOException {
        List<String> crewNames = new ArrayList<>();
        FileReader filereader = new FileReader(filePath);
        BufferedReader bufReader = new BufferedReader(filereader);
        for (String nextLine = bufReader.readLine(); nextLine != null; nextLine = bufReader.readLine()) {
            crewNames.add(nextLine);
        }
        return crewNames;
    }
}
