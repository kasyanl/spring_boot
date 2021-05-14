package kasyan.springweb.service;

import kasyan.springweb.bean.ProductOfDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecoveryProductService {

    private GetProductService getProductService;
    private SaveProductService saveProductService;
    private DeleteProductService deleteProductService;

    // восстановление всех записей из корзины
    public void recoveryAllProduct() {
        List<ProductOfDelete> newList = getProductService.findAllDeleted();
        for (ProductOfDelete productOfDelete : newList) {
            saveProductService.saveProduct(productOfDelete.getCategory(), productOfDelete.getName(),
                    productOfDelete.getPrice(), productOfDelete.getDiscount(), productOfDelete.getTotalVolume());
        }
        deleteProductService.cleanBasket();
    }

    //восстанавливаем удаленный ранее Product по его ID и отправка запроса в БД
    public void recovered(int id) {
        ProductOfDelete productOfDelete = getProductService.findProductOfBascketByID(id);
        saveProductService.saveProduct(productOfDelete.getCategory(), productOfDelete.getName(), productOfDelete.getPrice(),
                productOfDelete.getDiscount(), productOfDelete.getTotalVolume());
        deleteProductService.deleteOfBasket(id);
    }

    @Autowired
    public void setGetProductService(GetProductService getProductService) {
        this.getProductService = getProductService;
    }

    @Autowired
    public void setSaveProductService(SaveProductService saveProductService) {
        this.saveProductService = saveProductService;
    }

    @Autowired
    public void setDeleteProductService(DeleteProductService deleteProductService) {
        this.deleteProductService = deleteProductService;
    }
}