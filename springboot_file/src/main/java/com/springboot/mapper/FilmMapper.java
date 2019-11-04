package com.springboot.mapper;

import com.springboot.pojo.Film;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/18 - 9:17
 * @description ：
 */
@Repository
public interface FilmMapper {

    /**
     * 查询所有电影
     * @return
     */
    List<Film> listAll();

    /**
     * 分页，查询电影数目
     * @return
     */
    int count();

    /**
     * 删除电影
     */
    int deleteFilm(int id);

    /**
     * 更新电影信息
     * @param film
     * @return
     */
    int updateFilm(Film film);

    /**
     * 模糊查询
     * @param film
     * @return
     */
    List<Film> getFilmByFilmName(Film film);

    /**
     * 新增电影
     * @param film
     * @return
     */
    int addFilm(Film film);

    /**
     * 查询最近更新
     * @return
     */
    List<Film> LastUpdated();

    /**
     *查询
     */
    List<Film> getFilm(Film film);

    /**
     * 根据Id查询电影
     * @param film
     * @return
     */
    Film getById(Film film);

    /**
     * 根据电影评分查询电影
     */
    List<Film> listFilmByscore();

    /**
     * 按照类别统计电影数量
     */
    List<Integer> countFilm();
}
