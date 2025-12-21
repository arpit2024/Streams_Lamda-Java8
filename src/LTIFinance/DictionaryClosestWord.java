package LTIFinance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DictionaryClosestWord {

        public static void main(String[] args){
                Scanner sc=new Scanner(System.in);
                int N=5;
                String[] words={"cart", "care", "cards", "scar", "car"};
                String word="cars";

                String ans=Solve(N,words,word);

                System.out.println("Matching word from dictionary is: "+ans);

        }
        public static String Solve(int N,String words[], String word){
                List<Dictionary> list=new ArrayList<>();
                int minVal=0;
                for(int i=0;i<N;i++){

                        int val=editDistance(words[i],word);
                        Dictionary pair=new Dictionary(words[i],val);
                        list.add(pair);
                }
                List<Dictionary> ans=list.stream()
                        .sorted(Comparator.comparing(Dictionary::getEditDist).thenComparing(x-> x.getWord().length()))
                        .collect(Collectors.toList());

                return ans.get(0).word;
        }
        public static  int editDistance(String str, String target){
                int n=str.length();
                int m=target.length();
                int[][] dp=new int[n+1][m+1];

                for(int i=1;i<=n;i++)
                        dp[i][0]=i;
                for(int j=1;j<=m;j++)
                        dp[0][j]=j;
                for(int i=1;i<=n;i++){
                       for(int j=1;j<=m;j++){
                               if(str.charAt(i-1)==target.charAt(j-1)){
                                       dp[i][j]= dp[i-1][j-1];
                               }
                               else{
                                       dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                               }
                       }
                }
                return dp[n][m];
        }
}
class  Dictionary{
        String word;
        int editDist;
        Dictionary(String word,int editDist){
                this.word=word;
                this.editDist=editDist;
        }

        public String getWord() {
                return word;
        }

        public void setWord(String word) {
                this.word = word;
        }

        public int getEditDist() {
                return editDist;
        }

        public void setEditDist(int editDist) {
                this.editDist = editDist;
        }
}