package kasyan.springweb.controller;

import kasyan.springweb.service.ExportToExcelService;
import kasyan.springweb.service.GetProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class IndexController {

    private GetProductService getProductService;
    private ExportToExcelService exportToExcelService;

    //получение стартовой страницы
    @GetMapping
    public String index() {
        return "index";
    }

    // получение начальной страницы для юзера
    @GetMapping(value = "/content")
    public String content() {
        return "adminpages/content";
    }

    // получение начальной страницы для гостя
    @GetMapping(value = "/contentguest")
    public String contentguest() {
        return "guestpages/contentguest";
    }

    // получения списка категории, для последующего выбора продуктов данной категории для юзера
    @GetMapping(value = "/selectcategorybyread")
    public String selectCategoryByRead() {
        return "adminpages/selectcategorybyread";
    }

    // получения списка категории, для последующего выбора продуктов данной категории для гостя
    @GetMapping(value = "/selectcategorybyreadguest")
    public String selectCategoryByReadGuest() {
        return "guestpages/selectcategorybyreadguest";
    }

    // экспорт данных из корзины в excel
    @GetMapping(value = "/exportexceldel")
    public String exportExcelDel() {
        exportToExcelService.exportListOfBasket(getProductService.findAllDeleted());
        return "adminpages/exportexceldel";
    }

    // экспорт данных  в excel основной БД для юзера
    @GetMapping(value = "/exportexcel")
    public String exportExcel() {
        exportToExcelService.exportAllList(getProductService.findAll());
        return "adminpages/exportexcel";
    }

    // экспорт данных  в excel основной БД для гостя
    @GetMapping(value = "/exportexcelguest")
    public String exportExcelGuest() {
        exportToExcelService.exportAllList(getProductService.findAll());
        return "guestpages/exportexcelguest";
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @Autowired
    public void setExportToExcelService(ExportToExcelService exportToExcelService) {
        this.exportToExcelService = exportToExcelService;
    }
}