package inti;

import engine.Lobby;
import engine.RandomLobby;
import generators.RaceGen;
import generators.RandomRace;
import generators.WorldGen;
import logic.RandomMaster;
import model.Race;

import java.util.Arrays;
import java.util.List;

public class InitGame {
    public static void main(String[] args) {
        RandomLobby lobby = new RandomLobby();
        lobby.setParamsForLobby(4, 10);
        RandomMaster master = new RandomMaster(lobby);

    }

}
