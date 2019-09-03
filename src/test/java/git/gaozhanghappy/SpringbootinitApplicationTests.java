package git.gaozhanghappy;

import git.gaozhanghappy.FengJing.FengJing;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootinitApplicationTests {


	//测试枚举类
	@Test
	public void contextLoads() {
		final String jingQu = Jingqu.JINGQU1.getJingQu();
		System.out.println(jingQu);
	}
	@Value("${FENGJING}")
	private String fengJing;

	@Test
	public void application(){
		final String jingQu = Jingqu.JINGQU1.getJingQu();
		System.out.println("使用枚举"+jingQu);
		System.out.println("使用application"+fengJing);
		final String zhongShanLing = FengJing.zhongShanLing;
		System.out.println("使用接口"+zhongShanLing);
	}

}
