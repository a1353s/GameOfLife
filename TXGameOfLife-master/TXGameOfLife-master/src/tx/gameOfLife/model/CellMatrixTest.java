package tx.gameOfLife.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import tx.gameOfLife.util.Utils;

class CellMatrixTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	 public void initMatrixFromFile() throws Exception {
        String path = "D:\\case_test.txt";
        CellMatrix cellMatrix = Utils.initMatrixFromFile(path);
        Assert.assertEquals(3, cellMatrix.getHeight());
        Assert.assertEquals(3, cellMatrix.getWidth());
        Assert.assertEquals(60, cellMatrix.getTransfromNum());
        Assert.assertEquals(200, cellMatrix.getDuration());
        int[][] expected = new int[][]{
                {1, 0, 1}, {0, 1, 0}, {1, 1, 1}
        };
        Assert.assertArrayEquals(expected, cellMatrix.getMatrix());
    }

}
