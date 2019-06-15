package codingblocks.com.quotes_mvvm.ui

import androidx.lifecycle.ViewModel
import codingblocks.com.quotes_mvvm.data.Quote
import codingblocks.com.quotes_mvvm.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository)
    :ViewModel() {
    fun getQuotes()=quoteRepository.getQuotes()
    fun addQuote(quote: Quote)=quoteRepository.addQuote(quote)
}