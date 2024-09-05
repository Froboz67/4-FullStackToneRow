package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ToneRow;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcToneRowDao implements ToneRowDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcToneRowDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public ToneRow getTonerowById(int id) {
        ToneRow toneRow = null;
        final String sql = "SELECT id, name, pzero, pone, ptwo, pthree, pfour, pfive, psix, pseven, peight, pnine, pten, peleven\n" +
                "FROM tonerow\n" +
                "WHERE id = ?;";
        try {
            final SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
            if (results.next()) {
                toneRow = mapRowToTonerow(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("unable to connect to server or database", e);
        }
        return toneRow;
    }

    ToneRow mapRowToTonerow(SqlRowSet rowSet) {
        ToneRow toneRow = new ToneRow();
        toneRow.setId(rowSet.getInt("id"));
        toneRow.setName(rowSet.getString("name"));
        toneRow.setpZero(rowSet.getInt("pzero"));
        toneRow.setpOne(rowSet.getInt("pone"));
        toneRow.setpTwo(rowSet.getInt("ptwo"));
        toneRow.setpThree(rowSet.getInt("pthree"));
        toneRow.setpFour(rowSet.getInt("pfour"));
        toneRow.setpFive(rowSet.getInt("pfive"));
        toneRow.setpSix(rowSet.getInt("psix"));
        toneRow.setpSeven(rowSet.getInt("pseven"));
        toneRow.setpEight(rowSet.getInt("peight"));
        toneRow.setpNine(rowSet.getInt("pnine"));
        toneRow.setpTen(rowSet.getInt("pten"));
        toneRow.setpEleven(rowSet.getInt("peleven"));

        return toneRow;

    }
}
