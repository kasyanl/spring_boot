package kasyan.springweb.controller;

import kasyan.springweb.service.ExportToExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/product")
public class ExportToExcelController {

    private ExportToExcelService exportToExcelService;

    // получение списка категории ALCOHOLIC_BEVERAGES
    @GetMapping(value = "/exportexcel/alcohol")
    public String exportExcelAlcohol() {
        exportToExcelService.exportCategoryList("ALCOHOLIC_BEVERAGES");
        return "adminpages/exportexcel/alcohol";
    }

    // экспорт списка категории BERRIES в excel
    @GetMapping(value = "/exportexcel/berries")
    public String exportExcelBerries() {
        exportToExcelService.exportCategoryList("BERRIES");
        return "adminpages/exportexcel/berries";
    }

    // экспорт списка категории FRUITS в excel
    @GetMapping(value = "/exportexcel/fruits")
    public String exportExcelFruits() {
        exportToExcelService.exportCategoryList("FRUITS");
        return "adminpages/exportexcel/fruits";
    }

    // экспорт списка категории MEAT в excel
    @GetMapping(value = "/exportexcel/meat")
    public String exportExcelMeat() {
        exportToExcelService.exportCategoryList("MEAT");
        return "adminpages/exportexcel/meat";
    }

    // экспорт списка категории MILK_PRODUCT в excel
    @GetMapping(value = "/exportexcel/milk")
    public String exportExcelMikl() {
        exportToExcelService.exportCategoryList("MILK_PRODUCT");
        return "adminpages/exportexcel/milk";
    }

    // экспорт списка категории VEGETABLES в excel
    @GetMapping(value = "/exportexcel/vegetables")
    public String exportExcelVegetables() {
        exportToExcelService.exportCategoryList("VEGETABLES");
        return "adminpages/exportexcel/vegetables";
    }

    // получение списка категории ALCOHOLIC_BEVERAGES для Гостя
    @GetMapping(value = "/exportexcel/alcoholguest")
    public String exportExcelAlcoholGuest() {
        exportToExcelService.exportCategoryList("ALCOHOLIC_BEVERAGES");
        return "guestpages/exportexcel/alcoholguest";
    }

    // экспорт списка категории BERRIES в excel для Гостя
    @GetMapping(value = "/exportexcel/berriesguest")
    public String exportExcelBerriesGuest() {
        exportToExcelService.exportCategoryList("BERRIES");
        return "guestpages/exportexcel/berriesguest";
    }

    // экспорт списка категории FRUITS в excel для Гостя
    @GetMapping(value = "/exportexcel/fruitsguest")
    public String exportExcelFruitsGuest() {
        exportToExcelService.exportCategoryList("FRUITS");
        return "guestpages/exportexcel/fruitsguest";
    }

    // экспорт списка категории MEAT в excel для Гостя
    @GetMapping(value = "/exportexcel/meatguest")
    public String exportExcelMeatGuest() {
        exportToExcelService.exportCategoryList("MEAT");
        return "guestpages/exportexcel/meatguest";
    }

    // экспорт списка категории MILK_PRODUCT в excel для Гостя
    @GetMapping(value = "/exportexcel/milkguest")
    public String exportExcelMiklGuest() {
        exportToExcelService.exportCategoryList("MILK_PRODUCT");
        return "guestpages/exportexcel/milkguest";
    }

    // экспорт списка категории VEGETABLES в excel для Гостя
    @GetMapping(value = "/exportexcel/vegetablesguest")
    public String exportExcelVegetablesGuest() {
        exportToExcelService.exportCategoryList("VEGETABLES");
        return "guestpages/exportexcel/vegetablesguest";
    }

    @Autowired
    public void setExportToExcel(ExportToExcelService exportToExcelService) {
        this.exportToExcelService = exportToExcelService;
    }
}