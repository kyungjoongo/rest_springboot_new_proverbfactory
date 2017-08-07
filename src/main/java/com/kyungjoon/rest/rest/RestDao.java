package com.kyungjoon.rest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestDao {

    @Autowired
    private JdbcTemplate template;

    /**
     * Get hello list, using BeanPropertyRowMapper
     *
     * @return
     */
    public List<?> getList() {

        List arrList  = template.queryForList("SELECT * FROM proverbs order by id desc");
        return arrList;
    }

    /**
     * Insert hello
     *
     * @param hello
     * @return
     */
    public int insert(Hello hello) {
        String query = "INSERT INTO blogs(content) VALUES( ?)";
        return template.update(query, hello.getName());
    }


    public int insertImage(String imageName, String extension) {
        String query = "INSERT INTO images(image_name, extension) VALUES( ?,?)";
        return template.update(query, imageName, extension);
    }

    public List<?> getImageList() {

        List arrList  = template.queryForList("SELECT * FROM images order by id desc");
        return arrList;
    }

}