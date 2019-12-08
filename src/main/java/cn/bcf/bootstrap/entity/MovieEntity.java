package cn.bcf.bootstrap.entity;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "movie_id")
    private int movieId;

    @Column(name = "movie_name")
    private String movieName;

    //存的电影标签id
    @Column(name = "movie_label")
    private String movieLabel;

    //数据存储状态，1：保存，0：暂存，-1：删除
    @Column(name = "store_status")
    private int storeStatus;

    public MovieEntity() {
    }

    public MovieEntity(int id, int movieId, String movieName, String movieLabel) {
        this.id = id;
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieLabel = movieLabel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieLabel() {
        return movieLabel;
    }

    public void setMovieLabel(String movieLabel) {
        this.movieLabel = movieLabel;
    }


    public int getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(int storeStatus) {
        this.storeStatus = storeStatus;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", movieLabel='" + movieLabel + '\'' +
                ", storeStatus=" + storeStatus +
                '}';
    }
}
