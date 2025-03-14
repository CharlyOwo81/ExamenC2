package mx.edu.itson.examenc2armentaperez

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OptionMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_option_menu)


        var btnColdDrinks: Button = findViewById(R.id.coldDrinks) as Button
        var btnHotDrinks: Button = findViewById(R.id.hotDrinks) as Button
        var btnSweets: Button = findViewById(R.id.sweets) as Button
        var btnSalties: Button = findViewById(R.id.salties) as Button

        btnColdDrinks.setOnClickListener {
            var intent: Intent = Intent(this,ProductsGrid::class.java)
            intent.putExtra("menuType","Cold Drinks")
            startActivity(intent)
        }
        btnHotDrinks.setOnClickListener {
            var intent: Intent = Intent(this,ProductsGrid::class.java)
            intent.putExtra("menuType","Hot Drinks")
            startActivity(intent)
        }
        btnSweets.setOnClickListener {
            var intent: Intent = Intent(this,ProductsGrid::class.java)
            intent.putExtra("menuType","Sweets")
            startActivity(intent)
        }
        btnSalties.setOnClickListener {
            var intent: Intent = Intent(this,ProductsGrid::class.java)
            intent.putExtra("menuType","Salties")
            startActivity(intent)
        }



    }
}