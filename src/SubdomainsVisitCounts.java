import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:

counts = [ "900,google.com",
     "60,mail.yahoo.com",
     "10,mobile.sports.yahoo.com",
     "40,sports.yahoo.com",
     "300,yahoo.com",
     "10,stackoverflow.com",
     "20,overflow.com",
     "2,en.wikipedia.org",
     "1,m.wikipedia.org",
     "1,mobile.sports",
     "1,google.co.uk"]

Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

Sample output (in any order/format):

calculateClicksByDomain(counts)
1340    com
 900    google.com
  10    stackoverflow.com
  20    overflow.com
 410    yahoo.com
  60    mail.yahoo.com
  10    mobile.sports.yahoo.com
  50    sports.yahoo.com
   3    org
   3    wikipedia.org
   2    en.wikipedia.org
   1    m.wikipedia.org
   1    mobile.sports
   1    sports
   1    uk
   1    co.uk
   1    google.co.uk

 */

class SubdomainsVisitCounts {
    public static void main(String[] args) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        HashMap<String, Integer> map = countDomains(counts);

        Iterator iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)iterator.next();
            System.out.println(mapElement.getKey() + ":" + mapElement.getValue());
        }

    }
    public static HashMap<String, Integer> countDomains(String[] counts) {
        if (counts == null || counts.length == 0) {
            return null;
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < counts.length; i++) {
            String[] count = counts[i].split(",");
            String[] arr = count[1].split("\\.");
            int length = arr.length;
            String key = "";
            for (int j = length - 1; j >=  0; j--) {
                if (key == "") {
                    key = arr[j];
                } else {
                    key = arr[j] + "." + key;
                }

                if (map.containsKey(key)) {
                    int domainCounts = (int)map.get(key) + Integer.parseInt(count[0]);
                    map.put(key, domainCounts);
                } else {
                    map.put(key, Integer.parseInt(count[0]));
                }

            }

        }

        return map;

    }
}
