package pairmatching.controller;

import pairmatching.view.input.namereader.CrewNameReader;

public class PairMatchingMainController {
    private final CrewNameReader crewNameReader;

    public PairMatchingMainController(final CrewNameReader crewNameReader) {
        this.crewNameReader = crewNameReader;
    }
}
