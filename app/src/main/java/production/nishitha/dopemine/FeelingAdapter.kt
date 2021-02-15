package production.nishitha.dopemine

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FeelingAdapter(private val feelingList:List<FeelingModel>) : RecyclerView.Adapter<FeelingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.feelingcard, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(feelingList[position])
    }
    override fun getItemCount(): Int {
        return feelingList.size
    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(feelingObject: FeelingModel) {
            val image: ImageView =itemView.findViewById(R.id.feel_image)
            val title: TextView =itemView.findViewById(R.id.feel_title)
            val description: TextView =itemView.findViewById(R.id.feel_description)
            title.text=feelingObject.title
            image.setImageDrawable(feelingObject.image)
            description.text=feelingObject.description
        }
    }
}