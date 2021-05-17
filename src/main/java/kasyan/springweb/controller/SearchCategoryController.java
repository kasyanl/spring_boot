package kasyan.springweb.controller;

import kasyan.springweb.service.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product")
public class SearchCategoryController {

    private GetProductService getProductService;

    // получение списка категории FRUITS
    @GetMapping(value = "/finefruits")
    public ModelAndView fineFruits() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finefruits");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("FRUITS"));
        return modelAndView;
    }

    // получение списка категории BERRIES
    @GetMapping(value = "/fineberries")
    public ModelAndView fineBerries() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/fineberries");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("BERRIES"));
        return modelAndView;
    }

    // получение списка категории VEGETABLES
    @GetMapping(value = "/finevegetables")
    public ModelAndView fineVegetables() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finevegetables");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("VEGETABLES"));
        return modelAndView;
    }

    // получение списка категории MILK_PRODUCT
    @GetMapping(value = "/finemilkproduct")
    public ModelAndView fineMilkProduct() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finemilkproduct");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("MILK_PRODUCT"));
        return modelAndView;
    }

    // получение списка категории ALCOHOLIC_BEVERAGES
    @GetMapping(value = "/finealcohol")
    public ModelAndView fineAlcohol() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finealcohol");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("ALCOHOLIC_BEVERAGES"));
        return modelAndView;
    }

    // получение списка категории MEAT
    @GetMapping(value = "/finemeat")
    public ModelAndView fineMeat() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/finecategory/finemeat");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("MEAT"));
        return modelAndView;
    }

    // получение списка категории FRUITS для Гостя
    @GetMapping(value = "/finefruitsguest")
    public ModelAndView fineFruitsGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/finefruitsguest");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("FRUITS"));
        return modelAndView;
    }

    // получение списка категории BERRIES для Гостя
    @GetMapping(value = "/fineberriesguest")
    public ModelAndView fineBerriesGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/fineberriesguest");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("BERRIES"));
        return modelAndView;
    }

    // получение списка категории VEGETABLES для Гостя
    @GetMapping(value = "/finevegetablesguest")
    public ModelAndView fineVegetablesGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/finevegetablesguest");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("VEGETABLES"));
        return modelAndView;
    }

    // получение списка категории MILK_PRODUCT для Гостя
    @GetMapping(value = "/finemilkproductguest")
    public ModelAndView fineMilkProductGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/finemilkproductguest");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("MILK_PRODUCT"));
        return modelAndView;
    }

    // получение списка категории ALCOHOLIC_BEVERAGES для Гостя
    @GetMapping(value = "/finealcoholguest")
    public ModelAndView fineAlcoholGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/finealcoholguest");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("ALCOHOLIC_BEVERAGES"));
        return modelAndView;
    }

    // получение списка категории MEAT для Гостя
    @GetMapping(value = "/finemeatguest")
    public ModelAndView fineMeatGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/finecategory/finemeatguest");
        modelAndView.addObject("product", getProductService.fineCategoryForRead("MEAT"));
        return modelAndView;
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }
}