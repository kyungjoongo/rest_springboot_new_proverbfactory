package com.kyungjoon.rest.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class TestDao {

    @Autowired
    private JdbcTemplate template;

    /**
     * Get hello list, using BeanPropertyRowMapper
     *
     * @return
     */
    public List<?> getList() {
        String query = "SELECT * FROM blogs";


        return template.queryForList(query);
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
}