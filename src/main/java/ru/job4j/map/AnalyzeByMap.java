package ru.job4j.map;

import java.util.*;
import java.util.LinkedHashMap;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        int mid = 0;
        double all = 0D;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                all += subject.score();
                mid++;
            }
        }
        return all / mid;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> names = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int mid = 0;
            double all = 0D;
            for (Subject subject : pupil.subjects()) {
                all += subject.score();
                mid++;
            }
            all = all / mid;
            names.add(new Label(pupil.name(), all));
        }
        return names;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> names = new ArrayList<>();
        int mid = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (map.containsKey(subject.name())) {
                    map.put(subject.name(), subject.score() + map.get(subject.name()));
                } else {
                    map.put(subject.name(), subject.score());
                }
            }
            mid++;
        }
        for (Map.Entry<String, Integer> maps : map.entrySet()) {
            names.add(new Label(maps.getKey(), maps.getValue() / mid));
        }
        return names;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> names = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double all = 0D;
            for (Subject subject : pupil.subjects()) {
                all += subject.score();
            }
            names.add(new Label(pupil.name(), all));
        }
        names.sort(Comparator.naturalOrder());
        return names.get(names.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<Label> names = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (map.containsKey(subject.name())) {
                    map.put(subject.name(), subject.score() + map.get(subject.name()));
                } else {
                    map.put(subject.name(), subject.score());
                }
            }
        }
        for (Map.Entry<String, Integer> maps : map.entrySet()) {
            names.add(new Label(maps.getKey(), maps.getValue()));
        }
        names.sort(Comparator.naturalOrder());
        return names.get(names.size() - 1);
    }
}