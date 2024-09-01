import main.RevisionList
import pojo.Topic
import spock.lang.Specification

class RevisionListSpec extends Specification{

    def 'RevisionList must return only applicable topics'() {
        given:
        List<Topic> topics = getListOfTopics()
        RevisionList revisionList = new RevisionList(topics)
        List<Topic> revisionListTopics = revisionList.getRevisionList()
        expect:
        revisionListTopics.size() == 5
    }



     List<Topic> getListOfTopics(){
         Calendar tenDays = Calendar.getInstance()
         tenDays.add(Calendar.DATE, -10)

         Calendar twoDays = Calendar.getInstance()
         twoDays.add(Calendar.DATE, -2)

         Calendar sevenDays = Calendar.getInstance()
         sevenDays.add(Calendar.DATE, -7)

         Calendar fifteenDays = Calendar.getInstance()
         fifteenDays.add(Calendar.DATE, -15)

         Calendar twoMonths = Calendar.getInstance()
         twoMonths.add(Calendar.MONTH, -2)

         Calendar oneMonth = Calendar.getInstance()
         oneMonth.add(Calendar.MONTH, -1)

         Calendar sevenMonths = Calendar.getInstance()
         sevenMonths.add(Calendar.MONTH, -7)

         Calendar sixMonths = Calendar.getInstance()
         sixMonths.add(Calendar.MONTH, -6)
         List<Topic> topics = new ArrayList<>()
         topics.add(new Topic("tenDays", tenDays.getTime(), "tenDays" ));
         topics.add(new Topic("twoDays", twoDays.getTime(), "twoDays" ));
         topics.add(new Topic("sevenDays", sevenDays.getTime(), "sevenDays" ));
         topics.add(new Topic("fifteenDays", fifteenDays.getTime(), "fifteenDays"));
         topics.add(new Topic("oneMonth", oneMonth.getTime(), "oneMonth" ));
         topics.add(new Topic("twoMonths", twoMonths.getTime(), "twoMonths" ));
         topics.add(new Topic("twoMonths", twoMonths.getTime(), "twoMonths" ));
         topics.add(new Topic("twoMonths1", twoMonths.getTime(), "twoMonths" ));
         topics.add(new Topic("twoMonths2", twoMonths.getTime(), "twoMonths" ));
         topics.add(new Topic("twoMonths3", twoMonths.getTime(), "twoMonths" ));
         topics.add(new Topic("twoMonths4", twoMonths.getTime(), "twoMonths" ));
         topics.add(new Topic("twoMonths5", twoMonths.getTime(), "twoMonths" ));
         topics.add(new Topic("twoMonths6", twoMonths.getTime(), "twoMonths" ));
         topics.add(new Topic("twoMonths7", twoMonths.getTime(), "twoMonths" ));
         topics.add(new Topic("sevenMonths", sevenMonths.getTime(), "sevenMonths" ));
         topics.add(new Topic("sixMonths", sixMonths.getTime(), "sixMonths" ));
         topics
    }

}
