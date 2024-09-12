package com.techelevator.dao;

import com.techelevator.model.ToneRow;

import java.util.List;

public interface ToneRowDao {

    List<ToneRow> getToneRows();

    ToneRow getToneRowById(int id);

    ToneRow saveToneRow(ToneRow toneRow);
}
