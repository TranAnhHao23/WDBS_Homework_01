package cg.controller;

import cg.model.Human;
import cg.service.IHumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HumanController {

    @Autowired
    private IHumanService humanService;

    @GetMapping
    public ModelAndView showAll(@RequestParam(value = "nameSearch", required = false) String nameSearch,
                                @SortDefault(sort = {"name"}, direction = Sort.Direction.ASC) @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        if (nameSearch == null) {
            nameSearch = "";
        }
        Page<Human> humans = humanService.findAllByNameContaining(nameSearch, pageable);
        if (humans.isEmpty()) {
            modelAndView.addObject("message", "No Human!!!");
        }
        modelAndView.addObject("nameSearch", nameSearch);
        modelAndView.addObject("humans", humans);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createHuman() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("human", new Human());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveHuman(@Validated @ModelAttribute Human human, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("create");
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create");
        }
        if (human != null) {
            modelAndView.addObject("message", "Create Success!!!");
            humanService.save(human);
        }
        return modelAndView;
    }

    @GetMapping("/view")
    public ModelAndView viewDetail(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        Human human = humanService.findById(id);
        modelAndView.addObject("human", human);
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView delete(@RequestParam("id") Long id, @SortDefault(sort = {"name"}, direction = Sort.Direction.ASC) @PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        humanService.deleteById(id);
        Page<Human> humans = humanService.findAll(pageable);
        if (humans.isEmpty()) {
            modelAndView.addObject("message", "No Human!!!");
        }
        modelAndView.addObject("humans", humans);
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam("id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit");

    }
}
