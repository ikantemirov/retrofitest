package io.kantemirov;

import java.util.ArrayList;
import java.util.List;

public class OwnerLoginExtractor {
    public ArrayList<String> getOwnerLoginList(List<Repo> repos) {
        ArrayList<String> logins = new ArrayList<String>();
        for (int i = 0; i < repos.size(); i++) {
            logins.add(repos.get(i).getOwner().getLogin());
        }
        return  logins;
    }
}
