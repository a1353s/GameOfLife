package tx.gameOfLife.model;

import java.util.Arrays;

/**
 * Created by mjh on 2017/6/3.
 */
public class CellMatrix {
    /**
     * 矩阵高度
     */
    private int height;

    /**
     * 矩阵宽度
     */
    private int width;

    /**
     * 动画速度，每两个状态之间的毫秒数
     */
    private int duration;

    /**
     * 总的变化次数
     */
    private int transfromNum=0;

    /**
     * 矩阵状态，1表示活，0表示死
     */
    private int[][] matrix;

    public CellMatrix(int height, int width, int duration, int transfromNum, int[][] matrix) {
        this.height = height;
        this.width = width;
        this.duration = duration;
        this.transfromNum = transfromNum;
        this.matrix = matrix;
    }

    /**
     * 上一个状态到下一个状态的转移
     * 根据规则可以总结得出两条规则:
     * 1. 对于周围活着的细胞为3的情况,下一个状态该细胞总是为活
     * 2. 对于周围活着的细胞为2的情况,下一个状态与上一状态相同
     */
    public void transform(){
        int[][] nextMatrix=new int[height][width];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                nextMatrix[y][x]=0;
                int nearNum= findLifedNum(y,x);
                //等于3，则下一状态总是活
                if(nearNum==3){
                    nextMatrix[y][x]=1;
                }
                //等于2，则与上一状态一样
                else if(nearNum==2){
                    nextMatrix[y][x]=matrix[y][x];
                }
            }
        }
        matrix=nextMatrix;
    }



    /**
     * 统计每个细胞周围活着的个数
     * @param x 横坐标
     * @param y 纵坐标
     * @return
     */
    public int findLifedNum(int row, int col){
    	int count = 0, c, r;
        for(r = row-1; r <= row+1; r++)
            for(c = col-1; c <= col+1; c++) {
                if(r < 0 || r >= height || c < 0 || c >= width)
                    continue;
                if(matrix[r][c] == 1)
                    count++;
            }     
        if(matrix[row][col] == 1)
            count--;
        return count;

    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append(Arrays.toString(matrix[i]) + "\n");
        }
        return sb.toString();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public int getTransfromNum() {
        return transfromNum;
    }

    public int getDuration() {
        return duration;
    }
}
