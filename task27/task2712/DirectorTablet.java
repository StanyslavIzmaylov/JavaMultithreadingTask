package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.awt.*;
import java.util.*;
import java.util.List;

public class DirectorTablet {

    public void printAdvertisementProfit() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Long> profitMap = statisticManager.getProfitMap();
        ArrayList<String> list = new ArrayList(profitMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            double amount = 1.0 * profitMap.get(key) / 100;
            System.out.println(key + " - " + String.format(Locale.ENGLISH, "%.2f", amount));
        }
    }

    public void printCookWorkloading() {
        StatisticManager statisticManager = StatisticManager.getInstance();
        Map<String, Map<String, Integer>> cookWorkloadingMap = statisticManager.getCookWorkloadingMap();
        ArrayList<String> list = new ArrayList(cookWorkloadingMap.keySet());
        Collections.sort(list);

        for (String key : list) {
            Map<String, Integer> cookMap = cookWorkloadingMap.get(key);
            System.out.println(key);

            ArrayList<String> cookNames = new ArrayList(cookMap.keySet());
            Collections.sort(cookNames);
            for (String cookName : cookNames) {
                System.out.println(cookName + " - " + ((cookMap.get(cookName) + 59) / 60) + " min");
            }

            System.out.println();
        }
    }
    public void printActiveVideoSet(){
        StatisticAdvertisementManager advertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement>advertisementList = new ArrayList<>();
        for (Advertisement advertisement: advertisementManager.getActiveVideo()){
           advertisementList.add(advertisement);
        }
        Collections.sort(advertisementList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
      for (Advertisement advertisement:advertisementList){
          System.out.println(advertisement.getName() + " - " + advertisement.getHits());
      }
    }
    public void printArchivedVideoSet(){
        StatisticAdvertisementManager advertisementManager = StatisticAdvertisementManager.getInstance();
        List<Advertisement>advertisementList = new ArrayList<>();
        for (Advertisement advertisement: advertisementManager.getArchiveVideo()){
            advertisementList.add(advertisement);
        }
        Collections.sort(advertisementList, new Comparator<Advertisement>() {
            @Override
            public int compare(Advertisement o1, Advertisement o2) {
                return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
            }
        });
        for (Advertisement advertisement:advertisementList){
            System.out.println(advertisement.getName());
        }
    }
}
