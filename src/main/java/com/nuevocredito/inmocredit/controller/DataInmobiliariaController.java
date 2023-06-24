package com.nuevocredito.inmocredit.controller;

import com.nuevocredito.inmocredit.entities.DataInmobiliaria;
import com.nuevocredito.inmocredit.service.IDataInmobiliarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/data-inmobiliaria")
@Api(tags = "Data Inmobiliaria", value = "Web Service RESTful - Data Inmobiliaria")
public class DataInmobiliariaController {
    private final IDataInmobiliarioService dataInmobiliarioService;
    public DataInmobiliariaController(IDataInmobiliarioService dataInmobiliarioService) {
        this.dataInmobiliarioService = dataInmobiliarioService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List all inmobiliaria data", notes = "Method for list all data")
    @ApiResponses({
            @ApiResponse(code = 201, message = "data found"),
            @ApiResponse(code = 404, message = "data not found"),
            @ApiResponse(code = 501, message = "Internal Server Error")
    })
    public ResponseEntity<List<DataInmobiliaria>> findAllDataInmobiliaria(){
        try{
            List<DataInmobiliaria> data = dataInmobiliarioService.getAll();
            return new ResponseEntity<>(data, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Insert data", notes = "Method for insert new data")
    @ApiResponses({
            @ApiResponse(code = 201, message = "data created"),
            @ApiResponse(code = 404, message = "data not created"),
            @ApiResponse(code = 501, message = "Internal Server Error"),
            @ApiResponse(code = 404, message = "Unauthorized")
    })
    public ResponseEntity<DataInmobiliaria> insertDataInmobiliaria(@Valid @RequestBody DataInmobiliaria dataInmobiliaria){
        try{
            DataInmobiliaria dataInmobiliariaNew = dataInmobiliarioService.save(dataInmobiliaria);
            return ResponseEntity.status(HttpStatus.CREATED).body(dataInmobiliariaNew);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
