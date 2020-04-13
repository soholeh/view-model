package muhammad.solehudin.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: DataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        viewModel.getHitung().observe(this, getHitung)

        button.setOnClickListener {
            hitung(editText.text.toString().trim(), editText.text.toString().trim())
        }
    }

    fun hitung(panjang: String, lebar: String) {
        if (panjang.isEmpty() || lebar.isEmpty()) {
            Toast.makeText(applicationContext,"Data KOSONG",Toast.LENGTH_SHORT).show()
        } else {
            viewModel.setHitung(editText.text.toString().trim(), editText2.text.toString().trim())
        }
    }

    val getHitung = Observer<Result> {
        it.let {
            textView2.text = it?.result
        }
    }
}