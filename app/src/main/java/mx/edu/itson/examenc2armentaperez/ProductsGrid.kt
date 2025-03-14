package mx.edu.itson.examenc2armentaperez

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
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
    var menu = ArrayList<producto>()
    var adapter: AdaptadorProductos? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)

        var menuOption: String? = intent.getStringExtra("menuType")
        agregarProductos(menuOption)

        var grid : GridView = findViewById(R.id.products)
        grid.adapter = adapter
    }
    fun agregarProductos(option: String?) {
        when(option) {
            "coldDrinks" -> {
                menu.add(producto("Caramel Frap", R.drawable.caramelfrap, 5.0))
                menu.add(producto("Chocolate Frap", R.drawable.chocolatefrap, 6.0))
                menu.add(producto("Cold Brew", R.drawable.coldbrew, 3.0))
                menu.add(producto("Matcha Latte", R.drawable.matcha, 4.0))
                menu.add(producto("Oreo Milkshake", R.drawable.oreomilkshake, 7.0))
                menu.add(producto("Peanut Milkshake", R.drawable.peanutmilkshake, 7.0))
            }
            "hotDrinks" -> {
                menu.add(producto("Latte", R.drawable.latte, 6.0))
                menu.add(producto("Hot Chocolate", R.drawable.hotchocolate, 5.0))
                menu.add(producto("Espresso", R.drawable.espresso, 4.0))
                menu.add(producto("Chai Latte", R.drawable.chailatte, 6.0))
                menu.add(producto("Capuccino", R.drawable.capuccino, 7.0))
                menu.add(producto("American Coffee", R.drawable.americano, 2.0))
            }
            "salties" -> {
                menu.add(producto("Chicken Crepes", R.drawable.chickencrepes, 6.0))
                menu.add(producto("Club Sandwich", R.drawable.clubsandwich, 5.0))
                menu.add(producto("Panini", R.drawable.hampanini, 4.0))
                menu.add(producto("Philly Cheese Steak", R.drawable.phillycheesesteak, 6.0))
                menu.add(producto("Nachos", R.drawable.nachos, 7.0))
            }
            "sweets" -> {
                menu.add(producto("Blueberry Cake", R.drawable.blueberrycake, 6.0))
                menu.add(producto("Chocolate Cupcake", R.drawable.chocolatecupcake, 3.0))
                menu.add(producto("Lemon Tartalette", R.drawable.lemontartalette, 4.0))
                menu.add(producto("Red Velvet Cake", R.drawable.redvelvetcake, 6.0))
                menu.add(producto("Cherry Cheesecake", R.drawable.strawberrycheesecake, 7.0))
                menu.add(producto("Tiramisu", R.drawable.tiramisu, 6.0))
            }
        }
    }

}
class AdaptadorProductos: BaseAdapter {
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

    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var prod = producto[position]
        var inflator = contexto!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        // Use the new layout for each item
        var vista = inflator.inflate(R.layout.producto, null)

        var imagen: ImageView = vista.findViewById(R.id.image)
        var nombre: TextView = vista.findViewById(R.id.name)

        // Set image and text values
        imagen.setImageResource(prod.image)
        nombre.setText(prod.nombre)

        // Set an OnClickListener for the image
        imagen.setOnClickListener {
            val intent = Intent(contexto, DetalleProducto::class.java)
            intent.putExtra("nombre", prod.nombre)
            intent.putExtra("image", prod.image)
            contexto!!.startActivity(intent)
        }

        return vista
    }

}