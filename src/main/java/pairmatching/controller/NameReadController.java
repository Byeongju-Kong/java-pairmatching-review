package pairmatching.controller;

import pairmatching.view.input.namereader.CrewNameReader;

import java.io.IOException;
import java.util.List;

public class NameReadController {
    private final CrewNameReader crewNameReader;

    public NameReadController(final CrewNameReader crewNameReader) {
        this.crewNameReader = crewNameReader;
    }

    public List<String> readCrewNames(final String filePath) throws IOException {
        return crewNameReader.read(filePath);
    }
}
