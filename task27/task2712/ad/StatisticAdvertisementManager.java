package com.javarush.task.task27.task2712.ad;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StatisticAdvertisementManager {
    private static StatisticAdvertisementManager INSTANCE = new StatisticAdvertisementManager();
    private AdvertisementStorage storage = AdvertisementStorage.getInstance();
    private StatisticAdvertisementManager() {
    }
    public static StatisticAdvertisementManager getInstance(){
        return INSTANCE;
    }
    public List<Advertisement> getActiveVideo(){
        List<Advertisement> advertisementList = new ArrayList<>();
        for (Advertisement advertisement: storage.getVideos()){
            if (advertisement.isActive()){
                advertisementList.add(advertisement);
            }
        }
        return advertisementList;
    }
    public List<Advertisement> getArchiveVideo(){
        List<Advertisement> advertisementList = new ArrayList<>();
        for (Advertisement advertisement: storage.getVideos()){
            if (!advertisement.isActive()){
                advertisementList.add(advertisement);
            }
        }
        return advertisementList;
    }
}
