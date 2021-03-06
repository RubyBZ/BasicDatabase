package com.example.basicdatabase.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.basicdatabase.R;
import com.example.basicdatabase.database.Product;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private final int productItemLayout;
    private List<Product> productList;

    public ProductListAdapter(int layoutId) {
        productItemLayout = layoutId;
    }

    public void setProductList(List<Product> products) {
        productList = products;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return productList == null ? 0 : productList.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                parent.getContext()).inflate(productItemLayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView itemName = holder.itemName;
        TextView itemQuantity = holder.itemQuantity;

        itemName.setText(productList.get(listPosition).getName());
        itemQuantity.setText(String.valueOf(productList.get(listPosition).getQuantity()));

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView itemQuantity;

        ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.product_name_row);
            itemQuantity = itemView.findViewById(R.id.product_quantity_row);
        }
    }

}

