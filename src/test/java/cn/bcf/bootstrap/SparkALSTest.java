package cn.bcf.bootstrap;

import cn.bcf.bootstrap.conf.SparkALS;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SparkALSTest {

    @Before
    public void before(){
        System.setProperty("hadoop.home.dir", "D:\\WorkSoft\\hadoop2.6_Win_x64");
    }

    @Test
    public void sparkAlsTest(){
        SparkALS sparkALS = new SparkALS();
        sparkALS.recommend(1,10);
    }


}
