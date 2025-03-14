package mx.edu.itson.examenc2armentaperez

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetalleProducto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_producto)

        val imagen: ImageView = findViewById(R.id.iv_producto)
        val nombre: TextView = findViewById(R.id.tv_producto)
        val precio: TextView = findViewById(R.id.tv_precio)

        val bundle=intent.extras

        if (bundle!=null){
            imagen.setImageResource(bundle.getInt("image"))
            nombre.setText(bundle.getString("nombre"))
            precio.setText(bundle.getString("precio"))
        }

    }
}