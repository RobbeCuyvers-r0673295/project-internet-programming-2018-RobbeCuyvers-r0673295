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
        System.out.println("Get");
        return  service.getWorldsList();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createWorld(@RequestBody World newWorld) {
        service.addWorld(newWorld);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public  void updateWorld(@RequestBody World updatedWorld){
        service.updateWorld(updatedWorld);
    }


}
