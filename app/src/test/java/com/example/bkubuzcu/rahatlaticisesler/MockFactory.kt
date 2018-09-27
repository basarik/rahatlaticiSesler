package com.example.bkubuzcu.rahatlaticisesler

import com.example.bkubuzcu.rahatlaticisesler.app.PresenterFactory

/**
 * Created by bkubuzcu on 26/09/18.
 */
class MockFactory : PresenterFactory() {
    override fun categoryRepository() = MockCategoryRepository()
    override fun favouriteRepository() = MockFavouriteRepository()
}