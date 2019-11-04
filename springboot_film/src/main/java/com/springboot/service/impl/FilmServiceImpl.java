package com.springboot.service.impl;

import com.springboot.mapper.FilmMapper;
import com.springboot.pojo.Film;
import com.springboot.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ZWQ
 * @version ：1.0
 * @date ：2019/10/18 - 9:50
 * @description ：
 */

@Service("filmService")
public class FilmServiceImpl implements FilmService {

    @Autowired
    FilmMapper filmMapper;

    @Override
    public List<Film> listFilm() {

        List<Film> films = filmMapper.listAll();
        return films;
    }

    @Override
    public int count() {

        int count = filmMapper.count();
        return count;
    }


    @Override
    public boolean deleteFilm(int id) {

        int i = filmMapper.deleteFilm(id);
        if(i>0){
            return true;
        }
        return false;
    }


    @Override
    public boolean updateFilm(Film film) {
        int i = filmMapper.updateFilm(film);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Film> getFilmByFilmName(Film film) {

        List<Film> films = filmMapper.getFilmByFilmName(film);
        return films;
    }

    @Override
    public boolean addFilm(Film film) {
        int i = filmMapper.addFilm(film);
        if(i>0){
            return true;
        }
        return false;
    }

    @Override
    public List<Film> LastUpdated() {

        List<Film> films = filmMapper.LastUpdated();
        return films;
    }

    @Override
    public List<Film> getFilm(Film film) {

        List<Film> films = filmMapper.getFilm(film);

        return films;
    }

    @Override
    public Film getById(Film film) {

        Film film1 = filmMapper.getById(film);
        return film1;
    }

    @Override
    public List<Film> listFilmByscore() {

        List<Film> films = filmMapper.listFilmByscore();
        return films;
    }

    @Override
    public List<Integer> countFilm() {

        List<Integer> counts = filmMapper.countFilm();
        return counts;
    }
}
