package io.kantemirov;

import org.junit.Test;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GithubTest {

    public GithubTest() throws IOException {
    }

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private GitHubService service = retrofit.create(GitHubService.class);
    private final List<Repo> repos = service.listRepos("ikantemirov").execute().body();
    private OwnerLoginExtractor ownerLoginExtractor = new OwnerLoginExtractor();
    private OwnerIdExtractor ownerIdExtractor = new OwnerIdExtractor();
    private ArrayList<String> logins = new ArrayList<String>();
    private ArrayList<Integer> ids = new ArrayList<Integer>();


    @Test
    public void should0RepoId() {
        assertThat(repos.get(0).getId()).isEqualTo(105242668);
    }

    @Test
    public void should0RepoName() {
        assertThat(repos.get(0).getName()).isEqualTo("calculator");
    }

    @Test
    public void should2RepoName() {
        assertThat(repos.get(2).getName()).isEqualTo("htmlelementstry");
    }

    @Test
    public void shouldRepo0OwnerLogin() {
        assertThat(repos.get(0).getOwner().getLogin()).isEqualTo("ikantemirov");
    }

    @Test
    public void shouldRepo0OwnerId() {
        assertThat(repos.get(0).getOwner().getId()).isEqualTo(32172415);
    }

    @Test
    public void shouldReposOwnersLoginsIkantemirov() {
        logins = ownerLoginExtractor.getOwnerLoginList(repos);
        assertThat(logins).containsOnly("ikantemirov");
    }

    @Test
    public void shouldReposOwnersIds32172415() {
        ids = ownerIdExtractor.getOwnerIdList(repos);
        assertThat(ids).containsOnly(32172415);
    }
}
