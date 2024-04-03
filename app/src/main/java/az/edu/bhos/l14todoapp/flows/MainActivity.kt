package az.edu.bhos.l14todoapp.flows

import android.annotation.SuppressLint
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import az.edu.bhos.l14todoapp.R
import az.edu.bhos.l14todoapp.entities.TodoBundle
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    private lateinit var searchBtn: View
    private lateinit var emptyView: View
    private lateinit var addNewBtn: View
    private lateinit var contentView: View
    private lateinit var todoList: RecyclerView

    private val adapter: TodoBundleAdapter by lazy { TodoBundleAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupUI()

        todoList.adapter = adapter

        viewModel.todoBundles.observe(this) { todoBundles ->
            if (todoBundles.isEmpty()) {
                emptyView.isVisible = true
                contentView.isVisible = false
            } else {
                emptyView.isVisible = false
                contentView.isVisible = true
                adapter.setData(todoBundles)
            }
        }
    }

    private fun setupUI() {
        searchBtn = findViewById(R.id.searchBtn)
        emptyView = findViewById(R.id.emptyView)
        addNewBtn = findViewById(R.id.addNewBtn)
        contentView = findViewById(R.id.contentView)
        todoList = findViewById(R.id.todoList)
    }
}
