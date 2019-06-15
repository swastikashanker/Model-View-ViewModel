package codingblocks.com.quotes_mvvm.data

class Database private constructor(){

    var quoteDao =QuoteDao()
    private set
    companion object {
        @Volatile private var instance:Database?=null

        fun getInstance() =
                instance ?: synchronized(lock = this){
                    instance ?:Database().also { instance = it}


        }
    }

}