package kasyan.springweb.controller;

import kasyan.springweb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/product")
public class BuyController {

    private DeleteProductService deleteProductService;
    private ExportToExcelService exportToExcelService;
    private GetProductService getProductService;
    private UpdateProductService updateProductService;
    private SaveProductService saveProductService;

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/buystarted")
    public String buyStarted() {
        deleteProductService.cleanBuyDB();
        return "adminpages/buystarted";
    }

    @GetMapping(value = "/buyproduct")
    public ModelAndView buyProductGet() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/buyproduct");
        modelAndView.addObject("buyProduct", getProductService.findAll());
        modelAndView.addObject("totalPrice", getProductService.totalPrise());
        return modelAndView;
    }

    // отправка данных для добавления продуктов в БД и перенаправления на страницу со всем списком
    @PostMapping(value = "/buyproduct")
    public ModelAndView buyProductPost(@RequestParam(value = "id") int id,
                                       @RequestParam(value = "quantity") double quantity,
                                       @RequestParam(value = "totalVolume") double totalVolume,
                                       Model model) {
        model.addAttribute("id", id).addAttribute("quantity", quantity).addAttribute("totalVolume", totalVolume);

        if (getProductService.checkingForNumber(quantity, totalVolume)) {
            saveProductService.saveBayProduct(id, quantity);
        }
        return new ModelAndView("redirect:/product/buyproduct");
    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/endbuyproduct")
    public ModelAndView endBuyProductGet() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/endbuyproduct");
        modelAndView.addObject("product", getProductService.findAllBuyProduct());
        return modelAndView;
    }

    // получение страницы с формой для добавления продукта
    @GetMapping(value = "/checkend")
    public ModelAndView checkend() {
        var modelAndView = new ModelAndView();
        modelAndView.setViewName("adminpages/checkend");
        exportToExcelService.check(getProductService.findAllBuyProduct());
        updateProductService.endTransaction();
        modelAndView.addObject("product", getProductService.findAllBuyProduct());
        return modelAndView;
    }

    // получение страницы с сообщением, что продукт удален из основной БД
    @GetMapping(value = "/deleteproductbuy")
    public ModelAndView deleteproduct(@RequestParam(value = "id") int id) {
        deleteProductService.deleteBuy(id);
        return new ModelAndView("redirect:/product/endbuyproduct");
    }

    // получение страницы с сообщением, что продукт удален из основной БД
    @GetMapping(value = "/failbuyproduct")
    public ModelAndView failbuyproduct() {
        deleteProductService.cleanBuyDB();
        return new ModelAndView("redirect:/content");
    }

    @Autowired
    public void setExportToExcelService(ExportToExcelService exportToExcelService) {
        this.exportToExcelService = exportToExcelService;
    }

    @Autowired
    public void setDeleteProductService(DeleteProductService deleteProductService) {
        this.deleteProductService = deleteProductService;
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @Autowired
    public void setUpdateProductService(UpdateProductService updateProductService) {
        this.updateProductService = updateProductService;
    }

    @Autowired
    public void setSaveProductService(SaveProductService saveProductService) {
        this.saveProductService = saveProductService;
    }
}