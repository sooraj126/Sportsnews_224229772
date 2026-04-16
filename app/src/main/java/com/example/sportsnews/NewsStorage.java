package com.example.sportsnews;

import java.util.ArrayList;
import java.util.List;

public class NewsStorage {

    public static List<Newsitem> newsList = new ArrayList<>();
    public static List<Newsitem> bookmarkedList = new ArrayList<>();
    public static void initData() {
        if (!newsList.isEmpty()) {
            return;
        }

        newsList.add(new Newsitem(
                "Football Match Highlights",
                "Team A defeated Team B in a thrilling 90-minute clash, with striker Carlos Mendez scoring a stunning hat-trick in the final 20 minutes to seal the victory.",
                "Football",
                R.drawable.football1
        ));

        newsList.add(new Newsitem(
                "Cricket World Cup Update",
                "India secured a dominant victory over Australia by 5 wickets, with Virat Kohli scoring an unbeaten 98 runs to guide the team into the semi-finals.",
                "Cricket",
                R.drawable.cricket1
        ));

        newsList.add(new Newsitem(
                "Football Champions League",
                "Real Madrid knocked out Manchester City in a dramatic penalty shootout, with goalkeeper Thibaut Courtois saving three penalties to send the Spanish giants through.",
                "Football",
                R.drawable.football2
        ));

        newsList.add(new Newsitem(
                "Cricket Test Match Day 3",
                "England bowled out Zimbave for just 145 runs on a tricky Day 3 pitch, with James Anderson taking a remarkable 6 wickets for only 32 runs in 18 overs.",
                "Cricket",
                R.drawable.crciket2
        ));

        newsList.add(new Newsitem(
                "Basketball NBA Playoffs",
                "The Golden State Warriors eliminated the Denver Nuggets in six games, with Stephen Curry averaging 38 points per game throughout the entire series.",
                "Basketball",
                R.drawable.basketball1
        ));

        newsList.add(new Newsitem(
                "Football Premier League Update",
                "Arsenal reclaimed the top spot in the Premier League table after a convincing 3-0 win over Chelsea, with Bukayo Saka scoring twice and assisting the third goal.",
                "Football",
                R.drawable.football3
        ));

        newsList.add(new Newsitem(
                "Cricket IPL Final Recap",
                "Mumbai Indians defeated Chennai Super Kings by 6 runs in a breathtaking IPL final, with the last ball of the match deciding the title in front of 90,000 fans.",
                "Cricket",
                R.drawable.cricket3
        ));

        newsList.add(new Newsitem(
                "Basketball EuroLeague Final",
                "Real Madrid claimed the EuroLeague trophy for the 11th time, defeating Olympiacos by 87-76 in a dominant display of fast-break basketball and sharp three-point shooting.",
                "Basketball",
                R.drawable.basketball2
        ));

        newsList.add(new Newsitem(
                "Football World Cup Qualifier",
                "Brazil secured their place in the World Cup after a convincing 4-1 win over Argentina, with Neymar delivering a man-of-the-match performance with two goals and two assists.",
                "Football",
                R.drawable.football4
        ));

        newsList.add(new Newsitem(
                "Basketball NBA All-Star Game",
                "The Western Conference beat the Eastern Conference 211-186 in the highest scoring NBA All-Star Game in history, with Luka Doncic winning MVP after dropping 52 points.",
                "Basketball",
                R.drawable.basketball3
        ));

        newsList.add(new Newsitem(
                "Cricket One Day International",
                "South Africa chased down a record 387 runs against New Zealand with 2 balls to spare, in what commentators are calling the greatest ODI run chase in cricket history.",
                "Cricket",
                R.drawable.cricket4
        ));

        newsList.add(new Newsitem(
                "Football Transfer Window News",
                "Kylian Mbappe completed his blockbuster move to Real Madrid on a five-year deal, ending months of speculation and becoming the highest paid player in the club's history.",
                "Football",
                R.drawable.football5
        ));
    }
}