package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.ToneRow;
import com.techelevator.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class JdbcToneRowDao implements ToneRowDao{

    private JdbcTemplate jdbcTemplate;
    private final UserDao userDao;


    public JdbcToneRowDao(JdbcTemplate jdbcTemplate, UserDao userDao) {
        this.jdbcTemplate = jdbcTemplate;
        this.userDao = userDao;
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
        ToneRow saveToneRow;

        final String sql = "INSERT INTO tonerow(\n" +
                "\tname, starting_pitch_value, pzero, pone, ptwo, pthree, pfour, pfive, psix, pseven, peight, pnine, pten, peleven, user_id)\n" +
                "\tVALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)\n" +
                "\tRETURNING id;\n";
        try {
            int newToneRowId = jdbcTemplate.queryForObject(sql,int.class,toneRow.getName(), toneRow.getStartingPitchValue(), toneRow.getpZero(),
                    toneRow.getpOne(), toneRow.getpTwo(), toneRow.getpThree(), toneRow.getpFour(), toneRow.getpFive(),
                    toneRow.getpSix(), toneRow.getpSeven(), toneRow.getpEight(), toneRow.getpNine(), toneRow.getpTen(),
                    toneRow.getpEleven(), toneRow.getUser_id());
            System.out.println("userId number is : " + toneRow.getUser_id());
            saveToneRow = getToneRowById(newToneRowId);
            System.out.println("toneRow Id number is : " + newToneRowId);
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            if (Objects.requireNonNull(e.getMessage()).contains("unique constraint")) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "ToneRow name taken. Please choose a different name.");
            } else {
                throw new DaoException("Data integrity violation", e);
            }
        }
        return saveToneRow;
    }
    public ToneRow deleteToneRow(ToneRow toneRow) {
        return null;
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
        toneRow.setUser_id(rowSet.getInt("user_id"));

        return toneRow;

    }
}
