package cn.bcf.bootstrap.controller;

import cn.bcf.bootstrap.conf.ItemCF;
import cn.bcf.bootstrap.conf.SparkALS;
import cn.bcf.bootstrap.entity.HistoryEntity;
import cn.bcf.bootstrap.entity.MovieEntity;
import cn.bcf.bootstrap.service.HistoryService;
import cn.bcf.bootstrap.service.MovieService;
import cn.bcf.bootstrap.util.ReturnObj;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Auther: bichengfei
 * @Data: 2019/4/28 14:48
 **/
@Controller
@RequestMapping("/index")
public class indexController {

    @Autowired
    private MovieService movieService;

    @Autowired
    private HistoryService historyService;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/index");
        return view;
    }

    @ResponseBody
    @RequestMapping("/listByPage")
    public JSONArray getListByPage(){
        List<MovieEntity> list = movieService.findAll();
        JSONArray json = (JSONArray) JSONObject.toJSON(list);
        return json;
    }

    @ResponseBody
    @RequestMapping("/ALS")
    public ModelAndView sparkAls(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/als");
        return view;
    }

    @ResponseBody
    @RequestMapping("/listByPageAls")
    public JSONArray listByPageAls(){
        int userId = 1;
        int k;
        SparkALS sparkALS = new SparkALS();
        List<Integer> movieIdList = sparkALS.recommend(userId,10);
        List<MovieEntity> movieList = new ArrayList<>();

        JSONArray jsonArray = new JSONArray();
        for (Integer movieId : movieIdList){
            //movieList.add(movieService.findByMovieId(movieId));
            jsonArray.add(movieService.findByMovieId(movieId));
        }
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping("/itemRec")
    public ModelAndView itemRec(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/itemRec");
        return view;
    }

    @ResponseBody
    @RequestMapping("/listByPageItemRecHistory")
    public JSONArray listByPageItemRecHistory(){
        int userId = 1;
        HistoryEntity historyEntity = historyService.findByUserId(userId);

        MovieEntity movieEntity = movieService.findByMovieId(historyEntity.getMovieId());
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(JSONObject.toJSON(movieEntity));
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping("/listByPageItemRec")
    public JSONArray listByPageItemRec(){
        int userId = 1;
        HistoryEntity historyEntity = historyService.findByUserId(userId);

        int movieId = historyEntity.getMovieId();
        List<MovieEntity> list = movieService.findAll();
        ItemCF itemCF = new ItemCF();
        itemCF.pre(list);
        Map<Integer, Double> map = itemCF.recommend(movieId,10);

        List<MovieEntity> recList = new ArrayList<>();
        for (Map.Entry<Integer,Double> entry : map.entrySet()){
            recList.add(movieService.findByMovieId(entry.getKey()));
        }

        MovieEntity movieEntity = movieService.findByMovieId(historyEntity.getMovieId());
        JSONArray jsonArray = new JSONArray();
        jsonArray = (JSONArray) JSONObject.toJSON(recList);
        return jsonArray;
    }

    @ResponseBody
    @RequestMapping("/watch")
    public ReturnObj watch(@RequestParam int movieId){
        int userId = 1;
        ReturnObj returnObj = new ReturnObj();
        if (movieId != 0){
            MovieEntity entity = movieService.findByMovieId(movieId);
            if (entity != null){
                HistoryEntity historyEntity = new HistoryEntity();
                historyEntity.setUserId(userId);
                historyEntity.setMovieId(entity.getMovieId());
                historyEntity.setStartTime(String.valueOf(System.currentTimeMillis()));
                boolean bool = historyService.add(historyEntity);

                if (bool == true){
                    returnObj.setMsgCode("1");
                    returnObj.setMsg("已存入观看历史库");
                }else {
                    returnObj.setMsgCode("0");
                    returnObj.setMsg("存入观看历史库出现问题");
                }
            }else {
                returnObj.setMsgCode("0");
                returnObj.setMsg("此电影不存在");
            }
        }else {
            returnObj.setMsgCode("0");
            returnObj.setMsg("什么都没有输入");
        }
        return returnObj;
    }
}
