package com.example.demo;

import java.util.List;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@Service
public class findSeans implements FindSeansInterface {

    @Autowired
    private JdbcTemplate jtm;

    @Override
    public List<Seans> findAll() {

        String sql = "SELECT * FROM seansi";

        return jtm.query(sql, new BeanPropertyRowMapper<>(Seans.class));
    }

    @Override
    public void deleteById(long id) {

        String sql = "DELETE FROM seansi WHERE id = ? ";
        int res = jtm.update(sql, id);
        if (res == 0)
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Seans not found"
        );
    }

    @Override
    public Seans findById(Long id) {
        String sql = "SELECT * FROM seansi WHERE id = ?";

        return jtm.queryForObject(sql, new Object[]{id},
                new BeanPropertyRowMapper<>(Seans.class));
    }

    @Override
    public void insertSeans(String name, String zal, String author) {
        //MapSqlParameterSource params = new MapSqlParameterSource();
        String sql = "INSERT INTO seansi(name, zal, author) VALUES (?, ?, ?)";
        Object[] params = new Object[] {name, zal, author};

        jtm.update(sql, params);
        //params.addValue("firstName", firstName);
        //params.addValue("lastName", lastName);
        //params.addValue("age", age);
        //jdbcTemplate.update(SQL_INSERT_PROFILE, params);
    }
}