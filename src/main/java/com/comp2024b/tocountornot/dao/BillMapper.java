package com.comp2024b.tocountornot.dao;

import org.apache.ibatis.annotations.Mapper;
import com.comp2024b.tocountornot.bean.Bill;
import java.util.List;

@Mapper
public interface BillMapper {
    List<Bill> getBillByUserIdWithDate(Long user_id, String date);
}
