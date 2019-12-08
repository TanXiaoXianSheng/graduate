package cn.bcf.bootstrap.controller;

import cn.bcf.bootstrap.conf.ItemCF;
import cn.bcf.bootstrap.conf.SparkALS;
import cn.bcf.bootstrap.entity.HistoryEntity;
import cn.bcf.bootstrap.entity.LabelEntity;
import cn.bcf.bootstrap.entity.MovieEntity;
import cn.bcf.bootstrap.service.HistoryService;
import cn.bcf.bootstrap.service.LabelService;
import cn.bcf.bootstrap.service.MovieService;
import cn.bcf.bootstrap.util.ReturnObj;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    private LabelService labelService;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/index");
        return view;
    }

    @ResponseBody
    @RequestMapping("/add")
    public ModelAndView add(){
        ModelAndView view = new ModelAndView();
        view.setViewName("/add");
        return view;
    }

    @RequestMapping("/view")
    public ModelAndView view(@RequestParam int id){
        return viewAndEdit(id,"view");
    }

    @ResponseBody
    @RequestMapping("/edit")
    public ModelAndView edit(@RequestParam int id){
        return viewAndEdit(id,"edit");
    }

    private ModelAndView viewAndEdit(Integer id,String type){
        ModelAndView view = new ModelAndView();
        view.addObject("type","{'type':'" + type + "'}");
        view.addObject("id",id);
        view.addObject("entity",JSONObject.toJSON(movieService.findById(id)).toString());
        view.setViewName("viewAndEdit");
        return view;
    }

    @ResponseBody
    @RequestMapping("/delete")
    public ReturnObj delete(){
        ReturnObj returnObj = new ReturnObj();
        return returnObj;
    }

    @ResponseBody
    @RequestMapping("/save")
    public ReturnObj save(@RequestBody MovieEntity entity, @RequestParam String type){
        ReturnObj returnObj = new ReturnObj();
        switch (type){
            case "save":entity.setStoreStatus(1);break;
            case "temp":entity.setStoreStatus(0);break;
        }
        if (movieService.add(entity)){
            returnObj.setMsgCode("1");
            returnObj.setMsg("写入成功");
        } else {
            returnObj.setMsgCode("0");
            returnObj.setMsg("写入失败");
        }
        returnObj.setUrl("/index/");

        return returnObj;
    }

    @ResponseBody
    @RequestMapping("/listByPage")
    public JSONArray getListByPage(){
        List<MovieEntity> list = movieService.findAll();
        JSONArray json = (JSONArray) JSONObject.toJSON(list);
        return json;
    }

    @ResponseBody
    @RequestMapping("/movieLabel")
    public ReturnObj movieLabel(){
        ReturnObj returnObj = new ReturnObj();
        List<LabelEntity> entityList = labelService.findAll();
        if(entityList != null){
            returnObj.setMsgCode("1");
            returnObj.setArr((JSONArray)JSONObject.toJSON(entityList));
        } else {
            returnObj.setMsgCode("0");
        }
        return returnObj;
    }

}
