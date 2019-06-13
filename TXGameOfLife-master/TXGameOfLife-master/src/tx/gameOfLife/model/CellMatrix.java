package tx.gameOfLife.model;

import java.util.Arrays;

/**
 * Created by mjh on 2017/6/3.
 */
public class CellMatrix {
    /**
     * ����߶�
     */
    private int height;

    /**
     * ������
     */
    private int width;

    /**
     * �����ٶȣ�ÿ����״̬֮��ĺ�����
     */
    private int duration;

    /**
     * �ܵı仯����
     */
    private int transfromNum=0;

    /**
     * ����״̬��1��ʾ�0��ʾ��
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
     * ��һ��״̬����һ��״̬��ת��
     * ���ݹ�������ܽ�ó���������:
     * 1. ������Χ���ŵ�ϸ��Ϊ3�����,��һ��״̬��ϸ������Ϊ��
     * 2. ������Χ���ŵ�ϸ��Ϊ2�����,��һ��״̬����һ״̬��ͬ
     */
    public void transform(){
        int[][] nextMatrix=new int[height][width];
        for (int y = 0; y < matrix.length; y++) {
            for (int x = 0; x < matrix[0].length; x++) {
                nextMatrix[y][x]=0;
                int nearNum= findLifedNum(y,x);
                //����3������һ״̬���ǻ�
                if(nearNum==3){
                    nextMatrix[y][x]=1;
                }
                //����2��������һ״̬һ��
                else if(nearNum==2){
                    nextMatrix[y][x]=matrix[y][x];
                }
            }
        }
        matrix=nextMatrix;
    }



    /**
     * ͳ��ÿ��ϸ����Χ���ŵĸ���
     * @param x ������
     * @param y ������
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
