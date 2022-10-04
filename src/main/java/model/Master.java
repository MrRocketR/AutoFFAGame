package model;

import report.Report;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Master implements Runnable {
    private static Map<Integer, Player> playerMap;
    private static List<Integer> plLocker;
    private static List<Integer> TempLocker;

    public Master(Map<Integer, Player> players, List<Integer> locker) {
        playerMap = players;
        plLocker = locker;
        TempLocker = locker;
    }

    public static Player getPlayer(int id) {
        return playerMap.get(id);
    }

    public static void deletePlayer(int id) {
        playerMap.remove(id);
    }

    public synchronized static List<Integer> getList() {
        return plLocker;
    }
    private synchronized static Map <Integer, Player> getMap (){
        return playerMap;
    }

    public void startNewTurn() {
        if(plLocker.isEmpty()) {
            try {
                plLocker = TempLocker;
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
    }



    @Override
    public void run() {
        while (!Master.getMap().isEmpty()) {
            startNewTurn();
        }
        System.out.println("Games is over!");
    }
}
