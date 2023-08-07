package p.lc.bt;

public class TransferRequest {

    //https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/

    int ans = 0;

    public static void main(String[] args) {
        //either we take the request or ignore it so each request has 2 possibility
        //m request ll have 2*2*2..m =2^m possibility
        //request [0,1] means one out so --, one in so ++,
        //if total must be 0 for taking index valid answer
        System.out.println(new TransferRequest().maximumRequests(3, new int[][]{{0,0},{1,2},{2,1}}));


    }


    public int maximumRequests(int n, int[][] requests) {
        int[] house = new int[n];
          ans = 0;

        knap(house, requests, 0, 0);

        return ans;
    }

    private void knap(int[] house, int[][] requests, int index, int noOfWays) {
        if (index == requests.length) {
            for (int h : house) {
                if (h > 0) return;
            }
            ans = Math.max(noOfWays, ans);
            return;
        }

        house[requests[index][0]]--;
        house[requests[index][1]]++;
        //include above in noOfWays
        knap(house, requests, index + 1, noOfWays + 1);
        //not include in noOfways so reverse it
        house[requests[index][0]]++;
        house[requests[index][1]]--;
        knap(house, requests, index + 1, noOfWays);
        //we can't do knapsack becuase we need house all =0

    }
}

