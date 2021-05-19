package kasyan.springweb.controller;

import kasyan.springweb.service.ProductOfDeleteService;
import kasyan.springweb.service.ProductService;
import kasyan.springweb.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// Контроллер для работы с залогининым пользователем

@Controller
@RequestMapping(value = "/product")
public class ProductCrudOperationController {

    private ProductService productService;
    private ProductOfDeleteService productOfDeleteService;
    private UtilService utilService;

    // получение всего списка продуктов из основной БД
    @GetMapping(value = "/allproduct")
    public ModelAndView findAll() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/allproduct");
        modelAndView.addObject("allProduct", productService.findAll());
        return modelAndView;
    }

    // полечение всего списка продуктов из лсновной бд для Гостя
    @GetMapping(value = "/allproductguest")
    public ModelAndView findAllForGuest() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/allproductguest");
        modelAndView.addObject("allProductGuest", productService.findAll());
        return modelAndView;
    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/addproduct")
    public String addproduct() {
        return "adminpages/addproduct";
    }

    // отправка данных для добавления продуктов в БД и перенаправления на страницу со всем списком
    @PostMapping(value = "/addproduct")
    public ModelAndView add(@RequestParam(value = "category") String category,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "price") double price,
                            @RequestParam(value = "discount") double discount,
                            @RequestParam(value = "totalVolume") double totalVolume) {
        productService.saveProduct(category, name, price, discount, totalVolume);
        return new ModelAndView("adminpages/allproduct");
    }

    // получение всего списка продуктов из корзины
    @GetMapping(value = "/bascket")
    public ModelAndView bascket() {
        if (!utilService.basketIsEmpty()) {
            return new ModelAndView("redirect:/product/alldeletedproduct");
        }
        return new ModelAndView("adminpages/bascketempty");
    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/bascketempty")
    public String bascketEmpty() {
        return "adminpages/bascketempty";
    }

    @GetMapping(value = "/alldeletedproduct")
    public ModelAndView findAllDeletedProduct() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/alldeleteproducts");
        modelAndView.addObject("productDel", productOfDeleteService.findAllDeleted());
        return modelAndView;
    }

    // получение страницы с сообщением, что продукт удален из основной БД
    @GetMapping(value = "/deleteproduct")
    public ModelAndView deleteproduct(@RequestParam(value = "id") int id) {
        productOfDeleteService.saveProductOfDelete(id);
        productService.deleteProduct(id);

        return new ModelAndView("redirect:/product/allproduct");
    }

    // получение страницы с сообщением, что продукт удален из корзины
    @GetMapping(value = "/deleteproductbasket")
    public ModelAndView deleteproductbasket(@RequestParam(value = "id") int id) {
        productOfDeleteService.deleteOfBasket(id);
        return new ModelAndView("adminpages/deleteproductbasket");
    }

    // очистка корзины
    @GetMapping(value = "/cleanbascket")
    public String cleanBascket() {
        productOfDeleteService.cleanBasket();
        return "adminpages/cleanbascket";
    }

    // восстановление всех данных из корзины
    @GetMapping(value = "/recoveredallproduct")
    public String recoveredAllProduct() {
        utilService.recoveryAllProduct();
        return "adminpages/recoveredallproduct";
    }

    // получение страницы с сообщением, что продукт восстановлен
    @GetMapping(value = "/recoveredproduct")
    public ModelAndView recoveredProduct(@RequestParam(value = "id") int id) {
        utilService.recovered(id);
        return new ModelAndView("adminpages/recoveredproduct");
    }

    // получение страницы с формой для редактирования данных продукта
    @GetMapping(value = "/editproduct")
    public ModelAndView edit(@RequestParam(value = "id") int id) {
        var modelAndView = new ModelAndView("adminpages/editproduct");
        modelAndView.addObject("editProduct", productService.findById(id));
        return modelAndView;
    }

    // отправка обновленных данных в БД и перенаправление на страницу со всем списком
    @PostMapping(value = "/editproduct")
    public ModelAndView edit(@RequestParam(value = "id") int id,
                             @RequestParam(value = "category") String category,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "price") double price,
                             @RequestParam(value = "discount") double discount,
                             @RequestParam(value = "totalVolume") double totalVolume, Model model) {
        model.addAttribute("id", id).addAttribute("category", category)
                .addAttribute("name", name).addAttribute("price", price)
                .addAttribute("discount", discount).addAttribute("totalVolume", totalVolume);
        productService.update(id, category, name, price, discount, totalVolume);
        return new ModelAndView("redirect:/product/allproduct");
    }

    // сортировка списка по ID (от меньшего к большему)
    @GetMapping(value = "/a/{sort}")
    @ResponseBody
    public ModelAndView sortAdmin(@PathVariable("sort") String sort) {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/allproduct");
        modelAndView.addObject("allProduct", productService.sort(sort));
        return modelAndView;
    }

    // сортировка списка по ID (от меньшего к большему) для Гостя
    @GetMapping(value = "/g/{sort}")
    @ResponseBody
    public ModelAndView sortGuest(@PathVariable("sort") String sort) {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("guestpages/allproductguest");
        modelAndView.addObject("allProductGuest", productService.sort(sort));
        return modelAndView;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setProductOfDeleteService(ProductOfDeleteService productOfDeleteService) {
        this.productOfDeleteService = productOfDeleteService;
    }

    @Autowired
    public void setUtilService(UtilService utilService) {
        this.utilService = utilService;
    }
}