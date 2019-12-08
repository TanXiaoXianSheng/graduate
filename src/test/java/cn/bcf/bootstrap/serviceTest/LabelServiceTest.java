package cn.bcf.bootstrap.serviceTest;

import cn.bcf.bootstrap.entity.LabelEntity;
import cn.bcf.bootstrap.service.LabelService;
import cn.bcf.bootstrap.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LabelServiceTest {

    @Autowired
    private LabelService labelService;

    @Autowired
    private MovieService movieService;

    @Test
    public void add(){
        LabelEntity entity = new LabelEntity();
        entity.setLabel("励志");
        entity.setStartTime(String.valueOf(System.currentTimeMillis()));
        entity.setUpdateTime(String.valueOf(System.currentTimeMillis()));
        entity.setDeleteFlag(1);
        labelService.add(entity);
    }

    @Test
    public void findAll(){
        movieService.findAll();
    }

    @Test
    public void test001(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.iterator().forEachRemaining((Integer line) -> {
             line = line + 1;
        });
        int a = 1;
    }
}
