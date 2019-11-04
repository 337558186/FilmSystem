package com.springboot.service;

import com.springboot.pojo.Film;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/18 - 9:49
 * @description ：
 */
public interface FilmService {

    /**
     * 查询所有电影
     * @return
     */
    List<Film> listFilm();
    /**
     * 查询电影数目
     */
    int count();
    /**
     * 删除电影
     */
    boolean deleteFilm(int id);

    /**
     * 更新电影信息
     * @param film
     * @return
     */
    boolean updateFilm(Film film);

    /**
     * 根据名称模糊查询
     * @param film
     * @return
     */
    List<Film> getFilmByFilmName(Film film);

    /**
     * 新增电影
     * @param film
     * @return
     */
    boolean addFilm(Film film);

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
