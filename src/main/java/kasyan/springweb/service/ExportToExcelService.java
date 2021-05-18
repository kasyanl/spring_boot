package kasyan.springweb.service;

import kasyan.springweb.bean.BuyProduct;
import kasyan.springweb.bean.Product;
import kasyan.springweb.bean.ProductOfDelete;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExportToExcelService {
    static HSSFWorkbook workbook = new HSSFWorkbook();
    private ProductService productService;
    private UtilService utilService;
    static System.Logger logger;

    // сервис для экспорта всего списка продуктов в excel
    public void exportAllList(List<Product> listProduct) {
        exportList(listProduct);
    }

    // сервис на экспорт списка продуктов одной категории в excel
    public void exportCategoryList(String category) {
        exportList(productService.fineCategoryForRead(category));
    }

    // формирование таблицы excel и добавление данных из List
    public void exportList(List<Product> listProduct) {

        var sheet = getRows("List products");
        // даем название колонок таблицы
        extracted(sheet);

        // добавляем данные из List
        var i = 1;
        for (Product product : listProduct) {
            var rowProduct = sheet.createRow(i);
            var id = rowProduct.createCell(0);
            id.setCellValue(product.getId());

            var category = rowProduct.createCell(1);
            category.setCellValue(product.getCategory());

            var name = rowProduct.createCell(2);
            name.setCellValue(product.getName());

            var price = rowProduct.createCell(3);
            price.setCellValue(product.getPrice());

            var discount = rowProduct.createCell(4);
            discount.setCellValue(product.getDiscount());

            var totalVolume = rowProduct.createCell(5);
            totalVolume.setCellValue(product.getTotalVolume());

            var actualPrice = rowProduct.createCell(6);
            actualPrice.setCellValue(product.getActualPrice());

            i++;
        }
        // название и путь для нашего файла
        var filename = "src/main/webapp/WEB-INF/downloads/xls/productlist.xls";

        try (var out = new FileOutputStream(filename)) {
            workbook.write(out);
        } catch (IOException ex) {
            logger.log(System.Logger.Level.INFO, ex);
        }
    }


    // формирование таблицы excel и добавление данных из List
    public void exportListOfBasket(List<ProductOfDelete> listProductDelete) {

        var sheet = getRows("Deleted products");
        // даем название колонок таблицы
        extracted(sheet);

        // добавляем данные из List
        var i = 1;
        for (ProductOfDelete product : listProductDelete) {

            var rowProductDelete = sheet.createRow(i);

            var id = rowProductDelete.createCell(0);
            id.setCellValue(product.getId());

            var category = rowProductDelete.createCell(1);
            category.setCellValue(product.getCategory());

            var name = rowProductDelete.createCell(2);
            name.setCellValue(product.getName());

            var price = rowProductDelete.createCell(3);
            price.setCellValue(product.getPrice());

            var discount = rowProductDelete.createCell(4);
            discount.setCellValue(product.getDiscount());

            var totalVolume = rowProductDelete.createCell(5);
            totalVolume.setCellValue(product.getTotalVolume());

            var actualPrice = rowProductDelete.createCell(6);
            actualPrice.setCellValue(product.getActualPrice());

            i++;
        }
        // название и путь для нашего файла
        var filename = "src/main/webapp/WEB-INF/downloads/xls/productlist.xls";

        try (var out = new FileOutputStream(filename)) {
            workbook.write(out);
        } catch (IOException ex) {
            logger.log(System.Logger.Level.INFO, ex);
        }
    }

    // формирование таблицы excel из списка покупок
    public void check(List<BuyProduct> listProduct) {
        Sheet sheet = workbook.createSheet("check"); //название вкладки
        sheet.setColumnWidth(0, 2000); // ширина строк
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 3000);
        sheet.setColumnWidth(3, 4000);
        sheet.setColumnWidth(4, 4000);

        // даем название колонок таблицы
        var row = sheet.createRow(0); // первая строка

        var idTop = row.createCell(0);
        idTop.setCellValue("#"); // название первого столбца

        var nameTop = row.createCell(1);
        nameTop.setCellValue("Name");

        var actualPriceTop = row.createCell(2);
        actualPriceTop.setCellValue("Price, BYN");// название шестого столбца

        var quantityTop = row.createCell(3);
        quantityTop.setCellValue("Count");// название пятого столбца

        var totalPriceTop = row.createCell(4);
        totalPriceTop.setCellValue("Total, BYN");// название шестого столбца

        // добавляем данные из List
        var i = 1;
        for (BuyProduct product : listProduct) {
            var rowProduct = sheet.createRow(i);
            var id = rowProduct.createCell(0);
            id.setCellValue(i);

            var name = rowProduct.createCell(1);
            name.setCellValue(product.getName());

            var actualPrice = rowProduct.createCell(2);
            actualPrice.setCellValue(product.getActualPrice());

            var quantity = rowProduct.createCell(3);
            quantity.setCellValue(product.getQuantity());

            var totalPrice = rowProduct.createCell(4);
            totalPrice.setCellValue(product.getActualPrice());

            i++;
        }
        var rowProduct = sheet.createRow(i);

        var quantity = rowProduct.createCell(3);
        quantity.setCellValue("TOTAL:");

        var totalPrice = rowProduct.createCell(4);
        totalPrice.setCellValue(utilService.totalPrise());

        // название и путь для нашего файла (по умолчанию в корне проекта)
        var filename = "src/main/webapp/WEB-INF/downloads/xls/check.xls";

        try (var out = new FileOutputStream(filename)) {
            workbook.write(out);
        } catch (IOException ex) {
            logger.log(System.Logger.Level.INFO, ex);
        }
    }

    private Sheet getRows(String s) {
        Sheet sheet = workbook.createSheet(s); //название вкладки
        sheet.setColumnWidth(0, 1500); // ширина строк
        sheet.setColumnWidth(1, 6000);
        sheet.setColumnWidth(2, 6000);
        sheet.setColumnWidth(3, 3000);
        sheet.setColumnWidth(4, 3000);
        sheet.setColumnWidth(5, 3000);
        sheet.setColumnWidth(6, 3000);
        return sheet;
    }

    private void extracted(Sheet sheet) {
        var row = sheet.createRow(0); // первая строка
        var idTop = row.createCell(0);
        idTop.setCellValue("id"); // название первого столбца
        var categoryTop = row.createCell(1);
        categoryTop.setCellValue("Category");// название второго столбца
        var nameTop = row.createCell(2);
        nameTop.setCellValue("Name");// название третьего столбца
        var priceTop = row.createCell(3);
        priceTop.setCellValue("Price, BYN");// название четвертого столбца
        var discountTop = row.createCell(4);
        discountTop.setCellValue("Discount, %");// название пятого столбца
        var totalVolumeTop = row.createCell(5);
        totalVolumeTop.setCellValue("Count, kg()");// название шестого столбца
        var actualPriceTop = row.createCell(6);
        actualPriceTop.setCellValue("Total, BYN");// название седьмого столбца
    }


    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Autowired
    public void setUtilService(UtilService utilService) {
        this.utilService = utilService;
    }
}