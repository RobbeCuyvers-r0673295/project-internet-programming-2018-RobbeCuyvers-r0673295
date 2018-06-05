package controller;

import domain.Quotes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import domain.Payload;

@Controller
@RequestMapping(value = "/index")
public class IndexController {
    public IndexController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getIndex() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Payload response = restTemplate.getForObject("http://quotes.rest/qod.json", Payload.class);
            return new ModelAndView("index", "quote", response.getContents().getQuotes().get(0));//*/
        } catch (Exception e) {
            Quotes quote = new Quotes("Diepe quote (IndexController!)", "Robbe Cuyvers");
            return new ModelAndView("index", "quote", quote);//*/
        }

    }
}
