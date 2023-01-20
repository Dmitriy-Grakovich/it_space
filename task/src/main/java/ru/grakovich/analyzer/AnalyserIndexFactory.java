package ru.grakovich.analyzer;

import ru.grakovich.analyzer.AnalyzerIndex;
import ru.grakovich.analyzer.AnalyzerIndexImpl;

public final class AnalyserIndexFactory {
    private AnalyserIndexFactory() {
    }
    public static AnalyzerIndex createAnalyserIndex(){
        return new AnalyzerIndexImpl();
    }
}
