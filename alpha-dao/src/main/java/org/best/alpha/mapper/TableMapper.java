package org.best.alpha.mapper;

import org.best.alpha.entity.TablePo;

import java.util.List;

/**
 * @author: BG336672
 * @create: 2018-09-20 19:39
 * @description:
 **/
public interface TableMapper {

    void put(TablePo tablePo);

    void update(TablePo tablePo);

    void deletebyId(Integer id);

    void deleteByTableName(String tableName);

    TablePo findById(Integer id);

    TablePo findByTableName(String tableName);

    List<TablePo> getPage(Integer startId, Integer pageSize);

    List<TablePo> getAll();

}
