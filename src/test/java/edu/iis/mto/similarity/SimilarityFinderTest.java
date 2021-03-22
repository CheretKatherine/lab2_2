package edu.iis.mto.similarity;

import static org.junit.jupiter.api.Assertions.fail;

import edu.iis.mto.searcher.SearchResult;
import edu.iis.mto.searcher.SequenceSearcher;
import org.junit.jupiter.api.Test;

class SimilarityFinderTest {

    @Test
    void test() {
        SequenceSearcher ss = new SequenceSearcher() {
            @Override
            public SearchResult search(int elem, int[] sequence) {
                for(int i=0; i< sequence.length; i++){
                    if(sequence[i]==elem){
                        return SearchResult.Builder.withFound(true).withPosition(i).build();;
                    }
                }
                return SearchResult.Builder.withFound(false).build();;
            }
        }

    }

}
