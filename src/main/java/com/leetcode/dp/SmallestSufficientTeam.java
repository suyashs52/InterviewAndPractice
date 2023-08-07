package com.leetcode.dp;

import java.util.*;

public class SmallestSufficientTeam {
    List<Integer> mainTeam;

    //https://leetcode.com/problems/smallest-sufficient-team/description/
    public static void main(String[] args) {
        List<List<String>> people = new ArrayList<>();
        people.add(new ArrayList<>() {{
            add("java");
        }});
        people.add(new ArrayList<>() {{
            add("nodejs");
        }});
        people.add(new ArrayList<>() {{
            add("nodejs");
            add("reactjs");
        }});

        System.out.println(Arrays.toString(new SmallestSufficientTeam().smallestSufficientTeam(
                new String[]{"java", "nodejs", "reactjs"}
                , people)));
        System.out.println(Arrays.toString(new SmallestSufficientTeam().bottomup(
                new String[]{"java", "nodejs", "reactjs"}
                , people)));


    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int req = (int) Math.pow(2, req_skills.length) - 1; //111 , 2^3=8-1=7
        //1<<req_skills.length-1
        Map<String, Integer> map = new HashMap<>();

        //map string to integer
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }

        int[] skills = new int[people.size()];
        int i = 0;
        for (List<String> skill : people) {
            int value = 0;
            for (String s : skill) {
                int j = map.get(s);
                value = value | 1 << j; //for j=0 (java) set value to 001
            }
            skills[i++] = value;
        }
        //after this skills will have 001, 010, 110

        List<Integer> current = new ArrayList<>();
        mainTeam = new ArrayList<>();
//        for (int j = 0; j < skills.length; j++) { //add all people
//            answer.add(j);
//        }

        findTeam(req, 0, skills, current, 0);


        //convert answer to array
        int[] ans = new int[mainTeam.size()];
        i = 0;
        for (int a : mainTeam) {
            ans[i++] = a;
        }
        return ans;


    }

    void findTeam_limitExceed(int required, int currentSkill, int[] skills, List<Integer> localTeam, int person) {

        if (currentSkill == required && localTeam.size() < mainTeam.size()) { //check the minimum size possible if yes then
            mainTeam = new ArrayList<>(localTeam);
            return;
        }
        if (person > skills.length - 1) return;

        //take current skill
        localTeam.add(person);
        findTeam_limitExceed(required, currentSkill | skills[person], skills, localTeam, person + 1);

        //not take current skill so remove the added skill people
        localTeam.remove(localTeam.size() - 1);
        findTeam_limitExceed(required, currentSkill, skills, localTeam, person + 1);

    }


    void findTeam(int required, int teamSkill, int[] skills, List<Integer> localTeam, int person) {
        if (mainTeam.size() > 0 && localTeam.size() >= mainTeam.size() - 1) return;
        if (person == skills.length) return;

        // if(currentSkill==required && current.size()<answer.size()){ //check t
        // the minimum size possible if yes then
        //     answer=new ArrayList<>(current);
        //     return;
        // }

        //take current skill
        localTeam.add(person);
        if ((teamSkill | skills[person]) == required) {
            //check the minimum size possible if yes then
            mainTeam = new ArrayList<>(localTeam);
            localTeam.remove(localTeam.size() - 1); //backtrack before returning

            return;
        } else if ((teamSkill | skills[person]) > teamSkill) { //if adding skill moved our answer to closer to answer,not same answer
            findTeam(required, teamSkill | skills[person], skills, localTeam, person + 1);
        }
        //not take current skill so remove the added skill people
        localTeam.remove(localTeam.size() - 1);
        findTeam(required, teamSkill, skills, localTeam, person + 1);

    }


    public int[] bottomup(String[] req_skills, List<List<String>> people) {
        //we need to achieve 111, so for smaller problem
        //lets achieve 001, 011, and other skill
        //with the help of this skill
        int req = (int) (1 << req_skills.length) - 1; //111 , 2^3=8-1=7
        //1<<req_skills.length-1
        Map<String, Integer> map = new HashMap<>();

        //map string to integer
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }

        int[] skills = new int[people.size()];
        int i = 0;
        for (List<String> skill : people) {
            int value = 0;
            for (String s : skill) {
                int j = map.get(s);
                value = value | 1 << j; //for j=0 (java) set value to 001
            }
            skills[i++] = value;
        }
        //after this skills will have 001, 010, 110
        int m = 1 << req_skills.length;
        long[] dp = new long[m];  //check for each skill set
        //dp[m] contain minimum no of people having m skill set
        //at last answer will be in dp[int(111)]
        Arrays.fill(dp, (1 << skills.length) - 1); //all people required for each skill set , this will be max people ll
        dp[0] = 0; //for 0 skill min requirement is 0 people
        for (int skill = 1; skill < m; skill++) {

            for (int ppl = 0; ppl < skills.length; ppl++) {
                //need to achive skill, i have skill[ppl] ,  ~skill[ppl] is skill that
                //that people does not posses , common other skill is:  ~skill[ppl] & skill
                //this will contribute to overall skill
                int otherskill = ~skills[ppl] & skill; //check if other skill except the current skill people holding
                //skill, skill people 001, 011 => 001&100, other skill =000
                //add the ith person to the team and cover the remaining skills with the smallest possible set of people,
                // which is defined as dp[smallerSkillsMask] This update only makes sense if smallerSkillsMask≠skillsMask
                //because otherwise, the ith person would not contribute any new skills to the team.
                //same skill(otherskill) if already added before so no need to add this person
                if (otherskill != skill) { //if other skill except current skill both are not same
                    //otherskill | skill[ppl]  & skill =skill
                    System.out.println("otherskill (" + otherskill + ") | skill[ppl](" + skills[ppl] + ")" +
                            " & skill(" + skill + ")==" + ((otherskill | skills[ppl]) & skill));
                    long totalskillPeople = dp[otherskill] | 1 << ppl; //include people to combine skill
                    if (Long.bitCount(totalskillPeople) < Long.bitCount(dp[skill])) {
                        dp[skill] = totalskillPeople;
                    }

                }
            }
        }


        long ouranswer = dp[(1 << skills.length) - 1];
        int ans[] = new int[Long.bitCount(ouranswer)]; //initialize with lenght of skill having 1
        i = 0;
        for (int j = 0; j < people.size(); j++) { //
            if (((ouranswer >> j) & 1) == 1) ans[i++] = j; //if it is 1 people add to answer
        }

        return ans;

    }


}
