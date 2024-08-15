package array;

import java.util.Scanner;
public class ACM {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] matrix = new int[n][m];
            int sum=0;

            int result = 0;
            for (int i = 0; i < n; i++) {
                for(int j=0;j<m;j++){
                    matrix[i][j]=scanner.nextInt();
                    sum+=matrix[i][j];

                }

            }
            result=partition(matrix,sum,n,m);

            System.out.println(result);
            scanner.close();
        }
    public static int partition(int[][] matrix, int sum, int n, int m){
        int target=0;
        int distance;
        int minDis=Integer.MAX_VALUE;
        int pretarget=0;
        for (int i = 0; i < n; i++) {
            for(int j=0;j<m;j++){
                target+=matrix[i][j];
            }
            if(target*2>sum){
                distance = Math.min(target*2-sum,sum - pretarget*2);
                minDis= distance;
                break;

            }
            pretarget=target;

        }
        pretarget = 0;
        target=0;
        for (int j=0;j<m;j++) {
            for(int i = 0; i < n; i++){
                target+=matrix[i][j];
            }
            if(target*2>sum){
                distance = Math.min(target*2-sum,sum - pretarget*2);
                minDis=Math.min(minDis,distance);
                break;

            }
            pretarget=target;

        }
        return minDis;
    }


}
