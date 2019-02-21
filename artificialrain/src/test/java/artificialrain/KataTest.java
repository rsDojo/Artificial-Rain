package artificialrain;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class KataTest {

	@Test
	public void basicTests() {
		doTest(new int[] { 2 }, 1);
		doTest(new int[] { 1, 2, 1, 2, 1 }, 3);
		doTest(new int[] { 4, 2, 3, 3, 2 }, 4);
	}

	private void doTest(final int[] numbers, final int expected) {
		assertEquals(expected, Kata.artificialRain(numbers));
	}
	
	@Test
	public void cannotFlowLeftOnIndex0Test() throws Exception {
		final int[] numbers = new int[] {1};
		
		final boolean canFlowLeft = Kata.canFlowLeft(numbers, 0);
		
		Assert.assertThat("Cannot flow left on index 0", canFlowLeft , Matchers.equalTo(false) ); 
	}
	
	@Test
	public void canFlowLeftDownhillOnIndex1Test() throws Exception {
		final int[] numbers = new int[] {1,2};
		
		final boolean canFlowLeft = Kata.canFlowLeft(numbers, 1);
		
		Assert.assertThat("Can flow left downhill on index 1", canFlowLeft , Matchers.equalTo(true) ); 
	}
	
	@Test
	public void cannotFlowLeftUphillOnIndex1Test() throws Exception {
		final int[] numbers = new int[] {2,1};
		
		final boolean canFlowLeft = Kata.canFlowLeft(numbers, 1);
		
		Assert.assertThat("Cannot flow left uphill on index 1", canFlowLeft , Matchers.equalTo(false) ); 
	}
	
	@Test
	public void canFlowLeftOnPlainOnIndex1Test() throws Exception {
		final int[] numbers = new int[] {2,2};
		
		final boolean canFlowLeft = Kata.canFlowLeft(numbers, 1);
		
		Assert.assertThat("Cannot flow left on plain on index 1", canFlowLeft , Matchers.equalTo(true) ); 
	}
	
	@Test
	public void cannotFlowRightOnIndex0Test() throws Exception {
		final int[] numbers = new int[] {1};
		
		final boolean canFlowRight = Kata.canFlowRight(numbers, 0);
		
		Assert.assertThat("Cannot flow right on index 0", canFlowRight , Matchers.equalTo(false) ); 
	}
	
	@Test
	public void canFlowRightDownhillOnIndex1Test() throws Exception {
		final int[] numbers = new int[] {2,1};
		
		final boolean canFlowRight = Kata.canFlowRight(numbers, 0);
		
		Assert.assertThat("Can flow right downhill on index 0", canFlowRight , Matchers.equalTo(true) ); 
	}
	
	@Test
	public void cannotFlowRightUphillTest() throws Exception {
		final int[] numbers = new int[] {1,2};
		
		final boolean canFlowRight = Kata.canFlowRight(numbers, 0);
		
		Assert.assertThat(canFlowRight , Matchers.equalTo(false) ); 
	}
	
	@Test
	public void canFlowRightOnPlainTest() throws Exception {
		final int[] numbers = new int[] {2,2};
		
		final boolean canFlowRight = Kata.canFlowRight(numbers, 0);
		
		Assert.assertThat (canFlowRight , Matchers.equalTo(true) ); 
	}
	
	@Test(timeout=2000)
	public void simplePerformanceTestUp() throws Exception {
		
		final int[] numbers = new int[1_000_000_00];
		
		for(int i = 0; i < numbers.length ; i++) {
			numbers[i]=i;
		}
		
		final int artificialRain = Kata.artificialRain(numbers);
		Assert.assertTrue(artificialRain==numbers.length);
	}
	
	@Test(timeout=2000)
	public void simplePerformanceTestDown() throws Exception {
		
		final int[] numbers = new int[1_200_000_00];
		
		for(int i = 0; i < numbers.length ; i++) {
			numbers[i]=-i;
		}
		
		final int artificialRain = Kata.artificialRain(numbers);
		Assert.assertTrue(artificialRain==numbers.length);
	}
	
	@Test
	public void shouldComputeLeftFlows() throws Exception {
		int[] numbers = {1};
		int[] flowLeft = Kata.computeLeftFlow(numbers);
		Assert.assertThat(flowLeft, Matchers.equalTo(new int[]{0}));
	}
	@Test
	public void shouldComputeLeftFlowsFor2() throws Exception {
		int[] numbers = {0,1};
		int[] flowLeft = Kata.computeLeftFlow(numbers);
		Assert.assertThat(flowLeft, Matchers.equalTo(new int[]{0,1}));
	}
	@Test
	public void shouldComputeLeftFlowsFor4() throws Exception {
		int[] numbers = {1,1,2,1};
		int[] flowLeft = Kata.computeLeftFlow(numbers);
		Assert.assertThat(flowLeft, Matchers.equalTo(new int[]{0,1,2,0}));
	}
	@Test
	public void shouldComputeRightFlows() throws Exception {
		int[] numbers = {1};
		int[] flowLeft = Kata.computeRightFlow(numbers);
		Assert.assertThat(flowLeft, Matchers.equalTo(new int[]{0}));
	}
	@Test
	public void shouldComputeRightFlowsFor2() throws Exception {
		int[] numbers = {0,1};
		int[] flowLeft = Kata.computeRightFlow(numbers);
		Assert.assertThat(flowLeft, Matchers.equalTo(new int[]{0,0}));
	}
	@Test
	public void shouldComputeRightFlowsFor4() throws Exception {
		int[] numbers = {1,1,2,1};
		int[] flowLeft = Kata.computeRightFlow(numbers);
		Assert.assertThat(flowLeft, Matchers.equalTo(new int[]{1,0,1,0}));
	}
}
