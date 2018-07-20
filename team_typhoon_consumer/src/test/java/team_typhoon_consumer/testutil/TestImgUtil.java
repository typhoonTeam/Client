package team_typhoon_consumer.testutil;

import static org.junit.Assert.*;

import java.io.FileInputStream;

import org.junit.Test;

import typhoon.consuemer.util.ImgUtil;

public class TestImgUtil {
@Test
public void testInput() throws Exception {
	ImgUtil img = new ImgUtil();
	FileInputStream in = new FileInputStream("1.jpg");
	String s = img.imgUrl2String(in);
	System.out.println(s);
}
}
