package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.akademiakodu.dao.PersonDao;
import pl.akademiakodu.model.Person;

/**
 * Created by User on 30.03.2017.
 */
@Controller
public class PersonController {


    @GetMapping("/people/add")
    public String add() {

        return "people/add";
    }

    @Autowired
    PersonDao personDao;
//personDao = new PersonDaoImplementiation;

    @PostMapping("/people/create")
    public String success(@ModelAttribute Person person) {
        personDao.save(person);
        return "people/successadded";
    }


    @GetMapping("/people/personView")
    public String all(ModelMap modelMap) {
        modelMap.addAttribute("people", personDao.findAll());
        return "people/personView";
    }


    @GetMapping("/people/findperson")
    public String form() {

        return "people/findperson";
    }

    @PostMapping("/people/results")
    public String results(@ModelAttribute Person person, ModelMap modelMap) {
modelMap.addAttribute("people",personDao.findBySurname(person.getSurname()));
        return "people/findperson";
    }



//    @PostMapping("/people/delete")
//    public String deleted(@PathAttribute Person person) {
//        personDao.delete(person.getId());
//        return "people/add";
//    }

    @GetMapping("/people/{id}") //{id} klamry zmieniaja Id!!!
public String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
                                                //wczesniej ModelMap modelmap
//id =1, id =2 , id =3
        personDao.remove(id);
    //    modelMap.addAttribute("people", personDao.findAll());
        redirectAttributes.addFlashAttribute("message"," Successfull deleted");
        return "redirect:/people/personView";
      //  return "people/personView";
    }
}
