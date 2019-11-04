package com.springboot.controller;

import com.springboot.pojo.Film;
import com.springboot.pojo.Type;
import com.springboot.service.FilmService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/15 - 9:55
 * @description ：
 */
@Slf4j
@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmService filmService;

    /**
     * 查询所有电影
     * @return
     */
    @RequestMapping("/listFilm")
    public List<Film> listFilm(){
        //System.out.println("显示电影");
        List<Film> films = filmService.listFilm();
        //System.out.println(films);
        return films;
    }
    /**
     * 查询电影数目
     */
    @RequestMapping("/count")
    public int count(){
        System.out.println();

        int count = filmService.count();
        return count;

    }


    /**
     * 删除电影
     */
    @RequestMapping("/delete")
    public void deleteFilm(@RequestBody Film film){

       // System.out.println(film.getFilmId());
        boolean b = filmService.deleteFilm(film.getFilmId());
        if (b){
            log.info("删除成功");
        }else{
            log.warn("删除失败");
        }
    }

    /**
     * 更新电影信息
     * @param film
     */
    @RequestMapping("/update")
    public String updateFilm(@RequestBody Film film){

       // System.out.println(film);
        String status = "false";
        boolean b = filmService.updateFilm(film);
        if (b){
            log.info("更新信息成功");
            status = "success";
        }
        log.warn("更新信息失败");
        return status;
    }

    /**
     * 根据名称电影查询
     * @param film
     * @return
     */
    @RequestMapping("/getFilmByFilmName")
    public List<Film> getFilmByFilmName(@RequestBody Film film){

        List<Film> films = filmService.getFilmByFilmName(film);
        System.out.println(films);
        return films;
    }

    /**
     * 添加电影
     */
    @RequestMapping("insertFilm")
    public String addFilm(@RequestBody Film film){

        //System.out.println(film);
        boolean b = filmService.addFilm(film);
        if(b){
            return "success";
        }
        return "failed";

    }

    /*查询最近更新的电影*/
    @RequestMapping("/lastUpdated")
    public List<Film> LastUpdate(){

        List<Film> films = filmService.LastUpdated();
        return films;

    }

    /**
     * 根据类别查询电影
     * @param type
     * @return
     */
    @RequestMapping("listByType")
    public List<Film> listByTypeId(@RequestBody Type type){
        //System.out.println(type);
        Film film = new Film();
        film.setType(type);

        List<Film> films = filmService.getFilm(film);
       // System.out.println(films);
        return films;
    }

    /**
     * 根据ID查询电影
     * @param film
     * @return
     */
    @RequestMapping("/getFilmById")
    public Film getById(@RequestBody Film film){

        System.out.println(film);
        Film film1 = filmService.getById(film);
        return film1;

    }

    /**
     * 根据评分高低查询电影
     */
    @RequestMapping("/listFilmByScore")
    public List<Film> listFilmByScore(){

        List<Film> films = filmService.listFilmByscore();
        //System.out.println(films);
        return films;
    }


    /**
     * 根据ID查询电影---------------小程序
     * @param filmId
     * @return
     */
    @RequestMapping("/getFilmById1")
    public Film getById1(Integer filmId){

        System.out.println(filmId);
        Film film = new Film();
        film.setFilmId(filmId);
        Film film1 = filmService.getById(film);
        return film1;

    }

    /**
     * 根据类别查询电影---------------------小程序
     * @param typeId
     * @return
     */
    @RequestMapping("listByType1")
    public List<Film> listByTypeId1(Integer typeId){

        Type type = new Type();
        type.setTypeId(typeId);
        Film film = new Film();
        film.setType(type);

        List<Film> films = filmService.getFilm(film);
        return films;

    }

    /**
     * 图标分类电影数量
     * @return
     */
    @RequestMapping("/countFilm")
    public List<Integer> countFilm(){

        List<Integer> counts = filmService.countFilm();
        return counts;
    }

}
