package com.loopwiki.recylerviewheaderandfooter.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.bumptech.glide.Glide
import com.loopwiki.recylerviewheaderandfooter.R
import com.loopwiki.recylerviewheaderandfooter.models.FoodItem
import com.loopwiki.recylerviewheaderandfooter.models.Footer
import com.loopwiki.recylerviewheaderandfooter.models.Header
import com.loopwiki.recylerviewheaderandfooter.models.RecyclerViewItem


class Adapter(//Declare List of Recyclerview Items
    internal var recyclerViewItems: List<RecyclerViewItem>, internal var mContext: Context
) : RecyclerView.Adapter<*>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val row: View
        //Check fot view Type inflate layout according to it
        if (viewType == HEADER_ITEM) {
            row = inflater.inflate(R.layout.custom_row_header, parent, false)
            return HeaderHolder(row)
        } else if (viewType == FOOTER_ITEM) {
            row = inflater.inflate(R.layout.custom_row_footer, parent, false)
            return FooterHolder(row)
        } else if (viewType == FOOD_ITEM) {
            row = inflater.inflate(R.layout.custom_row_food, parent, false)
            return FoodItemHolder(row)

        }
        return null
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val recyclerViewItem = recyclerViewItems[position]
        //Check holder instance to populate data  according to it
        if (holder is HeaderHolder) {
            val header = recyclerViewItem as Header
            //set data
            holder.texViewHeaderText.setText(header.getHeaderText())
            holder.textViewCategory.setText(header.getCategory())
            Glide.with(mContext).load(header.getImageUrl()).into(holder.imageViewHeader)

        } else if (holder is FooterHolder) {
            val footer = recyclerViewItem as Footer
            //set data
            holder.texViewQuote.setText(footer.getQuote())
            holder.textViewAuthor.setText(footer.getAuthor())
            Glide.with(mContext).load(footer.getImageUrl()).into(holder.imageViewFooter)

        } else if (holder is FoodItemHolder) {
            val foodItem = recyclerViewItem as FoodItem
            //set data
            holder.texViewFoodTitle.setText(foodItem.getTitle())
            holder.texViewDescription.setText(foodItem.getDescription())
            holder.textViewPrice.setText(foodItem.getPrice())
            Glide.with(mContext).load(foodItem.getImageUrl()).into(holder.imageViewFood)
            //check food item is hot or not to set visibility of hot text on image
            if (foodItem.isHot())
                holder.textViewIsHot.visibility = View.VISIBLE
            else
                holder.textViewIsHot.visibility = View.GONE

        }

    }

    override fun getItemViewType(position: Int): Int {
        //here we can set view type
        val recyclerViewItem = recyclerViewItems[position]
        //if its header then return header item
        return if (recyclerViewItem is Header)
            HEADER_ITEM
        else if (recyclerViewItem is Footer)
            FOOTER_ITEM
        else if (recyclerViewItem is FoodItem)
            FOOD_ITEM
        else
            super.getItemViewType(position)//if its FoodItem then return Food item
        //if its Footer then return Footer item

    }

    override fun getItemCount(): Int {
        return recyclerViewItems.size
    }

    //Food item holder
    private inner class FoodItemHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var texViewFoodTitle: TextView
        internal var texViewDescription: TextView
        internal var textViewPrice: TextView
        internal var textViewIsHot: TextView
        internal var imageViewFood: ImageView

        init {
            texViewFoodTitle = itemView.findViewById(R.id.texViewFoodTitle)
            texViewDescription = itemView.findViewById(R.id.texViewDescription)
            imageViewFood = itemView.findViewById(R.id.imageViewFood)
            textViewPrice = itemView.findViewById(R.id.textViewPrice)
            textViewIsHot = itemView.findViewById(R.id.textViewIsHot)
        }
    }

    //header holder
    private inner class HeaderHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var texViewHeaderText: TextView
        internal var textViewCategory: TextView
        internal var imageViewHeader: ImageView

        init {
            texViewHeaderText = itemView.findViewById(R.id.texViewHeaderText)
            textViewCategory = itemView.findViewById(R.id.textViewCategory)
            imageViewHeader = itemView.findViewById(R.id.imageViewHeader)
        }
    }

    //footer holder
    private inner class FooterHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var texViewQuote: TextView
        internal var textViewAuthor: TextView
        internal var imageViewFooter: ImageView

        init {
            texViewQuote = itemView.findViewById(R.id.texViewQuote)
            textViewAuthor = itemView.findViewById(R.id.textViewAuthor)
            imageViewFooter = itemView.findViewById(R.id.imageViewFooter)
        }
    }

    companion object {
        //Header Item Type
        private val HEADER_ITEM = 0
        //Footer Item Type
        private val FOOTER_ITEM = 1
        ////Food Item Type
        private val FOOD_ITEM = 2
    }
}

