package io.kantemirov;

import java.util.ArrayList;
import java.util.List;

public class OwnerIdExtractor {
    public ArrayList<Integer> getOwnerIdList(List<Repo> repos) {
        ArrayList<Integer> ids = new ArrayList<Integer>();
        for (int i = 0; i < repos.size(); i++) {
            ids.add(repos.get(i).getOwner().getId());
        }
        return ids;
    }
}
