package edu.iis.mto.similarity;


import static org.junit.jupiter.api.Assertions.*;
import edu.iis.mto.searcher.SearchResult;
import edu.iis.mto.searcher.SequenceSearcher;
import org.junit.jupiter.api.Test;


class SimilarityFinderTest {

    @Test
    void test() {
        SimilarityFinder finder = new SimilarityFinder((elem, sequence) -> SearchResult.builder().withFound(true).build());
        int[] sequence = {-30, -21, 0, 2, 6, 9, 14, 25};
        int[] sequence2 = sequence;
        double expected = 1;
        assertEquals(expected, finder.calculateJackardSimilarity(sequence, sequence2));
    }

    @Test
    void test1() {
        SimilarityFinder finder = new SimilarityFinder((elem, sequence) -> SearchResult.builder().withFound(false).build());
        int[] sequence = {-30, -21, 0, 2, 6, 9, 14, 25};
        int[] sequence2 = {-18, -5, 1, 4, 12};
        double expected = 0;
        assertEquals(expected, finder.calculateJackardSimilarity(sequence, sequence2));
    }

    @Test
    void test2() {
        SimilarityFinder finder = new SimilarityFinder((elem, sequence) -> SearchResult.builder().withFound(false).build());
        int[] sequence = {};
        int[] sequence2 = {-18, -5, 1, 4, 12};
        double expected = 0;
        assertEquals(expected, finder.calculateJackardSimilarity(sequence, sequence2));
    }

    @Test
    void test3() {
        SimilarityFinder finder = new SimilarityFinder((elem, sequence) -> SearchResult.builder().withFound(false).build());
        int[] sequence = {-30, -21, 0, 2, 6, 9, 14, 25};
        int[] sequence2 = {};
        double expected = 0;
        assertEquals(expected, finder.calculateJackardSimilarity(sequence, sequence2));
    }

    @Test
    void test4() {
        SequenceSearcher ss = new SequenceSearcher() {
            @Override
            public SearchResult search(int elem, int[] sequence) {
                SearchResult searchResult = null;
                boolean[] types = {true, false};
                for (int i = 0; i < array.length; i++) {
                    if (elem == array[i]) {
                        searchResult = SearchResult.builder().withPosition(i).withFound(types[i]).build();
                    }
                }
                return searchResult;
            }
        };
        SimilarityFinder finder = new SimilarityFinder((elem, sequence) -> SearchResult.builder().withFound(false).build());
        int[] sequence = {-30, -21, 0, 2, 6, 9, 14, 25};
        int[] sequence2 = {6, 9, 14, 25};
        double expected = 0.5f;
        assertEquals(expected, finder.calculateJackardSimilarity(sequence, sequence2));
    }

}
