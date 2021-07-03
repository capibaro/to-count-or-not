package com.comp2024b.tocountornot.service;

import com.comp2024b.tocountornot.bean.Category;
import com.comp2024b.tocountornot.bean.Division;
import com.comp2024b.tocountornot.dao.DivisionMapper;
import com.comp2024b.tocountornot.exception.ForbiddenException;
import com.comp2024b.tocountornot.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService {
    private final DivisionMapper divisionMapper;

    public DivisionService(DivisionMapper divisionMapper) {
        this.divisionMapper = divisionMapper;
    }

    public void insertDivision(Division division) {
        divisionMapper.insertDivision(division);
    }

    public void deleteDivision(int id, int uid) {
        if (ExistDivision(id, uid)) {
            if (!ExistCategory(id)) {
                divisionMapper.deleteDivision(id);
            } else {
                throw new ForbiddenException("cannot delete division cause there is at least a category under it");
            }
        } else {
            throw new NotFoundException("division not found");
        }
    }

    public void updateDivision(Division division, int uid) {
        if (ExistDivision(division.getId(), uid)) {
            divisionMapper.updateDivision(division);
        } else {
            throw new NotFoundException("division not found");
        }
    }

    public List<Division> getAllDivision(int uid) {
        return divisionMapper.getAllDivision(uid);
    }

    public Division getDivisionById(int id, int uid) {
        Division division = divisionMapper.getDivisionById(id, uid);
        if (division != null) {
            return division;
        } else {
            throw new NotFoundException("division not found");
        }
    }

    public boolean ExistDivision(int id, int uid) {
        Division division = getDivisionById(id, uid);
        return division != null;
    }

    public boolean ExistCategory(int id) {
        List<Category> list = divisionMapper.getCategoryByDivision(id);
        return list != null;
    }
}
