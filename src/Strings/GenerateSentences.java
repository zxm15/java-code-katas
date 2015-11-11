package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by ZXM on 11/8/15.
 */
public class GenerateSentences {

    private Set<String> nounSet;
    private List<String> nounList;
    private Set<String> verbSet;
    private List<String> verbList;
    Random rand = new Random();

    public void addSentence(String sentence) {
        List<String> nounPharses = parseNounPharse(sentence);
        for (String pharse : nounPharses) {
            if (! nounSet.contains(pharse)) {
                nounSet.add(pharse);
                nounList.add(pharse);
            }
        }
        List<String> verbPharses = parseVerbPharse(sentence);
        for (String pharse : verbPharses) {
            if (! nounSet.contains(pharse)) {
                nounSet.add(pharse);
                nounList.add(pharse);
            }
        }
    }

    public List<String> parseNounPharse(String sentence) {
        return new ArrayList<>();
    }

    public List<String> parseVerbPharse(String sentence) {
        return new ArrayList<>();
    }

    public String generateSentence() {
        StringBuilder sb = new StringBuilder();
        sb.append(nounList.get(rand.nextInt(nounList.size())));
        sb.append(verbList.get(rand.nextInt(verbList.size())));
        sb.append(nounList.get(rand.nextInt(nounList.size())));

        return sb.toString();
    }
}
