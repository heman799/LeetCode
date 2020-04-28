import java.util.*;

public class TopKFrequentWords {

    public String[] topKFrequentWords(String[] words, int k) {
        String[] result = new String[k];

        if (words == null || words.length == 0 || k == 0) {
            return null;
        }

        //HashMap
        HashMap<String, Integer> map = new HashMap<>();
        for (String str : words) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        // traverse hashmap, then put element in priority queue
        Queue<PairFreq> queue = new PriorityQueue<PairFreq>(new PairComparator());

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            PairFreq pairFreq = new PairFreq(entry.getKey(), entry.getValue());
            queue.offer(pairFreq);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        // poll the element in minHeap out and then insert into the string array
        while (!queue.isEmpty()) {
            PairFreq curPair = queue.poll();
            result[--k] = curPair.word;
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"yes","lint","code","yes","code","baby",
                        "you","baby","chrome","safari","lint",
                        "code","body","lint","code"};
        int k = 3;

        TopKFrequentWords topKFrequentWords = new TopKFrequentWords();
        String[] result = topKFrequentWords.topKFrequentWords(words, k);

        for(String str : result) {
            System.out.println(str);
        }
    }



}

class PairComparator implements Comparator<PairFreq> {
    public int compare (PairFreq p1, PairFreq p2) {
        if (p1.freq != p2.freq) {
            return p1.freq - p2.freq;
        }
        return p2.word.compareTo(p1.word);
    }

}


class PairFreq
{
    String word;
    int freq;
    public PairFreq(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}
