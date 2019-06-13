package tx.gameOfLife.ui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class GameOfLifeFrameTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@SuppressWarnings("deprecation")
	@Test
	void testGameOfLifeFrame() {
		GameOfLifeFrame frame = new GameOfLifeFrame();
		boolean flag=false;
		int duration=frame.DEFAULT_DURATION;
		int width=frame.getWidth();
		int height=frame.getHeight();
		String l1=frame.openFileBtn.getLabel();
		String l2=frame.startGameBtn.getLabel();
		String l3=frame.durationPromtLabel.getText();
		if(duration==200 && width==1000 && height==1084 && l1.equals("选择文件") 
				&& l2.equals("开始游戏") && l3.equals("动画间隔设置(ms为单位)"))
			flag=true;
		Assert.assertEquals(true, flag);
	     
	}

}
