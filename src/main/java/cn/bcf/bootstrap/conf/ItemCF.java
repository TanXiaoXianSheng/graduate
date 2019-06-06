package cn.bcf.bootstrap.conf;

import cn.bcf.bootstrap.entity.MovieEntity;
import org.apache.commons.lang.StringUtils;

import java.io.*;
import java.util.*;

/**
 * 基于项目的推荐
 */
public class ItemCF {

    Map<Integer, List<String>> map = new HashMap<>();
    Set<String> labelSet = new TreeSet<>();
    //电影编号数组
    List<Integer> itemNum = new ArrayList<>();

    int labelNum = 0;
    int movieNum = 0;

    Map<Integer,List<Integer>> matrixMap = new HashMap<>();
    Map<Integer,List<Double>> simMatrixMap = new HashMap<>();

    /**
     * 从文件获取数据
     * 数据预处理，构建矩阵，构建电影编号list
     * @param filePath
     * @param pattern
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void pre(String filePath,String pattern) throws FileNotFoundException,IOException {
        InputStream is = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (StringUtils.isNotEmpty(line)){
            String[] arr = line.split(pattern);
            String[] labelArr = arr[2].split("\\|");
            map.put(Integer.parseInt(arr[0].trim()), Arrays.asList(labelArr));
            line = br.readLine();
        }
        movieNum = map.size();
    }

    /**
     * 从数据库获取数据
     * 数据预处理，构建矩阵，构建电影编号list
     * @param list
     */
    public void pre(List<MovieEntity> list){
        for (MovieEntity entity : list){
            String[] labelArr = entity.getMovieLabel().split("\\|");
            map.put(entity.getMovieId(),Arrays.asList(labelArr));
            itemNum.add(entity.getMovieId());
        }
        movieNum = list.size();
    }

    /**
     * 获取标签set集合
     */
    public void item(){
        for (Map.Entry<Integer,List<String>> entry : map.entrySet()){
            for (String str : entry.getValue()){
                labelSet.add(str);
            }
        }
        labelNum = labelSet.size();
    }

    /**
     * 构建物品-标签向量矩阵
     */
    public void setMatrix(){
        for (Map.Entry<Integer,List<String>> entry : map.entrySet()){
            List<Integer> list = new ArrayList<>();
            for (String str : labelSet){
                if (entry.getValue().contains(str)){
                    list.add(1);
                }else {
                    list.add(0);
                }
            }
            matrixMap.put(entry.getKey(),list);
        }
    }

    /**
     * 构建物品-物品相似度矩阵，以余弦相似度作为相似度计算算法
     */
    public void similar(){
        for (Map.Entry<Integer,List<Integer>> entry01 : matrixMap.entrySet()){
            List<Double> list = new ArrayList<>();
            for (Map.Entry<Integer,List<Integer>> entry02 : matrixMap.entrySet()){
                if (entry01.getKey() == entry02.getKey()){
                    list.add(0.0);
                    continue;
                }
                list.add(molecule(entry01.getValue(),entry02.getValue())/denominator(entry01.getValue(),entry02.getValue()));
            }
            simMatrixMap.put(entry01.getKey(),list);
        }
    }

    public int molecule(List<Integer> a,List<Integer> b){
        int mol = 0;
        for (int i = 0;i < a.size();i ++){
            mol += a.get(i) * b.get(i);
        }
        return mol;
    }

    public Double denominator(List<Integer> a,List<Integer> b){
        Double den = 0.0;
        int accA = 0;
        int accB = 0;
        for (int i = 0;i < a.size();i ++){
            accA += a.get(i) * a.get(i);
            accB += b.get(i) * b.get(i);
        }
        den = Math.sqrt(accA) * Math.sqrt(accB);
        return den;
    }

    /**
     * 为用户（uerId）推荐k部电影
     * @param movieId
     * @param number
     * @return map.key = 电影id，map.value = 相似度
     */
    public Map<Integer, Double> recommend(int movieId, int number){
        this.item();
        this.setMatrix();
        this.similar();
        //map key：电影编号    value:相似度
        Map<Integer,Double> map = new LinkedHashMap<>();
        List<Double> list = simMatrixMap.get(movieId);
        for (int i = 0;i < number;i ++){
            int index = 0;
            try{
                index = list.indexOf(Collections.max(list));
            }catch (Exception e){
                e.printStackTrace();
            }
            map.put(itemNum.get(index),Collections.max(list));
            list.remove(index);
            itemNum.remove(index);
        }
        return map;
    }


    public static void main(String[] args) throws Exception{
        String filePath = "F:" + File.separator + "大四" + File.separator + "毕业论文" + File.separator + "ml-1m" + File.separator + "ml-1m" + File.separator + "movies.dat";
        String pattern = "::";
        ItemCF itemCF = new ItemCF();
        itemCF.pre(filePath,pattern);
        itemCF.item();
        itemCF.setMatrix();
        itemCF.similar();

        int movieId = 567;
        Map<Integer,Double> map = itemCF.recommend(movieId,10);
        for (Map.Entry<Integer, Double> entry : map.entrySet()){
            System.out.println(entry.getKey() + "; " + entry.getValue());
        }
        int a = 1;
    }
}
