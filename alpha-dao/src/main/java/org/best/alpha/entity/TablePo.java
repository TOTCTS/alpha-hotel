package org.best.alpha.entity;

import org.best.alpha.enums.TableStatus;

import java.util.Date;

public class TablePo {

    private Integer id;

    private String tableName;

    private TableStatus tableStatus;

    private Date reservationDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(TableStatus tableStatus) {
        this.tableStatus = tableStatus;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    @Override
    public String toString() {
        return "TablePo{" +
                "id=" + id +
                ", tableName='" + tableName + '\'' +
                ", tableStatus=" + tableStatus +
                ", reservationDate=" + reservationDate +
                '}';
    }
}
