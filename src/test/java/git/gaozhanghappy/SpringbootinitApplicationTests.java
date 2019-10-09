package git.gaozhanghappy;

import git.gaozhanghappy.FengJing.FengJing;
import git.gaozhanghappy.aes.AESUtils;
import git.gaozhanghappy.enumTest.EnumLight;
import git.gaozhanghappy.enumTest.EnumLight2;
import git.gaozhanghappy.errorCode.EnumError;
import jdk.nashorn.internal.runtime.Context;
import jdk.nashorn.internal.runtime.ErrorManager;
import org.assertj.core.internal.bytebuddy.implementation.bytecode.Throw;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


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
	@Test
	public void enumTest(){
		final EnumLight red = EnumLight.RED;
		System.out.println(red);
		final String s = EnumLight.RED.toString();
		System.out.println(s);
	}
	@Test
	public void enumTest2(){
		final EnumLight2[] values = EnumLight2.values();
		System.out.println(values+"---------------");
		for (EnumLight2 enumLight2:values){
			System.out.println(enumLight2);
		}
	}
	@Test
	public void error(){
		final EnumError emptyParamet = EnumError.EMPTY_PARAMET;
		final String code = emptyParamet.getCode();
		System.out.println(code);
		if ("000".equals(emptyParamet.getCode())){
			System.out.println("0000");
		}
	}
	//aes对称加密测试
	@Test
	public void aesTest(){
		String key="kkkkkkk123456728";//必须保持16位//

		System.out.println("原数据：");
		String content="Hello,world";
		System.out.println(content);

		byte[] contentByte=content.getBytes();

		System.out.println("原数据转字节：");
		for (int i = 0; i < contentByte.length; i++) {
			System.out.print(contentByte[i]);
		}
		System.out.println();

		try {
			System.out.println("加密后字节：");
			byte[] resultByte= AESUtils.Encrypt(contentByte, key);

			for (int i = 0; i < resultByte.length; i++) {
				System.out.print(resultByte[i]);
			}
			System.out.println();

			System.out.println("解密后字节：");
			byte[] finalByte= AESUtils.Decrypt(resultByte, key);
			for (int i = 0; i < finalByte.length; i++) {
				System.out.print(finalByte[i]);
			}
			System.out.println();
			System.out.println("解密后数据：");
			System.out.println(new String(finalByte));

			String strBase64=new BASE64Encoder().encode(resultByte);
			System.out.println("加密后Base64的数据，这个可在C#解密:");
			System.out.println(strBase64);

			byte[] base64Byte=new BASE64Decoder().decodeBuffer(strBase64);
			System.out.println("Base64解密后的数据:");
			byte[] base64ResultByte=AESUtils.Decrypt(base64Byte, key);
			System.out.println(new String(base64ResultByte));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
