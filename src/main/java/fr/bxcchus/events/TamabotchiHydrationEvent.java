package fr.bxcchus.events;

import fr.bxcchus.entities.Tamabotchi;
import fr.bxcchus.managers.PlayerManager;
import fr.bxcchus.managers.TamabotchiManager;

import java.sql.SQLException;
import java.util.TimerTask;

public class TamabotchiHydrationEvent  extends TimerTask {
    @Override
    public void run() {
        try {
            for (Tamabotchi tamabotchi : TamabotchiManager.getInstance().getTamabotchis()) {
                TamabotchiManager.getInstance().updateTamabotchiHydration(tamabotchi.getId(), tamabotchi.getName(), tamabotchi.getLvl(), tamabotchi.getHp(), tamabotchi.getHappiness(), tamabotchi.getHydration(), tamabotchi.getHunger(), tamabotchi.getRace().getId(), tamabotchi.getRace().getName(), tamabotchi.getPlayer().getUid(), tamabotchi.getPlayer().getUsername(), tamabotchi.getDeath().getId(), tamabotchi.getDeath().getCause(), tamabotchi.getPoopness());
                if (tamabotchi.getHydration() <= -100) {
                    System.out.println(tamabotchi.getName() + " is dead because he wasn't hydrate. The owner was: " + tamabotchi.getPlayer().getUsername());

                    TamabotchiManager.getInstance().deleteTamabotchi(tamabotchi.getId(), tamabotchi.getName(), tamabotchi.getLvl(), tamabotchi.getHp(), tamabotchi.getHappiness(), tamabotchi.getHydration(), tamabotchi.getHunger(), tamabotchi.getRace().getId(), tamabotchi.getRace().getName(), tamabotchi.getPlayer().getUid(), tamabotchi.getPlayer().getUsername(), tamabotchi.getDeath().getId(), tamabotchi.getDeath().getCause(), tamabotchi.getPoopness());
                    PlayerManager.getInstance().removePlayer(tamabotchi.getPlayer().getUid(), tamabotchi.getPlayer().getUsername());
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
