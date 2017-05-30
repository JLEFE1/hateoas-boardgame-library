package be.homegrown.controller;

import be.homegrown.entities.Boardgame;
import be.homegrown.exception.EntityNotFoundException;
import be.homegrown.resource.BoardgameResource;
import be.homegrown.resource.BoardgameResourceAssembler;
import be.homegrown.resource.BoardgameWrappedResourceAssembler;
import be.homegrown.service.BoardgameService;
import be.homegrown.utils.StringUtils;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by JoLe on 15/05/2017.
 */
@CrossOrigin
@RestController
@RequestMapping("/boardgames")
public class BoardgameController {

    private final BoardgameService boardgameService;
    private final BoardgameResourceAssembler boardgameResourceAssembler;
    private final BoardgameWrappedResourceAssembler boardgameWrappedResourceAssembler;

    @Autowired
    public BoardgameController(BoardgameService boardgameService,
                               BoardgameResourceAssembler boardgameResourceAssembler,
                               BoardgameWrappedResourceAssembler boardgameWrappedResourceAssembler) {
        this.boardgameService = boardgameService;
        this.boardgameResourceAssembler = boardgameResourceAssembler;
        this.boardgameWrappedResourceAssembler = boardgameWrappedResourceAssembler;

    }

    @GetMapping(value = "/all", produces = {"application/json", "application/hal+json"})
    public HttpEntity<List<BoardgameResource>> getAll(){
        return new ResponseEntity<>(boardgameResourceAssembler.toResources(boardgameService.findAll()), HttpStatus.OK);
    }

    @GetMapping(value = "/jacksonMapper", params = "fields")
    public HttpEntity<MappingJacksonValue> getAllFilteredByJackson(@RequestParam String fields){


        String[] fieldsArray = StringUtils.splitBy(fields, ",");

        FilterProvider filterProvider = new SimpleFilterProvider().addFilter(
                "boardgameFilter", SimpleBeanPropertyFilter.filterOutAllExcept(fieldsArray));

        MappingJacksonValue wrapper = new MappingJacksonValue(boardgameWrappedResourceAssembler.toResources(boardgameService.findAll()));
        wrapper.setFilters(filterProvider);
        return new ResponseEntity<>(wrapper, HttpStatus.OK);
    }

    @GetMapping(value = "/findByBggId/{bggId}", produces = {"application/json", "application/hal+json"})
    public HttpEntity<BoardgameResource> findGameByBggId(@PathVariable("bggId") String bggId){
        Boardgame game = boardgameService.findOne(bggId).orElse(null);
        if(game == null){
            throw new EntityNotFoundException(String.format("No game found with id: %s", bggId));
        } else {
            return new ResponseEntity<>(boardgameResourceAssembler.toResource(game), HttpStatus.OK);
        }
    }

    @GetMapping(value = "/db/{query}", produces = {"application/json", "application/hal+json"})
    public HttpEntity<List<BoardgameResource>> queryOnDb(@PathVariable("query") String query) throws NoSuchMethodException {
        return new ResponseEntity<>(boardgameResourceAssembler.toResources(boardgameService.searchOnDb(query)), HttpStatus.OK);
    }

    @GetMapping(value = "/bgg/{query}", produces = {"application/json", "application/hal+json"})
    public HttpEntity<List<BoardgameResource>> queryOnBgg(@PathVariable("query") String query) throws NoSuchMethodException {
        return new ResponseEntity<>(boardgameResourceAssembler.toResources(boardgameService.searchOnBgg(query)), HttpStatus.OK);
    }









    @PutMapping(value = "", produces = {"application/json", "application/hal+json"}, consumes = {"application/json", "application/hal+json"})
    public Boardgame put(@RequestBody Boardgame boardgame){
        return boardgameService.insert(boardgame);
    }

    @PostMapping(value = "", produces = {"application/json", "application/hal+json"}, consumes = {"application/json", "application/hal+json"})
    public Boardgame update(@RequestBody Boardgame boardgame){
        return boardgameService.save(boardgame);
    }

    @DeleteMapping(value = "/{id}", consumes = {"application/json", "application/hal+json"})
    public void delete(@PathVariable("id") String id){
        boardgameService.delete(id);
    }



}
