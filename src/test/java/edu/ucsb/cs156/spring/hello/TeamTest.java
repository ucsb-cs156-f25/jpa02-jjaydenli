package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("f25-15");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("f25-15"));
    }

   
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=f25-15, members=[])", team.toString());
    }

    // Case 1
    @Test
    public void equals_sameObject() {
        Team team = new Team();
        team.addMember("Guntash Singh");
        team.addMember("Andrew X.");
        team.addMember("Jayden L.");
        team.addMember("Kelvin Apollo");
        team.addMember("Tim Van");
        team.addMember("Akul S.");
        assert(team.equals(team));
    }

    // Case 2
    @Test
    public void equals_diffInstance() {
        Team team = new Team();
        team.addMember("Guntash Singh");
        team.addMember("Andrew X.");
        team.addMember("Jayden L.");
        team.addMember("Kelvin Apollo");
        team.addMember("Tim Van");
        team.addMember("Akul S.");
        String notTeam = "Team(name=f25-15, members=[Guntash Singh, Andrew X., Jayden L., Kelvin Apollo, Tim Van, Akul S.])";
        assertFalse(team.equals(notTeam));
        assertFalse(team.equals(null));
    }

    // Case 3
    // name = T, members = T
    @Test
    public void equals_SameCast() {
        Team team = new Team("f25-15");
        team.addMember("Guntash Singh");
        team.addMember("Andrew X.");
        team.addMember("Jayden L.");
        Team team2 = new Team("f25-15");
        team2.addMember("Guntash Singh");
        team2.addMember("Andrew X.");
        team2.addMember("Jayden L.");
        assertTrue(team.equals(team2));
    }

    // name = T, members = F
    @Test
    public void equals_diffMembers() {
        Team team = new Team("f25-15");
        team.addMember("Guntash Singh");
        team.addMember("Andrew X.");
        team.addMember("Jayden L.");
        Team team2 = new Team("f25-15");
        team2.addMember("Tim Van");
        team2.addMember("Andrew X.");
        team2.addMember("Jayden L.");
        assertFalse(team.equals(team2));
    }

    // name = F, members = T
    @Test
    public void equals_diffName() {
        Team team = new Team("f25-xx");
        team.addMember("Guntash Singh");
        team.addMember("Andrew X.");
        team.addMember("Jayden L.");
        Team team2 = new Team("f25-15");
        team2.addMember("Guntash Singh");
        team2.addMember("Andrew X.");
        team2.addMember("Jayden L.");
        assertFalse(team.equals(team2));
    }

    // name = F, members = F
    @Test
    public void equals_diffNameAndMembers() {
        Team team = new Team("f25-xx");
        team.addMember("Guntash Singh");
        team.addMember("Andrew X.");
        team.addMember("Jayden L.");
        Team team2 = new Team("f25-15");
        team2.addMember("Tim Van");
        team2.addMember("Andrew X.");
        team2.addMember("Jayden L.");
        assertFalse(team.equals(team2));
    }

    @Test
    public void hashCode_returns_correct_hash() {
        Team t = new Team();
        int result = t.hashCode();
        int expectedResult = 1;
        assertEquals(result, expectedResult);
    }
}
