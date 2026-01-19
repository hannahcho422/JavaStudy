public class TV {
    // fields
     public int channel;        // 1 ~ 120
     public int volumeLevel;    // 1 ~ 7
     public boolean on;         // on/off

     // constructor
     public TV() {
        channel = 1;
        volumeLevel = 1;
        on = false;
     }

     // methods
     public void turnOn() {
        on = true;
     }

     public void turnOff() {
        on = false;
     }

     public void setChannel(int newChannel) {
        if (on && newChannel >= 1 && newChannel <= 120) {
            channel = newChannel;
        }
     }

     public void setVolume(int newVolumeLevel) {
        if(on && newVolumeLevel >= 1 && newVolumeLevel <= 7) {
            volumeLevel = newVolumeLevel;
        }
     }

     public void channelUp() {
        if(on && channel < 120) {
            channel++;
        }
     }

     public void channelDown() {
        if(on && channel > 1) {
            channel--;
        }
     }

     public void volumeUp() {
        if (on && volumeLevel < 7) {
            volumeLevel++;
        }
     }

     public void volumeDown() {
        if(on && volumeLevel > 1) {
            volumeLevel--;
        }
     }
}