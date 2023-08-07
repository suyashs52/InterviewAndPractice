package p.lc.bt;

public class DistributeCookies {

    public static void main(String[] args) {
        //https://leetcode.com/problems/fair-distribution-of-cookies/description/
        //cookies array n, student k, each cookie should assign among student(k)
        //1 cookies can assign to any ith student from k student 1 cookies has option k
        //jth too have same option, k*k*k..n =k^n
        //unfairness max cookies obtain by single student , find min unfairness
    }

    int[] student;
    int count=0;
    int res;
    public int distributeCookies(int[] cookies, int k) {
        student=new int[k];
        count=0;
        res=Integer.MAX_VALUE;

        backtrack(cookies,k,0);
        return res;
    }

    private void backtrack(int[] cookies, int k,int ith) {

        if(ith==cookies.length){ //all cookies assign to student
            //find unfairness
            int unfairness=-1;
            for(int s:student){
                unfairness=Math.max(unfairness,s);
            }
            res= Math.min(unfairness,res);
            return;

        }

        for(int i=0;i<k;i++){ //each cookies can assign to any student
            student[i]+=cookies[ith]; //cookie assign
            backtrack(cookies,k,ith+1);
            student[i]-=cookies[ith]; //cookie not assign , assign to next student
        }
    }
}
