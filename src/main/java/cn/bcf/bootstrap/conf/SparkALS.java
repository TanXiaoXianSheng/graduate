package cn.bcf.bootstrap.conf;

import cn.bcf.bootstrap.entity.MovieEntity;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.mllib.recommendation.ALS;
import org.apache.spark.mllib.recommendation.MatrixFactorizationModel;
import org.apache.spark.mllib.recommendation.Rating;

import java.util.*;

/**
 * 协同过滤
 */
public class SparkALS {


    // $example on$
    SparkConf conf = new SparkConf().setAppName("movie_01").setMaster("local[2]");
    JavaSparkContext jsc = new JavaSparkContext(conf);

    /**
     * 返回推荐电影id
     * @param userId 用户id
     * @param k 推荐数量
     * @return
     */
    public List<Integer> recommend(int userId, int k){
        // Load and parse the data
        String path = "F:/大四/毕业论文/ml-100k/ml-100k/u.data";
        JavaRDD<String> data = jsc.textFile(path);
        /*Map<Integer,Double> map = new HashMap<>();
        List<TrainRating> trainRatingList = new LinkedList<>();*/

        JavaRDD<Rating> ratings = data.map(s -> {
            String[] sarray = s.split("\\t");

            /*if(1.0 > 0.8){
                TrainRating trainRating = new TrainRating();
                trainRating.setUserId(Integer.parseInt(sarray[0]));
                trainRating.setMovieId(Integer.parseInt(sarray[1]));
                trainRating.setRating(Double.parseDouble(sarray[2]));
                trainRatingList.add(trainRating);

                return new Rating(Integer.parseInt(sarray[0]),
                        Integer.parseInt(sarray[1]),
                        0.0);
            }else {*/
                return new Rating(Integer.parseInt(sarray[0]),
                        Integer.parseInt(sarray[1]),
                        Double.parseDouble(sarray[2]));
            /*}*/

        });

        //ratings.keyBy(Rating::user).lookup(789);

        // 构建模型
        int rank = 50;
        int numIterations = 10;
        MatrixFactorizationModel model = ALS.train(JavaRDD.toRDD(ratings), rank, numIterations, 0.01);


        //求准确率
        /*int precisionNum = 0;
        Double precision = 0.00;
        for (TrainRating train : trainRatingList){
            Double trainRating = model.predict(train.getUserId(),train.getMovieId());
            if ((train.getRating() < 3 && trainRating < 3) || (train.getRating() > 3 && trainRating > 3))
                precisionNum ++;
        }
        precision = precisionNum / trainRatingList.size() + 0.00;*/

        Rating[] topKRecs = model.recommendProducts(userId,k);

        List<Integer> movieIdList = new ArrayList<>();
        for (Rating rating : topKRecs) {
            movieIdList.add(rating.product());
            //System.out.println(rating.user() + "， 推荐的电影编号：" + rating.product() + ", 预测评分： " + rating.rating());
            //System.out.println("推荐的电影编号：" + rating.product() + ", 预测评分： " + rating.rating());
            System.out.println(rating.product() + ", " + rating.rating());
        }
        /*System.out.println("准确率: " + precision);*/
        return movieIdList;
    }

    public class TrainRating{

        private int userId;
        private int movieId;
        private Double rating;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getMovieId() {
            return movieId;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public Double getRating() {
            return rating;
        }

        public void setRating(Double rating) {
            this.rating = rating;
        }
    }

}
