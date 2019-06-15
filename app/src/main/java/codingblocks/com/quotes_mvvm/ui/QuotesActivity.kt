package codingblocks.com.quotes_mvvm.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import codingblocks.com.quotes_mvvm.R
import codingblocks.com.quotes_mvvm.data.Quote
import codingblocks.com.quotes_mvvm.utilities.InjectorUtils
import kotlinx.android.synthetic.main.activity_quotes.*
import android.view.ViewGroup
import android.view.LayoutInflater

import android.view.View
import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider


class QuotesActivity :AppCompatActivity(){



   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)
        initializeUi()
    }




    private fun initializeUi() {
        val factory = InjectorUtils.provideQuotesViewModelFactory()
        // Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)
        val viewModel = ViewModelProviders.of(this@QuotesActivity,factory)
            .get(QuotesViewModel::class.java)


        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView_quotes.text = stringBuilder.toString()
        })

        // When button is clicked, instantiate a Quote and add it to DB through the ViewModel
        button_add_quote.setOnClickListener {
            val quote = Quote(editText_quote.text.toString(), editText_author.text.toString())
            viewModel.addQuote(quote)
            editText_quote.setText("")
            editText_author.setText("")
        }
    }


    }

}

