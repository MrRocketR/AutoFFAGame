package logic;

import engine.RandomLobby;
import model.Player;
import report.ReportEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RandomMaster implements Runnable {

    private RandomLobby lobby;
    private ReportEngine report;
    private Map<Integer, Player> playersMap;
    private ConcurrentLinkedQueue playersQueue;
    private int[][] world;
    private List<PlayerLogic> list;


    public RandomMaster(RandomLobby lobby) {
        this.lobby = lobby;
        this.playersMap = lobby.getPlayersMap();
        this.playersQueue = lobby.getPlayersQueue();
        this.world = lobby.getWorld();
        list = new ArrayList<>();
        List<Player> temp = new ArrayList<>(playersMap.values());
        for (Player pl : temp) {
                list.add(new PlayerLogic(pl, this));
        }
    }

    public void startTheGame() {
        for (PlayerLogic pl: list) {
            pl.start();
        }
        run();
    }

    private synchronized boolean masterOverview() throws InterruptedException {
        boolean r = true;
        if(!(playersMap.size() == 1)) {
            while (playersQueue.isEmpty()) {
                playersQueue.addAll(playersMap.values());
                this.wait();
            }
            notifyAll();
        } else {
            r = false;
        }
        return r;
    }

    @Override
    public void run() {
        try {
            masterOverview();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void deletePlayer(int id) {
        Player pl = this.playersMap.remove(id);
        System.out.println(pl.getRace() + " is destroyed!");
    }


    public ConcurrentLinkedQueue getPlayersQueue() {
        return playersQueue;
    }

    public int[][] getWorld() {
        return world;
    }

    public List<PlayerLogic> getList() {
        return list;
    }

    public void setWorld(int[][] world) {
        this.world = world;
    }
}
