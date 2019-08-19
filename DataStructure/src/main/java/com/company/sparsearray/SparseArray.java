package com.company.sparsearray;

/**
 * @description: 稀疏数组
 * @author: chunguang.yao
 * @date: 2019-08-19 23:55
 */
public class SparseArray {

    public static void main(String[] args) {
        // 二维数组转换成稀疏数组
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[3][4] = 2;
        // 打印原始二维数组
        System.out.println("原始的二维数组~~~");
        for (int[] rows : chessArr1) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // ======  将二维数组转换成稀疏数组  begin ======
        // 1、遍历原始的二维数组得到有效数据的个数
        int sum = 0;
        for (int[] rows : chessArr1) {
            for (int data : rows) {
                if (0 != data) {
                    sum++;
                }
            }
        }
        // 2、根据有效数据的个数sum就可以创建稀疏数组sparseArr[sum + 1][3]
        int[][] sparseArr = new int[sum + 1][3];
        // 3、将原始的二维数组的有效数据存入稀疏数组
        int rowNum = chessArr1.length; // 原始二维数组的行数
        int colNum = chessArr1[0].length; // 原始二维数组的列数
        // 稀疏数组的第一行记录原始二维数组的行数、列数和有效数据个数
        sparseArr[0][0] = rowNum;
        sparseArr[0][1] = colNum;
        sparseArr[0][2] = sum;
        // 存入原始数组的有效数据
        int count = 0; // 计数器
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        // 打印转换后的稀疏数组
        System.out.println("转换后的稀疏数组~~~");
        for (int[] rows : sparseArr) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        // ======  将二维数组转换成稀疏数组  end   ======

        // ======  将稀疏数组还原成二维数组  begin   ======
        // 1、根据稀疏数组的第一行，创建原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        // 2、读取稀疏数组后几行的数据，并赋值给二维数组即可
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("还原后的二维数组~~~");
        // 打印还原后的二维数组
        for (int[] rows : chessArr2) {
            for (int data : rows) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        // ======  将稀疏数组还原成二维数组  end     ======
    }
}
