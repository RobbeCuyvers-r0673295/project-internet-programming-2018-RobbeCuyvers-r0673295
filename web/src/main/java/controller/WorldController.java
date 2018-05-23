package controller;

import game.domain.GameService;
import game.domain.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/worlds")
public class WorldController {


    private final GameService service;

    public WorldController(@Autowired GameService service) {
        this.service = service;
    }

    //TODO: RequestMethods
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getWorlds(){
        /*Map<Long, World> werelden = service.getWorlds();
        if (werelden != null){
            for (long id : werelden.keySet()) {
                System.out.println(id);
                System.out.println(service.getWorld(id).getName());
            }
        } else {
            System.out.println("leeg");
        }*/


        return new ModelAndView("worlds", "worlds", service.getWorlds());
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET) //TODO fix next id
    public ModelAndView getNewForm(){
        long id = service.getNextId();
        //System.out.println(id);
        return new ModelAndView("worldForm" ,"world", new World(id)/**/);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid @ModelAttribute("world") World world, BindingResult result, ModelMap model){
        if (result.hasErrors()){
            return "worldForm";
        } else {
            service.addWorld(world);
        }
        return "redirect:/worlds.htm";
    }

    @RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute("world") World world, BindingResult result, ModelMap model){

        if (result.hasErrors()){
            return "edit";
        } else {
            service.updateWorld(world);

        }

        return "redirect:/worlds.htm";
    }


    @RequestMapping(value = "/{id}/remove", method = RequestMethod.POST)
    public String remove(@Valid @ModelAttribute("world") World world, BindingResult result, ModelMap model){

        if (result.hasErrors()){
            return "worlds";
        } else {
            service.deleteWorld(world);
        }

        return "redirect:/worlds.htm";
    }


    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public ModelAndView getEditForm(@PathVariable long id){
        return new ModelAndView("edit", "world", service.getWorld(id));
    }

    @RequestMapping(value = "/{id}/remove", method = RequestMethod.GET)
    public ModelAndView getDeleteForm(@PathVariable long id){
        return new ModelAndView("remove", "world", service.getWorld(id));
    }

}
