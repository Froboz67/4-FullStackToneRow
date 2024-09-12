package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ToneRow;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcToneRowDao implements ToneRowDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcToneRowDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ToneRow> getToneRows() {
        final List<ToneRow> toneRows= new ArrayList<>();
        final String sql = "SELECT id, name, starting_pitch_value, pzero, pone, ptwo, pthree, pfour, pfive, psix, pseven, peight, pnine, pten, peleven, user_id\n" +
                "\tFROM public.tonerow;";
        try {
            final SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                toneRows.add(mapRowToTonerow(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("unable to connect to server or database", e);
        }
        return toneRows;
    }
    public ToneRow getToneRowById(int id) {
        ToneRow toneRow = null;
        final String sql = "SELECT id, name, starting_pitch_value, pzero, pone, ptwo, pthree, pfour, pfive, psix, pseven, peight, pnine, pten, peleven, user_id\n" +
                "\tFROM public.tonerow\n" +
                "\tWHERE id = ?;";
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
    @Override
    public ToneRow saveToneRow(ToneRow toneRow) {
        ToneRow saveToneRow = null;
        final String sql = "INSERT INTO tonerow(\n" +
                "\tname, starting_pitch_value, pzero, pone, ptwo, pthree, pfour, pfive, psix, pseven, peight, pnine, pten, peleven, user_id)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
                "\tRETURNING id;\n";
        try {
            int newToneRowId = jdbcTemplate.queryForObject(sql,int.class,toneRow.getName(), toneRow.getStartingPitchValue(), toneRow.getpZero(),
                    toneRow.getpOne(), toneRow.getpTwo(), toneRow.getpThree(), toneRow.getpFour(), toneRow.getpFive(),
                    toneRow.getpSix(), toneRow.getpSeven(), toneRow.getpEight(), toneRow.getpNine(), toneRow.getpTen(),
                    toneRow.getpEleven(), 1);

            saveToneRow = getToneRowById(newToneRowId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return saveToneRow;
    }

    ToneRow mapRowToTonerow(SqlRowSet rowSet) {
        ToneRow toneRow = new ToneRow();
        toneRow.setId(rowSet.getInt("id"));
        toneRow.setName(rowSet.getString("name"));
        toneRow.setStartingPitchValue(rowSet.getInt("starting_pitch_value"));
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
