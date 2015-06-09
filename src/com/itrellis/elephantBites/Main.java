package com.itrellis.elephantBites;

import java.util.*;

//  Sample Input
//        1
//        3
//        John Doe
//        Jane Smith
//        Jane Austen
//        1 2 3
//        2 1 3
//        2 3 1
//        1 2 3
//        3 1 2


/*
interface AussieVoting {
    public void declareCandidate(String name);
    public void vote(String... names);
}

class AussieVotingImpl implements AussieVoting {

    private Map<String, Integer> votes = new HashMap<String, Integer>();

    @Override
    public void declareCandidate(String name) {
        votes.put(name, 0);
    }

    @Override
    public void vote(String... names) {
        for (String name : names) {
            votes.put(name, votes.get(name) + 1);
        }
    }
}



class Voting implements Map<String, Integer> {

    private HashMap<String, Integer> storage = new HashMap<String, Integer>();

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public boolean isEmpty() {
        return storage.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return storage.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return storage.containsValue(value);
    }

    @Override
    public Integer get(Object key) {
        return storage.get(key);
    }

    @Override
    public Integer put(String key, Integer value) {
        if (key == null)
            throw new RuntimeException("Never give me a null key. --Chuck Norris");
        if (value == null)
            throw new RuntimeException("Never give me a null value. --Donald Trump");

        return storage.put(key, value);
    }

    @Override
    public Integer remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends String, ? extends Integer> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<String> keySet() {
        return null;
    }

    @Override
    public Collection<Integer> values() {
        return null;
    }

    @Override
    public Set<Entry<String, Integer>> entrySet() {
        return null;
    }
}
*/

public class Main {

    public static List<String> getCandidateList() {
        List<String> candidates = new ArrayList<String>();

        candidates.add("John Adams");
        candidates.add("Jane Smith");
        candidates.add("Jane Austen");

        return candidates;
    }

    public static Ballot[] getBallots(List<String> candidates) {
        return new Ballot[]{
                new Ballot("John Adams", "Jane Smith", "Jane Austen"),
                new Ballot(candidates, 2, 1, 3),
                new Ballot(candidates, 2, 3, 1),
                new Ballot(candidates, 1, 2, 3),
                new Ballot(candidates, 3, 1, 2)
        };
    }

    public static void main(String... args) {
        List<String> candidates = getCandidateList();

        Ballot[] ballots = getBallots(candidates);

        // John Doe, Jane Smith, Jane Austen for this trial

        AussieElection election = new AussieElection(candidates, ballots);
        String newWinner = election.calculateWinner();
    }

    /*
    public static void oldmain(String[] args) {
	// write your code here
        String[] candidates = {"John Doe", "Jane Smith", "Jane Austen"};

        int[][] votes = new int[][]{ {1, 2, 3}, {2, 1, 3}, {2, 3, 1}, {1, 2, 3}, {3, 1, 2} };

        Map<String, Integer> results = new HashMap<String, Integer>();
        for (String candidate : candidates) {
            results.put(candidate, 0);
        }
        for (int i = 0; i < votes.length; i++) {
            System.out.println("***** Starting Round " + i + " ***********");
            for (int j = 0; j < candidates.length; j++) {
                String firstChoiceCandidate = candidates[(votes[i][j]) - 1];
                System.out.println(firstChoiceCandidate);
                int voteCount = results.get(firstChoiceCandidate);
                results.put(firstChoiceCandidate, ++voteCount);
                System.out.println(results);
                int mostVotes = 0;
                String roundLeader = "";
                for (String entry : results) {
                    // this doesn't work yet, but hopefully works as psuedocode
                    // there can be more than one entry with the max, but if
                    // that's the case, we need to re-run the results anyway.
                    // the real test is that max > numberOfVotes/2
                    if (results(entry) > mostVotes) {
                        roundLeader = entry;
                        mostVotes = results(entry);
                    }
                }
                if (mostVotes > numberOfVotes / 2) {
                    System.out.println("And the winner is "); // the key for the max value entry
                } else {
                    // we need to drop the mins and reenter the loop
                }
            }
        }

        }
    }
    */
}