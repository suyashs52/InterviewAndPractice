package com.leetcode.dp;

import java.util.Arrays;

public class NoOfMusicPlaylist {

    public static void main(String[] args) {
        System.out.println(new NoOfMusicPlaylist().numMusicPlaylists(3, 3, 0));
        System.out.println(new NoOfMusicPlaylist().numMusicPlaylists(3, 3, 1));
        System.out.println(new NoOfMusicPlaylist().numMusicPlaylists(2, 3, 1));
        System.out.println(new NoOfMusicPlaylist().topdown(3, 3, 0));


    }

    public int numMusicPlaylists(int uniqueSong, int goal, int k) {

        long[][] dp = new long[goal + 1][uniqueSong + 1];
        int mod = (int) 1e9 + 7;

        dp[0][0] = 1; //no of playlist with 0 unique song, and 0 song need to listen=1
        //which is essentially an empty playlist.
        //if goals < unique songs, no of ways always 0, question said need all unique songs in playlist
        for (int i = 1; i < goal + 1; i++) {

            for (int j = 1; j < Math.min(i + 1, uniqueSong + 1); j++) {

                //j(unique songs) will always be less then goals
                //if unique songs > goals dp=0 because we can't form playlist having at least 1 unique songs
//If we add a song that we haven't played yet to the playlist, the playlist length increases by 1 (i-1->i)
// the number of unique songs also increases by 1 (j-1->j)
//Since there are n unique songs in total, the number of new songs we can add to the playlist is n-(j-1)
// the number of new playlists we can create by adding a new song is: dp[i-1][j-1]*(n-j+1)
//f we replay an old song, the playlist length increases by 1, no of unique songs remains the same
                //so dp[i-1][j]*(j-k) we can only replay old song before k
//we can't replay a song unless kkk other songs have been played, we can't choose from the last k played songs.
                dp[i][j] = (dp[i - 1][j - 1] * (uniqueSong - (j - 1))) % mod; // no of way(total playlist)=last no of playlist * remaining unique songs

                if (j > k) {
                    //no of new playlist we can create by replaying  old songs
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % mod;

                }
            }
        }

        return (int) dp[goal][uniqueSong];


    }


    public int topdown(int uniqueSong, int goal, int k) {
          dp=new Long[goal+1][uniqueSong+1];

        for (Long[] d:dp){
            Arrays.fill(d,-1l);
        }

        return (int) noofplaylist_topdown(goal,uniqueSong,uniqueSong,k);


    }

    private Long[][] dp;

   long noofplaylist_topdown(int goal,int song,int uniqueSong, int k){

        if(goal==0 && song==0) return  1l;

        if(goal ==0 || song==0) return  0l;

        if(dp[goal][song]!=-1l) return  dp[goal][song];
        int mod =(int) 1e9+7;
        dp[goal][song] = (noofplaylist_topdown(goal-1,song-1,uniqueSong,k)*(uniqueSong-(song-1)))%mod;

        if(song>k){
            dp[goal][song]=(dp[goal][song]+ (noofplaylist_topdown(goal-1,song,uniqueSong,k)*(song-k))%mod)%mod;
        }

        return dp[goal][song];

   }


    }
