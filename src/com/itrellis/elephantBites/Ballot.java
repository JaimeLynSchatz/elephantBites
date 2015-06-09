package com.itrellis.elephantBites;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaime on 6/8/15.
 */
public class Ballot {
    List<String> votes = new ArrayList<String>();

    public Ballot(String... vs) {
        for (int i = 0; i < vs.length; i++) {
            votes.add(vs[i]);
        }
    }
    public Ballot(List<String> candidates, int... vs) {
        for (int i = 0; i < vs.length; i++) {
            votes.add(candidates.get(vs[i] - 1));
        }
    }

    public int getCandidates() {
        return votes.size();
    }

    public String getCandidate(List<String> koList) {
        for (String n : votes) {
            if (koList.contains(n))
                continue;
            else
                return n;
        }

        // Technically we should never get here, but...
        return null;
    }
}
