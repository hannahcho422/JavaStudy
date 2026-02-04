public class TestTV {
    public static void main(String[] args) {
        // tv1
        TV tv1 = new TV();
        tv1.turnOn();
        tv1.setChannel(27);
        tv1.setVolume(5);

        // tv2
        TV tv2 = new TV();
        tv2.turnOn();
        tv2.setChannel(27);
        tv2.setVolume(5);

        tv1.channelUp();
        tv1.channelUp();
        tv1.channelUp();

        tv1.volumeDown();
        tv1.volumeDown();

        for (int i = 0; i < 24; i++) {
            tv2.channelDown();
        }

        tv2.volumeDown();
        tv2.volumeDown();
        tv2.volumeDown();

        System.out.println("tv1's channel is " + tv1.channel + " and volume level is " + tv1.volumeLevel);
        System.out.println("tv2's channel is " + tv2.channel + " and volume level is " + tv2.volumeLevel);
    }
}