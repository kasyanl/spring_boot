package kasyan.springweb.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest{

    IndexController indexController;

    @Autowired
    public MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        indexController = new IndexController();
    }

    @Test
    void index() throws Exception {
        assertEquals("index", indexController.index());

        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void content() throws Exception {
        assertEquals("adminpages/content", indexController.content());

        mockMvc.perform(get("/content"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void contentguest() throws Exception {
        assertEquals("guestpages/contentguest", indexController.contentguest());

        mockMvc.perform(get("/content"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void selectCategoryByRead() throws Exception {
        assertEquals("adminpages/selectcategorybyread", indexController.selectCategoryByRead());

        mockMvc.perform(get("/selectcategorybyread"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void selectCategoryByReadGuest() throws Exception {
        assertEquals("guestpages/selectcategorybyreadguest", indexController.selectCategoryByReadGuest());

        mockMvc.perform(get("/selectcategorybyreadguest"))
                .andDo(print())
                .andExpect(status().isOk());
    }
    @Test
    void exportExcelDel() throws Exception {
        mockMvc.perform(get("/exportexceldel"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void exportExcel() throws Exception {
        mockMvc.perform(get("/exportexcel"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void exportExcelGuest() throws Exception {
        mockMvc.perform(get("/exportexcelguest"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}