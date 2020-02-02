package tests.meir.bar.trello.tests;

import org.testng.annotations.DataProvider;
import tests.meir.bar.trello.model.TeamData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    @DataProvider
    public Iterator<Object[]> validTeams() throws InterruptedException {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{"name DP","description DP"});
        Thread.sleep(5000);
        list.add(new Object[]{"DPn",""});
        Thread.sleep(5000);

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> validTeamsCSV() throws IOException, InterruptedException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/teamsPositiveCSV.csv")));
        Thread.sleep(5000);
        String line = reader.readLine();
        while (line!=null){
            String[]split = line.split(",");
            list.add(new Object[]{
                    new TeamData()
                            .withTeamName(split[0])
                            .withTeamDescr(split[1])});

            line = reader.readLine();
        }

        return list.iterator();
    }
}
