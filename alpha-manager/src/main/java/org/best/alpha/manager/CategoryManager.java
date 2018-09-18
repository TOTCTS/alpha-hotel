package org.best.alpha.manager;

import org.best.alpha.base.BaseManager;
import org.best.alpha.entity.CategoryPo;
import org.best.alpha.exception.AssertException;
import org.best.alpha.util.Assert;
import org.springframework.stereotype.Component;

@Component
public class CategoryManager implements BaseManager<CategoryPo> {

    @Override
    public void checkEntity(CategoryPo categoryPo) {
        boolean emptyText = Assert.isEmptyText(categoryPo.getCategoryName());
        if (emptyText) {
            throw new AssertException("category name of categoryPo is not null!");
        }
    }
}
