package controller;

import game.domain.GameService;
import game.domain.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest", produces = "application/json")
public class RESTController {
    private final GameService service;

    public  RESTController(@Autowired GameService service){
        this.service = service;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<World> getWorlds() {
        return  service.getWorldsList();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "{id}", produces = "application/json")
    public World getWorld(@PathVariable long id){
       return service.getWorld(id);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createWorld(@RequestBody World newWorld) {
        service.addWorld(newWorld);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")//niet nodig eigl
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateWorld(@RequestBody World updatedWorld){
        service.updateWorld(updatedWorld);
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    @ResponseStatus(HttpStatus.GONE)
    public void deleteWorld(@PathVariable long id){
        service.deleteWorld(id);
    }

    //TODO


}
