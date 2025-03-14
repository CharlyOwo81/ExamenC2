package mx.edu.itson.examenc2armentaperez

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ProductsGrid : AppCompatActivity() {
    var menu : ArrayList<producto> = ArrayList<producto>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        var grid : GridView = findViewById(R.id.products) as GridView

        var adaptador : AdaptadorProductos = AdaptadorProductos(this, menu)
        grid.adapter = adaptador
    }
    fun agregarProductos(option:String?){
        when(option){
            "Cold Drinks"->{
                menu.add(producto("Caramel Frap", R.drawable.caramelfrap, 5.0))
            }
            "Hot Drinks"->{

            }
            "Sweeties"->{

            }
            "Salties"->{

            }
        }
    }
}
private class AdaptadorProductos: BaseAdapter {
    var producto=ArrayList<producto>()
    var contexto : Context?=null
    constructor(contexto: Context, producto:ArrayList<producto>){
        this.producto=producto
        this.contexto=contexto
    }

    override fun getCount(): Int {
        return producto.size
    }

    override fun getItem(position: Int): Any {
        return producto[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var prod=producto[position]
        var inflador = LayoutInflater.from(contexto)
        var vista=inflador.inflate(R.layout.activity_products, null)

        var imagen=vista.findViewById(R.id.iv_producto) as ImageView
        var nombre=vista.findViewById(R.id.tv_producto) as TextView
        var precio=vista.findViewById(R.id.tv_precio) as TextView

        imagen.setImageResource(prod.image)
        nombre.setText(prod.nombre)
        precio.setText("$${prod.precio}")
        return vista
    }
}