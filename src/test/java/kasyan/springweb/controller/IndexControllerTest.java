package kasyan.springweb.controller;

import kasyan.springweb.common.AbstractTest;
import kasyan.springweb.service.ExportToExcelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}