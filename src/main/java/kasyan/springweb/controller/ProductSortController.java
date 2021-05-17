package kasyan.springweb.controller;

import kasyan.springweb.service.SortProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Контроллер для сортировки списка продуктов

@Controller
@RequestMapping(value = "/product")
public class ProductSortController {

    private SortProductService sortProductService;

    // сортировка списка по ID (от меньшего к большему)
    @GetMapping(value = "/sortbyid")
    public ModelAndView sortById(){
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyid");
        modelAndView.addObject("sortById", sortProductService.sortById());
        return modelAndView;
    }

    // сортировка списка по ID (от большего к меньшему)
    @GetMapping(value = "/sortbyidreverse")
    public ModelAndView sortByIdReverse(){
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyidreverse");
        modelAndView.addObject("sortByIdReverse", sortProductService.sortByIdReverse());
        return modelAndView;
    }

    // сортировка списка по категории (от A к Z)
    @GetMapping(value = "/sortbycategory")
    public ModelAndView sortByCategory() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbycategory");
        modelAndView.addObject("sortByCategory", sortProductService.sortByCategory());
        return modelAndView;
    }

    // сортировка списка по категории (от Z к A)
    @GetMapping(value = "/sortbycategoryreverse")
    public ModelAndView sortByCategoryReverse() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbycategoryreverse");
        modelAndView.addObject("sortByCategoryReverse", sortProductService.sortByCategoryReverse());
        return modelAndView;
    }

    // сортировка списка по названию (A -> Z)
    @GetMapping(value = "/sortbyname")
    public ModelAndView sortByName() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyname");
        modelAndView.addObject("sortByName", sortProductService.sortByName());
        return modelAndView;
    }

    // сортировка списка по названию (Z -> A)
    @GetMapping(value = "/sortbynamereverse")
    public ModelAndView sortByNameReverse() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbynamereverse");
        modelAndView.addObject("sortByNameReverse", sortProductService.sortByNameReverse());
        return modelAndView;
    }

    // сортировка списка по цене (от меньшего к большему)
    @GetMapping(value = "/sortbyprice")
    public ModelAndView sortByPrice() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyprice");
        modelAndView.addObject("sortByPrice", sortProductService.sortByPrice());
        return modelAndView;
    }

    // сортировка списка по цене (от большего к меньшему)
    @GetMapping(value = "/sortbypricereverse")
    public ModelAndView sortByPriceReverse() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbypricereverse");
        modelAndView.addObject("sortByPriceReverse", sortProductService.sortByPriceReverse());
        return modelAndView;
    }

    // сортировка списка по скидке (от меньшего к большему)
    @GetMapping(value = "/sortbydiscount")
    public ModelAndView sortByDiscount() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbydiscount");
        modelAndView.addObject("sortByDiscount", sortProductService.sortByDiscount());
        return modelAndView;
    }

    // сортировка списка по скидке (от большего к меньшему)
    @GetMapping(value = "/sortbydiscountreverse")
    public ModelAndView sortByDiscountReverse() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbydiscountreverse");
        modelAndView.addObject("sortByDiscountReverse", sortProductService.sortByDiscountReverse());
        return modelAndView;
    }

    // сортировка списка по конечной цене (от меньшего к большему)
    @GetMapping(value = "/sortbyactualprice")
    public ModelAndView sortByActualPrice() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyactualprice");
        modelAndView.addObject("sortByActualPrice", sortProductService.sortByActualPrice());
        return modelAndView;
    }

    // сортировка списка по конечной цене (от большего к меньшему)
    @GetMapping(value = "/sortbyactualpricereverse")
    public ModelAndView sortByActualPriceReverse() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbyactualpricereverse");
        modelAndView.addObject("sortByActualPriceReverse", sortProductService.sortByActualPriceReverse());
        return modelAndView;
    }

    // сортировка списка по наличию (от меньшего к большему)
    @GetMapping(value = "/sortbytotalvolume")
    public ModelAndView sortByTotalVolume() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbytotalvolume");
        modelAndView.addObject("sortByTotalVolume", sortProductService.sortByTotalVolume());
        return modelAndView;
    }

    // сортировка списка по наличию (от большего к меньшему)
    @GetMapping(value = "/sortbytotalvolumereverse")
    public ModelAndView sortByTotalVolumeReverse() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/sort/sortbytotalvolumereverse");
        modelAndView.addObject("sortByTotalVolumeReverse", sortProductService.sortByTotalVolumeReverse());
        return modelAndView;
    }

    // сортировка списка по ID (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbyidguest")
    public ModelAndView sortByIdGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyidguest");
        modelAndView.addObject("sortByIdGuest", sortProductService.sortById());
        return modelAndView;
    }

    // сортировка списка по ID (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbyidreverseguest")
    public ModelAndView sortByIdReverseGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyidreverseguest");
        modelAndView.addObject("sortByIdReverseGuest", sortProductService.sortByIdReverse());
        return modelAndView;
    }

    // сортировка списка по категории (от A к Z) для Гостя
    @GetMapping(value = "/sortbycategoryguest")
    public ModelAndView sortByCategoryGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbycategoryguest");
        modelAndView.addObject("sortByCategoryGuest", sortProductService.sortByCategory());
        return modelAndView;
    }

    // сортировка списка по категории (от Z к A) для Гостя
    @GetMapping(value = "/sortbycategoryreverseguest")
    public ModelAndView sortByCategoryReverseGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbycategoryreverseguest");
        modelAndView.addObject("sortByCategoryReverseGuest", sortProductService.sortByCategoryReverse());
        return modelAndView;
    }

    // сортировка списка по названию (A -> Z) для Гостя
    @GetMapping(value = "/sortbynameguest")
    public ModelAndView sortByNameGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbynameguest");
        modelAndView.addObject("sortByNameGuest", sortProductService.sortByName());
        return modelAndView;
    }

    // сортировка списка по названию (Z -> A) для Гостя
    @GetMapping(value = "/sortbynamereverseguest")
    public ModelAndView sortByNameReverseGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbynamereverseguest");
        modelAndView.addObject("sortByNameReverseGuest", sortProductService.sortByNameReverse());
        return modelAndView;
    }

    // сортировка списка по цене (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbypriceguest")
    public ModelAndView sortByPriceGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbypriceguest");
        modelAndView.addObject("sortByPriceGuest", sortProductService.sortByPrice());
        return modelAndView;
    }

    // сортировка списка по цене (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbypricereverseguest")
    public ModelAndView sortByPriceReverseGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbypricereverseguest");
        modelAndView.addObject("sortByPriceReverseGuest", sortProductService.sortByActualPriceReverse());
        return modelAndView;
    }

    // сортировка списка по скидке (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbydiscountguest")
    public ModelAndView sortByDiscountGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbydiscountguest");
        modelAndView.addObject("sortByDiscountGuest", sortProductService.sortByDiscount());
        return modelAndView;
    }

    // сортировка списка по скидке (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbydiscountreverseguest")
    public ModelAndView sortByDiscountReverseGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbydiscountreverseguest");
        modelAndView.addObject("sortByDiscountReverseGuest", sortProductService.sortByDiscountReverse());
        return modelAndView;
    }

    // сортировка списка по конечной цене (от меньшего к большему) для Гостя
    @GetMapping(value = "/sortbyactualpriceguest")
    public ModelAndView sortByActualPriceGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyactualpriceguest");
        modelAndView.addObject("sortByActualPriceGuest", sortProductService.sortByActualPrice());
        return modelAndView;
    }

    // сортировка списка по конечной цене (от большего к меньшему) для Гостя
    @GetMapping(value = "/sortbyactualpricereverseguest")
    public ModelAndView sortByActualPriceReverseGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbyactualpricereverseguest");
        modelAndView.addObject("sortByActualPriceReverseGuest", sortProductService.sortByActualPriceReverse());
        return modelAndView;
    }

    // сортировка списка по наличию (от меньшего к большему)
    @GetMapping(value = "/sortbytotalvolumeguest")
    public ModelAndView sortByTotalVolumeGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbytotalvolumeguest");
        modelAndView.addObject("sortByTotalVolumeGuest", sortProductService.sortByTotalVolume());
        return modelAndView;
    }

    // сортировка списка по наличию (от большего к меньшему)
    @GetMapping(value = "/sortbytotalvolumereverseguest")
    public ModelAndView sortByTotalVolumeReverseGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/sort/sortbytotalvolumereverseguest");
        modelAndView.addObject("sortByTotalVolumeReverseGuest", sortProductService.sortByTotalVolumeReverse());
        return modelAndView;
    }

    @Autowired
    public void setSortProductService(SortProductService sortProductService) {
        this.sortProductService = sortProductService;
    }
}