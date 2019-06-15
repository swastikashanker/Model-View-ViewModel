package codingblocks.com.quotes_mvvm.utilities

import codingblocks.com.quotes_mvvm.data.Database
import codingblocks.com.quotes_mvvm.data.QuoteRepository
import codingblocks.com.quotes_mvvm.ui.QuotesViewModelFactory

object InjectorUtils {

    fun provideQuotesViewModelFactory():QuotesViewModelFactory{

        val quoteRepository=QuoteRepository.getInstance(Database.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }


}