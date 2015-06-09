package com.itrellis.elephantBites;

import java.util.*;
import java.util.List;


/**
 * Created by jaime on 6/8/15.
 */
public class AussieElection {

    private List<String> candidates;
    private Ballot[] ballots;

    // Constructor: List of Candidates, List of Ballots
    public AussieElection(List<String> candidates, Ballot[] ballots) {
        this.candidates = candidates;
        this.ballots = ballots;
    }

    public List<String> lookForCandidateWith(Map<String,Integer> votes, int count) {
        List<String> results = new ArrayList<String>();

        for (String cand : votes.keySet()) {
            if (votes.get(cand) == count)
                results.add(cand);
        }

        return results;
    }

    // return the election winner
    public String calculateWinner() {

        String winner = null;
        List<String> knockedOutList = new ArrayList<String>();

        int totalVotes = ballots.length;
        int winningTotal = (int)(totalVotes / 2.0) + 1;

        while (winner == null) {
            System.out.println("Starting round");

            Map<String, Integer> votes = new HashMap<String, Integer>();

            // Seed the votes with candidates at 0
            for (String candidate : candidates)
                votes.put(candidate, 0);

            // Do the counting
            for (Ballot b : ballots) {
                String candidateName = b.getCandidate(knockedOutList);
                System.out.println("\t" + candidateName + " gets a vote!");
                votes.put(candidateName, votes.get(candidateName) + 1);
            }

            // Check our winner: Does anybody have > 50% of the vote?
            for (String candidate : candidates) {
                System.out.println(candidate + ": " + votes.get(candidate) + " votes");
                if (votes.get(candidate) >= winningTotal) {
                    winner = candidate;
                }
            }
            if (winner == null) {
                System.out.println("No clear winner!");

                List<Integer> voteCounts = new ArrayList<Integer>(votes.values());
                Collections.sort(voteCounts);
                int smallest = voteCounts.get(0);
                List<String> losers = lookForCandidateWith(votes, smallest);
                System.out.println("Our losers for this round are " + losers);
                knockedOutList.addAll(losers);

                if (knockedOutList.size() == candidates.size()) {
                    System.out.println("WHOA. No winners, man.");
                    winner = "NOBODY";
                }
            }
        }
        return winner;
    }
}
