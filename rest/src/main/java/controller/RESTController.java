package controller;

import game.domain.GameService;
import game.domain.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
public class RESTController {
    private final GameService service;

    public  RESTController(@Autowired GameService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<World> getWorlds() {
        return  service.getWorldsList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public World getWorld(@PathVariable long id){
       return service.getWorld(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createWorld(@RequestBody World newWorld) {
        service.addWorld(newWorld);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")//niet nodig eigl
    public void updateWorld(@RequestBody World updatedWorld){
        service.updateWorld(updatedWorld);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteWorld(@PathVariable long id){
        service.deleteWorld(id);
    }

    //TODO


}
