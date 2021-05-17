package kasyan.springweb.service;

import kasyan.springweb.bean.ProductOfDelete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecoveryProductService {

    private GetProductService getProductService;
    private SaveProductService saveProductService;
    private DeleteProductService deleteProductService;

    // восстановление всех записей из корзины
    @Transactional
    public void recoveryAllProduct() {
        List<ProductOfDelete> newList = getProductService.findAllDeleted();
        for (var productOfDelete : newList) {
            saveProductService.saveProduct(productOfDelete.getCategory(), productOfDelete.getName(),
                    productOfDelete.getPrice(), productOfDelete.getDiscount(), productOfDelete.getTotalVolume());
        }
        deleteProductService.cleanBasket();
    }

    //восстанавливаем удаленный ранее Product по его ID и отправка запроса в БД
    @Transactional
    public void recovered(int id) {
        var productOfDeleted = getProductService.findProductOfBasketByID(id);
        if (productOfDeleted.isPresent()) {
            var productOfDelete = productOfDeleted.get();
            saveProductService.saveProduct(productOfDelete.getCategory(), productOfDelete.getName(),
                    productOfDelete.getPrice(), productOfDelete.getDiscount(), productOfDelete.getTotalVolume());
            deleteProductService.deleteOfBasket(id);
        }
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