package sessionCookiePractice.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import sessionCookiePractice.model.MyCounter;

@Controller
// first af all Spring going to find value of myCounter in request, if can not find the value,
// it will call method setupCounter to get default value.
@SessionAttributes("myCounter")
public class CounterControllers {

    //
    @ModelAttribute("myCounter")
    public MyCounter setupCounter(){
        return new MyCounter();
    }

    @GetMapping("/show")
    public String get(@ModelAttribute("myCounter") MyCounter myCounter) {
        myCounter.increment();
        return "result";
    }
}
