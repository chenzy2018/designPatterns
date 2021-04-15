package com.designPatterns.a15Adapter;

/**
 * 适配器
 *
 * 有两个播放设备，其中一个支持MP3、MP4，另个支持其他模式，在不改变原有接口的前提下适配
 */
public class AdapterMain {
    public static void main(String[] args) {
        AudiaPlayer audiaPlayer = new AudiaPlayer();

        audiaPlayer.play("mp3", "stay with me");
        audiaPlayer.play("mp4", "alone");
        audiaPlayer.play("avi", "running");
    }
}

//播放器
interface MediaPlayer{
    void play(String audioType, String fileName);
}

//高级播放器，支持MP3、MP4
interface AdvancedMediaPlayer{
    void playMP3(String fileName);
    void playMP4(String fileName);
}

class Mp3player implements AdvancedMediaPlayer{

    @Override
    public void playMP3(String fileName) {
        System.out.println("MP3 is running " + fileName);
    }

    @Override
    public void playMP4(String fileName) {
        return;
    }
}

class Mp4player implements AdvancedMediaPlayer{

    @Override
    public void playMP3(String fileName) {
        return;
    }

    @Override
    public void playMP4(String fileName) {
        System.out.println("MP4 is running "+ fileName);
    }
}

//播放器适配器
class MediaPlayerAdapter implements MediaPlayer{
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaPlayerAdapter(String audioType){
        if("mp3".equals(audioType)){
            advancedMediaPlayer = new Mp3player();
        }else if("mp4".equals(audioType)){
            advancedMediaPlayer = new Mp4player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if("mp3".equals(audioType)){
            advancedMediaPlayer.playMP3(fileName);
        }else if("mp4".equals(audioType)){
            advancedMediaPlayer.playMP4(fileName);
        }
    }
}

//播放器实现类
class AudiaPlayer implements MediaPlayer{
    MediaPlayerAdapter mediaPlayerAdapter;

    @Override
    public void play(String audioType, String fileName) {
        if("mp3".equals(audioType) || "mp4".equals(audioType)){
            mediaPlayerAdapter = new MediaPlayerAdapter(audioType);
            mediaPlayerAdapter.play(audioType, fileName);
        }else{
            System.out.println(audioType+" is running "+fileName);
        }
    }
}