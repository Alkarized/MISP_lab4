package se.mspi.lab4.mbeans;


import se.mspi.lab4.objects.Shot;

/*
MBean, считающий общее число установленных пользователем точек, а также число точек, не попадающих в область.
В случае, если пользователь совершил 3 "промаха" подряд, разработанный MBean
должен отправлять оповещение об этом событии.
 */
public interface ShotCounterMBean {
    void addShot(boolean isSuccessful);

    long getCountOfAllShots();

    long getCountOfMissedShots();
}