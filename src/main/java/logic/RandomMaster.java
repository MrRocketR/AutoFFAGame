package logic;

import java.util.List;
import java.util.Map;




public class RandomMaster implements Runnable {
    private static Map<Integer, PlayerLogic> playerMap;
    private static List<Integer> plLocker;
    private static List<Integer> tempLocker;

    public RandomMaster(Map<Integer, PlayerLogic> players, List<Integer> locker) {
        playerMap = players;
        plLocker = locker;
        tempLocker = locker;
    }

    public static PlayerLogic getPlayer(int id) {
        return playerMap.get(id);
    }

    public static void deletePlayer(int id) {
        playerMap.remove(id);
    }

    public synchronized static List<Integer> getList() {
        return plLocker;
    }
    private synchronized static Map<Integer, PlayerLogic> getMap() {
        return playerMap;
    }

    public void startNewTurn() {
        if (plLocker.isEmpty()) {
            try {
                plLocker = tempLocker;
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notify();
    }



    @Override
    public void run() {
        while (!RandomMaster.getMap().isEmpty()) {
            startNewTurn();
        }
        System.out.println("Games is over!");
    }
}
