package com.golovanova.utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

public class CollectionInfo {
    private final LocalDateTime initTime;
    private LocalDateTime saveTime;

    public CollectionInfo(LocalDateTime initTime) {
        this.initTime = initTime;
        this.saveTime = LocalDateTime.now();
    }

    public LocalDateTime getInitTime() {
        return initTime;
    }

    public LocalDateTime getSaveTime() {
        return saveTime;
    }

    public void updateSaveTime(LocalDateTime saveTime) {
        this.saveTime = saveTime;
    }

    public String summary() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatInitTime = initTime.format(formatter);
        String formatSaveTime = saveTime.format(formatter);
        String summary =
                "Init time: " + formatInitTime
                        + "Last save time: " + formatSaveTime;
        return summary;
    }
}
