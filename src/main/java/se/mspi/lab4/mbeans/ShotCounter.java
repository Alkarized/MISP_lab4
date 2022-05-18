package se.mspi.lab4.mbeans;

import se.mspi.lab4.objects.Shot;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class ShotCounter extends NotificationBroadcasterSupport implements ShotCounterMBean {
    private long countOfAllShots = 0;
    private long countOfMissedShots = 0;
    private long missesInRow = 0;

    @Override
    public void addShot(boolean isSuccessful) {
        countOfAllShots++;
        if (!isSuccessful) {
            countOfMissedShots++;
            missesInRow++;
            if (missesInRow >= 3) {
                Notification notification = new Notification(
                        "threeMissedShotsInRow", this, missesInRow,
                        System.currentTimeMillis(), "3 missed shots in row"
                );
                this.sendNotification(notification);
            }
        } else {
            missesInRow = 0;
        }
    }

    @Override
    public long getCountOfAllShots() {
        return countOfAllShots;
    }

    @Override
    public long getCountOfMissedShots() {
        return countOfMissedShots;
    }
}
