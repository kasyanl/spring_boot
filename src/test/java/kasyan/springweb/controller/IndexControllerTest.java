package kasyan.springweb.controller;

import kasyan.springweb.bean.Product;
import kasyan.springweb.common.AbstractTest;
import kasyan.springweb.service.ExportToExcelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@SpringBootTest
class IndexControllerTest extends AbstractTest {

    IndexController indexController;

    @MockBean
    private ExportToExcelService exportToExcelService;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
        indexController.setExportToExcelService(exportToExcelService);
    }

    @Test
    void index() {
        assertEquals("index", indexController.index());
    }

    @Test
    void content() {
        assertEquals("adminpages/content", indexController.content());
    }

    @Test
    void contentguest() {
        assertEquals("guestpages/contentguest", indexController.contentguest());
    }

    @Test
    void selectCategoryByRead() {
        assertEquals("adminpages/selectcategorybyread", indexController.selectCategoryByRead());
    }

    @Test
    void selectCategoryByReadGuest() {
        assertEquals("guestpages/selectcategorybyreadguest", indexController.selectCategoryByReadGuest());
    }

    @Test
    void exportExcelDel() {
//        assertEquals("adminpages/exportexceldel", indexController.exportExcelDel());
    }

    @Test
    void exportExcel() {
//
//        Date data = new Date();
//
//        doNothing().when(exportToExcelService).exportAllList((isA(List.class)));
//        exportToExcelService.exportAllList(List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
//                new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0, 10.0, data)));
//
//        verify(exportToExcelService).exportAllList(List.of(new Product(1, "Fruits", "Banana", 10.0, 20.0, 8.0, 10.0, data),
//                new Product(2, "Fruits", "Apple", 20.0, 20.0, 16.0, 10.0, data)));
//        assertEquals("adminpages/exportexcel", indexController.exportExcel());
    }

    @Test
    void exportExcelGuest() {
//        assertEquals("guestpages/exportexcelguest", indexController.exportExcelGuest());
    }
}