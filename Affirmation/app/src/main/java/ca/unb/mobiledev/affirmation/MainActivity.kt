package ca.unb.mobiledev.affirmation
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ca.unb.mobiledev.affirmation.adapter.ItemAdapter
import ca.unb.mobiledev.affirmation.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create an instance of Data source and call loadAffirmation to get the affirmations
        val myDataset = Datasource().loadAffirmations()

        //Creating a recyclerview and use findViewById() to find reference to the recyclerView within the layout
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)

        //Create ItemAdapter instance and assign it to adapter property of recycler view
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
    }


}