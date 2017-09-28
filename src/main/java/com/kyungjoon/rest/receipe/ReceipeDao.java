package com.kyungjoon.rest.receipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReceipeDao {

    @Autowired
    private JdbcTemplate template;

    /**
     * Get hello list, using BeanPropertyRowMapper
     *
     * @return
     */
    public List<Receipe> getList() {
        List arrList = template.queryForList("SELECT * FROM receipe order by id desc");
        return arrList;
    }


    public int insertReceipe(Receipe receipe) {
        String query = "insert into receipe ( title, material,image, url,create_dt) values ( ?,?,?,?,date('now'))";
        return template.update(query, receipe.getTitle(), receipe.getMaterial(), receipe.getImage().getOriginalFilename(), receipe.getUrl());
    }


}