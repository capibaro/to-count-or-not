package com.comp2024b.tocountornot.controller;

import com.comp2024b.tocountornot.annotation.TokenRequired;
import com.comp2024b.tocountornot.bean.Division;
import com.comp2024b.tocountornot.service.DivisionService;
import com.comp2024b.tocountornot.util.Result;
import com.comp2024b.tocountornot.util.ResultFactory;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DivisionController {

    private final DivisionService divisionService;

    public DivisionController(DivisionService divisionService) {
        this.divisionService = divisionService;
    }

    @TokenRequired
    @PostMapping("division")
    public Result insertDivision(@Valid @RequestBody Division division, @RequestAttribute("uid") int uid) {
        division.setUser(uid);
        divisionService.insertDivision(division);
        return ResultFactory.getCreatedResult(division.getId());
    }

    @TokenRequired
    @PutMapping("division/{id}")
    public Result updateDivision(@PathVariable("id") int id, @Valid @RequestBody Division division, @RequestAttribute("uid") int uid) {
        division.setId(id);
        divisionService.updateDivision(division, uid);
        return ResultFactory.getSuccessResult(division.getId());
    }

    @TokenRequired
    @DeleteMapping("division/{id}")
    public Result deleteDivision(@PathVariable("id") int id, @RequestAttribute("uid") int uid) {
        divisionService.deleteDivision(id, uid);
        return ResultFactory.getSuccessResult(id);
    }

    @TokenRequired
    @GetMapping("division/{id}")
    public Result getDivisionById(@PathVariable("id") int id, @RequestAttribute("uid") int uid) {
        Division division = divisionService.getDivisionById(id, uid);
        return ResultFactory.getSuccessResult(division);
    }

    @TokenRequired
    @GetMapping("divisions")
    public Result getAllDivision(@RequestAttribute("uid") int uid) {
        List<Division> divisions = divisionService.getAllDivision(uid);
        return ResultFactory.getSuccessResult(divisions);
    }
}
