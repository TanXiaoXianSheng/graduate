package cn.bcf.bootstrap;

import cn.bcf.bootstrap.conf.ItemCF;
import cn.bcf.bootstrap.entity.MovieEntity;
import cn.bcf.bootstrap.entity.RatingEntity;
import cn.bcf.bootstrap.service.MovieService;
import cn.bcf.bootstrap.service.RatingService;
import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemCFTest {

    @Autowired
    private RatingService ratingService;

    @Autowired
    private MovieService movieService;

    @Before
    public void before(){

    }

    @Test
    public void recTest(){
        int movieId = 79;
        int k = 100;
        ItemCF itemCF = new ItemCF();
        List<MovieEntity> movieList = movieService.findAll();
        itemCF.pre(movieList);
        Map<Integer,Double> map = itemCF.recommend(movieId,k);
        for (Map.Entry<Integer,Double> entry : map.entrySet()){
            MovieEntity entity = movieService.findByMovieId(entry.getKey());
            //System.out.println("电影编号：" + entity.getId() + ", 电影名称： " + entity.getMovieName() + ", 电影标签: " + entity.getMovieLabel());
            System.out.println(entity.getId() + ", " + entity.getMovieName() + ", " + entity.getMovieLabel());
        }
    }

    @Test
    public void accuracyListTest() {
        Double precisionAvg = 0.00;
        for (int i = 141; i <= 160; i++){
            JSONObject jsonObject = precisionTest(i,100);
            precisionAvg += Double.parseDouble(jsonObject.get("precision").toString()) / 20.00;
        }
        System.out.println("准确率： " + precisionAvg);
    }

    @Test
    public void accuracyListTest02() {
        Double precisionAvg = 0.00;
        for(int j = 1;j <= 200;j ++){
            JSONObject jsonObject = precisionTest(j,20);
            precisionAvg += Double.parseDouble(jsonObject.get("precision").toString()) / 20.00;
            while (j % 2 == 0){
                System.out.println("准确率： " + precisionAvg);
                precisionAvg = 0.00;
            }
        }

    }

    public JSONObject precisionTest(int userId, int k){
        List<RatingEntity> list = ratingService.findByUserId(userId);

        RatingEntity firstMovie = null;
        if(list.size() > 0){
            firstMovie = list.get(0);
            list.remove(0);
        }
        ItemCF itemCF = new ItemCF();
        List<MovieEntity> movieList = movieService.findAll();
        itemCF.pre(movieList);
        Map<Integer,Double> map = itemCF.recommend(firstMovie.getMovieId(),k);

        List<Integer> watchedList = new ArrayList<>();
        for (RatingEntity entity : list){ watchedList.add(entity.getMovieId());
        }
        Set<Integer> recSet = map.keySet();
        watchedList.retainAll(recSet);

        Double precision = watchedList.size() / (k + 0.00);
        Double recall = watchedList.size() / (list.size() + 0.00);

        System.out.println("准确率: " + String.format("%.4f", precision) + ", 召回率: " + String.format("%.4f", recall));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("precision",precision);
        jsonObject.put("recall",recall);
        return jsonObject;
    }


}
