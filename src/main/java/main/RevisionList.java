package main;

import pojo.Topic;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;

public class RevisionList {

    private final List<Topic> listOfTopics ;

    public RevisionList(List<Topic> listOfTopics) {
        this.listOfTopics = listOfTopics;
    }

    public List<Topic> getListOfTopics() {
        return listOfTopics;
    }



    public List<Topic> getRevisionList() {
        List<Topic> revisionList = new ArrayList<>();
        List<Topic> topicsOlderThanOneMonth = listOfTopics.stream().filter(isMoreThanOneMonthOlder).toList();
        List<Topic> topicsLessThanOneMonthOld = listOfTopics.stream().filter(isNotOlderThanOneMonth).toList();

        if(!topicsOlderThanOneMonth.isEmpty()){
            revisionList.addAll(pickRandomTopicsForRevision(topicsOlderThanOneMonth));
        }
        revisionList.addAll(topicsLessThanOneMonthOld.stream().filter(isEligibleForRevisionToday).toList());
        return revisionList;
    }

    private Collection<Topic> pickRandomTopicsForRevision(List<Topic> topicsOlderThanOneMonth) {
        Random rand = new Random();
        if(topicsOlderThanOneMonth.size() <= 10){
            return topicsOlderThanOneMonth;
        }else{
            List<Topic> selected = new ArrayList<>();
            int count = (topicsOlderThanOneMonth.size() / 10 ) + 1;
            for(int i = 0; i < count; i++){
                selected.add(topicsOlderThanOneMonth.get(rand.nextInt(topicsOlderThanOneMonth.size())));
            }
            return selected;
        }
    }

    Predicate<Topic> isMoreThanOneMonthOlder = topic -> {
        Calendar oneMonth = Calendar.getInstance();
        oneMonth.add(Calendar.MONTH, -1);
        return topic.studiedOn().before(oneMonth.getTime());
    };

    Predicate<Topic> isEligibleForRevisionToday = topic -> {
        Date studiedOn = topic.studiedOn();
        Date today = new Date();
        long diffInDays = TimeUnit.MILLISECONDS.toDays(today.getTime() - studiedOn.getTime());
        return diffInDays == 2 || diffInDays == 7 || diffInDays == 15 || diffInDays == 30;
    };

    Predicate<Topic> isNotOlderThanOneMonth = topic -> {
        Calendar oneMonth = Calendar.getInstance();
        oneMonth.add(Calendar.MONTH, -1);
        return !topic.studiedOn().before(oneMonth.getTime());
    };




}
